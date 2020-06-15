package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.RegionMapper;
import team1.project.vo.Region;

@Service
@Transactional
public class RegionService {
	
	@Autowired private RegionMapper regionMapper;
	
	public int addRegion(Region region) {
		return regionMapper.addRegion(region);
	}
	
	public List<Region> getRegionMajorList(){
		return regionMapper.getRegionMajorList();
	}
	
	public List<Region> getOfficeRegionList(){
		return regionMapper.getRegionList();
	}

}
