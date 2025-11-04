/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;

import DomenskeKlase.KorisnikLogin;
import java.io.Serializable;

/**
 *
 * @author Lav
 */
public class TransferObjekatKorisnikLogin implements Serializable{
    
    private int id;
    public KorisnikLogin kor;
    public String poruka;
    public boolean signal;
    public int indeks = -1;
    public String nazivOperacije;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
