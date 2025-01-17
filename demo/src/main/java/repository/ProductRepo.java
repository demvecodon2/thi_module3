package repository;

import database.BaseRepository;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRepo implements IProductRepo {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = mapRowToProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product mapRowToProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("price"),
                resultSet.getString("discount"),
                resultSet.getString("inventory")
        );
    }


    @Override
    public Product findById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = mapRowToProduct(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Product newProduct) {
        String sql = "INSERT INTO product (name, price, discount, inventory) VALUES (?, ?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newProduct.getName());
            statement.setInt(2, newProduct.getPrice());
            statement.setString(3, newProduct.getDiscount());
            statement.setString(4, newProduct.getInventory());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findBestSellingProducts() {
        List<Product> bestSellingProducts = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY sales DESC LIMIT 3";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = mapRowToProduct(resultSet);
                bestSellingProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bestSellingProducts;
    }

    @Override
    public int getTotalSalesInDateRange(Date startDate, Date endDate) {
        int totalSales = 0;
        String sql = "SELECT SUM(quantity) FROM sales WHERE sale_date BETWEEN ? AND ?";

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(startDate.getTime()));
            statement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalSales = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalSales;
    }
}
