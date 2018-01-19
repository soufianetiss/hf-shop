package org.hf.controllers;

import java.util.List;

import org.hf.entities.Shop;
import org.hf.metier.ShopMetier;
import org.hf.util.ShopNearby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopRestService {
	@Autowired
	ShopMetier shopMetier;
	
	@RequestMapping(value="/nearby/{login}",method=RequestMethod.GET)
	public List<ShopNearby> listNearbyShops(@PathVariable("login") String login){
		return shopMetier.findNearbyShopsByUser(login);
	}
	@RequestMapping(value="/preferred/{login}",method=RequestMethod.GET)
	public List<Shop> listPreferredShops(@PathVariable("login") String login){
		return shopMetier.findPreferredShopsByUser(login);
	}
}
