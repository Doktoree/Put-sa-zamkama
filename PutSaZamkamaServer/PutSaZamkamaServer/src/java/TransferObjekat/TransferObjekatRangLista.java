/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;

import DomenskeKlase.Igra;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lav
 */
public class TransferObjekatRangLista implements Serializable{
    
    private List<Igra> rangLista;
    private String poruka;
    private boolean signal;

    public TransferObjekatRangLista() {
    }

    public List<Igra> getRangLista() {
        return rangLista;
    }

    public void setRangLista(List<Igra> rangLista) {
        this.rangLista = rangLista;
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

    
    
}
