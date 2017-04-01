package com.highluck.gamseong.service.app;

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
import com.highluck.gamseong.model.value.UserValue;
import com.highluck.gamseong.repository.FeedByUserRepository;
import com.highluck.gamseong.repository.LikeRepository;
import com.highluck.gamseong.repository.ReplyRepository;

@Service
public class FeedByUserService {
	
	@Autowired
	private FeedByUserRepository userRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private LikeRepository likeRepository;
	
	@Transactional(readOnly = true)
	public ArrayList<FeedResponse>findFeedAllByUser(final UserValue value){
		
		if(value.getPageNum() != 0)
			value.setOffset((value.getPageNum() - 1) * value.getLimit());
		
		final ArrayList<FeedResponse> response = new ArrayList<>();
		
		List<Feed> list = (List<Feed>) userRepository.findAllByUserId(value);
		
		list.forEach( f -> {
			FeedResponse feed = new FeedResponse();
			feed.setFeed(f);
			feed.setReply((ArrayList<Reply>)replyRepository.findByFeedId(f.getId()));
			feed.setUserLikeStatus(likeRepository.findCountByUserId(f.getUserId(), f.getId()));
			response.add(feed);		
		});
		
		return response;
	}
	
}
