package com.project.samsam.sujin.api;

import java.util.ArrayList;

public interface AnimalApi {
	
	String baseUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/";
	String serviceKey = "=5Ern8aw33VcOcSQOtvZctJL%2Fts0%2BlkWF44wrlicCom%2BtHN5GBj2nE2eYllAz5Zaq10sQ8LRzqFG4S5QgYLZvhg%3D%3D";

	// 시도 
	public ArrayList<Sido> getSido() throws Exception;
	
	// 시/군/구
	public ArrayList<Sigungu> getSiGunGu(Integer upr_cd) throws Exception;
	
	// 보호소
	public StringBuilder getShelter(Integer upr_cd, Integer org_cd) throws Exception;
	
	// 축종
	// 축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900
	public ArrayList<AnimalKind> getAnimalKind(Integer up_kind_cd) throws Exception;
	
	// 유기동물 정보
	public ArrayList<AnimalInfo> getAnimalInfo( String bgnde, String endde, Integer upkind, String state, Integer pageNo, Integer numOfRows, String neuter_yn  ) throws Exception;
	public ArrayList<AnimalInfo> getAnimalInfo( String bgnde, String endde,Integer upr_cd, Integer org_cd, Integer upkind, Integer kind, String state, Integer pageNo, Integer numOfRows, String neuter_yn  ) throws Exception;
	
	
	
	
}
