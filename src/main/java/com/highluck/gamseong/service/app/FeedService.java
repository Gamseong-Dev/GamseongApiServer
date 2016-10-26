package com.highluck.gamseong.service.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.response.FeedResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.repository.FeedRepository;
import com.highluck.gamseong.repository.LikeRepository;
import com.highluck.gamseong.repository.ReplyRepository;


@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private CommonResponse commonResponse;
	
	@Transactional(readOnly = true)
	public ArrayList<FeedResponse> findAllByLocationId(FeedValue value){
		
		if(value.getLimit() == 0) 
			value.setLimit(value.DEFAULT_LIMIT);
		if(value.getPageNum() != 0)
			value.setOffset((value.getPageNum() - 1) * value.getLimit());
		
		ArrayList<FeedResponse> response = new ArrayList<>();
		
		List<Feed> list = (List<Feed>) feedRepository.findAllByLocationId(value);
		
		list.forEach(( f )->{
			FeedResponse feed = new FeedResponse();
			feed.setFeed(f);
			feed.setReply((ArrayList<Reply>)replyRepository.findByFeedId(f.getId()));
			feed.setUserLikeStatus(likeRepository.findCountByUserId(f.getUserId(), f.getId()));
			response.add(feed);
		});
		
		return response; 
	}
	
	@Transactional(readOnly = true)
	public FeedResponse findById(FeedValue value){
		
		FeedResponse response = new FeedResponse();
		response.setFeed(feedRepository.findById(value));
		response.setReply((ArrayList<Reply>)replyRepository.findByFeedId(value.getId()));
		response.setUserLikeStatus(likeRepository.findCountByUserId(value.getUserId(), value.getId()));
		
		return response;	
	}
	
	@Transactional(readOnly = false)
	public CommonResponse save(Feed feed){
	
		feedRepository.save(feed);	
		commonResponse.setResult(commonResponse.SUCCESS);;
		
		return commonResponse;
	}
	
	@Transactional(readOnly = true)
	public ArrayList<FeedResponse> findBest(FeedValue value){
		
		if(value.getLimit() == 0) value.setLimit(5);
		
		value.setFromTime(Timestamp.valueOf(LocalDateTime.now().minusDays(7)));
		value.setToTime(Timestamp.valueOf(LocalDateTime.now()));
		
		ArrayList<FeedResponse> response = new ArrayList<>();
		
		List<Feed> list = feedRepository.findBest(value);
		
		list.forEach( f -> {
			FeedResponse feed = new FeedResponse();
			feed.setFeed(f);
			feed.setReply((ArrayList<Reply>)replyRepository.findByFeedId(f.getId()));
			feed.setUserLikeStatus(likeRepository.findCountByUserId(f.getUserId(), f.getId()));
			response.add(feed);		
		});
		
		return response;
	}
	
	@Transactional(readOnly =false)
	public CommonResponse set(Feed feed){
		
		feedRepository.set(feed);
		commonResponse.setResult(commonResponse.SUCCESS);
		
		return commonResponse;
	}
	
	@Transactional(readOnly =false)
	public CommonResponse delete(long id){
		
		feedRepository.delete(id);
		commonResponse.setResult(commonResponse.SUCCESS);
		
		return commonResponse;
	}
}
