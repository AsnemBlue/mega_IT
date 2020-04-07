package com.tj.ex.dto;

import java.sql.Date;

public class BoardDto {
	private int fId;
	private String mId;
	private String mName; // join해서 출력
	private String fTitle;
	private String fContent;
	private String fFileName;
	private Date   fRdate;
	private int    fHit;
	private int    fGroup;
	private int    fStep;
	private int    fIndent;
	private String fIp;
	public BoardDto() {}
	public BoardDto(int fId, String mId, String mName, String fTitle, String fContent, String fFileName, Date fRdate,
			int fHit, int fGroup, int fStep, int fIndent, String fIp) {
		this.fId = fId;
		this.mId = mId;
		this.mName = mName;
		this.fTitle = fTitle;
		this.fContent = fContent;
		this.fFileName = fFileName;
		this.fRdate = fRdate;
		this.fHit = fHit;
		this.fGroup = fGroup;
		this.fStep = fStep;
		this.fIndent = fIndent;
		this.fIp = fIp;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getfTitle() {
		return fTitle;
	}
	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}
	public String getfContent() {
		return fContent;
	}
	public void setfContent(String fContent) {
		this.fContent = fContent;
	}
	public String getfFileName() {
		return fFileName;
	}
	public void setfFileName(String fFileName) {
		this.fFileName = fFileName;
	}
	public Date getfRdate() {
		return fRdate;
	}
	public void setfRdate(Date fRdate) {
		this.fRdate = fRdate;
	}
	public int getfHit() {
		return fHit;
	}
	public void setfHit(int fHit) {
		this.fHit = fHit;
	}
	public int getfGroup() {
		return fGroup;
	}
	public void setfGroup(int fGroup) {
		this.fGroup = fGroup;
	}
	public int getfStep() {
		return fStep;
	}
	public void setfStep(int fStep) {
		this.fStep = fStep;
	}
	public int getfIndent() {
		return fIndent;
	}
	public void setfIndent(int fIndent) {
		this.fIndent = fIndent;
	}
	public String getfIp() {
		return fIp;
	}
	public void setfIp(String fIp) {
		this.fIp = fIp;
	}
	@Override
	public String toString() {
		return "BoardDto [fId=" + fId + ", mId=" + mId + ", mName=" + mName + ", fTitle=" + fTitle + ", fContent="
				+ fContent + ", fFileName=" + fFileName + ", fRdate=" + fRdate + ", fHit=" + fHit + ", fGroup=" + fGroup
				+ ", fStep=" + fStep + ", fIndent=" + fIndent + ", fIp=" + fIp + "]";
	}
}
