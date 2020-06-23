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
	
	
	public int ModifyMember(Member member) {
		return memberMapper.ModifyMember(member);
	}
	
	public Member DetailMember(Member member) {
		return memberMapper.DetailMember(member);
	};
	
	public Member selectgetMember(String memberId) {
		return memberMapper.selectgetMember(memberId);
	}
	
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	};
}
