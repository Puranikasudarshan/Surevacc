package com.uvce.ipproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "COMPLAINT")
public class complaint implements Serializable {

	@Id
	private String pname;
	private  String reason;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
