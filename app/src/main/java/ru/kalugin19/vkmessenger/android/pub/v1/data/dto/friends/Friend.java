package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Friend {

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("online")
	private Integer online;

	@SerializedName("uid")
	private Integer id;

	@SerializedName("photo_100")
	private String photo100;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("deactivated")
	private String deactivated;

	@SerializedName("city")
	private Integer city;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto100() {
		return photo100;
	}

	public void setPhoto100(String photo100) {
		this.photo100 = photo100;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDeactivated() {
		return deactivated;
	}

	public void setDeactivated(String deactivated) {
		this.deactivated = deactivated;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Friend{" +
				"lastName='" + lastName + '\'' +
				", online=" + online +
				", id=" + id +
				", photo100='" + photo100 + '\'' +
				", firstName='" + firstName + '\'' +
				", deactivated='" + deactivated + '\'' +
				", city=" + city +
				'}';
	}
}