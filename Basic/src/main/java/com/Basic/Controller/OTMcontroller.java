package com.Basic.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.Basic.Model.OTMcollege;
import com.Basic.Model.OTMuniversity;
import com.Basic.Model.OTMuniversityDTO;
import com.Basic.Model.OTOpersonModel;
import com.Basic.Repository.OTMrepository;
import com.Basic.Service.OTMservice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@RestController
@Slf4j
public class OTMcontroller {

	@Autowired
	OTMservice otmservice;
	
	@Autowired
	OTMrepository otmrepository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/OnetoMany")
    public ResponseEntity<?> Onetomany(@RequestBody OTMuniversity sm)
	{
		OTMuniversity res = otmservice.savedata(sm);
		log.info("This is an info message from Lombok!+++++++++="+res);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/OnetoManyfetch/{id}")
	public ResponseEntity<?> OnetoManyfetch(@PathVariable("id") Integer id) {
		OTMuniversity res = otmrepository.findById(id).get();
		
		OTMuniversityDTO resp = new OTMuniversityDTO();
		resp.setUniversityid(res.getUniversityid());
		resp.setUniversitylocation(res.getUniversitylocation());
		resp.setUniversityname(res.getUniversityname());
		resp.setUniversityrank(res.getUniversityrank());
		resp.setCollegename(res.getOtmcollege().stream().map(n->n.getCollegename()).collect(Collectors.toList()));
		resp.setEmpdept(res.getOtmcollege().stream().map(n->n.getOtmcollege_employee().stream().map(emp->emp.getEmpdept()).collect(Collectors.toList())).flatMap(List::stream).collect(Collectors.toList()));
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
		
		
		
		
	}
	
	
	@DeleteMapping("/OnetoManydelete/{id}")
	public ResponseEntity<String> OnetoManydelete(@PathVariable("id") Integer id) {
	    if (otmrepository.existsById(id)) {
	    	otmrepository.deleteById(id);
	        return ResponseEntity.ok("Record deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
	    }
	}
	
	
	
}
