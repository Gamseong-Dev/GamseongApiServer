package com.highluck.gamseong.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.LikeInfo;

@Repository
public interface FeedInterface extends CrudRepository<Feed, Long>{

	Feed findById(long id);
	
}
