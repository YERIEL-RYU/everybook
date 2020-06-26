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
	
	//도서코드로 도서정보 검색
	public List<Book> officeBookSerch() {
		List<Book> serchList = bookMapper.officeBookSerch();
		return serchList;
	}
	
	//소장도서리스트
	public List<Book> officeBookList(){
		List<Book> list = bookMapper.officeBookList();
		return list;
	}
}
