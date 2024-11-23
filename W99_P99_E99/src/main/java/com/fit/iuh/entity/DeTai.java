package com.fit.iuh.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "DETAI")
public class DeTai {

//    DETAI(MADETAI, TENDETAI, NAM, MOTADETAI, URLHINH, MAGV)

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "MADETAI")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDeTai;

    @Column(name = "TENDETAI")
    private String tenDeTai;

    @Column(name = "NAM")
    private int nam;

    @Column(name = "MOTADETAI")
    private String moTaDeTai;

    @Column(name = "URLHINH")
    private String urlHinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAGV")
    private GiangVien giangVien;

}
