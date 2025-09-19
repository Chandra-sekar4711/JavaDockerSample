package com.Basic.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OTMitem {
	
	@Id
	@Column(name="itemid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer itemid;
	
	@Column(name="itemcode")
	int itemcode;
	
	@Column(name="itemname")
	String itemname;
	
	@Column(name="itemprice")
	String itemprice;
	
	@Column(name="itemtype")
	String itemtype;
	
	@ManyToOne
	
	@JoinColumn(name="orderitem_fk")
	OTMorder otmorder;

	public OTMitem() {}

	public OTMitem(Integer itemid, int itemcode, String itemname, String itemprice, String itemtype,
			OTMorder otmorder) {
		super();
		this.itemid = itemid;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.itemtype = itemtype;
		this.otmorder = otmorder;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public int getItemcode() {
		return itemcode;
	}

	public void setItemcode(int itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemprice() {
		return itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public OTMorder getOtmorder() {
		return otmorder;
	}

	public void setOtmorder(OTMorder otmorder) {
		this.otmorder = otmorder;
	}

	@Override
	public String toString() {
		return "OTMitem [itemid=" + itemid + ", itemcode=" + itemcode + ", itemname=" + itemname + ", itemprice="
				+ itemprice + ", itemtype=" + itemtype + ", otmorder=" + otmorder + "]";
	}
	
	

}
