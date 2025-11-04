/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRangLista.Osluskivaci;

import GUIRangLista.RangLista;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;


/**
 *
 * @author Lav
 */
public class OsluskivacRangLista implements EventHandler{

    
    
    @Override
    public void handle(Event event) {
        
        RangLista rangLista = new RangLista();
        try {
            rangLista.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(OsluskivacRangLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
