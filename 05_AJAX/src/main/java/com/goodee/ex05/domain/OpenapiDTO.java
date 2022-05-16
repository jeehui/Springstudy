package com.goodee.ex05.domain;

public class OpenapiDTO {
	
	private String targetDt;
	private String key;
	private String rank;
	private String movieNm;
	private String openDt;
	private String audiCnt;
	private String audiAcc;
	
	public OpenapiDTO() {
	}

	public String getTargetDt() {
		return targetDt;
	}

	public void setTargetDt(String targetDt) {
		this.targetDt = targetDt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getAudiCnt() {
		return audiCnt;
	}

	public void setAudiCnt(String audiCnt) {
		this.audiCnt = audiCnt;
	}

	public String getAudiAcc() {
		return audiAcc;
	}

	public void setAudiAcc(String audiAcc) {
		this.audiAcc = audiAcc;
	}

	public OpenapiDTO(String targetDt, String key, String rank, String movieNm, String openDt, String audiCnt,
			String audiAcc) {
		super();
		this.targetDt = targetDt;
		this.key = key;
		this.rank = rank;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.audiCnt = audiCnt;
		this.audiAcc = audiAcc;
	}
	
	
}
