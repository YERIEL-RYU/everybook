package team1.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Writer;

@Mapper
public interface WriterMapper {
	public Writer selectWriteCode(Writer writer);
}
