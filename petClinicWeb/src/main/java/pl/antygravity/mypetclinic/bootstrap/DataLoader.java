package pl.antygravity.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.antygravity.mypetclinic.model.*;
import pl.antygravity.mypetclinic.services.OwnerService;
import pl.antygravity.mypetclinic.services.PetTypeService;
import pl.antygravity.mypetclinic.services.SpecialtyService;
import pl.antygravity.mypetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Piotr");
        vet2.setLastName("Młyn");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
