package com.Basic.Model;

import java.util.List;

public class OTMorderDTO {
	
	Integer orderid;
	String customername;
	String customerphno;
	String customerloc;
	List<OTMitemDTO> otmitems;
	
	public OTMorderDTO() {}

	public OTMorderDTO(Integer orderid, String customername, String customerphno, String customerloc,
			List<OTMitemDTO> otmitems) {
		super();
		this.orderid = orderid;
		this.customername = customername;
		this.customerphno = customerphno;
		this.customerloc = customerloc;
		this.otmitems = otmitems;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerphno() {
		return customerphno;
	}

	public void setCustomerphno(String customerphno) {
		this.customerphno = customerphno;
	}

	public String getCustomerloc() {
		return customerloc;
	}

	public void setCustomerloc(String customerloc) {
		this.customerloc = customerloc;
	}

	public List<OTMitemDTO> getOtmitems() {
		return otmitems;
	}

	public void setOtmitems(List<OTMitemDTO> otmitems) {
		this.otmitems = otmitems;
	}
	
	

}
