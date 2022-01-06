package city.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

}
