package city.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
