package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProfileDto {

	@SerializedName("country")
	private int country;

	@SerializedName("has_mobile")
	private int hasMobile;

	@SerializedName("bdate")
	private String bdate;

	@SerializedName("photo_50")
	private String photo50;

	@SerializedName("last_seen")
	private LastSeen lastSeen;

	@SerializedName("city")
	private int city;

	@SerializedName("timezone")
	private int timezone;

	@SerializedName("university")
	private int university;

	@SerializedName("education_form")
	private String educationForm;

	@SerializedName("faculty")
	private int faculty;

	@SerializedName("relation")
	private int relation;

	@SerializedName("uid")
	private int uid;

	@SerializedName("faculty_name")
	private String facultyName;

	@SerializedName("relation_partner")
	private RelationPartner relationPartner;

	@SerializedName("universities")
	private List<UniversitiesItem> universities;

	@SerializedName("graduation")
	private int graduation;

	@SerializedName("mobile_phone")
	private String mobilePhone;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("can_post")
	private int canPost;

	@SerializedName("can_see_all_posts")
	private int canSeeAllPosts;

	@SerializedName("photo_100")
	private String photo100;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("home_phone")
	private String homePhone;

	@SerializedName("counters")
	private Counters counters;

	@SerializedName("sex")
	private int sex;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("university_name")
	private String universityName;

	@SerializedName("education_status")
	private String educationStatus;

	@SerializedName("can_write_private_message")
	private int canWritePrivateMessage;

	@SerializedName("domain")
	private String domain;

	@SerializedName("online")
	private int online;

	@SerializedName("photo_200_orig")
	private String photo200Orig;

	@SerializedName("status")
	private String status;

	@SuppressWarnings("unused")
	public void setCountry(int country){
		this.country = country;
	}

	@SuppressWarnings("unused")
	public int getCountry(){
		return country;
	}

	@SuppressWarnings("unused")
	public void setHasMobile(int hasMobile){
		this.hasMobile = hasMobile;
	}

	@SuppressWarnings("unused")
	public int getHasMobile(){
		return hasMobile;
	}

	@SuppressWarnings("unused")
	public void setBdate(String bdate){
		this.bdate = bdate;
	}

	public String getBdate(){
		return bdate;
	}

	@SuppressWarnings("unused")
	public void setPhoto50(String photo50){
		this.photo50 = photo50;
	}

	@SuppressWarnings("unused")
	public String getPhoto50(){
		return photo50;
	}

	@SuppressWarnings("unused")
	public void setLastSeen(LastSeen lastSeen){
		this.lastSeen = lastSeen;
	}

	@SuppressWarnings("unused")
	public LastSeen getLastSeen(){
		return lastSeen;
	}

	@SuppressWarnings("unused")
	public void setCity(int city){
		this.city = city;
	}

	@SuppressWarnings("unused")
	public int getCity(){
		return city;
	}

	@SuppressWarnings("unused")
	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	@SuppressWarnings("unused")
	public int getTimezone(){
		return timezone;
	}

	@SuppressWarnings("unused")
	public void setUniversity(int university){
		this.university = university;
	}

	@SuppressWarnings("unused")
	public int getUniversity(){
		return university;
	}

	@SuppressWarnings("unused")
	public void setEducationForm(String educationForm){
		this.educationForm = educationForm;
	}

	@SuppressWarnings("unused")
	public String getEducationForm(){
		return educationForm;
	}

	@SuppressWarnings("unused")
	public void setFaculty(int faculty){
		this.faculty = faculty;
	}

	@SuppressWarnings("unused")
	public int getFaculty(){
		return faculty;
	}

	@SuppressWarnings("unused")
	public void setRelation(int relation){
		this.relation = relation;
	}

	@SuppressWarnings("unused")
	public int getRelation(){
		return relation;
	}

	@SuppressWarnings("unused")
	public void setUid(int uid){
		this.uid = uid;
	}

	@SuppressWarnings("unused")
	public int getUid(){
		return uid;
	}

	@SuppressWarnings("unused")
	public void setFacultyName(String facultyName){
		this.facultyName = facultyName;
	}

	@SuppressWarnings("unused")
	public String getFacultyName(){
		return facultyName;
	}

	@SuppressWarnings("unused")
	public void setRelationPartner(RelationPartner relationPartner){
		this.relationPartner = relationPartner;
	}

	public RelationPartner getRelationPartner(){
		return relationPartner;
	}

	@SuppressWarnings("unused")
	public void setUniversities(List<UniversitiesItem> universities){
		this.universities = universities;
	}

	@SuppressWarnings("unused")
	public List<UniversitiesItem> getUniversities(){
		return universities;
	}

	@SuppressWarnings("unused")
	public void setGraduation(int graduation){
		this.graduation = graduation;
	}

	@SuppressWarnings("unused")
	public int getGraduation(){
		return graduation;
	}

	@SuppressWarnings("unused")
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}

	@SuppressWarnings("unused")
	public String getMobilePhone(){
		return mobilePhone;
	}

	@SuppressWarnings("unused")
	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	@SuppressWarnings("unused")
	public String getNickname(){
		return nickname;
	}

	@SuppressWarnings("unused")
	public void setCanPost(int canPost){
		this.canPost = canPost;
	}

	@SuppressWarnings("unused")
	public int getCanPost(){
		return canPost;
	}

	@SuppressWarnings("unused")
	public void setCanSeeAllPosts(int canSeeAllPosts){
		this.canSeeAllPosts = canSeeAllPosts;
	}

	@SuppressWarnings("unused")
	public int getCanSeeAllPosts(){
		return canSeeAllPosts;
	}

	@SuppressWarnings("unused")
	public void setPhoto100(String photo100){
		this.photo100 = photo100;
	}

	public String getPhoto100(){
		return photo100;
	}

	@SuppressWarnings("unused")
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	@SuppressWarnings("unused")
	public void setHomePhone(String homePhone){
		this.homePhone = homePhone;
	}

	@SuppressWarnings("unused")
	public String getHomePhone(){
		return homePhone;
	}

	@SuppressWarnings("unused")
	public void setCounters(Counters counters){
		this.counters = counters;
	}

	public Counters getCounters(){
		return counters;
	}

	@SuppressWarnings("unused")
	public void setSex(int sex){
		this.sex = sex;
	}

	@SuppressWarnings("unused")
	public int getSex(){
		return sex;
	}

	@SuppressWarnings("unused")
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	@SuppressWarnings("unused")
	public void setUniversityName(String universityName){
		this.universityName = universityName;
	}

	public String getUniversityName(){
		return universityName;
	}

	@SuppressWarnings("unused")
	public void setEducationStatus(String educationStatus){
		this.educationStatus = educationStatus;
	}

	@SuppressWarnings("unused")
	public String getEducationStatus(){
		return educationStatus;
	}

	@SuppressWarnings("unused")
	public void setCanWritePrivateMessage(int canWritePrivateMessage){
		this.canWritePrivateMessage = canWritePrivateMessage;
	}

	@SuppressWarnings("unused")
	public int getCanWritePrivateMessage(){
		return canWritePrivateMessage;
	}

	@SuppressWarnings("unused")
	public void setDomain(String domain){
		this.domain = domain;
	}

	@SuppressWarnings("unused")
	public String getDomain(){
		return domain;
	}

	@SuppressWarnings("unused")
	public void setOnline(int online){
		this.online = online;
	}

	@SuppressWarnings("unused")
	public int getOnline(){
		return online;
	}

	@SuppressWarnings("unused")
	public void setPhoto200Orig(String photo200Orig){
		this.photo200Orig = photo200Orig;
	}

	@SuppressWarnings("unused")
	public String getPhoto200Orig(){
		return photo200Orig;
	}

	@SuppressWarnings("unused")
	public void setStatus(String status){
		this.status = status;
	}

	@SuppressWarnings("unused")
	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ProfileDto{" +
			"country = '" + country + '\'' + 
			",has_mobile = '" + hasMobile + '\'' + 
			",bdate = '" + bdate + '\'' + 
			",photo_50 = '" + photo50 + '\'' + 
			",last_seen = '" + lastSeen + '\'' + 
			",city = '" + city + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",university = '" + university + '\'' + 
			",education_form = '" + educationForm + '\'' + 
			",faculty = '" + faculty + '\'' + 
			",relation = '" + relation + '\'' + 
			",uid = '" + uid + '\'' + 
			",faculty_name = '" + facultyName + '\'' + 
			",relation_partner = '" + relationPartner + '\'' + 
			",universities = '" + universities + '\'' + 
			",graduation = '" + graduation + '\'' + 
			",mobile_phone = '" + mobilePhone + '\'' + 
			",nickname = '" + nickname + '\'' + 
			",can_post = '" + canPost + '\'' + 
			",can_see_all_posts = '" + canSeeAllPosts + '\'' + 
			",photo_100 = '" + photo100 + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",home_phone = '" + homePhone + '\'' + 
			",counters = '" + counters + '\'' + 
			",sex = '" + sex + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",university_name = '" + universityName + '\'' + 
			",education_status = '" + educationStatus + '\'' + 
			",can_write_private_message = '" + canWritePrivateMessage + '\'' + 
			",domain = '" + domain + '\'' + 
			",online = '" + online + '\'' + 
			",photo_200_orig = '" + photo200Orig + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}