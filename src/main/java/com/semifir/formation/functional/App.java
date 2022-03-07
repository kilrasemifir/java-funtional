package com.semifir.formation.functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {
	
	private static Random rng = new Random();
	private static Map<String, Consumer<Integer>> consumersDict = new HashMap<String, Consumer<Integer>>();
	
	
	/**
	 * Génere une liste de nombres aléatoires de taille taille.
	 * @param taille de la liste
	 * @param maximum des valeurs possible (valeur haute exclue des résultats)
	 * @return une liste de taille taille ayant des nombre aléatoire entre 0 et maximum-1
	 */
	public static List<Integer> generationAleatoireEntier(int taille, int maximum){
		List<Integer> results = new ArrayList<Integer>();
		for (int i=0; i<taille; i++) {
			results.add(rng.nextInt(maximum));
		}
		return results;
	}
	
	public static void exempleCosumer(int item) {
		int carre = item*item;
		double sqrt  = Math.sqrt(item);
		String str = "nombre="+item;
		System.out.println(new StringBuilder()
				.append("carre="+carre)
				.append("  sqrt ="+sqrt)
				.append("  str  = "+str));
	}

	

	private static void exempleLambda(List<Integer> liste) {
		exempleLoop(liste);
		exempleLambdaInline(liste);
		exempleLambdaLong(liste);
		exempleRef(liste);
	}

	/**
	 * @param liste
	 */
	private static void exempleRef(List<Integer> liste) {
		System.out.println("\nMtd ref");
		liste.forEach(App::exempleCosumer);
	}

	/**
	 * @param liste
	 */
	private static void exempleLambdaLong(List<Integer> liste) {
		System.out.println("\nMtd avec lambda sur plusieur lignes");
		liste.forEach(item -> {
			int carre = item*item;
			double sqrt  = Math.sqrt(item);
			String str = "nombre="+item;
			System.out.println(new StringBuilder()
					.append("carre="+carre)
					.append("  sqrt ="+sqrt)
					.append("  str  = "+str));
		});
	}

	/**
	 * @param liste
	 */
	private static void exempleLambdaInline(List<Integer> liste) {
		System.out.println("\nMtd avec lambda sur une ligne");
		liste.forEach(item -> exempleCosumer(item));
	}

	/**
	 * @param liste
	 */
	private static void exempleLoop(List<Integer> liste) {
		System.out.println("Mtd avec boucle for");
		for (Integer item : liste) {
			exempleCosumer(item);
		}
	}
	
	private static void imprimer(Integer item) {}
	
	private static void envoyerEmail(Integer item) {}
	
	public static void forEach(List<Integer> liste, Consumer<Integer> foo) {
		for (Integer integer : liste) {
			foo.accept(integer);
		}
	}
	
	/**
	 * 
	 */
	private static void exempledict() {
		consumersDict.put("Email", App::envoyerEmail);
		consumersDict.put("Imprimer", App::imprimer);
		consumersDict.put("Console", System.out::println);
		
		List<Integer> liste = generationAleatoireEntier(10, 100);
		//exempleLambda(liste);
		String typeConsume = "Email";
		
		forEach(liste, consumersDict.get(typeConsume));
	}
	
	public static void main(String[] args) {
		//exempledict();
		Function<String, Integer> taille = str -> str.length();
		System.out.println(taille.apply("Hello tout le monde"));
		
		Predicate<String> predicate = str -> str.length() < 10;
		System.out.println(predicate.test("Hello tout le monde"));
		
		Supplier<String> dateJour = ()-> LocalDate.now().toString();
		System.out.println(dateJour.get());
		
		MonTypeFonction foo = (message, repete) -> {
			for (int i =0; i<repete; i++) {
				System.out.println(repete);
			}
		};
		
		foo.repete("Hello", 10);
	}

	
	
	
}
