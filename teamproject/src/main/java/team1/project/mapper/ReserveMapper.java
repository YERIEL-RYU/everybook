package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.RtcanReserve;

@Mapper
public interface ReserveMapper {
	
	public List<RtcanReserve> addReserve(String libraryCode);
	public int addRtcanReserve(RtcanReserve rtcanReserve);
}
