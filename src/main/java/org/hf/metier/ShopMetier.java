package org.hf.metier;

import java.util.List;

import org.hf.entities.Shop;
import org.hf.util.ShopNearby;

public interface ShopMetier {
	
	List<ShopNearby> findNearbyShopsByUser(String login);
	List<Shop> findPreferredShopsByUser(String login);
	Shop findAll();
}
