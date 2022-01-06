package city.view;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import city.util.LocalDateStringConverter;
import city.util.StringLocalDateConverter;


public class PersonRequest {
	
	
	private String surName;
	private String givenName;
	private String patronymic;
	@JsonSerialize(converter = LocalDateStringConverter.class)
	@JsonDeserialize(converter = StringLocalDateConverter.class)
	private LocalDate dateOfBirth;
	private Integer streetCode;
	private String building;
	private String extension;
	private String apartment;
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public Integer getStreetCode() {
		return streetCode;
	}
	public void setStreetCode(Integer streetCode) {
		this.streetCode = streetCode;
	}
	
	@Override
	public String toString() {
		return surName+" "+givenName+" "+patronymic+" "+dateOfBirth+" "+streetCode+" "+
				building+" "+extension+" "+apartment;
	}
	
	
	
}
