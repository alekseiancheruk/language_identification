package cours_m2_UDv2;

import java.util.HashMap;

public class Lemme {

	private String lemme;
	private HashMap<String, Form> forms;
	
	public Lemme(String lemme) {
		this.lemme = lemme;
		this.forms = new HashMap<String, Form>();
	}
	
	public void addForm(Form form) {
		if(! forms.containsKey(form.getForm())) {
			forms.put(form.getForm(), form);		}
	}
	
	public String getLemme() {
		return this.lemme;
	}


	public void displayForms() {
		// TODO Auto-generated method stub
		for(String f : forms.keySet()) {
			System.out.println(f);
		}
	}
	
}
