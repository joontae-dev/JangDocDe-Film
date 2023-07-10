package com.example.jangdocdaefilm.service;


import com.example.jangdocdaefilm.dto.MemberDto;
import com.example.jangdocdaefilm.dto.MovieDto;
import com.example.jangdocdaefilm.dto.ReviewDto;
import com.example.jangdocdaefilm.dto.ReviewLikesDto;
import com.example.jangdocdaefilm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberMapper memberMapper;

  @Override
  public int isMemberInfo(String userId, String userPw) throws Exception {
    return memberMapper.isMemberInfo(userId, userPw);
  }

  @Override
  public MemberDto getMemberInfo(String userId) throws Exception {
    return memberMapper.getMemberInfo(userId);
  }

  @Override
  public void signUpMember(MemberDto member) throws Exception {
    memberMapper.signUpMember(member);
  }

  @Override
  public int confirmId(String id) throws Exception {
    return memberMapper.confirmId(id);
  }

  // 리뷰 등록
  @Override
  public void insertMovieReview(ReviewDto review) throws Exception {
    memberMapper.insertMovieReview(review);
  }

  // 해당 영화 모든 리뷰
  @Override
  public List<ReviewDto> getMovieReviewList(String movieId) throws Exception {
    return memberMapper.getMovieReviewList(movieId);
  }

  // 해당 영화 내가 쓴 리뷰
  @Override
  public ReviewDto getMyMovieReview(String movieId, String userId) throws Exception {
    return memberMapper.getMyMovieReview(movieId, userId);
  }

  // 리뷰 수정
  @Override
  public void updateMovieReview(ReviewDto review) throws Exception {
    memberMapper.updateMovieReview(review);
  }

  // 좋아요 +1
  @Override
  public void saveLike(int reviewIdx, String memberId) throws Exception {
    memberMapper.saveLike(reviewIdx, memberId);
    memberMapper.likeUp(reviewIdx);
  }

  @Override
  public ReviewDto getMovieReview(int reviewIdx) throws Exception {
    return memberMapper.getMovieReview(reviewIdx);
  }

  // 좋아요 -1
  @Override
  public void removeLike(int reviewIdx, String memberId) throws Exception {
    memberMapper.removeLike(reviewIdx, memberId);
    memberMapper.likeDown(reviewIdx);
  }

  // 좋아요 체크
  @Override
  public int checkLike(int reviewIdx, String memberId) throws Exception {
    return memberMapper.checkLike(reviewIdx, memberId);
  }

  @Override
  public void deleteMovieReview(int idx) throws Exception {
    memberMapper.deleteMovieReview(idx);
  }

  @Override
  public List<ReviewLikesDto> getReviewLike(String userId) throws Exception {
    return memberMapper.getReviewLike(userId);
  }

  @Override
  public String userScoreAvg(String movieId) throws Exception {
    return memberMapper.userScoreAvg(movieId);
  }

  @Override
  public void insertUserScoreAvg(MovieDto movie) throws Exception {
    memberMapper.insertUserScoreAvg(movie);
  }

  @Override
  public void updateUserScoreAvg(MovieDto movie) throws Exception {
    memberMapper.updateUserScoreAvg(movie);
  }

  @Override
  public MovieDto getScoreAvgMovie(String movieId) throws Exception {
    return memberMapper.getScoreAvgMovie(movieId);
  }
}
