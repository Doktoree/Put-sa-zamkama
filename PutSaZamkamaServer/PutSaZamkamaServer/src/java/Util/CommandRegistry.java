/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import TransferObjekat.TransferObjekatKorisnikLogin;
import Util.commands.PrijaviKorisnikaCommand;

/**
 *
 * @author Lav
 */
public class CommandRegistry {
    
    public static Object executeCommand(Object object){
        
        
        if(object instanceof TransferObjekatKorisnikLogin){
            
            return new PrijaviKorisnikaCommand().izvrsi(object);
        }
        
        
        return null;
    }
    
}
