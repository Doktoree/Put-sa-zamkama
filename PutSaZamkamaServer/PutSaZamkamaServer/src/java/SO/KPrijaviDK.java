/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DomenskeKlase.GeneralDObject;
import DomenskeKlase.Korisnik;
import DomenskeKlase.KorisnikLogin;
import TransferObjekat.TransferObjekatKorisnikLogin;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Lav
 */
public class KPrijaviDK extends OpsteIzvrsenjeSO{

    TransferObjekatKorisnikLogin tok;
    AtomicInteger atomicInteger = new AtomicInteger();
    
    public void prijaviDK(TransferObjekatKorisnikLogin tok) {
        this.tok = tok;
        opsteIzvrsenjeSO();
    }
    
    
    @Override
    public boolean izvrsiSO() {
       
        tok.signal = false;
        KorisnikLogin korisnikLogin = tok.kor;
        List<GeneralDObject> list = bbp.findRecord(new Korisnik(), korisnikLogin.getWhereCondition());
        
        if(list!= null && !list.isEmpty()){
            
            Korisnik k = (Korisnik) list.get(0);
            tok.setId(k.getPrimaryKey());
            tok.signal = true;
            tok.poruka = "Korisnik je uspešno prijavljen";
            
        }
        
        else{
            
            tok.poruka = "Sistem ne može da prijavi korisnika!";
            
        }
  
        
        return tok.signal;
    }

    public TransferObjekatKorisnikLogin getGto() {
        return tok;
    }
    
    
}
