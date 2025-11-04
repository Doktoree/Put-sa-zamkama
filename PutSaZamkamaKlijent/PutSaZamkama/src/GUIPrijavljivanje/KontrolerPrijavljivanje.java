/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPrijavljivanje;

import DomenskeKlase.KorisnikLogin;
import TransferObjekat.TransferObjekatKorisnikLogin;
import DomenskeKlase.TrenutniKorisnik;
import GUIIgra.Igra;
import GUIPrijavljivanje.Osluskivaci.OsluskivacPrijavljivanje;
import GUIKorisnik.Osluskivaci.OsluskivacRegistracija;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.Korisnik;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Lav
 */
public class KontrolerPrijavljivanje {
 
    FXMLDocumentController fXMLDocumentController;
    GenerickiKontrolerServer_Service generickiKontrolerServer_Service;
    GenerickiKontrolerServer generickiKontrolerServer;
    
    public KontrolerPrijavljivanje(FXMLDocumentController fXMLDocumentController) {
        this.fXMLDocumentController = fXMLDocumentController;
        this.fXMLDocumentController.btnPrijaviSe.setOnAction(new OsluskivacPrijavljivanje(this));
        this.fXMLDocumentController.btnRegistrujSe.setOnAction(new OsluskivacRegistracija(this));
        generickiKontrolerServer_Service = new GenerickiKontrolerServer_Service();
        generickiKontrolerServer = generickiKontrolerServer_Service.getGenerickiKontrolerServerPort();
        
    }
    
    
    public void poruka(String poruka){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Poruka:");
        alert.setHeaderText(null); 
        alert.setContentText(poruka); 
        alert.showAndWait(); 
        
    }
    
    /*public void prijaviKorisnika(){
        TransferObjekatKorisnikLogin tok = new TransferObjekatKorisnikLogin();
        tok.setKor(new Server_client.KorisnikLogin());
        KonverterGUIDK.konvertujGUIUDK(fXMLDocumentController, tok.getKor());
        tok = generickiKontrolerServer.prijaviDK(tok);
        poruka(tok.getPoruka());
        
        if(tok.isSignal()){
            
            try {
                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnickoIme(tok.getKor().getKorisnickoIme());
                korisnik.setSifra(tok.getKor().getSifra());
                korisnik.setIdKorisnik(tok.getId());
                TrenutniKorisnik.setKorisnik(korisnik);
                new Igra().start(new Stage());
                Stage stage = (Stage) fXMLDocumentController.korisnickoIme.getScene().getWindow();
                stage.close();
            } catch (Exception ex) {
                Logger.getLogger(KontrolerPrijavljivanje.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }*/
    
    public void prijaviKorisnika() {
        
        TransferObjekatKorisnikLogin tok = new TransferObjekatKorisnikLogin();
        tok.kor = new KorisnikLogin("", "");
        KonverterGUIDK.konvertujGUIUDK(fXMLDocumentController, tok.kor);

        try (Socket socket = new Socket("localhost", 8189);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject(tok);
            out.flush();
            out.reset();

            TransferObjekatKorisnikLogin odgovor = (TransferObjekatKorisnikLogin) in.readObject();
            poruka(odgovor.poruka);

            if (odgovor.signal) {
                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnickoIme(odgovor.kor.getKorisnickoIme());
                korisnik.setSifra(odgovor.kor.getSifra());
                korisnik.setIdKorisnik(odgovor.getId());

                TrenutniKorisnik.setKorisnik(korisnik);

                new Igra().start(new Stage());

                Stage stage = (Stage) fXMLDocumentController.korisnickoIme.getScene().getWindow();
                stage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            poruka("Greška prilikom povezivanja na server: " + e.getMessage());
        }
    }
    
    
}
