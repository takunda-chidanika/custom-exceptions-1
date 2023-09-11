package zw.tjchidanika.customexceptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.tjchidanika.customexceptions.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
