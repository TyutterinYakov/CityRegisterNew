package city.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cr_street")
public class Street {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="street_code")
	private Long streetId;
	@Column(name="street_name", nullable=false)
	private String streetName;
	@Column(name="building", nullable=false)
	private String building;
	@Column(name="extension")
	private String extension;
	@Column(name="appartment")
	private String appartment;
	
	
	
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
	public String getAppartment() {
		return appartment;
	}
	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}
	public Long getStreetId() {
		return streetId;
	}
	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	

	
	
	
	
}
