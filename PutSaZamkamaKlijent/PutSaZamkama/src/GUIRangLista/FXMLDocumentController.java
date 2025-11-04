/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRangLista;

import Server_client.Igra;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Lav
 */
public class FXMLDocumentController {

    @FXML
    public TableView<Igra> tabela;
    
    @FXML
    public TableColumn<Igra, String> korisnickoIme;
    
    @FXML
    public TableColumn<Igra,Integer> rezultat;
    
    @FXML
    public TableColumn<Igra, String> datum;
    
    @FXML
    public void initialize() {
        KontrolerRangLista kontrolerRangLista = new KontrolerRangLista(this);
    }    

    
}
