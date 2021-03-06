package lhp.mapper;

import lhp.pojo.Cargo;

import java.util.List;

public interface CargoMapper {
    //按类型
    public List<Cargo> queryForType(Cargo cargo);
    //按名字查询
    public List<Cargo> queryForName(Cargo cargo);
    //查询全部信息
    public List<Cargo> queryAll();
    //添加货物信息
    public void insertCargo(Cargo cargo);
    //按名称修改货物信息
    public void updateCargo(Cargo cargo);
    //删除货物信息
    public void deleteCargo(Cargo cargo);
}