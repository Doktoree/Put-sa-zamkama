/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DomenskeKlase.Igra;
import TransferObjekat.TransferObjekatRangLista;
import java.util.List;

/**
 *
 * @author Lav
 */
public class KVratiRangListu extends OpsteIzvrsenjeSO {

    TransferObjekatRangLista torl;
    
    public void vratiRangListu(TransferObjekatRangLista torl){
        
        this.torl = torl;
        opsteIzvrsenjeSO();
    }
    
    @Override
    public boolean izvrsiSO() {
        
        
        List<Igra> igre = bbp.vratiIgreSaKorisnikom();
        
        
        if(igre.isEmpty()){
            System.out.println("Nema rezultata!");
            torl.setSignal(false);
            torl.setPoruka("Ne postoje trenutno zabelezeni rezultati!");
            
        }
        else{
        
        torl.setRangLista(igre);
        torl.setSignal(true);
        torl.setPoruka("Sistem je pronasao rang listu");
        }
        
        
        
        
        return torl.isSignal();
    }
    
    
    
}
