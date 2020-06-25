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
	
	public List<Library> searchLibrary(String sk, String sv){
		return librarymapper.searchLibrary(sk, sv);
	}
	
	public int deleteLibrary(Library library) {
		return librarymapper.deleteLibrary(library);
	}
	
	public int modifyLibrary(Library library) {
		return librarymapper.modifyLibrary(library);
	}
	
	public Library getSelectLibrary(String libraryCode) {
		return librarymapper.getSelectLibrary(libraryCode);
	}
	
	public int addLibrary(Library library) {
		return librarymapper.addLibrary(library);
	}
	
	public List<Library> getLibraryList(){
		return librarymapper.getLibraryList();
	}
}
