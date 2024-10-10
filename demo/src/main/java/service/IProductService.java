package service;

import model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(int id);
    void save(Product newProduct);

    List<Product> findBestSellingProducts();
}
