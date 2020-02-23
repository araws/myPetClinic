package pl.antygravity.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.mypetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
