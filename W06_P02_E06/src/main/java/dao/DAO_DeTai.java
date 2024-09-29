package dao;

import dao_interface.I_DAO_DeTai;
import model.DeTai;
import model.GiangVien;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_DeTai implements I_DAO_DeTai {

    private final DataSource dataSource;

    public DAO_DeTai(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DeTai> getAll() {
        List<DeTai> deTais = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DETAI";
            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                DeTai deTai = new DeTai();
                deTai.setMaDT(resultSet.getString("MADT"));
                deTai.setTenDT(resultSet.getString("TENDT"));
                deTai.setNamDangKy(resultSet.getInt("NAMDANGKY"));
                deTai.setMoTaDeTai(resultSet.getString("MOTA"));
                deTai.setGiangVien(getByID(resultSet.getString("MAGV")));

                deTais.add(deTai);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return deTais;
    }

    @Override
    public void add(DeTai deTai) {
        try {
            String sql = "INSERT INTO DETAI(MADT, TENDT, NAMDANGKY, MOTA, MAGV) VALUES(?, ?, ?, ?, ?)";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deTai.getMaDT());
            preparedStatement.setString(2, deTai.getTenDT());
            preparedStatement.setInt(3, deTai.getNamDangKy());
            preparedStatement.setString(4, deTai.getMoTaDeTai());
            preparedStatement.setString(5, deTai.getGiangVien().getMaGV());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GiangVien getByID(String id) {
        try {
            String sql = "SELECT * FROM GIANGVIEN WHERE MAGV = ?";
            Connection connection = dataSource.getConnection();
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            resultSet.next();
            GiangVien giangVien = new GiangVien();
            giangVien.setMaGV(resultSet.getString("MAGV"));
            giangVien.setTenGV(resultSet.getString("TENGV"));
            giangVien.setLinhVucNghienCuu(resultSet.getString("LINHVUCNGHIENCUU"));
            giangVien.setSoDienThoai(resultSet.getString("SODIENTHOAI"));
            return giangVien;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
