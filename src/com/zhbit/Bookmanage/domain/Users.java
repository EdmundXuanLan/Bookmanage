package com.zhbit.Bookmanage.domain;



public class Users{
	private int uid;
	private String usersname;
	private String password;


	public Users(){
	}
	
	

	public Users(String usersname, String password) {
		super();
		this.usersname = usersname;
		this.password = password;

	}


	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}
	public String getUsersname() {
		return usersname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "[用户: uid=" + uid + ", usersname=" + usersname + ", password=" + password + "]";
	}

	
}
