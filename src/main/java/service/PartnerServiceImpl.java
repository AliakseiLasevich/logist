package service;

import dao.interfaces.PartnerDAO;
import entity.partner.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.PartnerService;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {


    @Autowired
    private PartnerDAO partnerDAO;

    @Transactional
    @Override
    public List<Partner> getAllPartners() {
        return partnerDAO.getAllPartners();
    }

    @Transactional
    @Override
    public List<Partner> getPartnersPaginated(Optional<Integer> pageId, int recordsOnPage) {
        int page = 1;
        if ((pageId.isPresent()) && (pageId.get() > 0)) {
            page = pageId.get();
        }
        if (page == 1) {
        } else {
            page = (page - 1) * recordsOnPage + 1;
        }

        return partnerDAO.getPartnersPaginated(page, recordsOnPage);
    }

    @Transactional
    @Override
    public void savePartner(Partner thePartner) {
        partnerDAO.savePartner(thePartner);
    }

    @Transactional
    @Override
    public List<Partner> getFilteredPartners(String filter) {

        return partnerDAO.getFilteredPartners(filter);
    }

    @Transactional
    @Override
    public Partner getPartnerById(int partnerId) {
        return partnerDAO.getPartnerById(partnerId);
    }
}
