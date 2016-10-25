package com.highluck.gamseong.repository.inter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.LikeInfo;

@Repository
public interface LikeInterface extends CrudRepository<LikeInfo, Long>{

	LikeInfo findByFeedIdAndUserId(long feedId, String userId);
	
	LikeInfo save(LikeInfo likeInfo);
}
