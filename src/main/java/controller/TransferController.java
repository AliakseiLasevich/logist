package controller;

import entity.transfer.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.CargoService;
import service.interfaces.PartnerService;
import service.interfaces.TransferService;

@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/transfer")
    public String index(Model theModel) {
        theModel.addAttribute("transfers", transferService.getAllTransfers());
        return "transfer";
    }


    @GetMapping("/add_transfer")
    public String addNewTransfer(Model theModel) {
        theModel.addAttribute("transfer", new Transfer());
        theModel.addAttribute("partners", partnerService.getAllPartners());
        theModel.addAttribute("cargos", cargoService.getAllCargos());
        return "transfer_form";
    }

    @PostMapping("/saveTransfer")
    public String savePartner(@ModelAttribute("transfer") Transfer transfer,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "transfer_form";
        } else {
            transferService.saveTransfer(transfer);
        }
        return "redirect:/transfer";
    }

    @GetMapping("/transfer_edit")
    public String editCustomer(Model theModel,
                               @RequestParam("transferId") int transferId) {
        Transfer transfer = transferService.getTransferById(transferId);
        theModel.addAttribute("transfer", transfer);
        return "transfer_form";
    }
}
