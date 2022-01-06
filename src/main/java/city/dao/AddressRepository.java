package city.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import city.domain.Address;
import city.domain.Street;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{


	@Query(nativeQuery = true, value="select address_street.address_id from address_street "
			+ "inner join address_person "
			+ "on address_street.address_id =  address_person.address_id "
			+ "where person_id=?1 and street_code=?2")
	Optional<Long> findAddress(Long personId,Long streetId);

	Optional<Address> findByStreetsAndPersons(Long streetId, Long personId);

	@Query(nativeQuery = true, value="select address_id from address_street where street_code=?1")
	Optional<List<Long>> findAddressByStreetId(Long streetId);

	@Query(nativeQuery = true, value="select address_id from address_person where person_id=?1")
	Optional<List<Long>> findAddressByPersonId(Long personId);


}
