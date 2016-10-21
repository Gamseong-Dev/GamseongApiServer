package com.highluck.gamseong.service.app;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.repository.FeedRepository;
import com.highluck.gamseong.repository.ReplyRepository;


@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;
	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional(readOnly = true)
	public ArrayList<Feed> findAllByLocationId(FeedValue value){
		
		if(value.getLimit() == 0) 
			value.setLimit(value.DEFAULT_LIMIT);
		if(value.getPageNum() != 0)
				value.setOffset(value.getPageNum() - 1 * value.getLimit());
		
		
		ArrayList<Feed> list = (ArrayList<Feed>) feedRepository.findAllByLocationId(value);
		list.forEach(( f )->{
			f.setReply((ArrayList<Reply>)replyRepository.findByFeedId(value));
		});
		
		return list; 
	}
	
	@Transactional(readOnly = true)
	public Feed findById(FeedValue value){
		
		return feedRepository.findById(value);	
	}
	
	@Transactional(readOnly = false)
	public CommonResponse addLike(FeedValue value){
		
		CommonResponse response = new CommonResponse();	
		feedRepository.addLike(value);
		
		response.setResult(response.SUCCESS);;
		
		return response;
	}
	
	@Transactional(readOnly = false)
	public CommonResponse save(Feed feed){
	
		CommonResponse response = new CommonResponse();	
		feedRepository.save(feed);
		
		response.setResult(response.SUCCESS);;
		
		return response;
	}
}
