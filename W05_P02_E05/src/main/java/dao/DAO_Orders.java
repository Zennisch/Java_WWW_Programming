package dao;

import dao_interface.I_DAO_Orders;
import model.Orders;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Orders implements I_DAO_Orders {

    private final DataSource dataSource;

    public DAO_Orders(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean addOrder() {
        String sql = "INSERT INTO Orders DEFAULT VALUES";
        try {
            Connection connection = this.dataSource.getConnection();
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Orders getLatestOrder() {
        String sql = "SELECT TOP 1 * FROM Orders ORDER BY id DESC";
        Orders order = new Orders();
        try {
            Connection connection = this.dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }
}
