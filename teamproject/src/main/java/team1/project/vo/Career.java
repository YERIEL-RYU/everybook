package team1.project.vo;

import java.util.Date;

public class Career {

	private String careerCode;
	private Library library;
	private Officer officer;
	private String careerName;
	private Date careerPeriodStart;
	private Date careerPeriodEnd;
	private Date careerRegDate;
	
	public String getCareerCode() {
		return careerCode;
	}
	public void setCareerCode(String careerCode) {
		this.careerCode = careerCode;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	public String getCareerName() {
		return careerName;
	}
	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}
	public Date getCareerPeriodStart() {
		return careerPeriodStart;
	}
	public void setCareerPeriodStart(Date careerPeriodStart) {
		this.careerPeriodStart = careerPeriodStart;
	}
	public Date getCareerPeriodEnd() {
		return careerPeriodEnd;
	}
	public void setCareerPeriodEnd(Date careerPeriodEnd) {
		this.careerPeriodEnd = careerPeriodEnd;
	}
	public Date getCareerRegDate() {
		return careerRegDate;
	}
	public void setCareerRegDate(Date careerRegDate) {
		this.careerRegDate = careerRegDate;
	}
	@Override
	public String toString() {
		return "Career [careerCode=" + careerCode + ", library=" + library + ", officer=" + officer
				+ ", careerName=" + careerName + ", careerPeriodStart=" + careerPeriodStart + ", careerPeriodEnd="
				+ careerPeriodEnd + ", careerRegDate=" + careerRegDate + "]";
	}
	
	
}
