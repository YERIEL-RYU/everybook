package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OfficerMapper;
import team1.project.vo.Library;
import team1.project.vo.Officer;

@Service
@Transactional
public class OfficerService {
	
	@Autowired private OfficerMapper officerMapper;
		
		//나의 정보
		public List<Officer> getMyOffice(String SID){
			List<Officer> myList = officerMapper.getMyOffice(SID);
			
			return myList;			
		}
	
		//직원리스트
		public List<Officer> getOfficerList(){
			List<Officer> list = officerMapper.getOfficerList();
			return list;
		}
	
		//직원등록
		public List<Library> addOfficer(Officer officer) {			
			List<Library> libraryList = officerMapper.addOfficer(officer);
			return libraryList;
		}

}
