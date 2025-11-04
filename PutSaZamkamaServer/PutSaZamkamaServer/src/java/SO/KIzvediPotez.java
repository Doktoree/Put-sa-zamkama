/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import TransferObjekat.TransferObjekatPartija;
import LogikaIgre.Logika;
/**
 *
 * @author Lav
 */
public class KIzvediPotez extends OpsteIzvrsenjeSO{

    TransferObjekatPartija top;
    Logika logika;
    
    public void izvediPotez(TransferObjekatPartija top) {
        this.top = top;
        logika = new Logika();
        opsteIzvrsenjeSO();
    }
    
    
    
    @Override
    public boolean izvrsiSO() {
        
        if(!top.isPartijaZapoceta()){
            
            logika.generisiPocetakPartije();
            top.setPartija(logika.getPartija());
            top.setPoruka("Igra je kreirana!");
            top.setSignal(true);
            return top.isSignal();
        }
        
        logika.setPartija(top.getPartija());
        String poruka = logika.potezKorisnika(top.getPartija().getTrenutanRed(), top.getPartija().getTrenutnaKolona());
        top.setPoruka(poruka);
        
        if(poruka.equals("Korisnik je odigrao potez!")){
            
            logika.potezSistema();
            top.setPartija(logika.getPartija());
            top.setSignal(true);
            
        }
        else if(poruka.equals("Pobeda!")){
            
            top.setPartija(logika.getPartija());
            top.setSignal(true);
            
        }
        
        else{
            
            top.setSignal(false);
            
        }
        
        return top.isSignal();
    }
    
}
