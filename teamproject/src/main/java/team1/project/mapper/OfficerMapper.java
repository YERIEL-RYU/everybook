package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Library;
import team1.project.vo.Officer;

@Mapper
public interface OfficerMapper {
	
	//나의직원정보(로그인처리후 해야겠다.. 아직못함) 
	public List<Officer> getMyOffice(String SID);
	 
	
	//직원리스트
	public List<Officer> getOfficerList();
	
	//직원등록
	public List<Library> addOfficer(Officer officer); 
}
