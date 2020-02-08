package pl.antygravity.mypetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.antygravity.mypetclinic.model.Specialty;
import pl.antygravity.mypetclinic.model.Vet;
import pl.antygravity.mypetclinic.services.SpecialtyService;
import pl.antygravity.mypetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object != null) {
            if (object.getSpecialties().size() > 0) {
                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
