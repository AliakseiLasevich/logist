package service.cargoService;

import entity.cargo.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoService {
    List<Cargo> getAllCargos();

    List<Cargo> getCargosPaginated(Optional<Integer> pageId, int recordsOnPage);

    Cargo getCargoById(int cargoId);
}
