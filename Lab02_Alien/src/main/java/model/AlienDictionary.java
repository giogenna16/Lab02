package model;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dizionario;
	
	public AlienDictionary() {
		dizionario= new LinkedList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word temp= new  Word(alienWord, translation);
		boolean presente= false;
		
		for(Word w: this.dizionario) {
			if(w.equals(temp)) {
				dizionario.remove(w);
				dizionario.add(temp);
				presente= true;
			}
		}
		
		if(presente==false)
			dizionario.add(temp);	
		
	}
	
	public String translateWord(String alienWord) {
		for(Word w: this.dizionario) {
			if(w.getAlienWord().equals(alienWord))
				return w.getTraslation();
		}
		
		return null;
		
	}
}

