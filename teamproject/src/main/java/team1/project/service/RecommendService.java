package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.mapper.LibraryMapper;
import team1.project.vo.Book;

@Service
public class RecommendService {
	
	@Autowired LibraryMapper libraryMapper;
	
	public List<Book> recommendList(String memberId){
		return null;
	}
}
