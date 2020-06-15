package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OfficerMapper;
import team1.project.vo.Officer;

@Service
@Transactional
public class OfficerService {
	
	@Autowired private OfficerMapper officerMapper;
		
		public List<Officer> getOfficerList(){
			List<Officer> list = officerMapper.getOfficerList();
			return list;
		}
	
		//직원등록
		public int addOfficer(Officer officer) {			
			int result = officerMapper.addOfficer(officer);
			return result;
		}

}