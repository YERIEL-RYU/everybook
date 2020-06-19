package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.mapper.LoginMapper;
import team1.project.vo.Login;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Service
public class LoginService {
	
	@Autowired private LoginMapper loginMapper;
	
	public int addLoginOfficer(Login officerId) {
		System.out.println("LoginService>>>>>"+officerId.toString());
		return loginMapper.addLoginOfficer(officerId);
	}
	
	public int addLoginMember(Login memberId) {
		System.out.println("LoginService>>>>>"+ memberId.toString());
		return loginMapper.addLoginMember(memberId);
	}
	
	public Officer getOfficerSelect(String officerId) {
		return loginMapper.getOfficerSelect(officerId);
	}
	
	public Member getMemberSelect(String memberId) {
		return  loginMapper. getMemberSelect(memberId);
	};
}
