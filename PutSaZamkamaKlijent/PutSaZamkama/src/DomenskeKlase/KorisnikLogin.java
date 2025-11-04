/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomenskeKlase;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lav
 */
public class KorisnikLogin extends GeneralDObject{
    
    private String korisnickoIme;
    
    private String sifra;

    public KorisnikLogin(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public KorisnikLogin() {
    }
    
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    

   @Override
     public String getAtrValue() { return  ", '" + korisnickoIme + "', '" + sifra + "'"; }

    @Override
    public String setAtrValue() {
        return "korisnickoIme='" + korisnickoIme + "', " + "sifra='" + sifra + "'";           
    }

    @Override
    public String getClassName() {
        return "KorisnikLogin";        
    }

    @Override
    public String getWhereCondition() {
        return "korisnickoIme=" + "'" + korisnickoIme + "' AND sifra='" + sifra + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"korisnickoIme","sifra"}; 
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
      return new KorisnikLogin(rs.getString("korisnickoIme"),rs.getString("sifra"));        
    }

    @Override
    public int getPrimaryKey() {
        return 0;
    }

    @Override
    public void setID(int id) {
    }

    @Override
    public String poruka1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka6() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka7() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka8() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka9() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String poruka10() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
