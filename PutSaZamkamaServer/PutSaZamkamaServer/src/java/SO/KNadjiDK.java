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
public class KNadjiDK extends OpsteIzvrsenjeSO {
    GenerickiTransferObjekat gto;
    
    
    public void nadjiDK(GenerickiTransferObjekat gto)
     { this.gto = gto;
       opsteIzvrsenjeSO();    
     }
    
    @Override
    public boolean izvrsiSO()
      {  gto.setSignal(false); 
         gto.postaviDK((GeneralDObject)bbp.findRecord(gto.getGdo()));
        if (gto.getGdo()!=null)
         { gto.setSignal(true); 
           gto.setCurrentRecord(bbp.findRecordPosition(gto.getGdo()));
           gto.setPoruka("Sistem je pronasao korisnika!");
         }
        else
         { gto.setCurrentRecord(-1);
           gto.setPoruka("Sistem nije pronasao korisnika!");
         }  
       return gto.isSignal();
      }     
}