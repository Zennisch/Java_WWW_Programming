package com.fit.iuh.service.impl;

import com.fit.iuh.entity.GiangVien;
import com.fit.iuh.repository.GiangVienRepository;
import com.fit.iuh.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienServiceImpl implements GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Override
    public GiangVien save(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    @Override
    public GiangVien update(int id, GiangVien giangVien) {
        GiangVien giangVienToUpdate = giangVienRepository.findById(id).orElse(null);
        if (giangVienToUpdate == null) {
            return null;
        }
        return giangVienRepository.save(giangVien);
    }

    @Override
    public boolean delete(int id) {
        GiangVien giangVienToDelete = giangVienRepository.findById(id).orElse(null);
        if (giangVienToDelete == null) {
            return false;
        }
        giangVienRepository.delete(giangVienToDelete);
        return true;
    }

    @Override
    public List<GiangVien> getAll() {
        return giangVienRepository.findAll();
    }

    @Override
    public GiangVien findById(int id) {
        return giangVienRepository.findById(id).orElse(null);
    }
}
