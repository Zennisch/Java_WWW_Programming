package dao;

import dao_interface.I_DAO_DanhMuc;
import model.DanhMuc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_DanhMuc implements I_DAO_DanhMuc {

    private final DataSource dataSource;

    public DAO_DanhMuc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    MADM        VARCHAR(10) PRIMARY KEY,
//    TENDANHMUC  NVARCHAR(50) NOT NULL,
//    NGUOIQUANLY NVARCHAR(50) NOT NULL,
//    GHICHU      NVARCHAR(100)

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        List<DanhMuc> danhMucList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DanhMuc";

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDanhMuc(resultSet.getString("MADM"));
                danhMuc.setTenDanhMuc(resultSet.getString("TENDANHMUC"));
                danhMuc.setNguoiQuanLy(resultSet.getString("NGUOIQUANLY"));
                danhMuc.setGhiChu(resultSet.getString("GHICHU"));
                danhMucList.add(danhMuc);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return danhMucList;
    }

    @Override
    public DanhMuc getDanhMucById(String id) {
        try {
            String sql = "SELECT * FROM DanhMuc WHERE MADM = ?";

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            DanhMuc danhMuc = null;
            if (resultSet.next()) {
                danhMuc = new DanhMuc();
                danhMuc.setMaDanhMuc(resultSet.getString("MADM"));
                danhMuc.setTenDanhMuc(resultSet.getString("TENDANHMUC"));
                danhMuc.setNguoiQuanLy(resultSet.getString("NGUOIQUANLY"));
                danhMuc.setGhiChu(resultSet.getString("GHICHU"));

            }
            return danhMuc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
