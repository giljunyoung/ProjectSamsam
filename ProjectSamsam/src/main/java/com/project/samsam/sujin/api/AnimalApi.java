package com.project.samsam.sujin.api;

public interface AnimalApi {
	
	String baseUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/";
	String serviceKey = "=5Ern8aw33VcOcSQOtvZctJL%2Fts0%2BlkWF44wrlicCom%2BtHN5GBj2nE2eYllAz5Zaq10sQ8LRzqFG4S5QgYLZvhg%3D%3D";

	// 시도 
	public StringBuilder getSido() throws Exception;
	
	// 시/군/구
	public StringBuilder getSiGunGu(Integer upr_cd) throws Exception;
	
	// 보호소
	public StringBuilder getShelter(Integer upr_cd, Integer org_cd) throws Exception;
	
	// 축종
	// 축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900
	public StringBuilder getAnimalKind(Integer up_kind_cd) throws Exception;
	
	
}
