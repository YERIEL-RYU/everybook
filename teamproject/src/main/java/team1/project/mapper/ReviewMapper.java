package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Review;

@Mapper
public interface ReviewMapper {

	//도서평 내역(회원)
	public List<Review> selectReview(String memberId);
	
	//도서평 등록
	public int addReview(Review review);
}
