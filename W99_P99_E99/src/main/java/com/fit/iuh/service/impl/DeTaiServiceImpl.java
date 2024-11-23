package com.fit.iuh.service.impl;

import com.fit.iuh.entity.DeTai;
import com.fit.iuh.repository.DeTaiRepository;
import com.fit.iuh.service.DeTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeTaiServiceImpl implements DeTaiService {

    @Autowired
    private DeTaiRepository deTaiRepository;

    @Override
    public List<DeTai> getAll() {
        return deTaiRepository.findAll();
    }
}
