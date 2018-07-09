package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

class UniversitiesItem{

	@SerializedName("country")
	private Integer country;

	@SerializedName("faculty_name")
	private String facultyName;

	@SerializedName("city")
	private Integer city;

	@SerializedName("graduation")
	private Integer graduation;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Integer id;

	@SerializedName("education_status")
	private String educationStatus;

	@SerializedName("education_form")
	private String educationForm;

	@SerializedName("faculty")
	private Integer faculty;

	@SuppressWarnings("unused")
	public void setCountry(int country){
		this.country = country;
	}

	@SuppressWarnings("unused")
	public int getCountry(){
		return country;
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
	public void setCity(int city){
		this.city = city;
	}

	@SuppressWarnings("unused")
	public int getCity(){
		return city;
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
	public void setName(String name){
		this.name = name;
	}

	@SuppressWarnings("unused")
	public String getName(){
		return name;
	}

	@SuppressWarnings("unused")
	public void setId(int id){
		this.id = id;
	}

	@SuppressWarnings("unused")
	public int getId(){
		return id;
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

	@Override
 	public String toString(){
		return 
			"UniversitiesItem{" + 
			"country = '" + country + '\'' + 
			",faculty_name = '" + facultyName + '\'' + 
			",city = '" + city + '\'' + 
			",graduation = '" + graduation + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",education_status = '" + educationStatus + '\'' + 
			",education_form = '" + educationForm + '\'' + 
			",faculty = '" + faculty + '\'' + 
			"}";
		}
}