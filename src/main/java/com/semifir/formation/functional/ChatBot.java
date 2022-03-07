package com.semifir.formation.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Chat bot incroyable
 * @author Killian
 *
 */
public class ChatBot {
	
	private static Map<String, Consumer<String>> interactions = new HashMap<>();
	private static Scanner scannerConsole = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Bonjour, je suis un super chatbot!! que voulez vous?");
		
		interactions.put("hello", message-> System.out.println("Bonjour!"));
		interactions.put("Hello", message-> System.out.println("Bonjour!"));
		interactions.put("hello!", message-> System.out.println("Bonjour!"));
		interactions.put("Hello!", message-> System.out.println("Bonjour!"));
		

		interactions.put("dit bonjour a m2i par mail!", message-> {
			System.out.println("Ok, j'envoie un mail a M2i");
			System.out.println("Mail envoyé");
		});
		
		interactions.put("ca va?", message-> System.out.println("Oui et vous?"));
		interactions.put("on danse?", message-> System.out.println("Je n'ai pas de jambe, je suis un systeme informatique, merci!"));
		interactions.put("aurevoir", message-> System.exit(0));
		
		String message = "";
		while (true) {
			message = scannerConsole.nextLine();
			Consumer<String> action = interactions.getOrDefault(message, msg-> System.out.println("Je n'ai pas compri votre message:\n"+msg));
			action.accept(message);
		}
		
		
	}

}
