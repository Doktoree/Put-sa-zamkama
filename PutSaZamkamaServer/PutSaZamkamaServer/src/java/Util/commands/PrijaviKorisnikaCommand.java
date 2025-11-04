/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.commands;

import SO.KPrijaviDK;
import TransferObjekat.TransferObjekatKorisnikLogin;
import Util.Command;

/**
 *
 * @author Lav
 */
public class PrijaviKorisnikaCommand implements Command{

    
    
    @Override
    public Object izvrsi(Object primljenObjekat) {
        
        TransferObjekatKorisnikLogin tokl = (TransferObjekatKorisnikLogin) primljenObjekat;
        
        KPrijaviDK kPrijaviDK = new KPrijaviDK();
        kPrijaviDK.prijaviDK(tokl);
        return primljenObjekat;
        
        
    }
    
}
