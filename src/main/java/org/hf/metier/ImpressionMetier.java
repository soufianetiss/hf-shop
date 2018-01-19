package org.hf.metier;

import java.util.List;

import org.hf.entities.Impression;

public interface ImpressionMetier {
	List<Impression> findDislikeImpressionByIdUserLogin(String login);
	List<Impression> findLikeImpressionByIdUserLogin(String login);
	List<Impression> findByIdUserLogin(String login);
	void save(Impression impression);
}
