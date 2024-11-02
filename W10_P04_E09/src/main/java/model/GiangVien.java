package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {

    @Id
    @Column(name = "MAGV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGV;

    @Column(name = "TENGV", columnDefinition = "NVARCHAR(50)")
    private String tenGV;

    @Column(name = "LINHVUCNGHIENCUU", columnDefinition = "NVARCHAR(50)")
    private String linhVucNghienCuu;

    @Column(name = "DIENTHOAI", columnDefinition = "NVARCHAR(10)")
    private String dienThoai;

    @Column(name = "EMAIL", columnDefinition = "NVARCHAR(50)")
    private String email;

    public GiangVien() {
    }

    public GiangVien(Integer maGV, String tenGV, String linhVucNghienCuu, String dienThoai, String email) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.linhVucNghienCuu = linhVucNghienCuu;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public Integer getMaGV() {
        return maGV;
    }

    public void setMaGV(Integer maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getLinhVucNghienCuu() {
        return linhVucNghienCuu;
    }

    public void setLinhVucNghienCuu(String linhVucNghienCuu) {
        this.linhVucNghienCuu = linhVucNghienCuu;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiangVien giangVien = (GiangVien) o;
        return Objects.equals(maGV, giangVien.maGV);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maGV);
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "maGV='" + maGV + '\'' +
                ", tenGV='" + tenGV + '\'' +
                ", linhVucNghienCuu='" + linhVucNghienCuu + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
