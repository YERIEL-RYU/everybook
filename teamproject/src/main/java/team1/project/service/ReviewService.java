package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.ReviewMapper;
import team1.project.vo.Review;

@Service
@Transactional
public class ReviewService {

	@Autowired private ReviewMapper reviewMapper;
	
	//도서평 삭제(회원)
	public int deleteReview(String reviewCode) {
		return reviewMapper.deleteReview(reviewCode);
	};
	
	//도서평 수정(회원)
	public int updateReview(String reviewCode,String reviewContent){
		return reviewMapper.updateReview(reviewCode, reviewContent);
	};
	
	//도서평 내역(회원)
	public List<Review> selectReview(String memberId){
		return reviewMapper.selectReview(memberId);
	};
	
	//도서평 등록
	public int addReview(Review review) {
		return reviewMapper.addReview(review);
	};
}
