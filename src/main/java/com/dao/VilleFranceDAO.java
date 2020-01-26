package com.dao;

import java.util.ArrayList;

import com.dto.client.VilleFrance;

public interface VilleFranceDAO {

	public ArrayList<VilleFrance> trouver(VilleFrance villeFrance);
	public void ajouter(VilleFrance villeFrance);
	public void modifier(VilleFrance villeFrance);
	public void supprimerVille(String Code_commune_INSEE);

}
