package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MissionDAO;
import com.dao.VilleFranceDAO;
import com.dto.Mission;
import com.dto.client.VilleFrance;

@Service
public class VilleBLOImpl implements VilleFranceBLO {

	@Autowired
	private VilleFranceDAO villeFranceDAO;

	@Override
	public ArrayList<VilleFrance> getInfoVilles(String codeCommuneINSEE) throws VilleException {
		ArrayList<VilleFrance> listVilles;

		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des
		// informations
		if (codeCommuneINSEE == null || "".equalsIgnoreCase(codeCommuneINSEE)) {
			listVilles = villeFranceDAO.findAllVilles();
		} else {
			listVilles = villeFranceDAO.findAllVilles();
		}
		System.out.println("Nombre de mission récupéré : " + listVilles.size());

		return listVilles;
	}

}
