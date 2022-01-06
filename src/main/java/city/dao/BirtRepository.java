package city.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import city.domain.Birth;

@Repository
public interface BirtRepository extends JpaRepository<Birth, Long> {

}
