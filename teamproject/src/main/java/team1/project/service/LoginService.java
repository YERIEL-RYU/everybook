package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.mapper.LoginMapper;
import team1.project.vo.Member;

@Service
public class LoginService {
	
	@Autowired private LoginMapper loginMapper;
	
	public Member getMemberSelect(String memberId) {
		return  loginMapper. getMemberSelect(memberId);
	};
}
