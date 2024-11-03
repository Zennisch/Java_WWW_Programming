package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "DETAI")
public class DeTai {

    @Id
    @Column(name = "MADETAI")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDeTai;

    @NotBlank(message = "Không được để trống tên đề tài")
    @Column(name = "TENDETAI", columnDefinition = "NVARCHAR(100)")
    private String tenDeTai;

    @NotNull(message = "Không được để trống năm")
    @Column(name = "NAM")
    private Integer nam;

    @NotBlank(message = "Không được để trống mô tả")
    @Column(name = "MOTA", columnDefinition = "NVARCHAR(500)")
    private String moTaDeTai;

    @Column(name = "URLHINH", columnDefinition = "NVARCHAR(100)")
    private String urlHinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAGV")
    private GiangVien giangVien;

    public DeTai() {
    }

    public DeTai(Integer maDeTai, String tenDeTai, Integer nam, String moTaDeTai, String urlHinh, GiangVien giangVien) {
        this.maDeTai = maDeTai;
        this.tenDeTai = tenDeTai;
        this.nam = nam;
        this.moTaDeTai = moTaDeTai;
        this.urlHinh = urlHinh;
        this.giangVien = giangVien;
    }

    public Integer getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(Integer maDeTai) {
        this.maDeTai = maDeTai;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public String getMoTaDeTai() {
        return moTaDeTai;
    }

    public void setMoTaDeTai(String moTaDeTai) {
        this.moTaDeTai = moTaDeTai;
    }

    public String getUrlHinh() {
        return urlHinh;
    }

    public void setUrlHinh(String urlHinh) {
        this.urlHinh = urlHinh;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeTai deTai = (DeTai) o;
        return Objects.equals(maDeTai, deTai.maDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maDeTai);
    }

    @Override
    public String toString() {
        return "DeTai{" +
                "maDeTai=" + maDeTai +
                ", tenDeTai='" + tenDeTai + '\'' +
                ", nam=" + nam +
                ", moTaDeTai='" + moTaDeTai + '\'' +
                ", urlHinh='" + urlHinh + '\'' +
                ", giangVien=" + giangVien +
                '}';
    }
}
