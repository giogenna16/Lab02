package model;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dizionario;
	
	public AlienDictionary() {
		dizionario= new LinkedList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		boolean presente =false;
		Word temp= null;
		for(Word w: dizionario)
			if(w.equals(alienWord)) {
				presente= true;
				temp=w;
				}
			
		if(presente== true) {
			temp.aggiungiTraduzione(translation);
			dizionario.add(temp);
		}
		if(presente== false) {
			temp= new Word(alienWord);
			temp.aggiungiTraduzione(translation);
			dizionario.add(temp);
	}
				
}	
	
	
	public String translateWord(String alienWord) {
		for(Word w: this.dizionario) {
			if(w.equals(alienWord))
				return w.getTraslation();
		}
		
		return null;
		
	}
}

