package com.semifir.formation.functional.parking;

import java.util.Arrays;
import java.util.List;

public class Parking <T>{
	private T[] places;

    public Parking(){
        this(1);
    }

    public Parking(int nombrePlace){
        this.places = (T[]) new Object[nombrePlace];
    }

    /**
    * Range une voiture dans un emplacement vide.
    * Si tout les emplacements sont pris, retourne une exception de type RuntimeException.
    *
    * @param voiture à ranger
    * @return l'emplacement de la voiture
    */
    public int ranger(T vehicule){
        for (int emplacement = 0; emplacement< places.length; emplacement++) {
        	if (places[emplacement] == null) {
        		places[emplacement] = vehicule;
        		return emplacement;
        	}
        }
        throw new RuntimeException("Il n'y a plus de place");
    }

    /**
    * Retourne la liste des voitures
    * 
    * @return la liste des voitures
    */
    public List<T> listerVoiture(){
    	/*
    	List<Voiture> voitures = new ArrayList<Voiture>();
    	for (Voiture v: places) {
    		voitures.add(v);
    	}
    	return voitures;
    	*/
        return Arrays.asList(places);
    }

    /**
    * Retourne la voiture situé a l'emplamcement.
    *
    * @return la voiture a l'emplacement, null s'il n'y a pas de voiture.
    */ 
    public T getVoiture(int emplacement){
    	return places[emplacement];
    }

    /**
    * Sort la voiture du parking.
    * Léve une exception RuntimeException s'il n'y a pas de voiture.
    * 
    * @param emplacement de la voiture a sortir
    * return la voiture sortie
    */
    public T sortirCamion(int emplacement){
    	T vehicule = getVoiture(emplacement);
    	places[emplacement] = null;
    	if (vehicule == null) throw new RuntimeException("Il n'y a pas de voiture a cet emplacement");
    	return vehicule;
    }
    
    public static void main(String[] args) {
		Parking<Voiture> pv = new Parking<Voiture>();
		pv.ranger(new Voiture());
		Parking<Camion> pc = new Parking<Camion>();
		pc.ranger(new Camion());
		Parking<String> ps = new Parking<String>();
		ps.ranger("Je suis une voiture");
		System.out.println(pv.listerVoiture());
	}
}
