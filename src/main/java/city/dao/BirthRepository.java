package city.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Birth;

@Repository
public interface BirthRepository extends JpaRepository<Birth, Long> {

	Optional<Birth> findByBirthNumberAndBirthCertificateDate(String birthCertififcate, LocalDate birthCertificateDate);

}
