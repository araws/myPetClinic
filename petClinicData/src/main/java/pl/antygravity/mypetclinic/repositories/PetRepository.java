package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
