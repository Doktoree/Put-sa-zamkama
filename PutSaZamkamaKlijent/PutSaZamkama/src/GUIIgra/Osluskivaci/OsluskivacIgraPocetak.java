/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIIgra.Osluskivaci;

import GUIIgra.KontrolerIgra;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Lav
 */
public class OsluskivacIgraPocetak implements EventHandler{

    KontrolerIgra kontrolerIgra;

    public OsluskivacIgraPocetak(KontrolerIgra kontrolerIgra) {
        this.kontrolerIgra = kontrolerIgra;
    }
    
    
    
    @Override
    public void handle(Event event) {
        
        kontrolerIgra.kreirajIgru();
        
    }
    
}
