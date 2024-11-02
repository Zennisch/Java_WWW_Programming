package service_interface;

import model.DeTai;
import model.GiangVien;

import java.util.List;

public interface I_Service_DeTai {

    List<DeTai> getAllDeTai();
    DeTai getDeTaiById(int id);
    boolean createDeTai(DeTai deTai);
    boolean updateDeTai(DeTai deTai);
    boolean deleteDeTai(int id);

    List<GiangVien> getAllGiangVien();
    GiangVien getGiangVienById(int id);
}
