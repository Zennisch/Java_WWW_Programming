package dao;

import dao_interface.I_DAO_TinTuc;
import model.DanhMuc;
import model.TinTuc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_TinTuc implements I_DAO_TinTuc {


//    MADM        VARCHAR(10) PRIMARY KEY,
//    TENDANHMUC  NVARCHAR(50) NOT NULL,
//    NGUOIQUANLY NVARCHAR(50) NOT NULL,
//    GHICHU      NVARCHAR(100)
//
//    MATT      VARCHAR(10) PRIMARY KEY,
//    TIEUDE    NVARCHAR(100) NOT NULL,
//    NOIDUNGTT NVARCHAR(1000) NOT NULL,
//    LIENKET   NVARCHAR(100) NOT NULL,
//    MADM      VARCHAR(10) NOT NULL,

    private final DataSource dataSource;

    public DAO_TinTuc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<TinTuc> getAllTinTuc() {
        List<TinTuc> tinTucList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TinTuc";

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String sql2 = "SELECT * FROM DanhMuc WHERE MADM = ?";

                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setString(1, resultSet.getString("MADM"));
                ResultSet resultSet2 = statement2.executeQuery();

                DanhMuc danhMuc = null;
                if (resultSet2.next()) {
                    danhMuc = new DanhMuc();
                    danhMuc.setMaDanhMuc(resultSet2.getString("MADM"));
                    danhMuc.setTenDanhMuc(resultSet2.getString("TENDANHMUC"));
                    danhMuc.setNguoiQuanLy(resultSet2.getString("NGUOIQUANLY"));
                    danhMuc.setGhiChu(resultSet2.getString("GHICHU"));
                }

                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(resultSet.getString("MATT"));
                tinTuc.setTieuDe(resultSet.getString("TIEUDE"));
                tinTuc.setNoiDungTT(resultSet.getString("NOIDUNGTT"));
                tinTuc.setLienKet(resultSet.getString("LIENKET"));
                tinTuc.setDanhMuc(danhMuc);
                tinTucList.add(tinTuc);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tinTucList;
    }

    @Override
    public TinTuc getTinTucById(int id) {
        try {
            String sql = "SELECT * FROM TinTuc WHERE MATT = ?";

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(sql);

            TinTuc tinTuc = null;
            if (resultSet.next()) {

                String sql2 = "SELECT * FROM DanhMuc WHERE MADM = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setString(1, resultSet.getString("MADM"));

                ResultSet resultSet2 = statement2.executeQuery();
                DanhMuc danhMuc = new DanhMuc();
                if (resultSet2.next()) {
                    danhMuc.setMaDanhMuc(resultSet2.getString("MADM"));
                    danhMuc.setTenDanhMuc(resultSet2.getString("TENDANHMUC"));
                    danhMuc.setNguoiQuanLy(resultSet2.getString("NGUOIQUANLY"));
                    danhMuc.setGhiChu(resultSet2.getString("GHICHU"));
                }

                tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(resultSet.getString("MATT"));
                tinTuc.setTieuDe(resultSet.getString("TIEUDE"));
                tinTuc.setNoiDungTT(resultSet.getString("NOIDUNGTT"));
                tinTuc.setLienKet(resultSet.getString("LIENKET"));
                tinTuc.setDanhMuc(danhMuc);
            }
            return tinTuc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addTinTuc(TinTuc tinTuc) {
        try {
            String sql = "INSERT INTO TinTuc(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?, ?)";

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tinTuc.getMaTinTuc());
            statement.setString(2, tinTuc.getTieuDe());
            statement.setString(3, tinTuc.getNoiDungTT());
            statement.setString(4, tinTuc.getLienKet());
            statement.setString(5, tinTuc.getDanhMuc().getMaDanhMuc());

            int result = statement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateTinTuc(TinTuc tinTuc) {
        try {
            String sql = "UPDATE TinTuc SET TIEUDE = ?, NOIDUNGTT = ?, LIENKET = ?, MADM = ? WHERE MATT = ?";

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tinTuc.getTieuDe());
            statement.setString(2, tinTuc.getNoiDungTT());
            statement.setString(3, tinTuc.getLienKet());
            statement.setString(4, tinTuc.getDanhMuc().getMaDanhMuc());
            statement.setString(5, tinTuc.getMaTinTuc());

            int result = statement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteTinTuc(int id) {
        try {
            String sql = "DELETE FROM TinTuc WHERE MATT = ?";

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int result = statement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
