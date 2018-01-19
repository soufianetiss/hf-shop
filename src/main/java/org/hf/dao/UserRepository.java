package org.hf.dao;

import org.hf.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	User findOneByLogin(String login);
	
}
