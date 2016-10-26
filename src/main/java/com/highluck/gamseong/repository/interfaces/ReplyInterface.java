package com.highluck.gamseong.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;

@Repository
public interface ReplyInterface extends CrudRepository<Reply, Long>{

	Reply findById(long id);
}
