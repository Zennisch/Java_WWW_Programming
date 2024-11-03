package service;

import dao_interface.I_DAO_GiangVien;
import jakarta.transaction.Transactional;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_interface.I_Service_GiangVien;

import java.util.List;

@Service
public class Service_GiangVien implements I_Service_GiangVien {

    @Autowired
    private I_DAO_GiangVien dao_giangVien;

    @Override
    @Transactional
    public List<GiangVien> getAllGiangVien() {
        return dao_giangVien.getAllGiangVien();
    }

    @Override
    @Transactional
    public GiangVien getGiangVienById(int id) {
        return dao_giangVien.getGiangVienById(id);
    }

    @Override
    @Transactional
    public boolean createGiangVien(GiangVien giangVien) {
        return dao_giangVien.createGiangVien(giangVien);
    }
}
