package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Library;

@Mapper
public interface LibraryMapper {
	
	public int addLibrary(Library library);
	
	public List<Library> getLibraryList();
}
