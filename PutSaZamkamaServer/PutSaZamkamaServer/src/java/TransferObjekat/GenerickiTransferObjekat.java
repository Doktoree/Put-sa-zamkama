/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;




import DomenskeKlase.GeneralDObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 *
 * @author Lav
 */
@XmlSeeAlso({
    TransferObjekatIgra.class,
    TransferObjekatKorisnik.class,
})
public abstract class GenerickiTransferObjekat implements Serializable{
    
   protected GeneralDObject gdo; 
   protected String poruka;
   protected boolean signal; 
   protected int currentRecord = -1;
   
   public void postaviDK(GeneralDObject gdo)  {this.gdo = gdo;}
   public String vratiPoruka(){return poruka;}
   public boolean vratiSignal(){return signal;} 
   public GeneralDObject vratiDK(){return (GeneralDObject) gdo;}

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public boolean isSignal() {
        return signal;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public GeneralDObject getGdo() {
        return gdo;
    }

    public void setGdo(GeneralDObject gdo) {
        this.gdo = gdo;
    }

    public int getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(int currentRecord) {
        this.currentRecord = currentRecord;
    }
   
    
   
    
    
    
}
