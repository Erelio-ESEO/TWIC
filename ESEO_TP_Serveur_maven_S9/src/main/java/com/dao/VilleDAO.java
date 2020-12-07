package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	
	public ArrayList<Ville> getInfoVille();

	public void setVille(Ville ville);

	public ArrayList<Ville> getInfoVilles(String param);

	public void mettreAJour(Ville ville);

	public void supprimerLigne(String code_commune_INSEE);
}
