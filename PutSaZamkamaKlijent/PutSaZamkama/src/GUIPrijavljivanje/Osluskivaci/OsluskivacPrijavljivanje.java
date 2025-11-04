/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPrijavljivanje.Osluskivaci;

import GUIPrijavljivanje.KontrolerPrijavljivanje;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Lav
 */
public class OsluskivacPrijavljivanje implements EventHandler{

    private KontrolerPrijavljivanje kontrolerPrijavljivanje;

    public OsluskivacPrijavljivanje(KontrolerPrijavljivanje kontrolerPrijavljivanje) {
        this.kontrolerPrijavljivanje = kontrolerPrijavljivanje;
    }
    
    
    @Override
    public void handle(Event event) {
        
        kontrolerPrijavljivanje.prijaviKorisnika();
        
    }
    
}
