/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;

import DomenskeKlase.Igra;

/**
 *
 * @author Lav
 */
public class TransferObjekatIgra extends GenerickiTransferObjekat{
    
    private Igra igra;

    public TransferObjekatIgra() {
    }

    
    
    public Igra getIgra() {
        return igra;
    }

    public void setIgra(Igra igra) {
        this.igra = igra;
        this.gdo = igra;
    }

    
    
    
    
}
