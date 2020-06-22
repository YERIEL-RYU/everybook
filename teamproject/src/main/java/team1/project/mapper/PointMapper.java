package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Point;

@Mapper
public interface PointMapper {
	
	public List<Point> getPsList();

}
