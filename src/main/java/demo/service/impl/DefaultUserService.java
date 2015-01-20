package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.model.User;
import demo.service.UserService;

@Service
@Transactional
public class DefaultUserService implements UserService {

	@Autowired
	MongoOperations mongoOperation;

	@Override
	public void save(User user) {
		mongoOperation.save(user);
	}

	@Override
	public void delete(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		
		mongoOperation.remove(query, User.class);
	}

	@Override
	public User getByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));

		return mongoOperation.findOne(query, User.class);
	}

}
