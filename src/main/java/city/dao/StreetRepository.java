package city.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long>{

	Optional<Street> findByStreetNameAndBuildingAndExtensionAndAppartment(String streetName, String building,
			String extension, String apartment);

}
