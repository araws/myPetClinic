package pl.antygravity.mypetclinic.services;

import pl.antygravity.mypetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById (Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
