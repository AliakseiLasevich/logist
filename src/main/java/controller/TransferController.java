package controller;

import entity.transfer.Transfer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TransferController {


    @GetMapping("/transfer")
    public String index(Model theModel) {
        theModel.addAttribute("transfer", new Transfer());
        return "transfer";
    }
}
