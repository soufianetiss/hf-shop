package org.hf.dao;


import org.hf.entities.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{
	
	//public Shop findByDistance(double distance);
	
//	@Query("select s from Shop s")
	//Stream<Shop> findLikedShopsByUser();
	 
}
