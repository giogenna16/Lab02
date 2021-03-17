package model;

public class Word {
	
	private String alienWord;
	private String traslation;
	
	
	
	public Word(String alienWord, String traslation) {
		super();
		this.alienWord = alienWord;
		this.traslation = traslation;
	}



	public String getAlienWord() {
		return alienWord;
	}



	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}



	public String getTraslation() {
		return traslation;
	}



	public void setTraslation(String traslation) {
		this.traslation = traslation;
	}



	public boolean equals(Object obj) {
		Word parola= (Word) obj;
		return this.alienWord.equals(parola.alienWord);
	}
	

}
