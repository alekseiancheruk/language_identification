package cours_m2_UDv2;

import java.util.ArrayList;

public class Upos {

	private String upos;
	// tous les tokens qui vont avoir cette catégorie 
	private ArrayList<Token> tokens;
	
	public Upos(String upos) {
		this.upos = upos;
		this.tokens = new ArrayList<Token>() ;
	}
	
	public void addToken(Token tok) {
		this.tokens.add(tok) ;
	}
	
	public String getUpos() {
		return this.upos;
	}
	
	public void displayOccurrences(int nb) {
		for (int i = 0 ; i < nb && i < tokens.size(); ++i) {
			System.out.println((i+1) + ". " + tokens.get(i).getOccurrence());
		}
	}
	
}
