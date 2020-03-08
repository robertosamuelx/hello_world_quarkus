package org.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

	private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
	
	@Inject
	public FruitService fruitService;
	
	public FruitResource() {
		fruits.add(new Fruit("Apple","Winter fruit"));
		fruits.add(new Fruit("Orange","Tropical fruit"));
	}
	
	@GET
	public List<Fruit> list(){
		return Fruit.listAll();
	}
	
	@POST
	@Transactional
	public Response add(Fruit fruit){ //using Response
		fruits.add(fruit);
		//fruitService.createFruit(fruit);
		fruit.persist();
		return Response.ok(list()).build();
	}
	
	@DELETE
	@Transactional
	public List<Fruit> delete(Fruit fruit){
//		fruits.removeIf(
//				existingFruit -> existingFruit.name.contentEquals(fruit.name)
//				);		
		Fruit.delete("id", fruit.id);
		return list();
	}
}
