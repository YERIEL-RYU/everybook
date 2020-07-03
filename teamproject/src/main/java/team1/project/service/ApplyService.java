package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ApplyMapper;
import team1.project.vo.Apply;

@Service
@Transactional
public class ApplyService {

	@Autowired private ApplyMapper applyMapper;
	
	//신청관리 - 신청도서리스트 - 삭제
	public int deleteOfficeApply(String applyCode) {
		return applyMapper.deleteOfficeApply(applyCode);
	}
	
	//신청관리 - 신청도서리스트
	public List<Apply> officeApplyList(){
		return applyMapper.officeApplyList();
	}
	
	//코드검색
	public Apply getApplyCode(String applyCode) {
		return applyMapper.getApplyCode(applyCode);
	}
	
	//나의 신청도서 취소하기
	public int deleteBookApply(Apply apply) {
		return applyMapper.deleteBookApply(apply);
	}
	
	//나의신청도서 리스트
	public List<Apply> myApplyList(String SID){
		return applyMapper.myApplyList(SID);
	}
	
	//희망도서신청 등록
	public int addBookApply(Apply apply) {
		return applyMapper.addBookApply(apply);
	}
}
