package team1.project.vo;

import java.util.Date;

public class Apply {

	private String applyCode;
	private String library;
	private String memberId;
	private String bookName;
	private String bookIsbn;
	private Date applyPublishDate;
	private String applyPublisher;
	private String applyWriter;
	private Date applyRegDate;
	
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getApplyPublishDate() {
		return applyPublishDate;
	}
	public void setApplyPublishDate(Date applyPublishDate) {
		this.applyPublishDate = applyPublishDate;
	}
	public String getApplyPublisher() {
		return applyPublisher;
	}
	public void setApplyPublisher(String applyPublisher) {
		this.applyPublisher = applyPublisher;
	}
	
	public String getApplyWriter() {
		return applyWriter;
	}
	public void setApplyWriter(String applyWriter) {
		this.applyWriter = applyWriter;
	}
	public Date getApplyRegDate() {
		return applyRegDate;
	}
	public void setApplyRegDate(Date applyRegDate) {
		this.applyRegDate = applyRegDate;
	}
	@Override
	public String toString() {
		return "Apply [applyCode=" + applyCode + ", library=" + library + ", memberId=" + memberId + ", bookName="
				+ bookName + ", bookIsbn=" + bookIsbn + ", applyPublishDate=" + applyPublishDate + ", applyPublisher="
				+ applyPublisher + ", applyWriter=" + applyWriter + ", applyRegDate=" + applyRegDate + "]";
	}
	
}
