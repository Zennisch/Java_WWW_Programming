package dao;

import dao_interface.I_DAO_GiangVien;
import model.GiangVien;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_GiangVien implements I_DAO_GiangVien {

    private final DataSource dataSource;

    public DAO_GiangVien(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<GiangVien> getAll() {
        List<GiangVien> giangViens = new ArrayList<>();
        try {
            String sql = "SELECT * FROM GIANGVIEN";
            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                GiangVien giangVien = new GiangVien();
                giangVien.setMaGV(resultSet.getString("MAGV"));
                giangVien.setTenGV(resultSet.getString("TENGV"));
                giangVien.setLinhVucNghienCuu(resultSet.getString("LINHVUCNGHIENCUU"));
                giangVien.setSoDienThoai(resultSet.getString("SODIENTHOAI"));

                giangViens.add(giangVien);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return giangViens;
    }

    @Override
    public boolean add(GiangVien giangVien) {
        try {
            String sql = "INSERT INTO GIANGVIEN(MAGV, TENGV, LINHVUCNGHIENCUU, SODIENTHOAI) VALUES(?, ?, ?, ?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, giangVien.getMaGV());
            preparedStatement.setString(2, giangVien.getTenGV());
            preparedStatement.setString(3, giangVien.getLinhVucNghienCuu());
            preparedStatement.setString(4, giangVien.getSoDienThoai());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GiangVien getByID(String id) {
        try {
            String sql = "SELECT * FROM GIANGVIEN WHERE MAGV = ?";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                GiangVien giangVien = new GiangVien();
                giangVien.setMaGV(resultSet.getString("MAGV"));
                giangVien.setTenGV(resultSet.getString("TENGV"));
                giangVien.setLinhVucNghienCuu(resultSet.getString("LINHVUCNGHIENCUU"));
                giangVien.setSoDienThoai(resultSet.getString("SODIENTHOAI"));
                return giangVien;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
