package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
