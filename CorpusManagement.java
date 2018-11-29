package cours_m2_UDv2;

import java.io.IOException;
import java.util.Scanner;

public class CorpusManagement {
	
	static Scanner lectureClavier ;
	
	public static void displayMenu(Corpus c) {
		System.out.println("");
		System.out.println("1. Chercher une forme");
		System.out.println("2. Chercher les formes d'un lemme");
		System.out.println("3. Chercher une catégorie");
		System.out.println("4. Afficher les formes les plus fréquentes");
		System.out.println("5. Quitter le programme");
		byte option = lectureClavier.nextByte();
		switch(option) {
			case 1 :
				System.out.println("Quelle forme ? ");
				String form = lectureClavier.next() ;
				System.out.println("Combien ? ");
				int nb = lectureClavier.nextInt();
				c.displayFormOccurrences(form, nb);
				displayMenu(c);
				break ;
			case 2 :
				System.out.println("Quelle lemme afficher ?");
				String lemma = lectureClavier.next() ;
				c.displayLemmaOccurrences(lemma) ;
				displayMenu(c);
				break;
			case 3 :
				System.out.println("Quelle catégorie ?");
				String cat = lectureClavier.next() ;
				System.out.println("Combien ? ");
				int nb2 = lectureClavier.nextInt();
				c.displayUposOccurrences(cat, nb2) ;
				displayMenu(c);
				break;
			case 4 :
				System.out.println("Combien ? ");
				int nb3 = lectureClavier.nextInt();
				c.displayMostFrequentForms(nb3);
				displayMenu(c);
				break;
			case 5 :
				lectureClavier.close();
				System.out.println("Au revoir");
				System.exit(0);
			default :
				System.out.println("Veuillez entrer une option valide");
				displayMenu(c) ;
		}
		
	}

	public static void main(String[] args) {
		lectureClavier = new Scanner(System.in);
		System.out.println("Bienvenue");
		Corpus c;
		try {
			c = new Corpus("PARTUT", "input/fr_partut-ud-train.conllu.txt");
			displayMenu(c);
		} catch (IOException e) {
			System.out.println("Erreur de chargement du corpus");
		}
		
	}

}
