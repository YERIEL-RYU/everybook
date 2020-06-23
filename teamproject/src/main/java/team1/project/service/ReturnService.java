package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ReturnMapper;
import team1.project.vo.Return;

@Service
@Transactional
public class ReturnService {
	@Autowired private ReturnMapper returnMapper;
	
	//반납관리 현재보유도서리스트
	public List<Return> officeReturnList(){
		List<Return> list = returnMapper.officeReturnList();
		return list;
	}
	
}
