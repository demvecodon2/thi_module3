package service;

import model.Product;

import java.util.Date;
import java.util.List;

public interface IProductService {
     List<Product> findAll();
     Product findById(int id);
    void save(Product newProduct);

    List<Product> findBestSellingProducts();

    int getTotalSalesInDateRange(Date startDate, Date endDate);
}
