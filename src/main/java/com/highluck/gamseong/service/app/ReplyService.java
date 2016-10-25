package com.highluck.gamseong.service.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional(readOnly=true)
	public ArrayList<Reply> findAllByFeedId(FeedValue value){	
		
		if(value.getLimit() == 0) 
			value.setLimit(value.DEFAULT_LIMIT);
		if(value.getPageNum() != 0)
				value.setOffset((value.getPageNum() - 1) * value.getLimit());
		
		return (ArrayList<Reply>) replyRepository.findAllByFeedId(value);
	}
	
	@Transactional(readOnly=false)
	public CommonResponse save(Reply reply){
		
		CommonResponse response = new CommonResponse();
		
		replyRepository.save(reply);
		response.setResult(response.SUCCESS);
		
		return response;
	}
}
