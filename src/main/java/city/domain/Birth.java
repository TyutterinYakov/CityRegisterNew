package city.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cr_birth")
public class Birth {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="birth_id")
	private Long birthId;
	@Column(name="birth_number", nullable=false)
	private String birthNumber;
	@Column(name="birth_certificate_date", nullable=false)
	private LocalDate birthCertificateDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	public Long getBirthId() {
		return birthId;
	}
	public void setBirthId(Long birthId) {
		this.birthId = birthId;
	}
	public String getBirthNumber() {
		return birthNumber;
	}
	public void setBirthNumber(String birthNumber) {
		this.birthNumber = birthNumber;
	}
	public LocalDate getBirthCertificateDate() {
		return birthCertificateDate;
	}
	public void setBirthCertificateDate(LocalDate birthCertificateDate) {
		this.birthCertificateDate = birthCertificateDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
