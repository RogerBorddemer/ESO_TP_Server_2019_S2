package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.LieuMission;
import com.dto.Mission;

@Repository
public class MissionDAOImpl implements MissionDAO {

	@Override
	public ArrayList<Mission> findAllTrains() {
		ArrayList<Mission> listMission = new ArrayList<Mission>();

		try {
			// solution 1
			Connection con = JDBCConfigurationSol1.getConnection();
			// solution 2
			// Connection con = JDBCConfigurationSol2.getConnection();
			Statement statement = con.createStatement();

			// execute la requete
			ResultSet resultSet = statement.executeQuery("SELECT * FROM info_train");

			// parcourt des éléments de réponse
			while (resultSet.next()) {
				Mission mission = new Mission();

				mission.setId(resultSet.getInt("id"));
				mission.setNumeroTrain(resultSet.getString("numero"));
				mission.setDateCirculation(resultSet.getString("dateCirculation"));
				mission.setHoraireDepart(resultSet.getString("horaireDepart"));
				mission.setHoraireDestination(resultSet.getString("horaireDestination"));
				LieuMission lieuMissionOrigine = new LieuMission();
				lieuMissionOrigine.setUIC(resultSet.getString("lieuOrigineUIC"));
				lieuMissionOrigine.setLibPr(resultSet.getString("lieuOrigineLibPr"));
				mission.setLieuOrigine(lieuMissionOrigine);
				LieuMission lieuMissionDestination = new LieuMission();
				lieuMissionDestination.setUIC(resultSet.getString("lieuDestinationUIC"));
				lieuMissionDestination.setLibPr(resultSet.getString("lieuDestinationLibPr"));
				mission.setLieuDestination(lieuMissionDestination);

				listMission.add(mission);
			}

			// close de la connexion
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMission;

	}

}
