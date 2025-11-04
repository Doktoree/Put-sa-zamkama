/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRangLista;

import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.Igra;
import Server_client.Korisnik;
import Server_client.TransferObjekatRangLista;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Lav
 */
public class KontrolerRangLista {
    
    GUIRangLista.FXMLDocumentController fXMLDocumentController;
    GenerickiKontrolerServer_Service generickiKontrolerServer_Service;
    GenerickiKontrolerServer generickiKontrolerServer;
    
    public KontrolerRangLista(GUIRangLista.FXMLDocumentController fXMLDocumentController) {
        this.fXMLDocumentController = fXMLDocumentController;
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
    
   public boolean vratiRangListu(){
       
       TransferObjekatRangLista torl = new TransferObjekatRangLista();
       torl = generickiKontrolerServer.vratiRangListu(torl);
       if(!torl.isSignal()){
           
           poruka(torl.getPoruka());
           return false;
       }
       
       popuniTabelu(torl.getRangLista(), fXMLDocumentController);
       poruka(torl.getPoruka());
       
           
       return true;
   }
    
   public void popuniTabelu(List<Igra> lista, FXMLDocumentController fXMLDocumentController) {
       
        
       fXMLDocumentController.datum.setCellValueFactory(cellData -> {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
           XMLGregorianCalendar xmlCal = cellData.getValue().getDatum();
           if (xmlCal != null) {
               LocalDate localDate = xmlCal.toGregorianCalendar().toZonedDateTime().toLocalDate();
               return new SimpleStringProperty(localDate.format(formatter));
           } else {
               return new SimpleStringProperty("");
           }
       });

        

            fXMLDocumentController.korisnickoIme.setCellValueFactory(cellData -> {
            Korisnik k = cellData.getValue().getKorisnik();
            String korisnickoIme = (k != null) ? k.getKorisnickoIme(): "";
            return new SimpleStringProperty(korisnickoIme);
        });

        fXMLDocumentController.rezultat.setCellValueFactory(new PropertyValueFactory<>("rezultat"));


        fXMLDocumentController.tabela.setItems(FXCollections.observableArrayList(lista));
        
        
}
   
}
