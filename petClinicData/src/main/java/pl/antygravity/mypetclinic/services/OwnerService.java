package pl.antygravity.mypetclinic.services;

import pl.antygravity.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
