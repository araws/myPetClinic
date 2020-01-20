package pl.antygravity.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.antygravity.mypetclinic.model.Owner;
import pl.antygravity.mypetclinic.model.Vet;
import pl.antygravity.mypetclinic.services.OwnerService;
import pl.antygravity.mypetclinic.services.VetService;
import pl.antygravity.mypetclinic.services.map.OwnerServiceMap;
import pl.antygravity.mypetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Kasia");
        owner1.setLastName("Gan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Andrzej");
        owner1.setLastName("Raw");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Małgorzata");
        vet1.setLastName("Młyn");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Piotr");
        vet1.setLastName("Młyn");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
