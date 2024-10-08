package dao_interface;

import model.DienThoai;

import java.util.List;

public interface I_DAO_DienThoai {

    List<DienThoai> getAll();
    DienThoai getByID(int id);
    boolean add(DienThoai dienThoai);
    boolean update(DienThoai dienThoai);
    boolean delete(int id);

}
