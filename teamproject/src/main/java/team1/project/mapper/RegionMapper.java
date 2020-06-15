package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Region;

@Mapper
public interface RegionMapper {
	public List<Region> getRegionList();
}
