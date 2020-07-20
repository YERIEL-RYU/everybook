package team1.project.scheduler;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import team1.project.service.RtcanReserveService;
import team1.project.vo.RtcanReserve;

@Component
public class CommonScheduler {
	
	private final static Logger logger = LoggerFactory.getLogger(CommonScheduler.class);
	@Autowired RtcanReserveService rtcanReserveService;

	@Scheduled(cron = "0/30 * * * * ?")
	public void reservate() throws ParseException {
		logger.info("예약 조회 및 처리 : {}");
		List<RtcanReserve> rtcanReserveTime = rtcanReserveService.getRtcanReserveTime();
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
		for(int i =0; i <rtcanReserveTime.size(); i++) {
			LocalDateTime reserveDate = LocalDateTime.parse(rtcanReserveTime.get(i).getRtcanRegDate(),formatter);
					
		}
	}
}
