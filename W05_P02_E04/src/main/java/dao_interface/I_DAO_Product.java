package dao_interface;

import model.Product;

import java.util.List;

public interface I_DAO_Product {
    List<Product> getAllProducts();
    Product getProduct(int id);
    boolean addProduct(Product product);
}
