package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	@Autowired
	private VilleDAO villeDAO;

	public ArrayList<Ville> getInfoVille(String param) {
		ArrayList<Ville> ville = null;
		if (param != null) {
			ville = villeDAO.getInfoVilles(param);
		} else {
			ville = villeDAO.getInfoVille();
		}
		return ville;
	}

	public void creerVille(Ville ville) {
		villeDAO.setVille(ville);
	}

	public void mettreAJour(Ville ville) {
		villeDAO.mettreAJour(ville);
	}

	public void supprimerLigne(String code_commune_INSEE) {
		villeDAO.supprimerLigne(code_commune_INSEE);
	}

}
