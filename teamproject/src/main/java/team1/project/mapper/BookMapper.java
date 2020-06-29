package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Book;

@Mapper
public interface BookMapper {

	//도서관책코드로 도서정보 검색
	public Book officeBookSerch(String bookLibraryCode, String libraryCode);
	
	//소장도서리스트
	public List<Book> officeBookList();
}
