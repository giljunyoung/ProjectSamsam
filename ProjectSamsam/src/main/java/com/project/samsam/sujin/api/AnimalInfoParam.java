package com.project.samsam.sujin.api;

public class AnimalInfoParam {
	
	private int bgnde;				// 20140601 (YYYYMMDD) - 검색 시작일
	private int endde;				// 20201231 (YYYYMMDD) - 검색 종료일
	private int upkind;				// 축종코드
	private int kind;				// 품종코드
	private int upr_cd;				// 시도코드
	private int org_cd;				// 시군구코드
	private int care_reg_no;		// 보호소번호
	private String state;			// 상태 - 전체 : null(빈값) - 공고중 : notice - 보호중 : protect
	private int pageNo;				// 페이지 번호
	private int numOfRows;			// 페이지당 보여줄 개수
	private String neuter_yn;		// 중성화 여부
	
	public int getBgnde() {
		return bgnde;
	}
	public void setBgnde(int bgnde) {
		this.bgnde = bgnde;
	}
	public int getEndde() {
		return endde;
	}
	public void setEndde(int endde) {
		this.endde = endde;
	}
	public int getUpkind() {
		return upkind;
	}
	public void setUpkind(int upkind) {
		this.upkind = upkind;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getUpr_cd() {
		return upr_cd;
	}
	public void setUpr_cd(int upr_cd) {
		this.upr_cd = upr_cd;
	}
	public int getOrg_cd() {
		return org_cd;
	}
	public void setOrg_cd(int org_cd) {
		this.org_cd = org_cd;
	}
	public int getCare_reg_no() {
		return care_reg_no;
	}
	public void setCare_reg_no(int care_reg_no) {
		this.care_reg_no = care_reg_no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getNeuter_yn() {
		return neuter_yn;
	}
	public void setNeuter_yn(String neuter_yn) {
		this.neuter_yn = neuter_yn;
	}
	
	@Override
	public String toString() {
		return "AnimalInfo [bgnde=" + bgnde + ", endde=" + endde + ", upkind=" + upkind + ", kind=" + kind + ", upr_cd="
				+ upr_cd + ", org_cd=" + org_cd + ", care_reg_no=" + care_reg_no + ", state=" + state + ", pageNo="
				+ pageNo + ", numOfRows=" + numOfRows + ", neuter_yn=" + neuter_yn + "]";
	}
	
	
	
}
