package com.axis.springbootdemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.springbootdemo.entity.Cricketer;

@RestController
public class CricketerController {
	
	private static ArrayList<Cricketer> cricList;
	
	static {
		cricList = new ArrayList<>();
		cricList.add(new Cricketer(1001, "Virat Kohli", 82, 53, 4, 6, 170.2));
		cricList.add(new Cricketer(1002, "Suryakumar Yadav", 111, 51, 6, 7, 217.1));
		cricList.add(new Cricketer(1003, "KL Rahul", 54, 25, 2, 3, 220.7));
		cricList.add(new Cricketer(1004, "Sachin Tendulkar", 62, 58, 7, 1, 125.4));
		cricList.add(new Cricketer(1005, "Virender Sehwag", 72, 53, 9, 3, 150));
	}
	
	@GetMapping("/message")
	public String getMessage() {
		return "Hello This is my First SpringBoot Appliaction ...";
	}
	
	@GetMapping("/message2")
	public String getMessage2() {
		return "This is message 2";
	}
	
//	@GetMapping("/cricketer")
//	public Cricketer getCricketer() {
//		return new Cricketer(1001, "Virat Kohli", 82, 53, 4, 6, 170.2);
//	}
	// Get all cricketer's List..
	@GetMapping("/cricketers")
	public ArrayList<Cricketer> getCricketers(){
		return cricList;
	}
	
	//Get cricketer by ID...
	@GetMapping("/cricketer/{cricketerId}") //{} -> used to define path-variable
 	public Cricketer getCricketerById(@PathVariable int cricketerId) { //using @PathVariable parameter can be defined as path var...	
		for(Cricketer cric : cricList) {
			if(cric.getCrickerterId() == cricketerId) {
				return cric;
			}
		}
		return null;
	}
	
	
	@PostMapping("/cricketers")
	public ResponseEntity<String> addCrickter(@RequestBody Cricketer cricketer) {
		cricList.add(cricketer);
		return new ResponseEntity<>("New Cricketer Added...", HttpStatus.OK);
	}
	
	//Update Mapping
	@PutMapping("/cricketer/update/{cricketerId}")
	public ResponseEntity<String> updateCricketer(@PathVariable int cricketerId, @RequestBody Cricketer updatedCricketer){
		if(cricketerId!=updatedCricketer.getCrickerterId()) {
			return new ResponseEntity<String>("Cricketer id's do not match!!!", HttpStatus.BAD_REQUEST);
		}
		int index = cricList.indexOf(updatedCricketer);
		if(index==-1) {
			return new ResponseEntity<String>("Cricketer ID with " +cricketerId +"NOT FOUND !!!", HttpStatus.NOT_FOUND);
		}else {
			cricList.get(index).setBallsFaced(updatedCricketer.getBallsFaced());
			cricList.get(index).setRunScored(updatedCricketer.getRunScored());
			cricList.get(index).setFours(updatedCricketer.getFours());
			cricList.get(index).setSixes(updatedCricketer.getSixes());
			cricList.get(index).setStrikeRate(updatedCricketer.getStrikeRate());
			return new ResponseEntity<String>("Cricketer Data Updated Successfully", HttpStatus.OK);
		}		
	}
	
	//Delete Mapping
	@DeleteMapping("/cricketer/delete/{cricketerId}")
	public ResponseEntity<String> deleteCricketer(@PathVariable int cricketerId){
		Cricketer cricketer = getCricketerById(cricketerId);
		if(cricketer==null) {
			return new ResponseEntity<String>("Cricketer with ID "+cricketerId+" Not found!!!", HttpStatus.NOT_FOUND);
		}else {
			cricList.remove(cricketer);
			return new ResponseEntity<String>("Cricketer with ID "+cricketerId+" Found!!!", HttpStatus.OK);
		}
	}
	
}
