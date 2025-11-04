/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIIgra.Osluskivaci;

import GUIIgra.KontrolerIgra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author Lav
 */
public class OsluskivacIgrePotez implements EventHandler<ActionEvent> {

    private KontrolerIgra kontrolerIgra;
    
    public OsluskivacIgrePotez(KontrolerIgra kontrolerIgra) {
        
        this.kontrolerIgra = kontrolerIgra;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        Button kliknutoDugme = (Button) event.getSource();
        String id = kliknutoDugme.getId();

        String koordinate = id.substring(1);

        int x = Character.getNumericValue(koordinate.charAt(0));
        int y = Character.getNumericValue(koordinate.charAt(1));
        
        kontrolerIgra.odigrajPotez(x, y);
        
    }
    
}
