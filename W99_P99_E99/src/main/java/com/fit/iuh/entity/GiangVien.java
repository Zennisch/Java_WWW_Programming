package com.fit.iuh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {

//    GIANGVIEN(MAGV, TENGV, LINHVUCNGHIENCUU, DIENTHOAI, EMAIL)

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "MAGV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maGV;

    @Column(name = "TENGV")
    private String tenGV;

    @Column(name = "LINHVUCNGHIENCUU")
    private String linhVucNghienCuu;

    @Column(name = "DIENTHOAI")
    private String dienThoai;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "giangVien", fetch = FetchType.EAGER)
    private List<DeTai> deTaiList;

}
