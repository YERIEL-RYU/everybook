package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Rent;

@Mapper
public interface RentMapper {

	//나의 대여 이력
	public List<Rent> getRentHistoryList();
}
