package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MissionDAO;
import com.dto.Mission;

@Service
public class MissionBLOImpl implements MissionBLO {

	@Autowired
	private MissionDAO missionDAO;

	@Override
	public ArrayList<Mission> getInfoMission(String numTrain) throws MissionException {
		ArrayList<Mission> listMission;

		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des
		// informations
		if (numTrain == null || "".equalsIgnoreCase(numTrain)) {
			listMission = missionDAO.findAllTrains();
		} else {
			listMission = missionDAO.findAllTrains();
		}
		System.out.println("Nombre de mission récupéré : " + listMission.size());

		return listMission;
	}

}
