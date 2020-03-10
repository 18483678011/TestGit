package ¶à¿Í»§test;

import java.io.Serializable;

public class User implements Serializable{
	private int ID;
	private String Name;
	private int  agg;
	private String info;
	private int user;
	
	public User( String Name,String info) {
	}
	
	public User() {
	}
	public User(int iD, String name, int agg, String info, int user) {
		super();
		ID = iD;
		Name = name;
		this.agg = agg;
		this.info = info;
		this.user = user;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Name=" + Name + ", agg=" + agg + ", info=" + info + ", user=" + user + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAgg() {
		return agg;
	}
	public void setAgg(int agg) {
		this.agg = agg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}

}
