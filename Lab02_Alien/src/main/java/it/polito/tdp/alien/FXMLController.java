package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.AlienDictionary;
import model.Word;

public class FXMLController {

	AlienDictionary model= new AlienDictionary();
   
    
	@FXML
    private TextField txtInserici;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	this.btnTraduci.setDisable(false);
    	this.btnClear.setDisable(true);
    	this.txtInserici.setDisable(false);
    	this.txtInserici.clear();
    	this.txtResult.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	this.btnTraduci.setDisable(true);
        this.btnClear.setDisable(false);
        this.txtInserici.setDisable(true);
        String t= this.txtInserici.getText();
        if(t.length()==0) {
        	this.txtResult.setText("Devi inserire una parola per tradurla o due parole per aggiungere la traduzione!!!");
        	return;
        }
        else {
        	
    	String[] parole= this.txtInserici.getText().split(" ");
    	
    	if(parole.length==2) {
    		String aliena= parole[0];
    		String tradotta= parole[1];
    		
    		if (!Pattern.matches("[a-zA-Z]+", aliena) || !Pattern.matches("[a-zA-Z]+", tradotta)){
    			    
    			this.txtResult.setText("Le parole possono contenere soltanto lettere!!!");
    		}
    		else {
    			model.addWord(aliena, tradotta);
	            this.txtResult.setText("La parola inserita e la rispettiva traduzione sono state aggiunte con successo!");
    		}
    	}
    	if(parole.length==1) {
    		String aliena= parole[0];
    		if(!aliena.contains("?")) {
    		   String temp= model.translateWord(aliena);
    		   if (!Pattern.matches("[a-zA-Z]+", aliena)) {
    			  this.txtResult.setText("this.txtResult.setText(\"La parola può contenere soltanto lettere\no lettere e un punto interrogativo(wildcard)!!!\");");
    	    	}
    	     	else {
    			
    			   if(temp!= null) {
    			 	
    				  if(temp.contains(","))
    				    	this.txtResult.setText("Le traduzioni della parola inserita sono: "+temp);
    				  else
    				    	this.txtResult.setText("La traduzione della parola inserita è: "+temp);
    				
    			    }
			      
		          else
			              this.txtResult.setText("Non esiste una traduzione per questa parola!");
    		  }
    		}
    		else {
    			if (!Pattern.matches("[a-zA-Z?]+", aliena)) {
      			  this.txtResult.setText("La parola può contenere soltanto lettere\no lettere e un punto interrogativo(wildcard)!!!");
      	    	}
    			else {
    			int n=0;
    			for(int i=1; i<aliena.length(); i++) {
    				if(aliena.substring(i-1, i).equals("?"))
    					n++;
    				if(aliena.substring(i).equals("?"))
    					n++;
    			}
    			if(n!=1) {
    				this.txtResult.setText("E' possibile inserire al massimo un punto interrogativo!!!");
    			}
    			else {
    			String r="";
    			for(String s: model.translateWildCard(aliena)) {
    				
    				r+=s;
 
    			}
    			if(r.equals(""))
    				this.txtResult.setText("Non esiste una traduzione per questa parola!");
    			else
    			 this.txtResult.setText(r);
    			}
    			}
    	  }
    	}
    	if(parole.length>2) {
    		 this.txtResult.setText("Non è possibile inserire più di due parole!\nDevi inserire una parola per tradurla o due parole per aggiungere la traduzione!!!");
    	}
    	
        }
    	
    	
    }
    
    public void setModel(AlienDictionary model) {
    	this.model= model;
    }
}