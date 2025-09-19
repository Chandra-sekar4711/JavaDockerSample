package com.Basic.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.Basic.Model.OTMcollege;
import com.Basic.Model.OTMcollege_employee;
import com.Basic.Model.OTMuniversity;
import com.Basic.Repository.OTMrepository;
import com.Basic.Service.OTMservice;


@Service
public class OTMserviceimpl implements OTMservice {

	@Autowired
	OTMrepository otmrpository;
	
	@Override
	public OTMuniversity savedata(OTMuniversity sm) {
//		System.out.println("sm-->"+""+sm);
	    if (sm.getOtmcollege() != null) {
	        List<OTMcollege> collegeList = new ArrayList<>(sm.getOtmcollege());
	        sm.getOtmcollege().clear();
	        for (OTMcollege college : collegeList) {
	        	 if (college.getOtmcollege_employee() != null) {
	                 for (OTMcollege_employee employee : college.getOtmcollege_employee()) {
	                	
	                     employee.setOtmcollege(college);  // Ensure FK is set in OTMcollege_employee
	                 }
	             }
	            sm.addCollege(college);
	            
	        }
	    }
	    OTMuniversity savedUniversity = otmrpository.save(sm);
	    System.out.println("Saved University: " + savedUniversity);
	    return savedUniversity;
	}
}
