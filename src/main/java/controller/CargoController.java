package controller;

import entity.cargo.Cargo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CargoController {

    @GetMapping("/cargo")
    public String index(Model theModel) {
        theModel.addAttribute("customer", new Cargo());
        return "cargo";
    }
}
