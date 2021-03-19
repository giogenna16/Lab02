package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	public List<String> translateWildCard(String alienWord) {
		if(alienWord.contains("?")) {
			List<String> listaTraduzioni= new LinkedList<>();
			List<Word> temporanea= new LinkedList<>(this.dizionario);
			
			int posizione=-1;
			for(int i=1; i<alienWord.length();i++) {
				if(alienWord.substring(i-1, i).equals("?"))
					posizione=i-1;
				if(alienWord.substring(i).equals("?"))
					posizione=i;
			}
			String temp=alienWord.replace("?", "");
			
			for(Word w: temporanea) {
				if(w.getAlienWord().length()==alienWord.length()) {
				    if(w.togliLettera(posizione).equals(temp))
				    	if(!listaTraduzioni.contains(w.getTraslationWildCard()))
				    	     listaTraduzioni.add(w.getTraslationWildCard());
				   
				}
				
			}
			
			return listaTraduzioni;
			
			
		}
		return null;
		
	}
}

