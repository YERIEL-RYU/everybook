package team1.project.vo;

import java.util.Date;

public class Officer {
	private String officerId;
	private String officerPw;
	private String officerName;
	private String officerBirth;
	private String level;
	private String library;
	private String officerAddress;
	private String officerTel;
	private String officerEmail;
	private Date officerRegDate;
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getOfficerPw() {
		return officerPw;
	}
	public void setOfficerPw(String officerPw) {
		this.officerPw = officerPw;
	}
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getOfficerBirth() {
		return officerBirth;
	}
	public void setOfficerBirth(String officerBirth) {
		this.officerBirth = officerBirth;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getOfficerAddress() {
		return officerAddress;
	}
	public void setOfficerAddress(String officerAddress) {
		this.officerAddress = officerAddress;
	}
	public String getOfficerTel() {
		return officerTel;
	}
	public void setOfficerTel(String officerTel) {
		this.officerTel = officerTel;
	}
	public String getOfficerEmail() {
		return officerEmail;
	}
	public void setOfficerEmail(String officerEmail) {
		this.officerEmail = officerEmail;
	}
	public Date getOfficerRegDate() {
		return officerRegDate;
	}
	public void setOfficerRegDate(Date officerRegDate) {
		this.officerRegDate = officerRegDate;
	}
	@Override
	public String toString() {
		return "Officer [officerId=" + officerId + ", officerPw=" + officerPw + ", officerName=" + officerName
				+ ", officerBirth=" + officerBirth + ", level=" + level + ", library=" + library + ", officerAddress="
				+ officerAddress + ", officerTel=" + officerTel + ", officerEmail=" + officerEmail + ", officerRegDate="
				+ officerRegDate + "]";
	}

}
