package fr.eseo.twic.dao;

import java.util.ArrayList;

import fr.eseo.twic.beans.Ville;

public interface VilleDAO {
	
	
	public ArrayList<Ville> getInfoVille();

	public void setVille(Ville ville);

	public ArrayList<Ville> getInfoVilles(String param);

	public void mettreAJour(Ville ville);

	public void supprimerLigne(String code_commune_INSEE);
}
