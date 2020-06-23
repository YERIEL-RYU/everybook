package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Return;

@Mapper
public interface ReturnMapper {

	//반납관리 반납도서리스트
	public List<Return> officeReturnList();
}
