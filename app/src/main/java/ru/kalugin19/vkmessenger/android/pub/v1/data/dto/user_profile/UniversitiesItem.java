package ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile;

import com.google.gson.annotations.SerializedName;

public class UniversitiesItem{

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

	public void setCountry(int country){
		this.country = country;
	}

	public int getCountry(){
		return country;
	}

	public void setFacultyName(String facultyName){
		this.facultyName = facultyName;
	}

	public String getFacultyName(){
		return facultyName;
	}

	public void setCity(int city){
		this.city = city;
	}

	public int getCity(){
		return city;
	}

	public void setGraduation(int graduation){
		this.graduation = graduation;
	}

	public int getGraduation(){
		return graduation;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEducationStatus(String educationStatus){
		this.educationStatus = educationStatus;
	}

	public String getEducationStatus(){
		return educationStatus;
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