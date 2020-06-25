package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Library;
import team1.project.vo.Member;

@Mapper
public interface MemberMapper {

	//지역 도서관 출력
	public List<Library> selectLibraryCode(String regionCode);
	
	//지역코드 출력
	public String selectRegionCode(String rMagjor, String rMinor);
	
	//전체회원리스트
	public List<Member> allListMember();
	
	//회원수정
	public int ModifyMember(Member member);
	
	//회원상세보기
	public Member DetailMember(Member member);
	
	//한명회원조회
	public Member selectgetMember(String memberId);
	
	//회원등록
	public int addMember(Member member);
}
