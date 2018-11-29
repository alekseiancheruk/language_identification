package cours_m2_UDv2;

import java.util.ArrayList ;

public class Sentence {
	
	// Données membres
	private String id, text ;
	private ArrayList<Token> tokens ;
	
	// Constructeur
	public Sentence(String id, String text) {
		this.id = id ;
		this.text = text ;
		tokens = new ArrayList<Token>() ;
	}
	
	// Méthodes : addToken, toString, getNbTokens
	
	public void addToken(Token token) {
		tokens.add(token) ;
	}
	
	public String toString() {
		return this.id+"\t"+this.text ;
	}
	
	public int getNbTokens() {
		return tokens.size();
	}
	

}
