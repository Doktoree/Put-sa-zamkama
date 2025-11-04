package GUIKorisnik;

import Enumi.Mod;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lav
 */
public class Korisnik extends Application{
    
    GUIKorisnik.FXMLDocumentController fXMLDocumentController;
    Mod mod;
    
    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fXMLDocumentController = (GUIKorisnik.FXMLDocumentController) fxmlLoader.getController();
        fXMLDocumentController.setMode(mod);
        
        if(mod == Mod.NALOG_KORISNIKA){
            
            KontrolerKorisnik kk = new KontrolerKorisnik(fXMLDocumentController);
            kk.ucitajKorisnika();
            
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.setResizable(false);
        stage.setTitle("Registracija");
        stage.show();

    }

    public GUIKorisnik.FXMLDocumentController getfXMLDocumentController() {
        return fXMLDocumentController;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }
    
    
}
