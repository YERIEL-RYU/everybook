package team1.project.vo;

import java.util.Date;

public class Return {

	private String returnCode;
	private String libraryCode;
	private String memberId;
	private Book book;
	private String rentCode;
	private String returnDate;
	private Date returnRegDate;
	private String officerId;
	private String writer;
	private String category;
	private String publisher;
	private String bookCode;
	private String bookLibraryCode;
	public String getReturnCode() {
		return returnCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookLibraryCode() {
		return bookLibraryCode;
	}
	public void setBookLibraryCode(String bookLibraryCode) {
		this.bookLibraryCode = bookLibraryCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getLibraryCode() {
		return libraryCode;
	}
	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getRentCode() {
		return rentCode;
	}
	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public Date getReturnRegDate() {
		return returnRegDate;
	}
	public void setReturnRegDate(Date returnRegDate) {
		this.returnRegDate = returnRegDate;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Return [returnCode=" + returnCode + ", libraryCode=" + libraryCode + ", memberId=" + memberId
				+ ", book=" + book + ", rentCode=" + rentCode + ", returnDate=" + returnDate + ", returnRegDate="
				+ returnRegDate + ", officerId=" + officerId + ", writer=" + writer + ", category=" + category
				+ ", publisher=" + publisher + ", bookCode=" + bookCode + ", bookLibraryCode=" + bookLibraryCode + "]";
	}
		
}
