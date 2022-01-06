package city.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String birthCertificateDate;

}
