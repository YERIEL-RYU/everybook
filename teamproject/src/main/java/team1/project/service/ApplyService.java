
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
	
	//신청관리 - 신청도서리스트
	public List<Apply> officeApplyList(){
		List<Apply> list2 = applyMapper.officeApplyList();
		return list2;
	}
	
	//나의신청도서 리스트
	public List<Apply> myApplyList(String SID){
		List<Apply> list = applyMapper.myApplyList(SID);
		return list;
	}
	
	//희망도서신청 등록
	public int addBookApply(Apply apply) {
		int result = applyMapper.addBookApply(apply);
		return result;
	}
}
