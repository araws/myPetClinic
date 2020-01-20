package pl.antygravity.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.antygravity.mypetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }
}
