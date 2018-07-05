package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

public class Counters{

	@SerializedName("albums")
	private int albums;

	@SerializedName("subscriptions")
	private int subscriptions;

	@SerializedName("notes")
	private int notes;

	@SerializedName("online_friends")
	private int onlineFriends;

	@SerializedName("groups")
	private int groups;

	@SerializedName("videos")
	private int videos;

	@SerializedName("photos")
	private int photos;

	@SerializedName("friends")
	private int friends;

	@SerializedName("user_photos")
	private int userPhotos;

	@SerializedName("followers")
	private int followers;

	@SerializedName("pages")
	private int pages;

	@SerializedName("audios")
	private int audios;

	@SerializedName("gifts")
	private int gifts;

	public void setAlbums(int albums){
		this.albums = albums;
	}

	public int getAlbums(){
		return albums;
	}

	public void setSubscriptions(int subscriptions){
		this.subscriptions = subscriptions;
	}

	public int getSubscriptions(){
		return subscriptions;
	}

	public void setNotes(int notes){
		this.notes = notes;
	}

	public int getNotes(){
		return notes;
	}

	public void setOnlineFriends(int onlineFriends){
		this.onlineFriends = onlineFriends;
	}

	public int getOnlineFriends(){
		return onlineFriends;
	}

	public void setGroups(int groups){
		this.groups = groups;
	}

	public int getGroups(){
		return groups;
	}

	public void setVideos(int videos){
		this.videos = videos;
	}

	public int getVideos(){
		return videos;
	}

	public void setPhotos(int photos){
		this.photos = photos;
	}

	public int getPhotos(){
		return photos;
	}

	public void setFriends(int friends){
		this.friends = friends;
	}

	public int getFriends(){
		return friends;
	}

	public void setUserPhotos(int userPhotos){
		this.userPhotos = userPhotos;
	}

	public int getUserPhotos(){
		return userPhotos;
	}

	public void setFollowers(int followers){
		this.followers = followers;
	}

	public int getFollowers(){
		return followers;
	}

	public void setPages(int pages){
		this.pages = pages;
	}

	public int getPages(){
		return pages;
	}

	public void setAudios(int audios){
		this.audios = audios;
	}

	public int getAudios(){
		return audios;
	}

	public void setGifts(int gifts){
		this.gifts = gifts;
	}

	public int getGifts(){
		return gifts;
	}

	@Override
 	public String toString(){
		return 
			"Counters{" + 
			"albums = '" + albums + '\'' + 
			",subscriptions = '" + subscriptions + '\'' + 
			",notes = '" + notes + '\'' + 
			",online_friends = '" + onlineFriends + '\'' + 
			",groups = '" + groups + '\'' + 
			",videos = '" + videos + '\'' + 
			",photos = '" + photos + '\'' + 
			",friends = '" + friends + '\'' + 
			",user_photos = '" + userPhotos + '\'' + 
			",followers = '" + followers + '\'' + 
			",pages = '" + pages + '\'' + 
			",audios = '" + audios + '\'' + 
			",gifts = '" + gifts + '\'' + 
			"}";
		}
}