/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPrijavljivanje;


import DomenskeKlase.KorisnikLogin;
import java.lang.reflect.Field;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lav
 */
public class KonverterGUIDK {

    public static boolean konvertujGUIUDK(FXMLDocumentController fxcon, KorisnikLogin tok) {
        for (Field f : fxcon.getClass().getDeclaredFields()) {
            for (Field dk : tok.getClass().getDeclaredFields()) {
                dk.setAccessible(true);
                if (dk.getName().equals(f.getName())) {
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(tok, ((javafx.scene.control.TextField) f.get(fxcon)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(tok, ((javafx.scene.control.PasswordField) f.get(fxcon)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

}
