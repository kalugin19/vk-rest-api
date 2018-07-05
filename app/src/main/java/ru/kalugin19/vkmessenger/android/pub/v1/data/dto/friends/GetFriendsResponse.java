package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetFriendsResponse{

	@SerializedName("response")
	private List<Friend> items;

	public void setItems(List<Friend> items){
		this.items = items;
	}

	public List<Friend> getItems(){
		return items;
	}

	@Override
	public String toString() {
		return "GetFriendsResponse{" +
				"items=" + items +
				'}';
	}
}