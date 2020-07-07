package team1.project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team1.project.controller.ReserveController;
import team1.project.mapper.LibraryMapper;
import team1.project.mapper.RentMapper;
import team1.project.vo.Book;

@Service
public class RecommendService {
	
	private final static Logger logger = LoggerFactory.getLogger(RecommendService.class);
	@Autowired LibraryMapper libraryMapper;
	@Autowired RentMapper rentMapper;
	
	public String recommendList(String memberId){
		List<String> bookIsbn = rentMapper.selectIsbn(memberId);
		String uri = "http://data4library.kr/api/recommandList?authKey=d30acf5969608e57f856c36ddd03e661e138d851efb484a2ddffc33ce70627d4"
				+ "&isbn13=";
		String line = null;
		for(int i =0; i < bookIsbn.size(); i++) {
			uri += bookIsbn.get(i)+";";
		}
		uri += "&format=json";
		logger.info("uri : {}",uri);
		try {
			URL url = new URL(uri);
			URLConnection conn = url.openConnection();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			while((line = br.readLine()) != null) {
				logger.info("line : {}", line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
