package dao.interfaces;

import entity.cargo.Cargo;

import java.util.List;

public interface CargoDAO {
    List<Cargo> getAllCargos();

    List<Cargo> getCargosPaginated(int page, int recordsOnPage);

    Cargo getCargoById(int cargoId);

    void saveCargo(Cargo theCargo);

    List<Cargo> getCargoWithoutTransfer();
}
