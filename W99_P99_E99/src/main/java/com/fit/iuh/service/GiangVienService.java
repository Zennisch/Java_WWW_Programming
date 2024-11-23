package com.fit.iuh.service;

import com.fit.iuh.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    GiangVien save(GiangVien giangVien);
    GiangVien update(int id, GiangVien giangVien);
    boolean delete(int id);
    List<GiangVien> getAll();
    GiangVien findById(int id);
}
