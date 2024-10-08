package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "DienThoai")
public class DienThoai {

    @Id
    @Column(name = "MaDienThoai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDienThoai;

    @Column(name = "TenDienThoai")
    private String tenDienThoai;

    @Column(name = "NamSanXuat")
    private int namSanXuat;

    @Column(name = "CauHinh")
    private String cauHinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaNhaCungCap")
    private NhaCungCap nhaCungCap;

    public DienThoai() {
    }

    public DienThoai(int maDienThoai, String tenDienThoai, int namSanXuat, String cauHinh, NhaCungCap nhaCungCap) {
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
    }

    public int getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(int maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DienThoai dienThoai = (DienThoai) o;
        return maDienThoai == dienThoai.maDienThoai;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maDienThoai);
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "maDienThoai=" + maDienThoai +
                ", tenDienThoai='" + tenDienThoai + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", cauHinh='" + cauHinh + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                '}';
    }
}
