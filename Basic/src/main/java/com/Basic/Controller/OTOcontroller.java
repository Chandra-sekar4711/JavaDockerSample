package com.Basic.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Basic.Model.OTOpersonModel;
import com.Basic.Repository.OTOrepository;
import com.Basic.Service.OTOservice;
 
//import com.crud1.Serviceimpl.Employeeserviceimpl;

@RestController
public class OTOcontroller {
	
	@Autowired
	OTOservice otoservice;
	
	@Autowired
	OTOrepository otorepository;
	
	/*@Autowired*/
	//Employeeserviceimpl empservice;
	
	
	@GetMapping("/Testapi1depcheck")
	public ResponseEntity<String> Testapi1depcheck()
	{
		return ResponseEntity.status(HttpStatus.OK).body("Triggerred");
	}
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/OnetoOne")

	public ResponseEntity<OTOpersonModel> Onetomany(@RequestBody OTOpersonModel sm)
	{
		System.out.println("**********************One to one hittedd********************************");
		OTOpersonModel res = otoservice.save_data(sm);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/OnetOnefetch/{id}")
	public ResponseEntity<OTOpersonModel> OnetOnefetch(@PathVariable("id") Integer id) {
		Optional<OTOpersonModel> res = otorepository.findById(id);
		
		return new ResponseEntity<>(res.get(), HttpStatus.CREATED);
		
		
	}
	
	
	@DeleteMapping("/OnetOnedelete/{id}")
	public ResponseEntity<String> OnetOnedelete(@PathVariable("id") Integer id) {
	    if (otorepository.existsById(id)) {
	        otorepository.deleteById(id);
	        return ResponseEntity.ok("Record deleted successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
	    }
	}

	
	
	
}
