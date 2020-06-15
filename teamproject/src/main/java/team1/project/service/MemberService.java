package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.MemberMapper;
import team1.project.vo.Member;

@Transactional
@Service
public class MemberService {

	@Autowired private MemberMapper memberMapper;
	
	public int memberIdCK(Member member) {
		return memberMapper.memberIdCK(member);
	} 
	
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	};
}
