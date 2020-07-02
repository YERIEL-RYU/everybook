package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Rent;

@Mapper
public interface RentMapper {

	//코드검색
	public Rent getRent(String rentCode);
	
	//대여관리 - 대여리스트 삭제
	public int officeRentDelete(Rent rent);
	
	//대여관리 - 대여리스트 검색
	public List<Rent> OfficeRentListSerch(String sk, String sv);
	
	//대여관리 - 대여리스트
	public List<Rent> officeRentList();
	
	//나의 대여 이력 - 검색
	public List<Rent> myRentHistorySearch(String sk, String sv, String SID);
	
	//나의 대여 이력
	public List<Rent> myRentHistoryList(String SID);
}
