package service.interfaces;

import entity.partner.Partner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PartnerService {
    void savePartner(Partner thePartner);

    List<Partner> getAllPartners();

    List<Partner> getPartnersPaginated(Optional<Integer> pageId, int recordsOnPage);

    List<Partner> getFilteredPartners(String filter);

    Partner getPartnerById(int partnerId);
}
