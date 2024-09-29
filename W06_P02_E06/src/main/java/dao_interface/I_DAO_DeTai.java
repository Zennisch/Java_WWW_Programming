package dao_interface;

import model.DeTai;
import model.GiangVien;

import java.util.List;

public interface I_DAO_DeTai {

    List<DeTai> getAll();
    void add(DeTai deTai);
    GiangVien getByID(String id);

}
