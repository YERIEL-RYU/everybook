package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.RentMapper;
import team1.project.vo.Rent;

@Service
@Transactional
public class RentService {
	@Autowired private RentMapper rentMapper;
	
	//대여관리 대여리스트 -삭제
	public int officeRentDelete() {
		int result = rentMapper.officeRentDelete();
		return result;
	}
	
	//대여관리 대여리스트
	public List<Rent> officeRentList(){
		List<Rent> list2 = rentMapper.officeRentList();
		return list2;
	}
	
	//나의 대여 이력
	public List<Rent> myRentHistoryList(String SID){
		List<Rent> list = rentMapper.myRentHistoryList(SID);
		return list;
	}
}
