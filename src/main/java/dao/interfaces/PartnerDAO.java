package dao.interfaces;

import entity.partner.Partner;

import java.util.List;

public interface PartnerDAO {

    void savePartner(Partner thePartner);

    List<Partner> getAllPartners();

    List<Partner> getPartnersPaginated(int page, int recordsOnPage);

    List<Partner> getFilteredPartners(String filter);

    Partner getPartnerById(int partnerId);
}
