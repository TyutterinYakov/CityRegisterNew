package city.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{

	Optional<Passport> findByPassportDateAndNumberAndSeria(LocalDate passportDate, String passportNumber, String passportSeria);

}
