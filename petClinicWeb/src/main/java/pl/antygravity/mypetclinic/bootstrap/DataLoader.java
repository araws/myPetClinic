package pl.antygravity.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.antygravity.mypetclinic.model.Owner;
import pl.antygravity.mypetclinic.model.PetType;
import pl.antygravity.mypetclinic.model.Vet;
import pl.antygravity.mypetclinic.services.OwnerService;
import pl.antygravity.mypetclinic.services.PetTypeService;
import pl.antygravity.mypetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kasia");
        owner1.setLastName("Gan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrzej");
        owner2.setLastName("Raw");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Małgorzata");
        vet1.setLastName("Młyn");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Piotr");
        vet2.setLastName("Młyn");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
