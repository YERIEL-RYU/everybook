package team1.project.vo;

public class OfficerLicense {
	private String officerLicenseCode;
	private Officer officer;
	private License license;
	private String officerLicenseDate;
	private String officerLicenseRegDate;
	
	public String getOfficerLicenseCode() {
		return officerLicenseCode;
	}
	public void setOfficerLicenseCode(String officerLicenseCode) {
		this.officerLicenseCode = officerLicenseCode;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public String getOfficerLicenseDate() {
		return officerLicenseDate;
	}
	public void setOfficerLicenseDate(String officerLicenseDate) {
		this.officerLicenseDate = officerLicenseDate;
	}
	public String getOfficerLicenseRegDate() {
		return officerLicenseRegDate;
	}
	public void setOfficerLicenseRegDate(String officerLicenseRegDate) {
		this.officerLicenseRegDate = officerLicenseRegDate;
	}
}
