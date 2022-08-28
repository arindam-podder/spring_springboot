package com.rest.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Actor;
import com.rest.service.ActorService;

@RestController
@RequestMapping(path = "/api/actor")
public class ActorController {

	private static final Logger logger = LoggerFactory.getLogger(ActorController.class);
	
	@Autowired
	private ActorService actorService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> saveActor(@RequestBody Actor actor){
		try {
			Actor saveActor = actorService.saveActor(actor);
			return new ResponseEntity<>(saveActor,HttpStatus.OK);
		}catch(Exception exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<>(exception.getMessage() , HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<?> getAllActor(){
		try {
			return new ResponseEntity<>( actorService.getAllActors() , HttpStatus.OK );
		}catch(Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public  ResponseEntity<?> deleteActor(@PathVariable Integer id){
		try {
			actorService.deleteActor(id);
			return new ResponseEntity<>("actor with the id="+id+", deleted successfully.", HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}//class end





