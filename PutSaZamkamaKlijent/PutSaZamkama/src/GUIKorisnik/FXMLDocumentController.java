/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIKorisnik;

import Enumi.Mod;
import Server_client.Pol;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lav
 */
public class FXMLDocumentController {

    @FXML
    public Text naslov;
    
    @FXML
    public Text naslovId;
    
    @FXML
    public TextField idKorisnik;
    
    @FXML
    public TextField korisnickoIme;
    
    @FXML
    public TextField ime;
    
    @FXML
    public TextField prezime;
    
    @FXML
    public PasswordField sifra;
    
    @FXML 
    public DatePicker datumRodjenja;
    
    @FXML
    public Button zapamtiKorisnika;
    
    @FXML
    public Button obrisiKorisnika;
    
    @FXML
    public ComboBox pol;
    
    private Mod mod;
    
    @FXML
    public void initialize() {
        KontrolerKorisnik kontrolerKorisnik = new KontrolerKorisnik(this);
    }    

    public Mod getMod() {
        return mod;
    }
    
    
    
    public void setMode(Mod mod){
        
        this.mod = mod;
        
        switch(mod){
            
            case REGISTRACIJA:{
                
                naslovId.setVisible(false);
                idKorisnik.setVisible(false);
                naslov.setText("Registracija korisnika");
                obrisiKorisnika.setVisible(false);
                zapamtiKorisnika.setVisible(true);
                pol.setItems(FXCollections.observableArrayList(Pol.values()));
                break;
            }
            
            case NALOG_KORISNIKA:{
                
                naslov.setText("Izmena korisnika");
                naslovId.setVisible(true);
                idKorisnik.setVisible(true);
                obrisiKorisnika.setVisible(true);
                zapamtiKorisnika.setVisible(true);
                break;
                
            }
           
                            
            
        }
        
    }
    
}
