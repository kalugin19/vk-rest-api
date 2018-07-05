package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

public class LastSeen{

	@SerializedName("time")
	private int time;

	@SerializedName("platform")
	private int platform;

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}

	public void setPlatform(int platform){
		this.platform = platform;
	}

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