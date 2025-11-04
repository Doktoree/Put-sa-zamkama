/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DomenskeKlase.Korisnik;
import TransferObjekat.GenerickiTransferObjekat;

/**
 *
 * @author Lav
 */
public class KIzmeniDK extends OpsteIzvrsenjeSO {

    GenerickiTransferObjekat gto;
    
    public void izmeniDK(GenerickiTransferObjekat gto){
        
        this.gto = gto;
        opsteIzvrsenjeSO();
        
    }
    
    @Override
    public boolean izvrsiSO() {
        
        gto.setSignal(false);
        Korisnik korisnik = (Korisnik) bbp.findRecord(gto.getGdo());
        
        if(korisnik != null){
            
          gto.setSignal(bbp.updateRecord(gto.getGdo(), korisnik));
          gto.setPoruka(korisnik.poruka8());
          
        }
        
        else {
            
            gto.setPoruka(new Korisnik().poruka10());
            
        }
        
        return gto.isSignal();
    }
    
}
