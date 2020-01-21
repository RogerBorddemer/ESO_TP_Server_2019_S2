package com.blo;

import java.util.ArrayList;

import com.dto.Mission;
import com.dto.client.VilleFrance;

public interface VilleFranceBLO {


	public ArrayList<VilleFrance> getInfoVilles(String codeINSEE) throws VilleException;

}
