package service;

import dao_interface.I_DAO_DeTai;
import dao_interface.I_DAO_GiangVien;
import jakarta.transaction.Transactional;
import model.DeTai;
import model.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_interface.I_Service_DeTai;

import java.util.List;

@Service
public class Service_DeTai implements I_Service_DeTai {

    @Autowired
    private I_DAO_DeTai dao_deTai;

    @Autowired
    private I_DAO_GiangVien dao_giangVien;

    @Override
    @Transactional
    public List<DeTai> getAllDeTai() {
        return dao_deTai.getAllDeTai();
    }

    @Override
    @Transactional
    public DeTai getDeTaiById(int id) {
        return dao_deTai.getDeTaiById(id);
    }

    @Override
    @Transactional
    public boolean createDeTai(DeTai deTai) {
        return dao_deTai.createDeTai(deTai);
    }

    @Override
    @Transactional
    public boolean updateDeTai(DeTai deTai) {
        return dao_deTai.updateDeTai(deTai);
    }

    @Override
    @Transactional
    public boolean deleteDeTai(int id) {
        return dao_deTai.deleteDeTai(id);
    }

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
}
