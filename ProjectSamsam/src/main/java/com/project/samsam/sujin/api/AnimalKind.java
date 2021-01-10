package com.project.samsam.sujin.api;

public class AnimalKind {
	private String kindCd;
	private String kindNm;
	
	
	public AnimalKind(String kindCd, String kindNm) {
		this.kindCd = kindCd;
		this.kindNm = kindNm;
	}

	public String getKindCd() {
		return kindCd;
	}


	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}


	public String getKindNm() {
		return kindNm;
	}


	public void setKindNm(String kindNm) {
		this.kindNm = kindNm;
	}

	@Override
	public String toString() {
		return "AnimalKind [kindCd=" + kindCd + ", kindNm=" + kindNm + "]";
	}
	
	
	
}
