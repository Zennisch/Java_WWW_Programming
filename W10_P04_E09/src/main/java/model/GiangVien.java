package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {

    @Id
    @Column(name = "MAGV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGV;

    @NotBlank(message = "Không được để trống tên giảng viên")
    @Column(name = "TENGV", columnDefinition = "nvarchar(50)")
    private String tenGV;

    @NotBlank(message = "Không được để trống lĩnh vực nghiên cứu")
    @Column(name = "LINHVUCNGHIENCUU", columnDefinition = "nvarchar(50)")
    private String linhVucNghienCuu;

    @NotBlank(message = "Không được để trống số điện thoại")
    @Pattern(regexp = "^[0-9]{9,11}$", message = "Số điện thoại phải từ 9 đến 11 số")
    @Column(name = "DIENTHOAI", columnDefinition = "nvarchar(10)")
    private String dienThoai;

    @NotBlank(message = "Không được để trống email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org|net\\.vn)$", message = "Email không đúng chuẩn")
    @Column(name = "EMAIL", columnDefinition = "nvarchar(50)")
    private String email;

    public GiangVien() {}

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
