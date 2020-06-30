package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.OverdueMapper;
import team1.project.vo.Overdue;

@Service
@Transactional
public class OverdueService {
	@Autowired private OverdueMapper overdueMapper;
	
	public List<Overdue> officeOverdueList(){
		List<Overdue> list = overdueMapper.officeOverdueList();
		return list;
	}
	
}