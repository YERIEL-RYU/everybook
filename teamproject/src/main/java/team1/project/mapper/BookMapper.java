package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Book;

@Mapper
public interface BookMapper {
	//대여중인 도서 예약 권수
	public Book reserveBookCount(String bookLibraryCode, String libraryCode);
	
	//도서관책코드로 하나의 도서관에서 도서정보 검색
	public Book officeBookSerch(String bookLibraryCode, String libraryCode);
	
	//도서 이름으로 검색하여 도서리스트 출력
	public List<Book> officeBookSerchList(String bookName, String libraryCode);
	
	//소장도서리스트
	public List<Book> officeBookList();
}
