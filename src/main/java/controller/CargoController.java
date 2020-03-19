package controller;

import entity.cargo.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import service.interfaces.CargoService;
import service.interfaces.CustomerService;
import service.interfaces.PartnerService;

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
                            WebRequest request,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cargo_edit";
        } else {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            theCargo.setCustomer(customerService.getCustomerById(customerId));
            cargoService.saveCargo(theCargo);
        }
        return "redirect:/cargo";
    }


}
