package team1.project.vo;

import java.util.Date;

public class Library {

	private String libraryCode;
	private Region region;
	private String libraryName;
	private String librarySetup;
	private String libraryOpen;
	private String libraryTel;
	private String libraryPage;
	private Date libraryRegDate;
	private String officerId;
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getLibrarySetup() {
		return librarySetup;
	}
	public void setLibrarySetup(String librarySetup) {
		this.librarySetup = librarySetup;
	}
	public String getLibraryOpen() {
		return libraryOpen;
	}
	public void setLibraryOpen(String libraryOpen) {
		this.libraryOpen = libraryOpen;
	}
	public String getLibraryTel() {
		return libraryTel;
	}
	public void setLibraryTel(String libraryTel) {
		this.libraryTel = libraryTel;
	}
	public String getLibraryPage() {
		return libraryPage;
	}
	public void setLibraryPage(String libraryPage) {
		this.libraryPage = libraryPage;
	}
	public Date getLibraryRegDate() {
		return libraryRegDate;
	}
	public void setLibraryRegDate(Date libraryRegDate) {
		this.libraryRegDate = libraryRegDate;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	@Override
	public String toString() {
		return "Library [libraryCode=" + libraryCode + ", region=" + region + ", libraryName=" + libraryName
				+ ", librarySetup=" + librarySetup + ", libraryOpen=" + libraryOpen + ", libraryTel=" + libraryTel
				+ ", libraryPage=" + libraryPage + ", libraryRegDate=" + libraryRegDate + ", officerId=" + officerId
				+ "]";
	}

	
}
