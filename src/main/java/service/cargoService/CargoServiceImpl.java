package service.cargoService;

import dao.cargoDAO.CargoDAO;
import entity.cargo.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {



    @Autowired
    CargoDAO cargoDAO;

    @Transactional
    @Override
    public List<Cargo> getAllCargos() {
        return cargoDAO.getAllCargos();
    }

    @Transactional
    @Override
    public List<Cargo> getCargosPaginated(Optional<Integer> pageId, int recordsOnPage) {
        int page = 1;
        if ((pageId.isPresent()) && (pageId.get() > 0)) {
            page = pageId.get();
        }
        if (page == 1) {
        } else {
            page = (page - 1) * recordsOnPage + 1;
        }
        return cargoDAO.getCargosPaginated(page, recordsOnPage);
    }

    @Transactional
    @Override
    public Cargo getCargoById(int cargoId) {
        return cargoDAO.getCargoById(cargoId);
    }

    @Transactional
    @Override
    public void saveCargo(Cargo theCargo) {
        cargoDAO.saveCargo(theCargo);
    }
}
