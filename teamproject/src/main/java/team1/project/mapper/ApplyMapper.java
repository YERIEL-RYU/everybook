package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Apply;

@Mapper
public interface ApplyMapper {
	
	//희망신청도서 리스트
	public List<Apply> getApplyList();
	
	/*
	 * //희망도서신청 코드자동증가 
	 * public int addApplyCodeMax();
	 */
	
	//희망도서신청 등록처리
	public int addBookApply(Apply apply);
}