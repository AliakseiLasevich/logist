package controller;

import entity.partner.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.interfaces.PartnerService;

import java.util.Optional;

@Controller
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/all_partners")
    public String getAllPartners(Model theModel) {
        theModel.addAttribute("partners", partnerService.getAllPartners());
        return "partners";
    }

    @GetMapping(value = {"/partners", "/partners/{pageId}"})
    public String index(@PathVariable Optional<Integer> pageId,
                        Model theModel) {
        int recordsOnPage = 30;
        theModel.addAttribute("partners", partnerService.getPartnersPaginated(pageId, recordsOnPage));
        theModel.addAttribute("totalPages", Math.ceil(partnerService.getAllPartners().size() / (double) recordsOnPage));
        return "partners";
    }

    @GetMapping("/add_partner")
    public String addNewCustomer(Model theModel) {
        theModel.addAttribute("partner", new Partner());
        return "partner_edit";
    }

    @PostMapping("/savePartner")
    public String savePartner(@ModelAttribute("partner") Partner thePartner,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "partner_edit";
        } else {
            partnerService.savePartner(thePartner);
        }
        return "redirect:/partners";
    }

    @GetMapping("/partners/filter/")
    public String filterPartnersByName(Model theModel,
                                        @RequestParam("filter") String filter) {
        theModel.addAttribute("partners", partnerService.getFilteredPartners(filter));
        return "partners";
    }

    @GetMapping("/partner_edit")
    public String editCustomer(Model theModel,
                               @RequestParam("partnerId") int partnerId) {
        Partner partner = partnerService.getPartnerById(partnerId);
        theModel.addAttribute("partner", partner);
        return "partner_edit";
    }
}
