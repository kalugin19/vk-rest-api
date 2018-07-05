package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseItem{

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

	public void setCountry(int country){
		this.country = country;
	}

	public int getCountry(){
		return country;
	}

	public void setHasMobile(int hasMobile){
		this.hasMobile = hasMobile;
	}

	public int getHasMobile(){
		return hasMobile;
	}

	public void setBdate(String bdate){
		this.bdate = bdate;
	}

	public String getBdate(){
		return bdate;
	}

	public void setPhoto50(String photo50){
		this.photo50 = photo50;
	}

	public String getPhoto50(){
		return photo50;
	}

	public void setLastSeen(LastSeen lastSeen){
		this.lastSeen = lastSeen;
	}

	public LastSeen getLastSeen(){
		return lastSeen;
	}

	public void setCity(int city){
		this.city = city;
	}

	public int getCity(){
		return city;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public int getTimezone(){
		return timezone;
	}

	public void setUniversity(int university){
		this.university = university;
	}

	public int getUniversity(){
		return university;
	}

	public void setEducationForm(String educationForm){
		this.educationForm = educationForm;
	}

	public String getEducationForm(){
		return educationForm;
	}

	public void setFaculty(int faculty){
		this.faculty = faculty;
	}

	public int getFaculty(){
		return faculty;
	}

	public void setRelation(int relation){
		this.relation = relation;
	}

	public int getRelation(){
		return relation;
	}

	public void setUid(int uid){
		this.uid = uid;
	}

	public int getUid(){
		return uid;
	}

	public void setFacultyName(String facultyName){
		this.facultyName = facultyName;
	}

	public String getFacultyName(){
		return facultyName;
	}

	public void setRelationPartner(RelationPartner relationPartner){
		this.relationPartner = relationPartner;
	}

	public RelationPartner getRelationPartner(){
		return relationPartner;
	}

	public void setUniversities(List<UniversitiesItem> universities){
		this.universities = universities;
	}

	public List<UniversitiesItem> getUniversities(){
		return universities;
	}

	public void setGraduation(int graduation){
		this.graduation = graduation;
	}

	public int getGraduation(){
		return graduation;
	}

	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone(){
		return mobilePhone;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setCanPost(int canPost){
		this.canPost = canPost;
	}

	public int getCanPost(){
		return canPost;
	}

	public void setCanSeeAllPosts(int canSeeAllPosts){
		this.canSeeAllPosts = canSeeAllPosts;
	}

	public int getCanSeeAllPosts(){
		return canSeeAllPosts;
	}

	public void setPhoto100(String photo100){
		this.photo100 = photo100;
	}

	public String getPhoto100(){
		return photo100;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setHomePhone(String homePhone){
		this.homePhone = homePhone;
	}

	public String getHomePhone(){
		return homePhone;
	}

	public void setCounters(Counters counters){
		this.counters = counters;
	}

	public Counters getCounters(){
		return counters;
	}

	public void setSex(int sex){
		this.sex = sex;
	}

	public int getSex(){
		return sex;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setUniversityName(String universityName){
		this.universityName = universityName;
	}

	public String getUniversityName(){
		return universityName;
	}

	public void setEducationStatus(String educationStatus){
		this.educationStatus = educationStatus;
	}

	public String getEducationStatus(){
		return educationStatus;
	}

	public void setCanWritePrivateMessage(int canWritePrivateMessage){
		this.canWritePrivateMessage = canWritePrivateMessage;
	}

	public int getCanWritePrivateMessage(){
		return canWritePrivateMessage;
	}

	public void setDomain(String domain){
		this.domain = domain;
	}

	public String getDomain(){
		return domain;
	}

	public void setOnline(int online){
		this.online = online;
	}

	public int getOnline(){
		return online;
	}

	public void setPhoto200Orig(String photo200Orig){
		this.photo200Orig = photo200Orig;
	}

	public String getPhoto200Orig(){
		return photo200Orig;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
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