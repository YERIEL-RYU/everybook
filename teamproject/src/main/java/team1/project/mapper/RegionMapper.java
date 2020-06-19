package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Region;

@Mapper
public interface RegionMapper {
	
	public Region getRegion(String regionCode);
	
	public int addRegion(Region region);
	
	public List<Region> getRegionMajorList();
	
	public List<Region> getRegionList();
}
