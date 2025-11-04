/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIKorisnik.Osluskivaci;

import Enumi.Mod;
import GUIKorisnik.Korisnik;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Lav
 */
public class OsluskivacKorisnik implements EventHandler{

    
    @Override
    public void handle(Event event) {
        
        Korisnik k = new Korisnik();
        k.setMod(Mod.NALOG_KORISNIKA);
        try {
            k.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(OsluskivacKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
