package BrokerBazePodataka;



import DomenskeKlase.GeneralDObject;
import DomenskeKlase.Igra;
import DomenskeKlase.Korisnik;
import static SO.OpsteIzvrsenjeSO.bbp;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;



public class BrokerBazePodatakaImpl extends BrokerBazePodataka 
{
   Connection conn = null;
   
   @Override
    public boolean makeConnection() 
    {
        String Url;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Url = "jdbc:mysql://127.0.0.1:3306/put_sa_zamkama";
             conn = DriverManager.getConnection(Url,"root","");
             conn.setAutoCommit(false);
            } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("Uspela konekcija!");
        return true;
    }
  
  
    @Override
    public boolean insertRecord(GeneralDObject odo)
    {  
       String upit = "INSERT INTO " + odo.getClassName() +  " VALUES (" + odo.getAtrValue() + ")";
        System.out.println("SQL UPIT INSERT: " + upit);
       return executeUpdate(upit);
    }


   
    @Override
    public boolean getCounter(GeneralDObject odo,AtomicInteger counter) 
    {  
        String sql = "SELECT Counter FROM Counter WHERE TableName = '" + odo.getClassName() + "'";
       
        ResultSet rs = null;
        Statement st = null;
               
        boolean signal = false;
        try  { st  = conn.prepareStatement(sql);
               rs = st.executeQuery(sql);
               signal = rs.next(); 
               counter.set(rs.getInt("Counter") + 1);
	     } catch (SQLException  ex)  
                { Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
                  signal = false;
                } 
               finally {close(null,st,rs);}
        return signal;
       
    }
  
    @Override
    public boolean increaseCounter(GeneralDObject odo,AtomicInteger counter) 
    {   String  upit = "UPDATE Counter SET Counter =" + counter.get() + " WHERE TableName = '" + odo.getClassName() + "'";
       return executeUpdate(upit);
    }
  
    @Override
    public boolean deleteRecord(GeneralDObject odo) 
    {   String upit ="DELETE FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);
    }

    @Override
    public boolean deleteRecords(GeneralDObject odo,String where) 
    {   String upit ="DELETE FROM " + odo.getClassName() + " " + where;
        return executeUpdate(upit);
    }
    
    
    @Override
    public boolean updateRecord(GeneralDObject odo,GeneralDObject odoold) 
    {   String  upit = "UPDATE " + odo.getClassName() +  " SET " + odo.setAtrValue() +   " WHERE " + odoold.getWhereCondition();
        return executeUpdate(upit);       
    }

    @Override
    public boolean updateRecord(GeneralDObject odo) 
    {   
        String  upit = "UPDATE " + odo.getClassName() +  " SET " + odo.setAtrValue() +   " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);       
    }
     
    public boolean executeUpdate(String upit) 
    {   Statement st=null;
        boolean signal = false;
  	try {   st  = conn.prepareStatement(upit);
                int rowcount = st.executeUpdate(upit);
                if (rowcount > 0) 
                    signal = true;    
	    } catch (SQLException ex)  
                {   Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
                    signal = false;
                } finally {close(null,st,null);}
	return signal;
    }
   
    @Override
    public GeneralDObject findRecord(GeneralDObject odo) 
    {   ResultSet rs = null;
        Statement st = null;
        String  upit = "SELECT * FROM " + odo.getClassName() +  " WHERE " + odo.getWhereCondition();
        System.out.println("SQL FIND UPIT: "  + upit);
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                signal = rs.next();
                if (signal == true)
                    odo = odo.getNewRecord(rs);
                else
                    odo = null;
	    } catch (SQLException  ex)  
               {   Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return odo;
    }
    
    
    @Override
    public List<GeneralDObject> findRecord(GeneralDObject odo, String where) 
    {   ResultSet rs = null;
        Statement st = null;
        String  upit = "SELECT * FROM " + odo.getClassName() +  " WHERE " + where;
        List<GeneralDObject> ls = new ArrayList<>();
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                while(rs.next()) 
                   { ls.add(odo.getNewRecord(rs));
                   }
	    } catch (SQLException  ex)  
               {   Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return ls;
    }
    
    
    
    @Override
    public boolean commitTransation()
    {   try { conn.commit();
	    } catch(SQLException esql){ return false; }
	return true;
    }

	
   @Override
    public boolean rollbackTransation()
    {   try { conn.rollback();
	    } catch(SQLException esql){ return false;  }
		   
	return true;
    }
        
    @Override
    public void closeConnection() 
    { close(conn,null,null);
    }
     
    @Override
    public void close(Connection conn, Statement st, ResultSet rs) 
    { if (rs != null) 
        {  try { rs.close(); 
               } catch (SQLException ex) 
                   { Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);}
        }
        
      if (st != null) 
        { try { st.close();
              } catch (SQLException ex) 
                  { Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);}
        }
      if (conn != null) 
        { try { conn.close();
              } catch (SQLException ex) 
                  { Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }

    @Override
    public int getRecordsNumber(GeneralDObject odo) 
    {   ResultSet rs = null;
        Statement st = null;
        int recordsNumber = 0;
        String  upit = "SELECT * FROM " + odo.getClassName();
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                if (rs.last()) { recordsNumber = rs.getRow();}
	    } catch (SQLException  ex)  
               {   Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return recordsNumber;
    }
    
            
    @Override
    public GeneralDObject getRecord(GeneralDObject odo,int index) 
     {
       ResultSet rs = null;
        Statement st = null;
        String  upit = "SELECT * FROM " + odo.getClassName();
        upit = upit + " order by " + odo.getNameByColumn(0) + " ASC LIMIT " + index + ",1";	
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                signal = rs.next();
                if (signal == true)
                    odo = odo.getNewRecord(rs);
                else
                    odo = null;
	    } catch (SQLException  ex)  
               {  odo = null; Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return odo;
     
     }
    
    @Override
    public int findRecordPosition(GeneralDObject odo) 
    {   ResultSet rs = null;
        Statement st = null;
        String  upit = "SELECT (COUNT(*)) as pozicija FROM " + odo.getClassName() +  " WHERE " + odo.getNameByColumn(0) + " < " + odo.getPrimaryKey();
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                signal = rs.next(); 
                if (signal == true)
                  { return Integer.parseInt(rs.getString("pozicija"));}
	    } catch (SQLException  ex)  
               {   Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return -1;
    }
 
   

    @Override
    public Connection getConnection() {
        
        return conn;
        
    }

    @Override
    public List<Igra> vratiIgreSaKorisnikom() {
        
    List<Igra> lista = new ArrayList<>();
    String sql = "SELECT i.id AS igra_id, i.datum AS igra_datum, i.rezultat AS igra_rezultat, " +
             "k.idKorisnik AS idKorisnik, k.korisnickoIme AS korisnickoIme " +
             "FROM Igra i " +
             "JOIN Korisnik k ON i.korisnikId = k.idKorisnik " +
             "ORDER BY i.rezultat ASC LIMIT 10";


    ResultSet rs = null;
    Statement st = null;

    try {
        st = bbp.getConnection().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Korisnik k = new Korisnik();
            k.setID(rs.getInt("idKorisnik"));
            k.setKorisnickoIme(rs.getString("korisnickoIme"));

            Igra i = new Igra();
            i.setId(rs.getInt("igra_id"));
            i.setDatum(rs.getDate("igra_datum"));
            i.setRezultat(rs.getInt("igra_rezultat"));
            i.setKorisnik(k);

            lista.add(i);
        }
    } catch (SQLException ex) {
        Logger.getLogger(BrokerBazePodatakaImpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        bbp.close(null, st, rs);
    }

    return lista;
} 
    
}
