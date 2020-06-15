package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Member;

@Mapper
public interface MemberMapper {

	//회원아이디중복체크
	public int memberIdCK(Member member);
	
	//회원등록
	public int addMember(Member member);
}
