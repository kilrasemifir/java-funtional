package com.semifir.formation.functional.parking;

public class Voiture {

	private String model, marque;
	private int nombrePlace, volumeCarburant;
	private double poids, hauteur;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public int getVolumeCarburant() {
		return volumeCarburant;
	}
	public void setVolumeCarburant(int volumeCarburant) {
		this.volumeCarburant = volumeCarburant;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	
}
