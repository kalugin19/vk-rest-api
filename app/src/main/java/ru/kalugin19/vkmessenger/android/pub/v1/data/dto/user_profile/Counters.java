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

	@SuppressWarnings("unused")
	public void setAlbums(int albums){
		this.albums = albums;
	}

	@SuppressWarnings("unused")
	public int getAlbums(){
		return albums;
	}

	@SuppressWarnings("unused")
	public void setSubscriptions(int subscriptions){
		this.subscriptions = subscriptions;
	}

	@SuppressWarnings("unused")
	public int getSubscriptions(){
		return subscriptions;
	}

	@SuppressWarnings("unused")
	public void setNotes(int notes){
		this.notes = notes;
	}

	@SuppressWarnings("unused")
	public int getNotes(){
		return notes;
	}

	@SuppressWarnings("unused")
	public void setOnlineFriends(int onlineFriends){
		this.onlineFriends = onlineFriends;
	}

	@SuppressWarnings("unused")
	public int getOnlineFriends(){
		return onlineFriends;
	}

	@SuppressWarnings("unused")
	public void setGroups(int groups){
		this.groups = groups;
	}

	@SuppressWarnings("unused")
	public int getGroups(){
		return groups;
	}

	@SuppressWarnings("unused")
	public void setVideos(int videos){
		this.videos = videos;
	}

	@SuppressWarnings("unused")
	public int getVideos(){
		return videos;
	}

	@SuppressWarnings("unused")
	public void setPhotos(int photos){
		this.photos = photos;
	}

	@SuppressWarnings("unused")
	public int getPhotos(){
		return photos;
	}

	@SuppressWarnings("unused")
	public void setFriends(int friends){
		this.friends = friends;
	}

	public int getFriends(){
		return friends;
	}

	@SuppressWarnings("unused")
	public void setUserPhotos(int userPhotos){
		this.userPhotos = userPhotos;
	}

	@SuppressWarnings("unused")
	public int getUserPhotos(){
		return userPhotos;
	}

	@SuppressWarnings("unused")
	public void setFollowers(int followers){
		this.followers = followers;
	}

	public int getFollowers(){
		return followers;
	}

	@SuppressWarnings("unused")
	public void setPages(int pages){
		this.pages = pages;
	}

	@SuppressWarnings("unused")
	public int getPages(){
		return pages;
	}

	@SuppressWarnings("unused")
	public void setAudios(int audios){
		this.audios = audios;
	}

	@SuppressWarnings("unused")
	public int getAudios(){
		return audios;
	}

	@SuppressWarnings("unused")
	public void setGifts(int gifts){
		this.gifts = gifts;
	}

	@SuppressWarnings("unused")
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