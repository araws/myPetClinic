package pl.antygravity.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.antygravity.mypetclinic.model.Owner;
import pl.antygravity.mypetclinic.model.Pet;
import pl.antygravity.mypetclinic.model.PetType;
import pl.antygravity.mypetclinic.model.Vet;
import pl.antygravity.mypetclinic.services.OwnerService;
import pl.antygravity.mypetclinic.services.PetTypeService;
import pl.antygravity.mypetclinic.services.VetService;

import java.time.LocalDate;

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
        owner1.setAddress("Kopernika");
        owner1.setCity("Gliwice");
        owner1.setTelephone("790790790");


        Pet alicja = new Pet();
        alicja.setPetType(saveCatPetType);
        alicja.setOwner(owner1);
        alicja.setBirthDate(LocalDate.of(2007, 3, 21));
        alicja.setName("Alicja");
        owner1.getPets().add(alicja);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Andrzej");
        owner2.setLastName("Raw");
        owner2.setAddress("Kopernika");
        owner2.setCity("Gliwice");
        owner2.setTelephone("793793793");

        Pet falka = new Pet();
        falka.setPetType(saveDogPetType);
        falka.setOwner(owner2);
        falka.setBirthDate(LocalDate.of(2012, 6, 3));
        falka.setName("Falka");
        owner2.getPets().add(falka);

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
