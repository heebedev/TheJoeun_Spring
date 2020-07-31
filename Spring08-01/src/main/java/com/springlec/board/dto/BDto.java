package com.springlec.board.dto;

public class BDto {
	
	int bId;
	String bName;
	String bTitle;
	String bContent;
	String bDate;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}

	public BDto(int bId, String bName, String bTitle, String bContent, String bDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}
	
	
	public BDto(int bId, String bName, String bTitle, String bContent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	
	
	
	public BDto(String bName, String bTitle, String bContent) {
		super();
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
	
	

}
