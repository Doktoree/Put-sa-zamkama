/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;

import DomenskeKlase.Partija;
import java.io.Serializable;

/**
 *
 * @author Lav
 */
public class TransferObjekatPartija implements Serializable{
    
    private Partija partija;
    private boolean partijaZapoceta;
    private String poruka;
    private boolean signal;
    private String nazivOperacije;

    public TransferObjekatPartija() {
    }

    
    
    public Partija getPartija() {
        return partija;
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public String getNazivOperacije() {
        return nazivOperacije;
    }

    public void setNazivOperacije(String nazivOperacije) {
        this.nazivOperacije = nazivOperacije;
    }

    public boolean isPartijaZapoceta() {
        return partijaZapoceta;
    }

    public void setPartijaZapoceta(boolean partijaZapoceta) {
        this.partijaZapoceta = partijaZapoceta;
    }
    
    
    
    
}
