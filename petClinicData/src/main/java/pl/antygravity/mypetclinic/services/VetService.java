package pl.antygravity.mypetclinic.services;

import pl.antygravity.mypetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
