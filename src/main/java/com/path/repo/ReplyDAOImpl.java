package com.path.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.path.model.Reply;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Reply create(Reply r) {
		return mongo.insert(r);
	}

}
