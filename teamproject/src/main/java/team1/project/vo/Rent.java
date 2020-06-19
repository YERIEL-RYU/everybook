package team1.project.vo;

public class Rent {
	private String rentCode;
	private String library;
	private String memberId;
	private String bookCode;
	private String rentDate;
	private String rentReturnDate;
	private String rentRegDate;
	private String officerId;
	private Book book;
	
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
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getRentReturnDate() {
		return rentReturnDate;
	}
	public void setRentReturnDate(String rentReturnDate) {
		this.rentReturnDate = rentReturnDate;
	}
	public String getRentRegDate() {
		return rentRegDate;
	}
	public void setRentRegDate(String rentRegDate) {
		this.rentRegDate = rentRegDate;
	}
	public String getOfficerId() {
		return officerId;
	}
	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}
	@Override
	public String toString() {
		return "Rent [rentCode=" + rentCode + ", library=" + library + ", memberId=" + memberId + ", bookCode="
				+ bookCode + ", rentDate=" + rentDate + ", rentReturnDate=" + rentReturnDate + ", rentRegDate="
				+ rentRegDate + ", officerId=" + officerId + "]";
	}
	
	
}
