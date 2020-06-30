package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OfficerMapper;
import team1.project.vo.License;
import team1.project.vo.Officer;

@Service
@Transactional
public class OfficerService {
	
	@Autowired private OfficerMapper officerMapper;
	
		//나의정보 수정
		public int myOfficeModify() {
			int i = officerMapper.myOfficeModify();
			return i;
		}
	
		//직원아이디 자동생성
		public Officer getOfficerId() {
			Officer officer = officerMapper.getOfficerId();
			System.out.println(officer +" <-- OfficerService.java");
			return officer;
		}
		
		//나의정보 - 자격증 조회
		public List<License> getOfficerLicense(String SID){
			List<License> licenseList = officerMapper.getOfficerLicense(SID);
			return licenseList;
		}
	
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
		public int addOfficer(Officer officer) {			
			int i = officerMapper.addOfficer(officer);
			return i;
		}

}
