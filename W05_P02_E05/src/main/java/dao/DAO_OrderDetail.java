package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao_interface.I_DAO_OrderDetail;
import model.OrderDetail;

public class DAO_OrderDetail implements I_DAO_OrderDetail {

    private final DataSource dataSource;

    public DAO_OrderDetail(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
//        private Orders order;
//        private Book book;
//        private int quantity;
        String sql = "INSERT INTO OrderDetail (order_id, book_id, quantity) VALUES (?, ?, ?)";
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderDetail.getOrder().getId());
            preparedStatement.setInt(2, orderDetail.getBook().getId());
            preparedStatement.setInt(3, orderDetail.getQuantity());
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
