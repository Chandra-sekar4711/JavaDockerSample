package com.Basic.Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "iid", "icode", "iname", "iprice", "itype" })
public class OTMitemDTO {

	Integer Iid;
	int Icode;
	String Iname;
	String Iprice;
	String Itype;
	
	public OTMitemDTO() {}

	public OTMitemDTO(Integer iid, int icode, String iname, String iprice, String itype) {
		super();
		Iid = iid;
		Icode = icode;
		Iname = iname;
		Iprice = iprice;
		Itype = itype;
	}

	public Integer getIid() {
		return Iid;
	}

	public void setIid(Integer iid) {
		Iid = iid;
	}

	public int getIcode() {
		return Icode;
	}

	public void setIcode(int icode) {
		Icode = icode;
	}

	public String getIname() {
		return Iname;
	}

	public void setIname(String iname) {
		Iname = iname;
	}

	public String getIprice() {
		return Iprice;
	}

	public void setIprice(String iprice) {
		Iprice = iprice;
	}

	public String getItype() {
		return Itype;
	}

	public void setItype(String itype) {
		Itype = itype;
	}
	
	
}
