package cours_m2_UDv2;

import java.util.ArrayList ;

public class Form implements Comparable<Form> {

	private String form ;
	private ArrayList<Token> occurrences;
	
	public Form(String form) {
		this.form = form ;
		this.occurrences = new ArrayList<Token>() ;
	}
	
	public void addToken(Token token) {
		this.occurrences.add(token) ;
	}
	
	public String getForm() {
		return this.form ;
	}
	
	public void displayOccurrences() {
		for (Token tok : occurrences) {
			System.out.println(tok.getOccurrence());
		}
	}
	
	/**
	 * Affiche au plus nb occurrences
	 * @param nb
	 */
	public void displayOccurrences(int nb) {
		for (int i = 0 ; i < nb && i < occurrences.size(); ++i) {
			System.out.println((i+1) + ". " + occurrences.get(i).getOccurrence());
		}
		
	}

	public Integer getNbTokens() {
		return this.occurrences.size();
	}

	// Trier la liste des formes
	@Override
	public int compareTo(Form o) {
		// TODO Auto-generated method stub
		// normal order, compareTo() parameter is >0 : return this.getNbTokens().compareTo(o.getNbTokens());
		return o.getNbTokens().compareTo(this.getNbTokens()); // compareTo() parameter is <0 : inversed order
	}
	
	// Shows les formes les plus fréquentes
	@Override
	public String toString() {
		return this.form + "(" + this.getNbTokens() + ")";
	}
		
}
