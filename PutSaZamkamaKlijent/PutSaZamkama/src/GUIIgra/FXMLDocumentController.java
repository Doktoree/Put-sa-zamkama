/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIIgra;

import java.util.Arrays;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lav
 */
public class FXMLDocumentController {

    @FXML
    public GridPane grid;
    
    @FXML
    public MenuBar menuBar;

    @FXML
    public Menu igra;
    
    @FXML
    public Menu korisnik;
    
    @FXML
    public Menu izlazIzPrograma;
    
    
    @FXML
    public MenuItem zapocniIgru;
    @FXML
    public MenuItem rangLista;
    @FXML
    public MenuItem nalogKorisnika;
    @FXML
    public MenuItem izlaz;

    @FXML
    public Button p00;
    @FXML
    public Button p10;
    @FXML
    public Button p20;
    @FXML
    public Button p30;
    @FXML
    public Button p40;
    @FXML
    public Button p50;

    @FXML
    public Button p01;
    @FXML
    public Button p11;
    @FXML
    public Button p21;
    @FXML
    public Button p31;
    @FXML
    public Button p41;
    @FXML
    public Button p51;

    @FXML
    public Button p02;
    @FXML
    public Button p12;
    @FXML
    public Button p22;
    @FXML
    public Button p32;
    @FXML
    public Button p42;
    @FXML
    public Button p52;

    @FXML
    public Button p03;
    @FXML
    public Button p13;
    @FXML
    public Button p23;
    @FXML
    public Button p33;
    @FXML
    public Button p43;
    @FXML
    public Button p53;

    @FXML
    public Button p04;
    @FXML
    public Button p14;
    @FXML
    public Button p24;
    @FXML
    public Button p34;
    @FXML
    public Button p44;
    @FXML
    public Button p54;

    @FXML
    public Button p05;
    @FXML
    public Button p15;
    @FXML
    public Button p25;
    @FXML
    public Button p35;
    @FXML
    public Button p45;
    @FXML
    public Button p55;
    
    @FXML
    public void initialize(){
        
        KontrolerIgra kontrolerIgra = new KontrolerIgra(this);
        
    }

    public List<Button> vratiDugmice(){
        
        return Arrays.asList(
        p00, p01, p02, p03, p04, p05,
        p10, p11, p12, p13, p14, p15,
        p20, p21, p22, p23, p24, p25,
        p30, p31, p32, p33, p34, p35,
        p40, p41, p42, p43, p44, p45,
        p50, p51, p52, p53, p54, p55
    );
        
    }
}
