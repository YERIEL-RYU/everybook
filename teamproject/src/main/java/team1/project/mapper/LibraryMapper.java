package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Library;

@Mapper
public interface LibraryMapper {
	
	public List<Library> searchLibrary(String sk, String sv);
	
	public int deleteLibrary(Library library);
	
	public int modifyLibrary(Library library);
	
	public Library getSelectLibrary(String libraryCode);
	
	public int addLibrary(Library library);
	
	public List<Library> getLibraryList();
}
