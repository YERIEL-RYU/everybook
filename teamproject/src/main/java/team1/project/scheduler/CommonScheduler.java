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

	@Scheduled(cron = "0 0/3 * * * ?")
	public void reservate() throws ParseException {
		logger.info("예약 조회 및 처리 : {}");
		List<RtcanReserve> rtcanReserveTime = rtcanReserveService.getRtcanReserveTime();
		LocalDateTime currentTime = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
		for(int i =0; i <rtcanReserveTime.size(); i++) {
			//LocalDateTime reserveDate = LocalDateTime.parse(rtcanReserveTime.get(i).getRtcanRegDate(),formatter);
			String tt = rtcanReserveTime.get(i).getRtcanRegDate();
			int year = Integer.parseInt(tt.substring(0,4));
			int month = Integer.parseInt(tt.substring(5, 7));
			int day = Integer.parseInt(tt.substring(8,10));
			int hour = Integer.parseInt(tt.substring(11,13));
			int minute = Integer.parseInt(tt.substring(14,16));
			int second = Integer.parseInt(tt.substring(17,19));
			/*
			 * logger.info("tt : {}",tt); logger.info("year : {}",year);
			 * logger.info("month : {}",month); logger.info("day : {}",day);
			 * logger.info("time : {}",time); logger.info("minute : {}",minute);
			 * logger.info("seconds : {}",seconds);
			 */
			LocalDateTime reserveDate = LocalDateTime.of(year, month, day, hour, minute, second);
			Duration duration = Duration.between(reserveDate, currentTime);
			logger.info("시간차이 : {}", duration.getSeconds());
			if(duration.getSeconds() > 75600 && duration.getSeconds() < 86399) {
				logger.info("경고메세지를 보내고");
			}else if(duration.getSeconds() > 86400) {
				logger.info("예약 취소 및 벌점 긔긔");
			}
			
		}
	}
}
