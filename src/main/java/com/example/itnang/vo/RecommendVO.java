package com.example.itnang.vo;

public class RecommendVO {

	//게시판 ID
	private Long recomId;
	
	//사용자 ID
	private String userId;
		
	//게시물 명
	private String recomSj;
		
	//게시물 내용
	private String recomCn;
		
	//조회수
	private int recomCo;
		
	//등록자 IP
	private String recomIp;
		
	//공지여부
	private String recomAt;
	
	//이미지
	private  String recomImg;
		
	//최초등록시점
	private java.util.Date recomFrst;
		
	//최종수정시점
	private java.util.Date recomLast;

	public Long getRecomId() {
		return recomId;
	}

	public void setRecomId(Long recomId) {
		this.recomId = recomId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecomSj() {
		return recomSj;
	}

	public void setRecomSj(String recomSj) {
		this.recomSj = recomSj;
	}

	public String getRecomCn() {
		return recomCn;
	}

	public void setRecomCn(String recomCn) {
		this.recomCn = recomCn;
	}

	public int getRecomCo() {
		return recomCo;
	}

	public void setRecomCo(int recomCo) {
		this.recomCo = recomCo;
	}

	public String getRecomIp() {
		return recomIp;
	}

	public void setRecomIp(String recomIp) {
		this.recomIp = recomIp;
	}

	public String getRecomAt() {
		return recomAt;
	}

	public void setRecomAt(String recomAt) {
		this.recomAt = recomAt;
	}

	public String getRecomImg() {
		return recomImg;
	}

	public void setRecomImg(String recomImg) {
		this.recomImg = recomImg;
	}

	public java.util.Date getRecomFrst() {
		return recomFrst;
	}

	public void setRecomFrst(java.util.Date recomFrst) {
		this.recomFrst = recomFrst;
	}

	public java.util.Date getRecomLast() {
		return recomLast;
	}

	public void setRecomLast(java.util.Date recomLast) {
		this.recomLast = recomLast;
	}
		
}
