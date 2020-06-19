package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import team1.project.vo.Member;
import team1.project.vo.Officer;

@Mapper
public interface LoginMapper {
	
	//직원검색
	public Officer getOfficerSelect(String officerId);
	
	//회원검색
	public Member getMemberSelect(String memberId);
}
