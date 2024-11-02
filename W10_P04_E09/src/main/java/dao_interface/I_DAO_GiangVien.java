package dao_interface;

import model.GiangVien;

import java.util.List;

public interface I_DAO_GiangVien {

    List<GiangVien> getAllGiangVien();
    GiangVien getGiangVienById(int id);

}
