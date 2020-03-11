package controller;

import entity.cargo.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.cargoService.CargoService;
import java.util.Optional;

@Controller
public class CargoController {

    @Autowired
    CargoService cargoService;

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
        return "cargo_edit";
    }

    @GetMapping("/cargo_edit")
    public String editCustomer(Model theModel,
                               @RequestParam("cargoid") int cargoId) {
        Cargo cargo = cargoService.getCargoById(cargoId);
        theModel.addAttribute("cargo", cargo);
        return "cargo_edit";
    }

//    @PostMapping("/saveCustomer")
//    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer,
//                               BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "customer_edit";
//        } else {
//            customerService.saveCustomer(theCustomer);
//        }
//        return "redirect:/customers";
//    }


}
