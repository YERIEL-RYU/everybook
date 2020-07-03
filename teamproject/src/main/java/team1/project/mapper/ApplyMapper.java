package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Apply;

@Mapper
public interface ApplyMapper {
	
	//신청관리-신청도서리스트
	public List<Apply> officeApplyList();
	
	//코드검색
	public Apply getApplyCode(String applyCode);
	
	//나의 신청도서 취소하기
	public int deleteBookApply(Apply apply);
	
	//나의 희망도서신청 리스트
	public List<Apply> myApplyList(String SID);	
	
	//희망도서 신청 
	public int addBookApply(Apply apply);
}
