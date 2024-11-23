package com.fit.iuh.repository;

import com.fit.iuh.entity.DeTai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTai, Integer> {
}
