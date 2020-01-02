package com.uvce.ipproject.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PRODUCT")
public class product implements Serializable {

	@Id
	private int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private String pname;
	
}
