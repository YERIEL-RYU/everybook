package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.WarningMapper;
import team1.project.vo.Warning;

@Service
@Transactional
public class WarningService {

	@Autowired WarningMapper warningMapper;
	
	//도서평 신고 등록처리
	public int addWarning(Warning Warning) {
		return warningMapper.addWarning(Warning);
	};
	
}
