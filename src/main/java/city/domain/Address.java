package city.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cr_address")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private Long addressId;
	@Column(name="start_date", nullable=false)
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Column(name="temporal", nullable=false)
	private boolean temporal;
    @ManyToMany (cascade = {
            CascadeType.PERSIST,
                    CascadeType.MERGE
        })
        @JoinTable(name = "address_person",
                joinColumns = @JoinColumn(name = "address_id"),
                inverseJoinColumns = @JoinColumn(name = "person_id")
        )
    private List<Person> persons;
    @ManyToMany (cascade = {
            CascadeType.PERSIST,
                    CascadeType.MERGE
        })
        @JoinTable(name = "address_street",
                joinColumns = @JoinColumn(name = "address_id"),
                inverseJoinColumns = @JoinColumn(name = "street_code")
        )
    private List<Street> streets;
    
    
    
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public boolean isTemporal() {
		return temporal;
	}
	public void setTemporal(boolean temporal) {
		this.temporal = temporal;
	}
	
	
}
