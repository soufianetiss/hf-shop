package org.hf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.hf.entities.Shop;
import org.hf.util.Location;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;


@SpringBootApplication
public class ProjShopApplication {
	
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext c=SpringApplication.run(ProjShopApplication.class, args);
		MongoClient mongoClient;

		// Connect to the local database server
		mongoClient = new MongoClient();
		// Get handle to "dbName" database
		MongoDatabase database = mongoClient.getDatabase("shopdb");
		// Get a handle to the "collName" collection
		MongoCollection<Document> collection = database.getCollection("shops");
		collection.createIndex(Indexes.geo2dsphere("shops.location"));
		Document query = new Document("location", 
                new Document("$near", 
                   new Document("$geometry", 
                       new Document("type", "Point")
                           // Note that the order is "longitude, latitude"
                           .append("coordinates", Arrays.asList( -6.589017,34.254050) )
                   )
                   // These distances are in meters.
//                   .append("$minDistance", 1000)
//                   .append("$mashopDistance", 34000)
		  )
		);
//		MongoCursor<Document> cursor = collection.find(query).limit(10).map((shop)->{
//			return shop;
//		}).iterator();
		MongoCursor<Shop> ls = collection.find(query).limit(10).map((shop)->{
			Shop s=new Shop();
			Location l=new Location();
			s.setId(shop.get("_id").toString());
			s.setEmail(shop.get("email").toString());
			s.setName(shop.get("name").toString());
			s.setPicture(shop.get("picture").toString());
			//l=(Location) shop.get("location").;
			//System.out.println(l);
			Document location=(Document) shop.get("location");
			l.setType(location.get("type").toString());
			List<Document> lcoor=(List<Document>)location.get("coordinates");
			double[] pos={Double.parseDouble(lcoor.toArray()[0].toString()),Double.parseDouble(lcoor.toArray()[1].toString())};
			//pos[0]=Double.parseDouble(lcoor.toArray()[0].toString());
			//pos[1]=Double.parseDouble(lcoor.toArray()[1].toString());
			l.setCoordinates(pos);
			//System.out.println(Double.parseDouble(lcoor.toArray()[0].toString()));
			s.setLocation(l);
			return s;
		}).iterator();
		try {
		    // print them out
		    while (ls.hasNext()) {
		        System.out.println(ls.next().toString());
		    }
		} finally {
		    ls.close();
		}
		// Release resources
		mongoClient.close();
		//UserRepository ur=(UserRepository)conteshopt.getBean(UserRepository.class);
//		ShopRepository sr=(ShopRepository)conteshopt.getBean(ShopRepository.class);
//		ShopMetier sm=(ShopMetier)conteshopt.getBean(ShopMetier.class);
//		ImpressionRepository ir=(ImpressionRepository)conteshopt.getBean(ImpressionRepository.class);
//		UserMetier um=(UserMetier)conteshopt.getBean(UserMetier.class);
		//		MongoTemplate mt=conteshopt.getBean(MongoTemplate.class);
		//		
//		User u=new User("login","pass");
//		Shop s=new Shop("na3na3",70D);
//		ur.save(u);
//		if(sr.findByNameAndDistance(s.getName(), s.getDistance())==null){
//			sr.save(s);
//		}else{
//			s=sr.findByNameAndDistance(s.getName(), s.getDistance());
//		}
//		Impression i=new Impression(new ImpressionId(u, s),"like",new Date());
//		//sr.delete(s);
//		ir.save(i);
//		//ir.delete(new ImpressionId(u, s));
		//new
		//User u=new User("zaza","pass",new LinkedHashSet<>(sm.findNearbyShopsByUser("osus")));
		//um.signUp(u);
		//Thread.sleep(4000);
//		System.out.println(um.findAll());
//		Shop s=new Shop("na3na3",70D);
//		s.setId("5a457d29d8493c32247a7012");
//		
//		Impression i=new Impression(new ImpressionId(u, s),"like",new Date());
//		ir.save(i);
//		QShop shop=QShop.shop;
//		QImpression impression=QImpression.impression1;
		//MongoTemplate mt=new MongoTemplate(mongoDbFactory)
		//List<Impression> li=(List<Impression>);
		//System.out.println(mt.findAllAndRemove(Query.query(criteriaDefinition)(Criteria.where("_id").equals(i)),Impression.class));
//		System.out.println(ir.findByIdUserLoginAndImpression("login","dislike"));
//		List<Shop> listShop=new ArrayList<Shop>();
//		listShop.add(new Shop("5a457d29d8493c32247a7012","na3na3",70D));
//		listShop.add(new Shop("5a4631a1d8493c23d87892a9","cha3cha3",40D));
//		User user=new User("osus", "pass", listShop);
//		ur.save(user);
//		System.out.println(ur.findAll().get(1));
	}
}
