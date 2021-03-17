package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.AlienDictionary;

public class FXMLController {

	AlienDictionary model= new AlienDictionary();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;

    @FXML
    void doTranslate(ActionEvent event) {
    	// TODO - add the button and complete this    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO - add the button and complete this 
    }
    
    
    
    @FXML
    void initialize() {

    }
    
    public void setModel(AlienDictionary model) {
    	this.model= model;
    }
}