package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.LibraryMapper;
import team1.project.vo.Library;

@Service
@Transactional
public class LibraryService {
	
	@Autowired private LibraryMapper librarymapper;
	
	public List<Library> getLibraryList(){
		return librarymapper.getLibraryList();
	}
}
