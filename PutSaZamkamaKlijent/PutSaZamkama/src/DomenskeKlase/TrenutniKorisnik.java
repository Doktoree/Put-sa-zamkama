/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomenskeKlase;

/**
 *
 * @author Lav
 */
public class TrenutniKorisnik {
    
    private static Server_client.Korisnik korisnik;

    public TrenutniKorisnik() {
    }

    public static Server_client.Korisnik getKorisnik() {
        return korisnik;
    }

    public static void setKorisnik(Server_client.Korisnik korisnik) {
        TrenutniKorisnik.korisnik = korisnik;
    }
    
    
    
}
