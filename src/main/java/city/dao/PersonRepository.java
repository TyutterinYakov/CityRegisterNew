package city.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByPersonIdAndSurNameAndGivenNameAndPatronymicAndDateOfBirth(Long personId, String surName,
			String givenName, String patronymic, LocalDate dateOfBirth);

}
