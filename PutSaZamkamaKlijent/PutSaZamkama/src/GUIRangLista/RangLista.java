/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRangLista;

import Enumi.Mod;
import GUIKorisnik.KontrolerKorisnik;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Lav
 */
public class RangLista extends Application {

    FXMLDocumentController fXMLDocumentController;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fXMLDocumentController = (FXMLDocumentController) fxmlLoader.getController();
        
        KontrolerRangLista krl = new KontrolerRangLista(fXMLDocumentController);
        if(krl.vratiRangListu()){
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
        
            stage.initModality(Modality.APPLICATION_MODAL); 
            stage.setResizable(false);
            stage.setTitle("Rang lista");
            stage.show();
        }
        
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
