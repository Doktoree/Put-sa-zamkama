/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPrijavljivanje;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public Text textKorisnickoIme;
    
    @FXML
    public Text textLozinka;
    
    @FXML
    public TextField korisnickoIme;
    
    @FXML
    public PasswordField sifra; 
    
    @FXML
    public Button btnRegistrujSe;
    
    @FXML
    public Button btnPrijaviSe;
    
    
    
    
    @FXML
    public void initialize(){
        
       KontrolerPrijavljivanje kontrolerPrijavljivanje = new KontrolerPrijavljivanje(this);
        
    }
    
    
}
