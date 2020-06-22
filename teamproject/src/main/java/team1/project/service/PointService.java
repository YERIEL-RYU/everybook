package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PointMapper;
import team1.project.vo.Point;

@Service
@Transactional
public class PointService {

	@Autowired private PointMapper pointMapper;
	
	public List<Point> getPsList(){
		return pointMapper.getPsList();
	}
	
}
