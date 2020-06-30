package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.BookMapper;
import team1.project.vo.Book;

@Service
@Transactional
public class BookService {
	@Autowired private BookMapper bookMapper;
		
	//도서 코드로 도서 정보 검색
	public Book officeBookSerch(String bookLibraryCode, String libraryCode) {
		Book searchBook = bookMapper.officeBookSerch(bookLibraryCode, libraryCode);
		if(searchBook.getBookSituation().equals("예약 중")) {
			Book countBook = bookMapper.reserveBookCount(bookLibraryCode, libraryCode);
			System.out.println(countBook.toString());
			return countBook;
		}else {
			return searchBook;
		}
	}
	
	//도서이름으로 도서정보 검색
	public List<Book> officeBookSerchList(String bookName, String libraryCode){
		return bookMapper.officeBookSerchList(bookName, libraryCode);
	}
	
	//소장도서리스트
	public List<Book> officeBookList(){
		List<Book> list = bookMapper.officeBookList();
		return list;
	}
}
