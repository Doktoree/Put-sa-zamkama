/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;



import DomenskeKlase.GeneralDObject;
import TransferObjekat.GenerickiTransferObjekat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Lav
 */
public class KKreirajDK extends OpsteIzvrsenjeSO {
    
    GenerickiTransferObjekat gto;
    AtomicInteger counter = new AtomicInteger();
    
    public void kreirajDK(GenerickiTransferObjekat gto)
     { this.gto = gto;
       opsteIzvrsenjeSO();    
     }
    
    @Override
    public boolean izvrsiSO()
      { gto.setSignal(false); 
          GeneralDObject kor1 = (GeneralDObject) bbp.findRecord(gto.getGdo());
        if (kor1==null)
         { 
              if (!bbp.getCounter(gto.getGdo(),counter)) 
                 { gto.setPoruka(gto.getGdo().poruka1());
                 }  
               if (!bbp.increaseCounter(gto.getGdo(),counter)) 
                {  gto.setPoruka(gto.getGdo().poruka2());
                }   
            
          gto.getGdo().setID(counter.get()); 
             
           if (bbp.insertRecord(gto.getGdo()))
             { gto.setPoruka(gto.getGdo().poruka3());
               gto.setSignal(true);
             }
           else
             { gto.setPoruka(gto.getGdo().poruka4());  
             }
         }
       else
         { gto.setPoruka("Domenska klasa postoji");
         }  
       
          System.out.println(gto.getPoruka());
        
       return gto.isSignal();
      }     
}