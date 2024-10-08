package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

    @Id
    @Column(name = "MaNhaCungCap")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhaCungCap;

    @Column(name = "TenNhaCungCap")
    private String tenNhaCungCap;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    public NhaCungCap() {
    }

    public NhaCungCap(String soDienThoai, String diaChi, String tenNhaCungCap, int maNhaCungCap) {
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tenNhaCungCap = tenNhaCungCap;
        this.maNhaCungCap = maNhaCungCap;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhaCungCap that = (NhaCungCap) o;
        return maNhaCungCap == that.maNhaCungCap;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maNhaCungCap);
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNhaCungCap=" + maNhaCungCap +
                ", tenNhaCungCap='" + tenNhaCungCap + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
