package team1.project.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.controller.ReserveController;
import team1.project.mapper.BookMapper;
import team1.project.vo.Book;

@Service
@Transactional
public class BookService {
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	@Autowired private BookMapper bookMapper;
	
	//isbn으로 도서 정보 가져오기 api - 영주
	public Book searchIsbn(String isbn) {
		logger.info("BookService - isbn : {}",isbn);
		String seojiUrl = "http://seoji.nl.go.kr/landingPage/SearchApi.do?"
					+ "cert_key=028d34c6eb6f18a4cade4731aa6dc4651d41706a33d3ffe5babd55542c96a9f0&"	
					+ "result_style=xml&page_no=1&page_size=10&isbn="+isbn;
		String naruUrl = "http://data4library.kr/api/srchDtlList?"
				+ "authKey=d30acf5969608e57f856c36ddd03e661e138d851efb484a2ddffc33ce70627d4&isbn13="
				+ isbn;
		
		Book book = new Book();
		try {
			//도서관 정보나루 api
			Document naru = Jsoup.connect(naruUrl).data("isbn",isbn).get();
			Document seoji = Jsoup.connect(seojiUrl).data("isbn",isbn).get();
			String bookName = seoji.select("TITLE").text();
			String bookPrice = seoji.select("REAL_PRICE").text();
			String writer = naru.select("authors").text();
			String publisher = naru.select("publisher").text();
			String bookDescription = naru.select("description").text();
			String bookImageURL = naru.select("bookImageURL").text();
			String category = naru.select("class_no").text();
			book.setBookName(bookName);
			book.setWriter(writer);
			book.setBookDescription(bookDescription);
			book.setBookImageURL(bookImageURL);
			book.setPublisher(publisher);
			book.setBookPrice(bookPrice);
			book.setCategory(category);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return book;
	}
	
	//도서 코드로 도서 정보 검색 -영주
	public Book officeBookSerch(String bookLibraryCode, String libraryCode) {
		Book searchBook = bookMapper.officeBookSerch(bookLibraryCode, libraryCode);
		if(searchBook.getBookSituation().equals("예약 중")) {
			Book countBook = bookMapper.reserveBookCount(bookLibraryCode, libraryCode);
			logger.info("book : {}",countBook.toString());
			return countBook;
		}else {
			return searchBook;
		}
	}
	
	//도서이름으로 도서정보 검색 - 영주
	public List<Book> officeBookSerchList(String bookName, String libraryCode){
		return bookMapper.officeBookSerchList(bookName, libraryCode);
	}
	
	//소장도서리스트
	public List<Book> officeBookList(){
		List<Book> list = bookMapper.officeBookList();
		return list;
	}
}
