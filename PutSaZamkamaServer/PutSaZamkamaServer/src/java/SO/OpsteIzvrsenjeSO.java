/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import BrokerBazePodataka.*;
import DomenskeKlase.GeneralDObject;




/**
 *
 * @author Lav
 */
public abstract class OpsteIzvrsenjeSO {
    static public BrokerBazePodataka bbp = new BrokerBazePodatakaImpl();
    int recordsNumber;
    int currentRecord = -1;
    GeneralDObject gdo;
    
    synchronized public boolean opsteIzvrsenjeSO()
      {  bbp.makeConnection();
         boolean signal = izvrsiSO();
        if (signal==true) 
          bbp.commitTransation();
        else
         bbp.rollbackTransation();
        bbp.closeConnection();
        return signal;
      }    
       
     
    abstract public boolean izvrsiSO();
    
}
