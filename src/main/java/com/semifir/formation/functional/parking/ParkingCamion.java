package com.semifir.formation.functional.parking;

import java.util.Arrays;
import java.util.List;

public class ParkingCamion{
    private Camion[] places;

    public ParkingCamion(){
        this(1);
    }

    public ParkingCamion(int nombrePlace){
        this.places = new Camion[nombrePlace];
    }

    /**
    * Range une voiture dans un emplacement vide.
    * Si tout les emplacements sont pris, retourne une exception de type RuntimeException.
    *
    * @param voiture à ranger
    * @return l'emplacement de la voiture
    */
    public int ranger(Camion vehicule){
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
    public List<Camion> listerVoiture(){
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
    public Camion getVoiture(int emplacement){
    	return places[emplacement];
    }

    /**
    * Sort la voiture du parking.
    * Léve une exception RuntimeException s'il n'y a pas de voiture.
    * 
    * @param emplacement de la voiture a sortir
    * return la voiture sortie
    */
    public Camion sortirCamion(int emplacement){
    	Camion vehicule = getVoiture(emplacement);
    	places[emplacement] = null;
    	if (vehicule == null) throw new RuntimeException("Il n'y a pas de voiture a cet emplacement");
    	return vehicule;
    }

}