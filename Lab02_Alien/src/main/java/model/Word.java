package model;

import java.util.LinkedList;
import java.util.List;

public class Word {
	
	private String alienWord;
	private List<String> listaTraslation= new LinkedList<>();
	
	
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
		this.listaTraslation= new LinkedList<>();
		
	}

	public void aggiungiTraduzione(String traduzione) {
		if(!this.listaTraslation.contains(traduzione.toLowerCase()))
		    this.listaTraslation.add(traduzione.toLowerCase());
	}


	public String getAlienWord() {
		return alienWord;
	}



	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}



	public List<String> getListaTraslation() {
		return listaTraslation;
	}



	public void setListaTraslation(List<String> listaTraslation) {
		this.listaTraslation = listaTraslation;
	}



	public String getTraslation() {
		String s="";
		int dim= this.listaTraslation.size();
		
		if(dim==1) {
			s= (String)this.listaTraslation.toArray()[0];
			return s+".";
		}
		if(dim>1) {	
			
		   int n=0;
		   for(String temp: this.listaTraslation) {
			   n++;
			   if(n==this.listaTraslation.size())
			      s+=temp+".";
			   else
				   s+=temp+", "; 
			   
		   }
		   
		   return s;
		}
		
		return null;
	}
	
	
	
	
	
	


	public boolean equals(Object obj) {
	    String aliena= (String) obj;
		return this.alienWord.toLowerCase().equals(aliena.toLowerCase());
	}
	

}
