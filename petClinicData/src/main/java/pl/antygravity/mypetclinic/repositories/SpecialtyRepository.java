package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
