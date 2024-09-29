package model;

public class TinTuc {

//    MATT      VARCHAR(10) PRIMARY KEY,
//    TIEUDE    NVARCHAR(100) NOT NULL,
//    NOIDUNGTT NVARCHAR(1000) NOT NULL,
//    LIENKET   NVARCHAR(100) NOT NULL,
//    MADM      VARCHAR(10) NOT NULL,
//    FOREIGN KEY (MADM) REFERENCES DANHMUC (MADM)

    private String maTinTuc;
    private String tieuDe;
    private String noiDungTT;
    private String lienKet;
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(String maTinTuc, String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.maTinTuc = maTinTuc;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }

    public String getMaTinTuc() {
        return maTinTuc;
    }

    public void setMaTinTuc(String maTinTuc) {
        this.maTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDungTT() {
        return noiDungTT;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public String toString() {
        return "TinTuc{" +
                "maTinTuc='" + maTinTuc + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", noiDungTT='" + noiDungTT + '\'' +
                ", lienKet='" + lienKet + '\'' +
                ", danhMuc=" + danhMuc +
                '}';
    }
}
