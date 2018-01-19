package org.hf.dao;

import java.util.List;

import org.hf.entities.Impression;
import org.hf.entities.ImpressionId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImpressionRepository extends MongoRepository<Impression, ImpressionId> {
	
	List<Impression> findByIdUserLoginAndImpression(String login,String impression);
	List<Impression> findByIdUserLogin(String login);
}
