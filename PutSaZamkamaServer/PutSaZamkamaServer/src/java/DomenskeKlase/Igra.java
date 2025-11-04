package DomenskeKlase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lav
 */
public class Igra extends GeneralDObject {

    private int id;
    private Date datum;
    private int rezultat;
    private Korisnik korisnik;

    public Igra() {
    }

    public Igra(int id, Date datum, int rezultat, Korisnik korisnik) {
        this.id = id;
        this.datum = datum;
        this.rezultat = rezultat;
        this.korisnik = korisnik;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getRezultat() {
        return rezultat;
    }

    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public String formatirajDatum(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(datum);
        
    }
    
    @Override
    public String getAtrValue() {
        
        return  id + ", '" + formatirajDatum() + "', " + rezultat + ", " + korisnik.getIDKorisnik();
    }

    @Override
    public String setAtrValue() {
        
        return "id=" + id + ", " + "datum='" + formatirajDatum() + "', " + "rezultat=" + rezultat + " , korisnikId=" + korisnik.getIDKorisnik();
        
    }

    @Override
    public String getClassName() {
        
        return "Igra";
        
    }

    @Override
    public String getWhereCondition() {
        
        return "id = " + id;
        
    }

    @Override
    public String getNameByColumn(int column) {
        
        String names[] = {"id","datum","rezultat","korisnikId"};
        return names[column];
        
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        
        Date date = new Date(rs.getDate("datum").getTime());
        Korisnik k = new Korisnik();
        k.setID(rs.getInt("korisnikId"));
        return new Igra(rs.getInt("id"),date,rs.getInt("rezultat"),k);
        
    }

    @Override
    public int getPrimaryKey() {
        
        return id;
        
    }

    @Override
    public void setID(int id) {
        
        setId(id);
        
    }

    @Override
    public String poruka1() {
        
        return "Problem oko brojaca igre.";
        
    }

    @Override
    public String poruka2() {
        
        return "Ne moze da se poveca brojac igre.";
        
    }

    @Override
    public String poruka3() {
        
        return "Igra je dodata!";
        
    }

    @Override
    public String poruka4() {
        
        return "Nije mogla da bude kreirana igra.";
        
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
