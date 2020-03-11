package dao.cargoDAO;

import entity.cargo.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoDAO {
    List<Cargo> getAllCargos();

    List<Cargo> getCargosPaginated(int page, int recordsOnPage);

    Cargo getCargoById(int cargoId);
}
