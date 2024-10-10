package service;

import model.Product;
import repository.IProductRepo;
import repository.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepo productRepo;

    public ProductService() {
        this.productRepo = new ProductRepo();
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product newProduct) {
        productRepo.save(newProduct);
    }

    @Override
    public List<Product> findBestSellingProducts() {
        return productRepo.findBestSellingProducts();
    }
}
