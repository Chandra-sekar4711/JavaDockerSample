package com.Basic.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Basic.Model.OTMitem;
import com.Basic.Model.OTMitemDTO;
import com.Basic.Model.OTMorder;
import com.Basic.Model.OTMorderDTO;
import com.Basic.Repository.OTMitemsrepository;
import com.Basic.Repository.OTMmapper;
import com.Basic.Repository.OTMorderrepository;
import com.Basic.Service.OTMorderitemservice;

@Service
public class OTMorderitemserviceimpl implements OTMorderitemservice{

	@Autowired
	OTMorderrepository otmorderrepository;
    @Autowired
    OTMitemsrepository otmitemrepository;

    @Autowired
    OTMmapper mapper;
    
    @Override
	public OTMorderDTO saveorder(OTMorderDTO sm1) {
    	OTMorder sm = mapper.toEntity(sm1);
        for (OTMitem item : sm.getOtmitems()) {
            item.setOtmorder(sm); 
        }
        
        OTMorder res = otmorderrepository.save(sm);
        return mapper.toDto(res);
	}

	

	@Override
	public OTMorderDTO getorderdetails(Integer id) {
		  if (id != null) {
		        Optional<OTMorder> otmorder = otmorderrepository.findById(id);
		        OTMorder res = otmorder.get();
		        if (otmorder.isPresent()) {
		        	OTMorderDTO res1= mapper.toDto(res);
		            return res1;
		        } else {
		            return null; // or throw a custom exception
		        }
		    }
		    return null;
	}
	

	@Override
	public void Deleteorderbyid(Integer id) throws Exception {
		OTMorder obj = otmorderrepository.findById(id).orElseThrow(()-> new Exception("NULL"));
		if(obj!=null) {
		otmorderrepository.deleteById(id);
		}
		else {
			throw new Exception("Order id doesnt exist");}
	}

	@Override
	public void deleteitembyorderid(Integer orderid, Integer itemcode) throws Exception {
	   boolean b= false;
		OTMorder obj  = otmorderrepository.findById(orderid).orElseThrow(()->new RuntimeException("NULL"));
		
			List<OTMitem> otmitems = obj.getOtmitems();	
			for(OTMitem obj1:otmitems)
			{
			if(obj1.getItemcode()==itemcode)	{
			    b=true;
			    
//			    otmitemrepository.deleteById(9);
			    otmitems.remove(obj1);
			    otmorderrepository.save(obj);

			    break;
			}}
			if(b==false)
			{
			 throw new Exception("Item id not found");	
			}
			
	}


	@Override
	public OTMorder updateorderByid(OTMorder order, Integer id) throws Exception {
		OTMorder obj = otmorderrepository.findById(id).orElseThrow(()-> new Exception("NULL"));
		
		//This works but if we hav 100 line item means we can get and set it it time consuming and memeoy wastage so we go for DTO and mapper
		
		if(order.getCustomerloc()!=null)
		obj.setCustomerloc(order.getCustomerloc());
		if(order.getCustomername()!=null)
		obj.setCustomername(order.getCustomername());
		if(order.getCustomerphno()!=null)
		obj.setCustomerphno(order.getCustomerphno());
	
		return otmorderrepository.save(obj);
		
		
	}

	@Override
	public OTMorderDTO mapstructupdtaeorder(OTMorderDTO obj1, Integer id) {
		
		OTMorder order =mapper.toEntity(obj1);

		OTMorder obj = otmorderrepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		    if (order.getCustomername() != null) {
		    obj.setCustomername(order.getCustomername());
		    }
		    if (order.getCustomerphno() != null) {
		    obj.setCustomerphno(order.getCustomerphno());}
		    if (order.getCustomerloc() != null) {
		    obj.setCustomerloc(order.getCustomerloc());}

		   
		    for (OTMitem dtoItem : order.getOtmitems()) {
		       for (OTMitem entityItem : obj.getOtmitems()) {
		                if (dtoItem.getItemid().equals(entityItem.getItemid())) {
		                    entityItem.setItemcode(dtoItem.getItemcode());
		                    entityItem.setItemname(dtoItem.getItemname());
		                    entityItem.setItemprice(dtoItem.getItemprice());
		                    entityItem.setItemtype(dtoItem.getItemtype());
		                    break; 
		                }
		            
		        }
		    }

		    OTMorder updatedOrder = otmorderrepository.save(obj);
		   OTMorderDTO res =  mapper.toDto(updatedOrder);
		    return res;
	}



	@Override
	public OTMitem getitembyid(Integer id) {
		OTMitem res =otmitemrepository.findById(id).get();
		OTMorder otmorder = new OTMorder();
		otmorder.setOrderid(res.getOtmorder().getOrderid());
		otmorder.setCustomerloc(res.getOtmorder().getCustomerloc());
		otmorder.setCustomername(res.getOtmorder().getCustomername());
		otmorder.setCustomerphno(res.getOtmorder().getCustomerphno());
		res.setOtmorder(otmorder);
		
		return res;
	}






	


	


	







	


}
