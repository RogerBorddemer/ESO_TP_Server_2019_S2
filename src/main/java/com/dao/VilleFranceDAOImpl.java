package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfig;
import com.dto.client.VilleFrance;

@Repository
public class VilleFranceDAOImpl implements VilleFranceDAO{
	
	@Override
	public ArrayList<VilleFrance> findAllVilles() {
		ArrayList<VilleFrance> villesFrance = new ArrayList<VilleFrance>();

		try {

			Connection con = JDBCConfig.getConnection();
			
			Statement statement = con.createStatement();

			// execute la requete
			ResultSet resultSet = statement.executeQuery("SELECT * FROM villes_france");

			// parcourt des éléments de réponse
			while (resultSet.next()) {
				VilleFrance ville = new VilleFrance();
				
				ville.setCodeCommuneINSEE(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne5(resultSet.getString("Ligne_5"));
				ville.setLatitude(resultSet.getString("Latitude"));
				ville.setLongitude(resultSet.getString("Longitude"));

				villesFrance.add(ville);
			}

			// close de la connexion
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villesFrance;

	}
	
	

}
