package org.hf.metier;


import java.util.List;
import java.util.stream.Collectors;

import org.hf.dao.ShopRepository;
import org.hf.dao.UserRepository;
import org.hf.entities.Impression;
import org.hf.entities.ImpressionId;
import org.hf.entities.Shop;
import org.hf.util.ShopNearby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShopMetierImp implements ShopMetier{
	@Autowired
	ImpressionMetier impressionMetier;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	UserRepository userRepository;

	

	@Override
	public Shop findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ShopNearby> findNearbyShopsByUser(String login) {
		// TODO Auto-generated method stub
//		double dateDiff;
//		Duration d;
		if(!userRepository.exists(login)){
			throw new RuntimeException("login dosn't exist");
		}
		List<Shop> listShop=shopRepository.findAll();
		List<Impression> listImpression=impressionMetier.findByIdUserLogin(login);
		
//		List<Impression> listImpression=impressionMetier.findDislikeImpressionByIdUserLogin(login);
//		for(Impression i:listImpression){
//			
//			if(i.getImpression().equals("dislike")){
//				d=new Duration(new DateTime(i.getDate()), new DateTime(new Date()));
//				dateDiff=d.getStandardHours();
//				if(dateDiff>2){
//					for
//				}
//			}
//		}
		
		List<ShopNearby> listShopNearby=listShop.stream()
			.map((s)->{
				int ShopImpressionUpdateCounter=0;
				Boolean flag=false;
				ShopNearby sn=new ShopNearby();
				if(listImpression.size()>ShopImpressionUpdateCounter){
					for(int i=0;i<listImpression.size();i++){
						if(listImpression.get(i).getId().getShop().getId().equals(s.getId())){
							sn=new ShopNearby(s,listImpression.get(i).getImpression(), listImpression.get(i).getDate());
							ShopImpressionUpdateCounter=0;
							flag=true;
							ShopImpressionUpdateCounter++;
							break;
						}
					}
				}
				
				if(flag==false){
					sn=new ShopNearby(s,null, null);
				}
				
				return sn;
			})
			.collect(Collectors.toList());
		return listShopNearby;
	}

	@Override
	public List<Shop> findPreferredShopsByUser(String login) {
		// TODO Auto-generated method stub
		if(!userRepository.exists(login)){
			throw new RuntimeException("login dosn't exist");
		}
		List<Impression> listImpression=impressionMetier.findLikeImpressionByIdUserLogin(login);
		List<Shop> listShop=listImpression.stream().map(Impression::getId)
													.map(ImpressionId::getShop)
													.collect(Collectors.toList());
		
		return listShop;
	}

}
