package cours_m2_UDv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList ;
import java.util.Collections;
import java.util.HashMap ;
import java.util.List;

public class Corpus {
	
	private String name ;
	private String corpusFile;
	private ArrayList<Sentence> sentences ;
	private HashMap<String,Form> forms ;
	private HashMap<String,Upos> upos;
	private HashMap<String,Lemme> lemmes;
	
	public Corpus(String name, String corpusFile) throws IOException {
		this.name = name;
		this.corpusFile = corpusFile;
		sentences = new ArrayList<Sentence>();
		forms = new HashMap<String,Form>();
		lemmes = new HashMap<String,Lemme>();
		upos = new HashMap<String,Upos>();
		readCorpus();
	}
	
	private void readCorpus() throws IOException {
		Path p1 = Paths.get(this.corpusFile);
		Charset charset = Charset.forName("UTF-8") ;
		try (BufferedReader reader = Files.newBufferedReader(p1, charset)) {
			String line = reader.readLine();
			while(line != null) {
				String sentId = line.substring(12);
				line = reader.readLine();
				String sentText = line.substring(9);
				// appel au constructeur de Sentence 
				Sentence sent = new Sentence(sentId, sentText);
				sentences.add(sent);
				line = reader.readLine();
				// Tant que l'on trouve des tokens 
				while(line.length() > 0) {
					String[] lineSplit = line.split("\t");
					if( ! lineSplit[0].contains("-")) {
						Form f ;
						if(forms.containsKey(lineSplit[1])) {
							// Cas où la forme a déjà été rencontrée
							f = forms.get(lineSplit[1]);
						} else {
							// Première occurrence de la forme
							f = new Form(lineSplit[1]);
							// On l'ajoute dans la HashMap
							forms.put(lineSplit[1], f);
						}
						
						Token tok = new Token(Integer.parseInt(lineSplit[0]),
								f, sent);
						
						Lemme lem ;
						if(lemmes.containsKey(lineSplit[2])) {
							lem = lemmes.get(lineSplit[2]);
						} else {
							lem = new Lemme(lineSplit[2]);
							lemmes.put(lineSplit[2], lem);
						}
						lem.addForm(f);
						
						Upos pos ;
						if(upos.containsKey(lineSplit[3])) {
							pos = upos.get(lineSplit[3]);
						} else {
							pos = new Upos(lineSplit[3]);
							upos.put(lineSplit[3], pos);
						}
						pos.addToken(tok);
						
						//Ajout du token à l'objet de type Sentence
						sent.addToken(tok);
						// On ajoute la nouvelle occurrence
						f.addToken(tok);
					}
					line = reader.readLine();
				}
				line = reader.readLine();
			}
		}

	}
	
	/*
	 * Classe Corpus :
	 * Affichage des occurrences de la forme
	 */
	public void displayFormOccurrences(String form, int nb) {
		if (this.forms.containsKey(form)) {
			forms.get(form).displayOccurrences(nb);
		} else {
			System.out.println("Il n'y pas d'occurrences de "+form);
		}
		
	}

	public void displayLemmaOccurrences(String lemma) {
		// TODO Auto-generated method stub
		if(this.lemmes.containsKey(lemma)) {
			lemmes.get(lemma).displayForms();
		} else {
			System.out.println("Il n'y pas d'occurrences de "+lemma);
		}
	}

	public void displayUposOccurrences(String pos, int nb) {
		// TODO Auto-generated method stub
		if(upos.containsKey(pos)) {
			upos.get(pos).displayOccurrences(nb);
		} else {
			System.out.println("Il n'y pas d'occurrences de "+pos);
		}
	}
	
	public void displayMostFrequentForms(int nb) {
		List<Form> formsList = new ArrayList<Form>(forms.values());
		Collections.sort(formsList);
		for (int i = 0; i < nb && i < formsList.size(); i++) {
			System.out.println((i + 1) + ". " + formsList.get(i).toString());
		}
	}

}
