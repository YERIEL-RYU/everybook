package team1.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.BookMapper;
import team1.project.mapper.MemberMapper;
import team1.project.mapper.ReturnMapper;
import team1.project.vo.Return;

@Service
@Transactional
public class ReturnService {
	private final static Logger logger = LoggerFactory.getLogger(ReturnService.class);
	@Autowired private ReturnMapper returnMapper;
	@Autowired private BookMapper bookMapper;
	@Autowired private MemberMapper memberMapper;
	
	//반납처리
	public int addBookReturn(Return returnVo) {
		logger.info("RentService.java addBookReturn() returnVo -> " + returnVo);
		int i =  bookMapper.bookSituationReturnModify(returnVo); //도서상태 변환(대여 중 -> 보유 중)
		logger.info("RentService bookSituationReturnModify() 실행결과 : " + i);
		int j = memberMapper.memberRentCountMinus(returnVo);//회원의 대여도서 수 감소)
		logger.info("RentService memberRentCountMinus() 실행결과 : " + j);

		return returnMapper.addBookReturn(returnVo);
	}
	
	//반납관리 - 반납도서리스트 검색
	public List<Return> officeReturnListSearch(String sk, String sv){
		return returnMapper.officeReturnListSearch(sk, sv);
	}
	
	//반납관리 - 반납도서리스트 조회
	public List<Return> officeReturnList(){
		return returnMapper.officeReturnList();
	}
	
}
