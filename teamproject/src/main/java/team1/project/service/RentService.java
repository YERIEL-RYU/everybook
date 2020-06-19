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
	
	//나의 대여 이력
	public List<Rent> getRentHistoryList(){
		List<Rent> list = rentMapper.getRentHistoryList();
		return list;
	}
}
