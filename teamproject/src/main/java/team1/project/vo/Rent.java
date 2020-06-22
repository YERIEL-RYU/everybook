package team1.project.vo;

public class Rent {
	private String rentCode;
	private Library library;
	private Member member;
	private String bookCode;
	private String rentDate;
	private String rentReturnDate;
	private String rentRegDate;
	private Officer officer;
	private Book book;
	public String getRentCode() {
		return rentCode;
	}
	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
	public Officer getOfficer() {
		return officer;
	}
	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Rent [rentCode=" + rentCode + ", library=" + library + ", member=" + member + ", bookCode=" + bookCode
				+ ", rentDate=" + rentDate + ", rentReturnDate=" + rentReturnDate + ", rentRegDate=" + rentRegDate
				+ ", officer=" + officer + ", book=" + book + "]";
	}
			
	
}

