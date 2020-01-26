package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VilleFranceDAOImpl;
import com.dto.client.VilleFrance;

@RestController
//@RequestMapping("/path")
class VilleController {

	

	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<VilleFrance> get(@RequestParam(required = false, value="codeCommuneINSEE") String codeCommuneINSEE,
			@RequestParam(required = false, value="nomCommune") String nomCommune,
			@RequestParam(required = false, value="codePostal") String codePostal,
			@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne5") String ligne5,
			@RequestParam(required = false, value="latitude") String latitude,
			@RequestParam(required = false, value="longitude") String longitude) {
		
		ArrayList<VilleFrance> villesFrance = null;
		VilleFranceDAOImpl vfdao = new VilleFranceDAOImpl();
		
		VilleFrance villeFrance = new VilleFrance();
		villeFrance.setCodeCommuneINSEE(getSpace(codeCommuneINSEE));
		villeFrance.setNomCommune(getSpace(nomCommune));
		villeFrance.setCodePostal(getSpace(codePostal));
		villeFrance.setLibelleAcheminement(getSpace(libelleAcheminement));
		villeFrance.setLigne5(getSpace(ligne5));
		villeFrance.setLatitude(getSpace(latitude));
		villeFrance.setLongitude(getSpace(longitude));
		
		villesFrance = vfdao.trouver(villeFrance);
		
		return villesFrance;
	}

	@RequestMapping(value="/post", method=RequestMethod.POST)
	@ResponseBody
	public void post(@RequestParam(required = true, value="codeCommuneINSEE") String codeCommuneINSEE,
			@RequestParam(required = true, value="nomCommune") String nomCommune,
			@RequestParam(required = true, value="codePostal") String codePostal,
			@RequestParam(required = true, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne5") String ligne5,
			@RequestParam(required = true, value="latitude") String latitude,
			@RequestParam(required = true, value="longitude") String longitude) {
		
		VilleFrance villeFrance = new VilleFrance();
		VilleFranceDAOImpl vfdao = new VilleFranceDAOImpl();
		
		villeFrance.setCodeCommuneINSEE((codeCommuneINSEE));
		villeFrance.setNomCommune((nomCommune));
		villeFrance.setCodePostal((codePostal));
		villeFrance.setLibelleAcheminement((libelleAcheminement));
		villeFrance.setLigne5((ligne5));
		villeFrance.setLatitude((latitude));
		villeFrance.setLongitude((longitude));
		
		vfdao.ajouter(villeFrance);
		
	}

	@RequestMapping(value="/put", method=RequestMethod.PUT)
	@ResponseBody
	public void put(@RequestParam(required = true, value="codeCommuneINSEE") String codeCommuneINSEE,
			@RequestParam(required = false, value="nomCommune") String nomCommune,
			@RequestParam(required = false, value="codePostal") String codePostal,
			@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne5") String ligne5,
			@RequestParam(required = false, value="latitude") String latitude,
			@RequestParam(required = false, value="longitude") String longitude) {
				
		VilleFranceDAOImpl vfdao = new VilleFranceDAOImpl();
		
		VilleFrance villeFrance = new VilleFrance();
		villeFrance.setCodeCommuneINSEE(getSpace(codeCommuneINSEE));
		villeFrance.setNomCommune(getSpace(nomCommune));
		villeFrance.setCodePostal(getSpace(codePostal));
		villeFrance.setLibelleAcheminement(getSpace(libelleAcheminement));
		villeFrance.setLigne5(getSpace(ligne5));
		villeFrance.setLatitude(getSpace(latitude));
		villeFrance.setLongitude(getSpace(longitude));
		
		vfdao.modifier(villeFrance);
		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required = true, value = "codeCommuneINSEE") String codeCommuneInsee) {

		VilleFranceDAOImpl vfdao = new VilleFranceDAOImpl();

		vfdao.supprimerVille(codeCommuneInsee);
	}
	
	private String getSpace(String str) {
		if (str == null) {
			return str;
		}
		return str.replaceAll("%20", " ");
	}
}
