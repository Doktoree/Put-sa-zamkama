package DomenskeKlase;

import Enumeracija.Pol;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author Lav
 */
public class Korisnik  extends GeneralDObject implements Serializable{
    public int idKorisnik;
    String korisnickoIme;
    String sifra;
    String ime;
    String prezime;
    public Date datumRodjenja;
    Pol pol;

    public Korisnik(int idKorisnik, String korisnickoIme, String sifra, String ime, String prezime, Date datumRodjenja, Pol pol) {
        this.idKorisnik = idKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
    }
    
    
    
    public Korisnik()
      { this.idKorisnik = 0;
        this.korisnickoIme = "";
        this.sifra = "";
        this.ime = "";
        this.prezime = "";
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumRodjenja = java.sql.Date.valueOf(sm.format(dDatum)); 
      }


    public int getIDKorisnik(){
        
        return this.idKorisnik;
        
    }
    
    public void setIdKorisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }
    
    
    public Korisnik(int idKorisnik)
      { this.idKorisnik = idKorisnik;
      }
    
    public void setID(int id)
      { this.idKorisnik = id;
      }
    
       
    public int getPrimaryKey()
      {return this.idKorisnik;}  
    
    public String getKorisnickoIme()
      {return this.korisnickoIme;}  
    
    public String getSifra()
      {return this.sifra;}  
    
    public String getIme()
      {return this.ime;}  
    
    public String getPrezime()
      {return this.prezime;}  
    
    public Date getDatumRodjenja()
      {return this.datumRodjenja;}  
    
    public void setIDKorisnika(int idKorisnik)
      {this.idKorisnik = idKorisnik;}    
    
    public void setKorisnickoIme(String korisnickoIme)
      {this.korisnickoIme = korisnickoIme;}  
    
    public void setSifra(String sifra)
      {this.sifra = sifra; }  
    
    public void setIme(String ime)
      {this.ime = ime;}  
    
    public void setPrezime(String prezime)
      {this.prezime = prezime;}  
    
    public void setDatumRodjenja(java.sql.Date datumRodjenja)
      {this.datumRodjenja = datumRodjenja;}
    
     public java.util.Date getDatumRodjenja1(java.util.Date datumRodjenja)
      {SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
       this.datumRodjenja = java.sql.Date.valueOf(sm.format(datumRodjenja)); 
       return this.datumRodjenja;
      }
    
    
    @Override
     public String getAtrValue() { return  idKorisnik + ", '" + korisnickoIme + "', '" + sifra + "', '" + ime + "', '" + prezime + "', '" + getDatumRodjenja1(datumRodjenja) + "', '" + pol + "'"; }

    @Override
    public String setAtrValue() {
        return "idKorisnik=" + idKorisnik + ", " + "korisnickoIme='" + korisnickoIme + "', " + "sifra='" + sifra + "', ime='" + ime + "', prezime='" + prezime + "', datumRodjenja='" + getDatumRodjenja1(datumRodjenja) + "', " + "pol='" + pol + "'";           
    }

    @Override
    public String getClassName() {
        return "Korisnik";        
    }

    @Override
    public String getWhereCondition() {
        return "idKorisnik=" + idKorisnik;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"idKorisnik","korisnickoIme","sifra","ime","prezime","datumRodjenja","pol"}; 
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
      return new Korisnik(rs.getInt("idKorisnik"),rs.getString("korisnickoIme"),rs.getString("sifra"),rs.getString("ime"),rs.getString("prezime"),(rs.getDate("datumRodjenja")), Pol.valueOf(rs.getString("pol")));        
    }

    @Override
    public String poruka1() {
        return "Problem oko brojaca korisnika.";
    }

    @Override
    public String poruka2() {
        return "Ne moze da se poveca brojac korisnika.";
    }

    @Override
    public String poruka3() {
        return "Korisnik je registrovan.";
    }

    @Override
    public String poruka4() {
        return "Sistem ne može da registruje novog korisnika.";
    }

    @Override
    public String poruka5() {
        return "Sistem je obrisao korisnika.";
    }

    @Override
    public String poruka6() {
        return "Sistem ne može da obriše korisnika.";
    }

    @Override
    public String poruka7() {
        return "Ne moze se obrisati korisnik jer ne postoji.";
    }

    @Override
    public String poruka8() {
        return "Korisnik je izmenjen.";
    }

    @Override
    public String poruka9() {
        return "Sistem ne može da izmeni korisnika.";
    }

    @Override
    public String poruka10() {
        return "Ne moze se promeniti korisnik jer ne postoji.";
    }
    
}
