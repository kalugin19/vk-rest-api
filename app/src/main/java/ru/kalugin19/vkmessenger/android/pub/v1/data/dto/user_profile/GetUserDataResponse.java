package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetUserDataResponse{

	@SerializedName("response")
	private List<ResponseItem> response;

	public void setResponse(List<ResponseItem> response){
		this.response = response;
	}

	public List<ResponseItem> getResponse(){
		return response;
	}

	@Override
 	public String toString(){
		return 
			"GetUserDataResponse{" + 
			"response = '" + response + '\'' + 
			"}";
		}
}