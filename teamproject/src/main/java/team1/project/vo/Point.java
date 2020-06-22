package team1.project.vo;

import java.util.Date;

public class Point {
	private String psCode;
	private String psName;
	private int psScore;
	private Date psRegDate;
	private Officer officer;
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public int getPsScore() {
		return psScore;
	}
	public void setPsScore(int psScore) {
		this.psScore = psScore;
	}
	public Date getPsRegDate() {
		return psRegDate;
	}
	public void setPsRegDate(Date psRegDate) {
		this.psRegDate = psRegDate;
	}
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
}
