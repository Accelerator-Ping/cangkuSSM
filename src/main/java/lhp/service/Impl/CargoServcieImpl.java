package lhp.service.Impl;


import lhp.mapper.CargoMapper;
import lhp.pojo.Cargo;
import lhp.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServcieImpl implements CargoService{

    @Autowired
    private CargoMapper cargoMapper;

    public List<Cargo> queryForType(Cargo cargo) {
        return cargoMapper.queryForType(cargo);
    }

    public List<Cargo> queryForName(Cargo cargo) {
        return cargoMapper.queryForName(cargo);
    }

    public List<Cargo> queryAll() {
        return cargoMapper.queryAll();
    }

    public void insertCargo(Cargo cargo) {
        cargoMapper.insertCargo(cargo);
    }

    public void updateCargo(Cargo cargo) {
        cargoMapper.updateCargo(cargo);
    }

    public void deleteCargo(Cargo cargo) {
        cargoMapper.deleteCargo(cargo);
    }
}
