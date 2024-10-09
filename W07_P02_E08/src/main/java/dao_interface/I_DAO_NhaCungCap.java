package dao_interface;

import model.NhaCungCap;

import java.util.List;

public interface I_DAO_NhaCungCap {

    List<NhaCungCap> getAll();
    NhaCungCap getByID(int id);

}
