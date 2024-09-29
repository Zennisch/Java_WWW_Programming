package model;

public class DeTai {

    private String maDT;
    private String tenDT;
    private int namDangKy;
    private String moTaDeTai;
    private GiangVien giangVien;


    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public String getMoTaDeTai() {
        return moTaDeTai;
    }

    public void setMoTaDeTai(String moTaDeTai) {
        this.moTaDeTai = moTaDeTai;
    }

    public int getNamDangKy() {
        return namDangKy;
    }

    public void setNamDangKy(int namDangKy) {
        this.namDangKy = namDangKy;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public DeTai() {
    }

    public DeTai(String maDT, String tenDT, int namDangKy, String moTaDeTai, GiangVien giangVien) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namDangKy = namDangKy;
        this.moTaDeTai = moTaDeTai;
        this.giangVien = giangVien;
    }

    @Override
    public String toString() {
        return "DeTai{" +
                "maDT='" + maDT + '\'' +
                ", tenDT='" + tenDT + '\'' +
                ", namDangKy=" + namDangKy +
                ", moTaDeTai='" + moTaDeTai + '\'' +
                ", giangVien=" + giangVien +
                '}';
    }
}
