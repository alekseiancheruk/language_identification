package cours_m2_UDv2;

public class Token {
	
	private int id ;
	private Form form ;
	private Sentence sentence ;
	
	public Token(int id, Form form,
			Sentence sentence) {
		this.id = id ;
		this.form = form ;
		this.sentence = sentence ;
	}
	
	public String getOccurrence() {
		return form.getForm() + " : " + sentence.toString();
	}
	
}
