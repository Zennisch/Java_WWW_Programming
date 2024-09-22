package dao;

import dao_interface.I_DAO_Book;
import jakarta.annotation.Resource;
import model.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Book implements I_DAO_Book {

    private final DataSource dataSource;

    public DAO_Book(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Book";
        List<Book> products = new ArrayList<>();
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book product = new Book();
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setImage(resultSet.getString("image"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Book getBook(int id) {
        String sql = "SELECT * FROM Book WHERE id = ?";
        Book product = new Book();
        try {
            Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setImage(resultSet.getString("image"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

}
