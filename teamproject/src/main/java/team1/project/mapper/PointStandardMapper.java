package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Point;

@Mapper
public interface PointStandardMapper {
	
	public int deletePs(Point point);
	
	public int modifyPs(Point point);
	
	public Point getSelectPs(String psCode);
	
	public int addPs(Point point);
	
	public List<Point> getPsList();

}
