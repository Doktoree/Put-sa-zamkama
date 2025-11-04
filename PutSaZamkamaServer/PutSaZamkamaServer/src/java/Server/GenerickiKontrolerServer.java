/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import TransferObjekat.TransferObjekatKorisnikLogin;
import TransferObjekat.TransferObjekatPartija;
import TransferObjekat.TransferObjekatRangLista;
import SO.KIzmeniDK;
import SO.KIzvediPotez;
import SO.KKreirajDK;
import SO.KNadjiDK;
import SO.KObrisiDK;
import SO.KPrijaviDK;
import SO.KVratiRangListu;
import TransferObjekat.GenerickiTransferObjekat;
import javax.jws.WebService;

/**
 *
 * @author Lav
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {

    public  GenerickiTransferObjekat  kreirajDK(GenerickiTransferObjekat gto) 
    { 
      new KKreirajDK().kreirajDK(gto);  
      
      return gto;
    }
    
     public GenerickiTransferObjekat izmeniDK(GenerickiTransferObjekat gto)
     { new KIzmeniDK().izmeniDK(gto);
       return gto;
     }
     
    
     public GenerickiTransferObjekat obrisiDK(GenerickiTransferObjekat gto)
     { new KObrisiDK().obrisiDK(gto);
       return gto;
     }
     
      public TransferObjekatKorisnikLogin prijaviDK(TransferObjekatKorisnikLogin tok)
     { 
       KPrijaviDK kPrijaviDK = new KPrijaviDK();
       kPrijaviDK.prijaviDK(tok);
       return kPrijaviDK.getGto();
     }
      
      public TransferObjekatPartija izvediPotez(TransferObjekatPartija top)
     { 
         new KIzvediPotez().izvediPotez(top);
         return top;
         
     }
    
     public  GenerickiTransferObjekat  nadjiDk(GenerickiTransferObjekat gto) 
    { 
      new KNadjiDK().nadjiDK(gto);  
      return gto;
    }
    
     public TransferObjekatRangLista vratiRangListu(TransferObjekatRangLista torl){
         
         new KVratiRangListu().vratiRangListu(torl);
         return torl;
         
     }
}
