package team1.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.BookMapper;
import team1.project.mapper.MemberMapper;
import team1.project.mapper.RentMapper;
import team1.project.vo.Rent;

@Service
@Transactional
public class RentService {
	private final static Logger logger = LoggerFactory.getLogger(RentService.class);
	@Autowired private RentMapper rentMapper;
	@Autowired private BookMapper bookMapper;
	@Autowired private MemberMapper memberMapper;
	
	//대여처리
	public int addBookRent(Rent rent) {
		logger.info("RentService.java bookSituationModify rent -> " + rent);
		int i =  bookMapper.bookSituationModify(rent);
		logger.info("RentService bookSituationModify() 실행결과 : " + i);
		int j = memberMapper.memberRentCountPlus(rent);
		logger.info("RentService memberRentCountPlus() 실행결과 : " + j);
		 
		return rentMapper.addBookRent(rent);
	}
	
	//코드 검색
	public Rent getRentCode(String rentCode) {
		return rentMapper.getRentCode(rentCode);
	}
	
	//대여관리 대여리스트 -삭제
	public int officeRentDelete(Rent rent) {
		return rentMapper.officeRentDelete(rent);
	}
	
	//대여관리 대여리스트 - 검색
	public List<Rent> OfficeRentListSerch(String sk, String sv){
		return rentMapper.OfficeRentListSerch(sk, sv);
	}
	
	//대여관리 대여리스트
	public List<Rent> officeRentList(){
		return rentMapper.officeRentList();
	}
	
	//나의 대여 이력 - 검색
	public List<Rent> myRentHistorySearch(String sk, String sv, String SID){
		return rentMapper.myRentHistorySearch(sk, sv, SID);
	}
	
	//나의 대여 이력
	public List<Rent> myRentHistoryList(String SID){
		return rentMapper.myRentHistoryList(SID);
	}
}
