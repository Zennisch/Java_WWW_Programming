package service_interface;

import model.GiangVien;

import java.util.List;

public interface I_Service_GiangVien {

    List<GiangVien> getAllGiangVien();
    GiangVien getGiangVienById(int id);

}