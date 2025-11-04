/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIKorisnik.Osluskivaci;

import Enumi.Mod;
import GUIKorisnik.Korisnik;
import GUIPrijavljivanje.KontrolerPrijavljivanje;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Lav
 */
public class OsluskivacRegistracija implements EventHandler{

    
    public OsluskivacRegistracija(KontrolerPrijavljivanje kp){
        
        
    }
    
    @Override
    public void handle(Event event) {
        
        Korisnik korisnik = new Korisnik();
        try {
            korisnik.setMod(Mod.REGISTRACIJA);
            korisnik.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(OsluskivacRegistracija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
