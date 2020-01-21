package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleFranceBLO;
import com.dto.Mission;
import com.dto.client.VilleFrance;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleFranceBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public String recover(@RequestParam(required = false, value = "codeCommuneINSEE") String codeCommuneINSEE) {
		System.out.println("Appel GETsqdsq");

		ArrayList<VilleFrance> listVilles = villeService.getInfoVilles(codeCommuneINSEE);
		System.out.println(listVilles.get(0).getNomCommune());

		return "coucou";
	}

	// Methode POST
	//TODO
	
	// Methode PUT
	//TODO

}
