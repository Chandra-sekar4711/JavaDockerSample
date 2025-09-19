package com.Basic.Service;

import com.Basic.Model.OTMitem;
import com.Basic.Model.OTMitemDTO;
import com.Basic.Model.OTMorder;
import com.Basic.Model.OTMorderDTO;


public interface OTMorderitemservice {

	OTMorderDTO saveorder(OTMorderDTO sm);

	OTMorderDTO getorderdetails(Integer id);

	void deleteitembyorderid(Integer orderid, Integer itemid) throws Exception;

	void Deleteorderbyid(Integer id) throws Exception ;

	OTMorder updateorderByid(OTMorder order, Integer id)throws Exception;

	OTMorderDTO mapstructupdtaeorder(OTMorderDTO order, Integer id);

	OTMitem getitembyid(Integer id);

	
	

	



	



}
