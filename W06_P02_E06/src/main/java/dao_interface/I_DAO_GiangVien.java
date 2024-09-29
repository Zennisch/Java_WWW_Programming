package dao_interface;

import model.GiangVien;

import java.util.List;

public interface I_DAO_GiangVien {

    List<GiangVien> getAll();
    boolean add(GiangVien giangVien);
}
