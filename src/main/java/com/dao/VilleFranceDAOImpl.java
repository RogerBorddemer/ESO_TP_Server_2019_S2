package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfig;
import com.dto.client.VilleFrance;

@Repository
public class VilleFranceDAOImpl implements VilleFranceDAO{
	
	@Override
	public ArrayList<VilleFrance> trouver(VilleFrance villeFrance) {
		
		ArrayList<VilleFrance> villesFrance = new ArrayList<VilleFrance>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String codeCommuneINSEE = villeFrance.getCodeCommuneINSEE();
		String nomCommune = villeFrance.getNomCommune();
		String codePostal = villeFrance.getCodePostal();
		String libelleAcheminement = villeFrance.getLibelleAcheminement();
		String ligne5 = villeFrance.getLigne5();
		String latitude = villeFrance.getLatitude();
		String longitude = villeFrance.getLongitude();
		
		try {
			connection = JDBCConfig.getConnection();
			String query = "SELECT * FROM ville_france WHERE " +
			(codeCommuneINSEE == null ? "Code_commune_INSEE IS NOT NULL " : "Code_commune_INSEE = ? ") + 
			(nomCommune == null ? "AND Nom_commune IS NOT NULL " : "AND Nom_commune = ? ") +
			(codePostal == null ? "AND Code_postal IS NOT NULL " : "AND Code_postal	= ? ") +
			(libelleAcheminement == null ? "AND Libelle_acheminement IS NOT NULL " : "AND Libelle_acheminement = ? ") +
			(ligne5 == null ? "AND Ligne_5 IS NOT NULL " : "AND Ligne_5 = ? ") +
			(latitude == null ? "AND Latitude IS NOT NULL " : "AND Latitude = ? ") +
			(longitude == null ? "AND Longitude IS NOT NULL " : "AND Longitude = ? ");
						
			preparedStatement = connection.prepareStatement(query);
			int index = 0;
			if (codeCommuneINSEE != null) {
				index++;
				preparedStatement.setString(index, codeCommuneINSEE);
			}
			if (nomCommune != null) {
				index++;
				preparedStatement.setString(index, nomCommune);
			}
			if (codePostal != null) {
				index++;
				preparedStatement.setString(index, codePostal);
			}
			if (libelleAcheminement != null) {
				index++;
				preparedStatement.setString(index, libelleAcheminement);
			}
			if (ligne5 != null) {
				index++;
				preparedStatement.setString(index, ligne5);
			}
			if (latitude != null) {
				index++;
				preparedStatement.setString(index, latitude);
			}
			if (longitude != null) {
				index++;
				preparedStatement.setString(index, longitude);
			}
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				villesFrance.add(this.map(resultSet));
			}
			
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villesFrance;
		
	}
	
	@Override
	public void ajouter(VilleFrance villeFrance) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String codeCommuneINSEE = villeFrance.getCodeCommuneINSEE();
		String nomCommune = villeFrance.getNomCommune();
		String codePostal = villeFrance.getCodePostal();
		String libelleAcheminement = villeFrance.getLibelleAcheminement();
		String ligne5 = villeFrance.getLigne5();
		String latitude = villeFrance.getLatitude();
		String longitude = villeFrance.getLongitude();
		
		connection = JDBCConfig.getConnection();
		//INSERT INTO VILLE_FRANCE ("CODE_COMMUNE_INSEE", "NOM_COMMUNE", "CODE_POSTAL", "LIBELLE_ACHEMINEMENT", "LIGNE_5","LATITUDE","LONGITUDE") VALUES ('00001', 'test', '', '', '', '', '')
		//INSERT INTO VILLE_FRANCE ("CODE_COMMUNE_INSEE", "NOM_COMMUNE", "CODE_POSTAL", "LIBELLE_ACHEMINEMENT", "LIGNE_5","LATITUDE","LONGITUDE") VALUES ('00001', 'test', '00001', 'TEST', 'TEST', '123.25', '64.54')
		String query = "INSERT INTO ville_france(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (\'"
				+ codeCommuneINSEE + "\', \'" + nomCommune + "\', \'" + codePostal + "\', \'" + libelleAcheminement
				+ "\', \'" + ligne5 + "\', \'" + latitude + "\', \'" + longitude + "\')";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			System.out.println("ueh");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	@Override
	public void modifier(VilleFrance villeFrance) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String codeCommuneINSEE = villeFrance.getCodeCommuneINSEE();
		String nomCommune = villeFrance.getNomCommune();
		String codePostal = villeFrance.getCodePostal();
		String libelleAcheminement = villeFrance.getLibelleAcheminement();
		String ligne5 = villeFrance.getLigne5();
		String latitude = villeFrance.getLatitude();
		String longitude = villeFrance.getLongitude();
		//UPDATE VILLE_FRANCE SET "LIGNE_5" = 'test'  WHERE Code_commune_INSEE = 01001
		try {
			connection = JDBCConfig.getConnection();
			String query = "UPDATE VILLE_FRANCE SET Nom_commune = \'"+nomCommune+"\', Code_postal = \'"+codePostal+"\',"
					+ " Libelle_acheminement = \'"+libelleAcheminement+"', Ligne_5 = \'"+ligne5+"\',"
					+ " Latitude = \'"+latitude+"\', Longitude = \'"+longitude+"\'"
					+ " WHERE Code_commune_INSEE = \'"+codeCommuneINSEE+"\'";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void supprimerVille(String Code_commune_INSEE) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String query = "DELETE FROM ville_france WHERE Code_commune_INSEE = " + Code_commune_INSEE;
		try {
			connection = JDBCConfig.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	private VilleFrance map(ResultSet resultSet) throws SQLException {
		VilleFrance villeFrance = new VilleFrance();
		
		villeFrance.setCodeCommuneINSEE(resultSet.getString("Code_commune_INSEE"));
		villeFrance.setNomCommune(resultSet.getString("Nom_commune"));
		villeFrance.setCodePostal(resultSet.getString("Code_postal"));
		villeFrance.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
		villeFrance.setLigne5(resultSet.getString("Ligne_5"));
		villeFrance.setLatitude(resultSet.getString("Latitude"));
		villeFrance.setLongitude(resultSet.getString("Longitude"));
		
		return villeFrance;
	}
}
