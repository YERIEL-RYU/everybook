package team1.project.vo;

public class OfficerLicense {
	private String officerLicenseCode;
	private String officerId;
	private String license;
	private String officerLicenseDate;
	private String officerLicenseRegDate;
	public String getOfficerLicenseCode() {
		return officerLicenseCode;
	}
	public void setOfficerLicenseCode(String officerLicenseCode) {
		this.officerLicenseCode = officerLicenseCode;
	}
	public String getofficerId() {
		return officerId;
	}
	public void setofficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
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
	@Override
	public String toString() {
		return "OfficerLicense [officerLicenseCode=" + officerLicenseCode + ", officerId=" + officerId + ", license="
				+ license + ", officerLicenseDate=" + officerLicenseDate + ", officerLicenseRegDate="
				+ officerLicenseRegDate + "]";
	}
	
	
}
