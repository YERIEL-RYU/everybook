package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Warning;

@Mapper
public interface WarningMapper {
	
	//도서평 신고 등록처리
	public int addWarning(Warning Warning);
}
