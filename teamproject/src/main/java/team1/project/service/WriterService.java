package team1.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.WriterMapper;
import team1.project.vo.Writer;

@Service
@Transactional
public class WriterService {
	@Autowired private WriterMapper writerMapper;
	
	public int addWriter(Writer writer) {
		return writerMapper.addWriter(writer);
	}
	
	public String selectWriterCode(String writer) {
		return writerMapper.selectWriteCode(writer);
	}
}
