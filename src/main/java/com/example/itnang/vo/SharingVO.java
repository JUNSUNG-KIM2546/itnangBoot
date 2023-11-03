package com.example.itnang.vo;

public class SharingVO {

	//게시판 ID
	private Long sharingId;
	
	//사용자 ID
	private String userId;
		
	//게시물 명
	private String sharingSj;
		
	//게시물 내용
	private String sharingCn;
		
	//조회수
	private int sharingCo;
		
	//등록자 IP
	private String sharingIp;
		
	//공지여부
	private String sharingAt;
	
	//이미지
	private  String sharingImg;
		
	//최초등록시점
	private java.util.Date sharingFrst;
		
	//최종수정시점
	private java.util.Date sharingLast;

	
	public Long getSharingId() {
		return sharingId;
	}

	public void setSharingId(Long sharingId) {
		this.sharingId = sharingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSharingSj() {
		return sharingSj;
	}

	public void setSharingSj(String sharingSj) {
		this.sharingSj = sharingSj;
	}

	public String getSharingCn() {
		return sharingCn;
	}

	public void setSharingCn(String sharingCn) {
		this.sharingCn = sharingCn;
	}

	public int getSharingCo() {
		return sharingCo;
	}

	public void setSharingCo(int sharingCo) {
		this.sharingCo = sharingCo;
	}

	public String getSharingIp() {
		return sharingIp;
	}

	public void setSharingIp(String sharingIp) {
		this.sharingIp = sharingIp;
	}

	public String getSharingAt() {
		return sharingAt;
	}

	public void setSharingAt(String sharingAt) {
		this.sharingAt = sharingAt;
	}

	public String getSharingImg() {
		return sharingImg;
	}

	public void setSharingImg(String sharingImg) {
		this.sharingImg = sharingImg;
	}

	public java.util.Date getSharingFrst() {
		return sharingFrst;
	}

	public void setSharingFrst(java.util.Date sharingFrst) {
		this.sharingFrst = sharingFrst;
	}

	public java.util.Date getSharingLast() {
		return sharingLast;
	}

	public void setSharingLast(java.util.Date sharingLast) {
		this.sharingLast = sharingLast;
	}

		
}
