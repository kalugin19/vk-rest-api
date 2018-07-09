package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

public class RelationPartner{

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SuppressWarnings("unused")
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	@SuppressWarnings("unused")
	public void setId(int id){
		this.id = id;
	}

	@SuppressWarnings("unused")
	public int getId(){
		return id;
	}

	@SuppressWarnings("unused")
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	@Override
 	public String toString(){
		return 
			"RelationPartner{" + 
			"last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",first_name = '" + firstName + '\'' + 
			"}";
		}
}