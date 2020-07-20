package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PublisherMapper;
import team1.project.vo.Publisher;

@Service
@Transactional
public class PublisherService {
	
	@Autowired PublisherMapper publisherMapper;
	
	public int addPublisher(Publisher publisher) {
		return publisherMapper.addPublisher(publisher);
	}
	
	public String selectPublisherCode(String publisherName) {
		return publisherMapper.selectPublisherCode(publisherName);
	}

}
