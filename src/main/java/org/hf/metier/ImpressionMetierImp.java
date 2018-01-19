package org.hf.metier;

import java.util.List;

import org.hf.dao.ImpressionRepository;
import org.hf.entities.Impression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpressionMetierImp implements ImpressionMetier{
	@Autowired
	ImpressionRepository impressionRepository;
	
	@Override
	public List<Impression> findDislikeImpressionByIdUserLogin(String login) {
		// TODO Auto-generated method stub
		List<Impression> listImpression = impressionRepository.findByIdUserLoginAndImpression(login, "dislike");
		return listImpression;
	}
	@Override
	public List<Impression> findLikeImpressionByIdUserLogin(String login) {
		// TODO Auto-generated method stub
		List<Impression> listImpression = impressionRepository.findByIdUserLoginAndImpression(login, "like");
		return listImpression;
	}
	@Override
	public void save(Impression impression) {
		// TODO Auto-generated method stub
		impressionRepository.save(impression);
	}
	@Override
	public List<Impression> findByIdUserLogin(String login) {
		// TODO Auto-generated method stub
		return impressionRepository.findByIdUserLogin(login);
	}
	
}
