package team1.project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import team1.project.vo.Unicode;

@Service
@Transactional
public class BookService {
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	private List<Map<String, Integer>> intList;
	private List<Map<String, Character>> charList;
	
	@Autowired private BookMapper bookMapper;
	
	public int sameNameCount(String libraryCode, String bookName, String writer) {
		return bookMapper.sameNameCount(libraryCode, bookName, writer);
	}
	
	/**
	 * action 메소드 실행
	 * @param str
	 * @return
	 */
	public List<Map<String, Integer>>getIntList(String str){
		action(str, false);
		return intList;
	}
	
	public List<Map<String, Character>>getCharList(String str){
		action(str, true);
		return charList;
	}
	
	/**
	 * 저자의 이름을 자음 모음 받침으로 분리
	 * @param str
	 * @param isCharType
	 */
	private void action(String str, boolean isCharType) {
		if(!isCharType) {
			intList = new ArrayList<Map<String, Integer>>();
		}
		if(isCharType) charList = new ArrayList<Map<String, Character>>();
		
		if( str != null ) {
			for(int i = 0 ; i<str.length(); i++){
				char character = str.charAt(i);
				if(character>= 0xAC00){
					char uniVal = (char) (character - 0xAC00);
					char cho = (char) (((uniVal - (uniVal % 28))/28)/21);    
					char jun = (char) (((uniVal - (uniVal % 28))/28)%21);
					char jon = (char) (uniVal %28);
					
					char reCho = Unicode.CHO[cho];
					char reJun = Unicode.JUN[jun];
								
					if(isCharType) {
						Map<String, Character>charMap = new HashMap<String, Character>();

						charMap.put("char", (char) character);
						charMap.put("reCho", (char) reCho);
						charMap.put("reJun", (char) reJun);
						
						if((char)jon != 0x0000) {
							char reJon = Unicode.JON[jon];	
							charMap.put("reJon", (char) reJon);
						}
						charList.add(charMap);
					}
					if(!isCharType) {
						
						Map<String, Integer>intMap = new HashMap<String, Integer>();
						intMap.put("cho", (int) cho);
						intMap.put("jun", (int) jun);
						if((char)jon != 0x0000) {
							intMap.put("jon", (int) jon);
						}
						intList.add(intMap);
					}
				}
			}
		}
	}
	
	//isbn으로 도서 정보 가져오기 api - 영주
	public Book searchIsbn(String isbn) {
		logger.info("BookService - isbn : {}",isbn);
		//중앙 도서관api 이용 url
		String seojiUrl = "http://seoji.nl.go.kr/landingPage/SearchApi.do?"
					+ "cert_key=028d34c6eb6f18a4cade4731aa6dc4651d41706a33d3ffe5babd55542c96a9f0&"	
					+ "result_style=xml&page_no=1&page_size=10&isbn="+isbn;
		//도서관 정보나루 api 이용 url
		String naruUrl = "http://data4library.kr/api/srchDtlList?"
				+ "authKey=d30acf5969608e57f856c36ddd03e661e138d851efb484a2ddffc33ce70627d4&isbn13="
				+ isbn;
		Book book = new Book();
		try {
			//도서관 정보나루 api
			Document naru = Jsoup.connect(naruUrl).data("isbn",isbn).get();
			//국립도서곤 api
			Document seoji = Jsoup.connect(seojiUrl).data("isbn",isbn).get();
			String bookName = seoji.select("TITLE").text();
			String bookPrice = seoji.select("PRE_PRICE").text();
			String seriesNo = seoji.select("SERIES_NO").text();
			String category = seoji.select("KDC").text();
			String writer = naru.select("authors").text();
			String publisher = naru.select("publisher").text();
			String bookDescription = naru.select("description").text();
			String bookImageURL = naru.select("bookImageURL").text();
			String bookPublishDate = naru.select("publication_date").text();
			book.setBookName(bookName);
			book.setWriter(writer);
			book.setBookDescription(bookDescription);
			book.setBookImageURL(bookImageURL);
			book.setPublisher(publisher);
			book.setBookPrice(bookPrice);
			book.setCategory(category);
			book.setBookPublishDate(bookPublishDate);
			book.setSeriesNo(seriesNo);
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
