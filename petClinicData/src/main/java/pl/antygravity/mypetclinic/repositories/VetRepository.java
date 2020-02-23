package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
