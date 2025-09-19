package com.Basic.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OTMorder {
	
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderid;
	
	@Column(name="customername")
	String customername;
	
	@Column(name="customerphno")
	String customerphno;
	
	@Column(name="customerloc")
	String customerloc;
	
	@Column(name="otmitems")
	
	
	@OneToMany(mappedBy = "otmorder", cascade = CascadeType.ALL,orphanRemoval = true)
	List<OTMitem> otmitems = new ArrayList<OTMitem>();
	
	
	public void additem(OTMitem items) {
	otmitems.add(items);
	items.setOtmorder(this);
		
	}

	public OTMorder() {}

	public OTMorder(Integer orderid, String customername, String customerphno, String customerloc,
			List<OTMitem> otmitems) {
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

	public List<OTMitem> getOtmitems() {
		return otmitems;
	}

	public void setOtmitems(List<OTMitem> otmitems) {
		this.otmitems = otmitems;
	}

	@Override
	public String toString() {
		return "OTMorder [orderid=" + orderid + ", customername=" + customername + ", customerphno=" + customerphno
				+ ", customerloc=" + customerloc + ", otmitems=" + otmitems + "]";
	}

	

	
	
	

}
