package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Publisher;

@Mapper
public interface PublisherMapper {
	public int addPublisher(Publisher publisher);
	public String selectPublisherCode(String publisherName);
}
