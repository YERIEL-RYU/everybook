package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ReserveMapper;
import team1.project.vo.RtcanReserve;

@Service
@Transactional
public class RtcanReserveService {
	
	@Autowired private ReserveMapper reserveMapper;
	
	//직원 온라인 예약 미승인 건수
	public int getReserveCount() {
		return reserveMapper.getReserveCount();
	}
	
	//직원 온라인 예약 리스트 화면 리스트 호출
	public List<RtcanReserve> getReserveList(String libraryCode){
		return reserveMapper.getReserveList(libraryCode);
	}
	
	//직원 온라인 예약 등록화면에서  대기중인 리스트 승인 업데이트
	public int modifyReserve(RtcanReserve rtcanReserve) {
		return reserveMapper.modifyReserve(rtcanReserve);
	}
	
	//직원화면에서 회원이 등록한 대기중인 온라인 예약 리스트 호출
	public List<RtcanReserve> addReserve(String libraryCode){
		return reserveMapper.addReserve(libraryCode);
	}
	
	
	//회원 화면에서 회원이 온라인 예약 등록하기
	public int addRtcanReserve(RtcanReserve rtcanReserve) {
		return reserveMapper.addRtcanReserve(rtcanReserve);
	}
}
