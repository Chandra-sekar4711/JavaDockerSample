package com.Basic.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.Basic.Model.OTMitem;
import com.Basic.Model.OTMitemDTO;
import com.Basic.Model.OTMorder;
import com.Basic.Model.OTMorderDTO;
import com.Basic.Model.OTMuniversity;
import com.Basic.Repository.OTMitemsrepository;
import com.Basic.Service.OTMorderitemservice;

@RestController
public class OTMorderitemcontroller {
	
	
	
	@Autowired
	OTMitemsrepository itemrepo;
	
	@Autowired
	OTMorderitemservice otmorderservice;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/create_orderitem")

	public ResponseEntity<OTMorderDTO> Onetomany(@RequestBody OTMorderDTO sm)
	{
		OTMorderDTO res = otmorderservice.saveorder(sm);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getorder/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") Integer id) {
	    OTMorderDTO order = otmorderservice.getorderdetails(id);
	    
	    
	    if (order != null) {
	        return new ResponseEntity<>(order, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Order with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("/deleteorder")
	public ResponseEntity<String> Deleteorderbyid(@RequestParam("id") Integer id)	
	{
		try {
	    otmorderservice.Deleteorderbyid(id);
	    return new ResponseEntity<String>(id+" is deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			if("Order id doesnt exist".equals(e.getMessage()))
				return new ResponseEntity<String>(id+"is not present",HttpStatus.NOT_FOUND);
			else
			return new ResponseEntity<String>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@DeleteMapping("/deleteitembyorderid/{orderid}/{itemid}")
	public ResponseEntity<String> deleteitembyorderid(@PathVariable("orderid") Integer orderid,@PathVariable("itemid") Integer itemid)	
	{
		try {
		otmorderservice.deleteitembyorderid(orderid,itemid);
		return new ResponseEntity<String>("Item is deleted successfull",HttpStatus.OK);
		}
		catch(Exception e)
		{
			if(e.getMessage().equals("order id not found"))
			{
				return new ResponseEntity<String>("Order id not found",HttpStatus.NOT_FOUND);
			}
			else if(e.getMessage().equals("Item id not found"))
			{
				return new ResponseEntity<String>("Item id not found",HttpStatus.NOT_FOUND);
			}
			else {
	            return new ResponseEntity<>("Something went wrong: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		}}
	
	//update order using normal getter and setter
	@PutMapping("/updtaeorder/{id}")
	public ResponseEntity<?> updtaeorder(@RequestBody OTMorder order,@PathVariable("id") Integer id)
	{
		try {
		OTMorder obj = otmorderservice.updateorderByid(order,id);
		return new ResponseEntity<OTMorder>(obj,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Exception occurs",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update order using Mapstrct
	@PutMapping("/mapstructupdtaeorder/{id}")
	public ResponseEntity<?> mapstructupdtaeorder(@RequestBody OTMorderDTO order,@PathVariable("id") Integer id)
	{
	try {
		OTMorderDTO obj = otmorderservice.mapstructupdtaeorder(order,id);
		return new ResponseEntity<OTMorderDTO>(obj,HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>("Exception occurs",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	}
	
	@GetMapping("/getitem/{id}")
	public ResponseEntity<?> getitem(@PathVariable("id") Integer id) {
	             OTMitem res = otmorderservice.getitembyid(id);
	    
	    if (res != null) {
	        return new ResponseEntity<>(res, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Order with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}
	
	
}
