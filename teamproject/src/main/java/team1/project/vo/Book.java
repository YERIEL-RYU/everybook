package team1.project.vo;

public class Book {
	private String bookCode;
	private String library;
	private String bookLibraryCode;
	private String bookName;
	private String category;
	private String writer;
	private String publisher;
	private String bookPublishDate;
	private String bookPrice;
	private String bookIsbn;
	private String bookSituation;
	private String bookRegdate;
	private String group;
	private String budget;
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getBookLibraryCode() {
		return bookLibraryCode;
	}
	public void setBookLibraryCode(String bookLibraryCode) {
		this.bookLibraryCode = bookLibraryCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookPublishDate() {
		return bookPublishDate;
	}
	public void setBookPublishDate(String bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookSituation() {
		return bookSituation;
	}
	public void setBookSituation(String bookSituation) {
		this.bookSituation = bookSituation;
	}
	public String getBookRegdate() {
		return bookRegdate;
	}
	public void setBookRegdate(String bookRegdate) {
		this.bookRegdate = bookRegdate;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", library=" + library + ", bookLibraryCode=" + bookLibraryCode
				+ ", bookName=" + bookName + ", category=" + category + ", writer=" + writer + ", publisher="
				+ publisher + ", bookPublishDate=" + bookPublishDate + ", bookPrice=" + bookPrice + ", bookIsbn="
				+ bookIsbn + ", bookSituation=" + bookSituation + ", bookRegdate=" + bookRegdate + ", group=" + group
				+ ", budget=" + budget + "]";
	}
	
	
}
