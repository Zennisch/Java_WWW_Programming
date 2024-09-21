package dao_interface;

import model.Product;

import java.util.List;

public interface I_DAO_Product {
    public List<Product> getAllProducts();
    public Product getProduct(int id);
    public boolean addProduct(Product product);
}
