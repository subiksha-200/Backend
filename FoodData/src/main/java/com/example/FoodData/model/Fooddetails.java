package com.example.FoodData.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fooddetails {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fid;
    private String fname;
    private String hname;
    private String location;
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Fooddetails [fid=" + fid + ", fname=" + fname + ", hname=" + hname + ", location=" + location + "]";
	}
    

}
