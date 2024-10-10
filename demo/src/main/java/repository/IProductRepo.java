package repository;

import model.Product;

import java.util.List;

public interface IProductRepo {
  List<Product> findAll();
  Product findById(int id);
  void save(Product newProduct);
  List<Product> findBestSellingProducts();

}