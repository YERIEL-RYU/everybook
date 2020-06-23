package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Member;

@Mapper
public interface MemberMapper {

	//회원수정
	public int ModifyMember(Member member);
	
	//회원상세보기
	public Member DetailMember(Member member);
	
	//한명회원조회
	public Member selectgetMember(String memberId);
	
	//회원등록
	public int addMember(Member member);
}
