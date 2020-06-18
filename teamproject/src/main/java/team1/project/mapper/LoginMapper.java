package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import team1.project.vo.Member;

@Mapper
public interface LoginMapper {
	
	//회원검색
	public Member getMemberSelect(String memberId);
}
