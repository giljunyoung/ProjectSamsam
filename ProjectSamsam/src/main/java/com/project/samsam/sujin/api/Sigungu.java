package com.project.samsam.sujin.api;

public class Sigungu {
	private Integer sigunguCode;
	private String sigunguNm;
	
	public Sigungu(Integer sigunguCode, String sigunguNm) {
		this.sigunguCode = sigunguCode;
		this.sigunguNm = sigunguNm;
	}

	public Integer getSigunguCode() {
		return sigunguCode;
	}

	public void setSigunguCode(Integer sigunguCode) {
		this.sigunguCode = sigunguCode;
	}

	public String getSigunguNm() {
		return sigunguNm;
	}

	public void setSigunguNm(String sigunguNm) {
		this.sigunguNm = sigunguNm;
	}
}
