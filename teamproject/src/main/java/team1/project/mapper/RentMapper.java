package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Rent;

@Mapper
public interface RentMapper {

	//대여관리 - 대여리스트 삭제
	public int officeRentDelete();
	
	//대여관리 - 대여리스트
	public List<Rent> officeRentList();
	
	//나의 대여 이력
	public List<Rent> myRentHistoryList(String SID);
}
