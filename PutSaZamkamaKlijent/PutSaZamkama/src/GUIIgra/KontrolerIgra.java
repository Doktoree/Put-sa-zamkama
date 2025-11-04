/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIIgra;

import DomenskeKlase.TrenutniKorisnik;
import GUIIgra.Osluskivaci.OsluskivacIgrePotez;
import GUIIgra.Osluskivaci.OsluskivacIgraPocetak;
import GUIKorisnik.KonverterGUIDK;
import GUIKorisnik.Osluskivaci.OsluskivacKorisnik;
import GUIRangLista.Osluskivaci.OsluskivacRangLista;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.GenerickiTransferObjekat;
import Server_client.Partija;
import Server_client.TransferObjekatIgra;
import Server_client.TransferObjekatPartija;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lav
 */
public class KontrolerIgra {
    
    FXMLDocumentController fXMLDocumentController;
    GenerickiKontrolerServer_Service generickiKontrolerServer_Service;
    GenerickiKontrolerServer generickiKontrolerServer;
    Server_client.Partija partija;
    
    public KontrolerIgra(FXMLDocumentController fXMLDocumentController) {
        this.fXMLDocumentController = fXMLDocumentController;
        generickiKontrolerServer_Service = new GenerickiKontrolerServer_Service();
        generickiKontrolerServer = generickiKontrolerServer_Service.getGenerickiKontrolerServerPort();
        fXMLDocumentController.zapocniIgru.setOnAction(new OsluskivacIgraPocetak(this));
        fXMLDocumentController.nalogKorisnika.setOnAction(new OsluskivacKorisnik());
        fXMLDocumentController.rangLista.setOnAction(new OsluskivacRangLista());
        fXMLDocumentController.izlazIzPrograma.setOnAction(e -> Platform.exit());
        partija = new Server_client.Partija();
        postaviOsluskivaceNaDugmad();
        ocistiTablu();
    }
    
    public void poruka(String poruka){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Poruka:");
        alert.setHeaderText(null); 
        alert.setContentText(poruka); 
        alert.showAndWait(); 
        
    }

    
    public void kreirajIgru(){
        
        poruka("Sistem je kreirao novu partiju.");
        
        List<Button> dugmici = fXMLDocumentController.vratiDugmice();
        
        for(Button b: dugmici){
            
            b.setDisable(false);
            
        }
        
        TransferObjekatPartija top = new TransferObjekatPartija();
        top.setPartijaZapoceta(false);
        top = generickiKontrolerServer.izvediPotez(top);
        partija = top.getPartija();
        Button dugmePocetak = formirajButton(top.getPartija().getPocetak().get(0),top.getPartija().getPocetak().get(1));
        Button dugmeKraj = formirajButton(top.getPartija().getKraj().get(0), top.getPartija().getKraj().get(1));        
        postaviSliku(vratiSliku("start"), dugmePocetak);
        postaviSliku(vratiSliku("finish"), dugmeKraj);
        
        
        
    }
    
    public Button formirajButton(int x, int y){
        
        String str = "#p" + x + y;
        return (Button) fXMLDocumentController.grid.getScene().lookup(str);
        
    }
    
    public void postaviSliku(Image slika, Button dugme ){
        
        ImageView imageView = new ImageView(slika);
        imageView.setFitWidth(45);  
        imageView.setFitHeight(45); 
        imageView.setPreserveRatio(true); 
        dugme.setGraphic(imageView);
        
    }
    
    public Image vratiSliku(String ime)
    {   String location = "slike/";
        String filename =  ime + ".png";
        Image slikaBroja = new Image(location + filename);
        return slikaBroja;

    }
    
    public void postaviOsluskivaceNaDugmad(){
        
        List<Button> dugmici = fXMLDocumentController.vratiDugmice();
        OsluskivacIgrePotez osluskivacIgrePotez = new OsluskivacIgrePotez(this);
        
        for(Button b : dugmici){
            
            b.setOnAction(osluskivacIgrePotez);
            
        }
        
    }
    
    public void odigrajPotez(int x, int y){
        
        TransferObjekatPartija top = new TransferObjekatPartija();
        top.setPartijaZapoceta(true);
        top.setPartija(partija);
        top.getPartija().setTrenutanRed(x);
        top.getPartija().setTrenutnaKolona(y);
        top = generickiKontrolerServer.izvediPotez(top);
        
        if(top.isSignal()){
            
            partija = top.getPartija();
            Button dugme = formirajButton(x, y);
            postaviSliku(vratiSliku("cikica"), dugme);
            
            if(top.getPoruka().equals("Pobeda!")){
                popuniPoljaSistema(partija);
                poruka(top.getPoruka() + "\nVas rezultat je: " + top.getPartija().getBrojPoteza());
                dodajRezultatIgre(top.getPartija().getBrojPoteza());
                ocistiTablu();
                
                
            }
                
            
        }
        
        else{
            popuniPoljaSistema(partija);
            poruka(top.getPoruka());
            
            if(top.getPoruka().equals("Korisnik je upao u zamku!"))
                ocistiTablu();
            
        }
        
        
    }
    
    public void ocistiTablu(){
        
        Field[] polja = fXMLDocumentController.getClass().getDeclaredFields();
        
        for(Field f : polja){
            
            if(Button.class.isAssignableFrom(f.getType())){
                
                f.setAccessible(true);
            try {
                Button b = (Button) f.get(fXMLDocumentController);
                b.setGraphic(null);
                b.setDisable(true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
                
            }
            
        }
        
    }
    
    
    public boolean dodajRezultatIgre(int rezultat){
        
        GenerickiTransferObjekat gto = new TransferObjekatIgra();
        Server_client.Igra igra = new Server_client.Igra();
        igra.setDatum(KonverterGUIDK.konvertujLocalDateUXMLGregorianCalendar(LocalDate.now()));
        igra.setKorisnik(TrenutniKorisnik.getKorisnik());
        igra.setRezultat(rezultat);
        gto.setGdo(igra);
        gto = generickiKontrolerServer.kreirajDK(gto);
        
        return gto.isSignal();
    }
    
    public void popuniPoljaSistema(Partija partija){
        
        for(int i = 0; i<6; i++){
            
            for(int j = 0; j<6; j++){
                
                if(partija.getMatrica().get(i).getItem().get(j) == 2){
                    
                    postaviSliku(vratiSliku("sistem"), formirajButton(i, j));
                    
                }
                
            }
            
        }
        
    }
}
