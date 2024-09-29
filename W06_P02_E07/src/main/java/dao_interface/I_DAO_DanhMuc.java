package dao_interface;

import model.DanhMuc;

import java.util.List;

public interface I_DAO_DanhMuc {

    List<DanhMuc> getAllDanhMuc();
    DanhMuc getDanhMucById(String id);

}
