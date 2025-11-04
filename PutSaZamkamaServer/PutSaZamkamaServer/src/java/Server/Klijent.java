/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Util.CommandRegistry;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lav
 */
public class Klijent extends Thread{
    
    private final Socket soketS;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Klijent(Socket soketS1, int brojKlijenta) {
        soketS = soketS1;
        start();
    }

    @Override
    public void run() {
        
        try {
            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            while (true) {
                Object receivedObject = in.readObject();
                
                Object returnObject = executeOperation(receivedObject);
                
                if (returnObject != null) {
                    sendObject(returnObject);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    private Object executeOperation(Object receivedObject) {
        
        return CommandRegistry.executeCommand(receivedObject);
        
    }

    private void sendObject(Object object) throws IOException {
        out.writeObject(object);
        out.flush();
        out.reset();
    }

    
}
