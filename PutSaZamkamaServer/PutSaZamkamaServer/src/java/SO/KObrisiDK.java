/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;


import DomenskeKlase.GeneralDObject;
import TransferObjekat.GenerickiTransferObjekat;



/**
 *
 * @author Lav
 */
public class KObrisiDK extends OpsteIzvrsenjeSO {
    GenerickiTransferObjekat gto;
        
     public void obrisiDK(GenerickiTransferObjekat gto)
     { this.gto = gto;
       opsteIzvrsenjeSO();    
     }
    
    @Override
    public boolean izvrsiSO()
      { gto.setSignal(false);
          GeneralDObject gdo1 = bbp.findRecord(gto.getGdo());
        if (gdo1!=null)
         {  if (bbp.deleteRecord(gto.getGdo()))
            { gto.setPoruka(gto.getGdo().poruka5()); 
              gto.setSignal(true);
            }
           else
             { gto.setPoruka(gto.getGdo().poruka6());  
             }
         }
       else
         { gto.setPoruka(gto.getGdo().poruka7()); 
         }  
       
       return gto.isSignal();
      }     
}