package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
