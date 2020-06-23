package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PointStandardMapper;
import team1.project.vo.Point;

@Service
@Transactional
public class PointService {

	@Autowired private PointStandardMapper pointMapper;
	
	public List<Point> searchPs(String sk, String sv){
		return pointMapper.searchPs(sk, sv);
	}
	
	public int deletePs(Point point) {
		return pointMapper.deletePs(point);
	}
	
	public int modifyPs(Point point) {
		return pointMapper.modifyPs(point);
	}
	
	public Point getSelectPs(String psCode) {
		return pointMapper.getSelectPs(psCode);
	}
	
	public int addPs(Point point) {
		return pointMapper.addPs(point);
	}
	
	public List<Point> getPsList(){
		return pointMapper.getPsList();
	}
	
}
