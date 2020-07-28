package team1.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PointHistoryMapper;
import team1.project.mapper.PointStandardMapper;
import team1.project.vo.PointHistory;
import team1.project.vo.PointStandard;

@Service
@Transactional
public class PointService {
	
	private final static Logger logger = LoggerFactory.getLogger(PointService.class);
	@Autowired private PointStandardMapper pointStandardMapper;
	@Autowired private PointHistoryMapper pointHistoryMapper;
	
	/*상벌점 내역*/
	public Map<String, Object> getMemberPointHistory(String memberId, int currentPage){
		final int ROW_PER_PAGE = 10;
		int startPageNum = 1;
		int lastPageNum = ROW_PER_PAGE;
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("currentPage", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		map.put("memberId", memberId);
		double phCount = pointHistoryMapper.getMemberPointHistoryCount(memberId);
		//logger.info("도서관 전체 갯수 : {}",libraryCount);
		
		
		// view에 보여질 마지막 페이지의 수(전체행의 갯수/보여줄 행의 갯수-> 올림)
		int lastPage = (int)(Math.ceil(phCount/ROW_PER_PAGE));
		
		// view에 현재 페이지가 마지막페이지보다 4작을 경우 view쪽의 반복문의 반복횟수를 조정
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
		// view에 보여질 페이징 처리를 위해 값을 Map에 담아 리턴
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", pointHistoryMapper.getMemberPointHistory(map));
		returnMap.put("currentPage", currentPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("startPageNum", startPageNum);
		returnMap.put("lastPageNum", lastPageNum);
		logger.info("returnMap : {}",returnMap);
		
		return returnMap;
	}
	public int addPh(PointHistory point) {
		String phCode = pointHistoryMapper.getMaxPhCode();
		if(phCode == null) {
			phCode = "point_history_00001";
		}else {
			phCode = phCode.substring(15);
			int maxPhCode = Integer.parseInt(phCode);
			if(maxPhCode <9) {
				phCode = "point_history_0000"+(maxPhCode+1);
			}else if(maxPhCode <99) {
				phCode = "point_history_000"+(maxPhCode+1);
			}else if(maxPhCode <999) {
				phCode = "point_history_00"+(maxPhCode+1);
			}else if(maxPhCode <999) {
				phCode = "point_history_0"+(maxPhCode+1);
			}else {
				phCode = "point_history_"+(maxPhCode+1);
			}
		}
		point.setPhCode(phCode);
		return pointHistoryMapper.addPh(point);
	}
	
	public List<PointHistory> getStandbyPsList(String libraryCode){
		return pointHistoryMapper.getStandbyPhList(libraryCode);
	}
	
	public List<PointHistory> getPhList(String libraryCode){
		return pointHistoryMapper.getPhList(libraryCode);
	}
	
	/*상벌점 기준*/
	public List<PointStandard> searchPs(String sk, String sv){
		return pointStandardMapper.searchPs(sk, sv);
	}
	
	public int deletePs(PointStandard point) {
		return pointStandardMapper.deletePs(point);
	}
	
	public int modifyPs(PointStandard point) {
		return pointStandardMapper.modifyPs(point);
	}
	
	public PointStandard getSelectPs(String psCode) {
		return pointStandardMapper.getSelectPs(psCode);
	}
	
	public int addPs(PointStandard point) {
		return pointStandardMapper.addPs(point);
	}
	
	public List<PointStandard> getPsList(){
		return pointStandardMapper.getPsList();
	}
	
}
