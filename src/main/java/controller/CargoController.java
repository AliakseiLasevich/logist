package controller;

import entity.cargo.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.cargoService.CargoService;
import service.customerService.CustomerService;
import service.partnerService.PartnerService;

import java.util.Optional;

@Controller
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PartnerService partnerService;

    @GetMapping(value = {"/cargo", "/cargo/{pageId}"})
    public String index(@PathVariable Optional<Integer> pageId,
                        Model theModel) {
        int recordsOnPage = 30;
        theModel.addAttribute("cargos", cargoService.getCargosPaginated(pageId, recordsOnPage));
        theModel.addAttribute("totalPages", Math.ceil(cargoService.getAllCargos().size() / (double) recordsOnPage));
        return "cargo";
    }

    @GetMapping("/all_cargos")
    public String getAllCargos(Model theModel) {
        theModel.addAttribute("cargos", cargoService.getAllCargos());
        return "cargo";
    }


    @GetMapping("/add_cargo")
    public String addNewCargo(Model theModel) {
        theModel.addAttribute("cargo", new Cargo());
        theModel.addAttribute("customers", customerService.getAllCustomers());
        return "cargo_edit";
    }

    @GetMapping("/cargo_edit")
    public String editCargo(Model theModel,
                            @RequestParam("cargoId") int cargoId) {
        Cargo cargo = cargoService.getCargoById(cargoId);
        theModel.addAttribute("cargo", cargo);
        theModel.addAttribute("customers", customerService.getAllCustomers());
        return "cargo_edit";
    }

    @PostMapping("/saveCargo")
    public String saveCargo(@ModelAttribute("cargo") Cargo theCargo,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cargo_edit";
        } else {
            cargoService.saveCargo(theCargo);
        }
        return "redirect:/cargo";
    }


}
