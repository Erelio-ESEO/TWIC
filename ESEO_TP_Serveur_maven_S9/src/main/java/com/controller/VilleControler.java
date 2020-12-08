package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

//import com.blo.VilleBLO;

@RestController
// @RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET");
		System.out.println("param = " + monParam);
		ArrayList<Ville> ville = villeService.getInfoVille(monParam);
		return ville;
	}

	// Methode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Ville> appelPost(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel POST");
		villeService.creerVille(ville);
		ArrayList<Ville> ville1 = null;
		return ville1;
	}

	// Methode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville ville) throws ClassNotFoundException, SQLException {
		System.out.println("Appel PUT");
		villeService.mettreAJour(ville);
	}

	// Methode DELETE
	@RequestMapping(value = "/ville/delete/{Code_commune_INSEE}", method = RequestMethod.DELETE)
	public void appelDelete(@PathVariable("Code_commune_INSEE") String Code_commune_INSEE) throws Exception {
		System.out.println("Appel DELETE");
		villeService.supprimerLigne(Code_commune_INSEE);
	}
}
