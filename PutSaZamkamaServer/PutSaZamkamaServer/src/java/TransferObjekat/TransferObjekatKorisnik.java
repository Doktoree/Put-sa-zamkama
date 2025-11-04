/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObjekat;

import DomenskeKlase.Korisnik;

/**
 *
 * @author Lav
 */
public class TransferObjekatKorisnik extends GenerickiTransferObjekat{
    
    private Korisnik korisnik;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
        this.gdo = korisnik;
    }
    
    
    
}
