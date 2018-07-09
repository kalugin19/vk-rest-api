package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends;

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

	@SuppressWarnings("unused")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@SuppressWarnings("unused")
	public Integer getOnline() {
		return online;
	}

	@SuppressWarnings("unused")
	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getId() {
		return id;
	}

	@SuppressWarnings("unused")
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto100() {
		return photo100;
	}

	@SuppressWarnings("unused")
	public void setPhoto100(String photo100) {
		this.photo100 = photo100;
	}

	public String getFirstName() {
		return firstName;
	}

	@SuppressWarnings("unused")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@SuppressWarnings("unused")
	public String getDeactivated() {
		return deactivated;
	}

	@SuppressWarnings("unused")
	public void setDeactivated(String deactivated) {
		this.deactivated = deactivated;
	}

	@SuppressWarnings("unused")
	public Integer getCity() {
		return city;
	}

	@SuppressWarnings("unused")
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