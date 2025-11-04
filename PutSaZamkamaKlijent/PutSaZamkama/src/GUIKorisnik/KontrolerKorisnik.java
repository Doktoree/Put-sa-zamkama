/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIKorisnik;

import DomenskeKlase.TrenutniKorisnik;
import Enumi.Mod;
import Server_client.GeneralDObject;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.GenerickiTransferObjekat;
import Server_client.TransferObjekatKorisnik;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Lav
 */
public class KontrolerKorisnik {
    
    FXMLDocumentController fXMLDocumentController;
    GenerickiKontrolerServer_Service generickiKontrolerServer_Service;
    GenerickiKontrolerServer generickiKontrolerServer;
    
    public KontrolerKorisnik(FXMLDocumentController fXMLDocumentController) {
        this.fXMLDocumentController = fXMLDocumentController;
        generickiKontrolerServer_Service = new GenerickiKontrolerServer_Service();
        generickiKontrolerServer = generickiKontrolerServer_Service.getGenerickiKontrolerServerPort();
        
        if(fXMLDocumentController.getMod() == Mod.NALOG_KORISNIKA)
            fXMLDocumentController.zapamtiKorisnika.setOnAction(e -> izmeniKorisnika());
        else
            fXMLDocumentController.zapamtiKorisnika.setOnAction(e -> registrujKorisnika());
        
        fXMLDocumentController.obrisiKorisnika.setOnAction(e -> obrisiKorisnika());
        
        
    }
    
    public void poruka(String poruka){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Poruka:");
        alert.setHeaderText(null); 
        alert.setContentText(poruka); 
        alert.showAndWait(); 
        
    }

    
   public void registrujKorisnika(){
        
       
       if (fXMLDocumentController.ime.getText() == null || fXMLDocumentController.korisnickoIme.getText() == null
               || fXMLDocumentController.prezime.getText() == null || fXMLDocumentController.datumRodjenja.getValue() == null
               || fXMLDocumentController.pol.getValue() == null) {

           poruka("Sistem ne može da registruje novog korisnika!");
           return;
       }
       
        Server_client.Korisnik korisnik = new Server_client.Korisnik();
        fXMLDocumentController.idKorisnik.setText("-1");
        KonverterGUIDK.konvertujGUIUDK(fXMLDocumentController, korisnik);
        
        obradiKorisnika(korisnik, TransferObjekatKorisnik.class, 
        gto -> (TransferObjekatKorisnik) generickiKontrolerServer.kreirajDK(gto));

        Stage stage = (Stage) fXMLDocumentController.ime.getScene().getWindow();
        stage.close();
        
    }
    
    public void ucitajKorisnika(){
        
        Server_client.Korisnik korisnik = TrenutniKorisnik.getKorisnik();
        
        obradiKorisnika(korisnik, TransferObjekatKorisnik.class,
        gto -> {
            gto.setGdo(korisnik);
            gto = (TransferObjekatKorisnik) generickiKontrolerServer.nadjiDk(gto);

            TrenutniKorisnik.setKorisnik((Server_client.Korisnik) gto.getGdo());

            KonverterGUIDK.konvertujDKUGUI(gto.getGdo(), fXMLDocumentController);
            return gto;
        });
        
    }
    
    public void izmeniKorisnika(){
        
        if (fXMLDocumentController.ime.getText().isEmpty() || fXMLDocumentController.korisnickoIme.getText().isEmpty()
               || fXMLDocumentController.prezime.getText().isEmpty()) {

           poruka("Sistem ne može da izmeni korisnika!");
           return;
       }
        
        Server_client.Korisnik korisnik = new Server_client.Korisnik();
        KonverterGUIDK.konvertujGUIUDK(fXMLDocumentController, korisnik);

        obradiKorisnika(korisnik, TransferObjekatKorisnik.class,
            gto -> (TransferObjekatKorisnik) generickiKontrolerServer.izmeniDK(gto)
            );

        Stage stage = (Stage) fXMLDocumentController.prezime.getScene().getWindow();
        stage.close();
        
    }
    
    public void obrisiKorisnika(){
        
        Server_client.Korisnik korisnik = new Server_client.Korisnik();
        KonverterGUIDK.konvertujGUIUDK(fXMLDocumentController, korisnik);

         obradiKorisnika(korisnik, TransferObjekatKorisnik.class,
            gto -> (TransferObjekatKorisnik) generickiKontrolerServer.obrisiDK(gto)
            );

        Platform.exit();
    }
    
    public <T extends GenerickiTransferObjekat, M extends GeneralDObject> void obradiKorisnika(M model, Class<T> gtoClass, Function<T,T> operacija){
        
        try {
            T gto = gtoClass.getDeclaredConstructor().newInstance();
            gto.setGdo(model);
            
            gto = operacija.apply(gto);
            
            if (model instanceof Server_client.Korisnik) {
                TrenutniKorisnik.setKorisnik((Server_client.Korisnik) gto.getGdo());
            }
            
            poruka(gto.getPoruka());
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
