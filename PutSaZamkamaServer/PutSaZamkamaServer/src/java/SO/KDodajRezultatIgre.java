/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DomenskeKlase.GeneralDObject;
import TransferObjekat.TransferObjekatIgra;
import static SO.OpsteIzvrsenjeSO.bbp;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Lav
 */
public class KDodajRezultatIgre extends OpsteIzvrsenjeSO {

    TransferObjekatIgra toi;
    AtomicInteger counter = new AtomicInteger();
    
    public void dodajRezultatIgre(TransferObjekatIgra toi){
        
        this.toi = toi;
        opsteIzvrsenjeSO();
    }
    
    @Override
    public boolean izvrsiSO() {
        
        toi.setSignal(false);
          GeneralDObject igra = (GeneralDObject) bbp.findRecord(toi.getIgra());
        if (igra==null)
         { 
              if (!bbp.getCounter(toi.getIgra(),counter)) 
                 { toi.setPoruka(toi.getIgra().poruka1());
                 }  
               if (!bbp.increaseCounter(toi.getIgra(),counter)) 
                {  toi.setPoruka(toi.getIgra().poruka2());
                }   
            
          toi.getIgra().setID(counter.get());
             
           if (bbp.insertRecord(toi.getIgra()))
             { toi.setPoruka(toi.getIgra().poruka3());
               toi.setSignal(true);
             }
           else
             { toi.setPoruka(toi.getIgra().poruka3());  
             }
         }
       else
         {toi.setPoruka("Igra vec postoji");
         }  
       
       return toi.isSignal();
        
    }
    
}
