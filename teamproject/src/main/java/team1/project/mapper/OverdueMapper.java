package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Overdue;

@Mapper
public interface OverdueMapper {

	//연체도서리스트
	public List<Overdue> officeOverdueList();
}
