package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

public class LastSeen{

	@SerializedName("time")
	private int time;

	@SerializedName("platform")
	private int platform;

	@SuppressWarnings("unused")
	public void setTime(int time){
		this.time = time;
	}

	@SuppressWarnings("unused")
	public int getTime(){
		return time;
	}

	@SuppressWarnings("unused")
	public void setPlatform(int platform){
		this.platform = platform;
	}

	@SuppressWarnings("unused")
	public int getPlatform(){
		return platform;
	}

	@Override
 	public String toString(){
		return 
			"LastSeen{" + 
			"time = '" + time + '\'' + 
			",platform = '" + platform + '\'' + 
			"}";
		}
}