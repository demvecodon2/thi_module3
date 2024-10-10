package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SystemManagement", value = "/home")
public class SystemManagement extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "add":
                    request.getRequestDispatcher("/WEB-INF/thi/add.jsp").forward(request, response);
                    break;

                case "view":
                    handleViewAction(request, response);
                    break;

                case "list":
                    handleListAction(request, response);
                    break;

                case "bestSelling":
                    handleBestSellingAction(request, response);
                    break;

                case "salesInDateRange":
                    handleSalesInDateRange(request, response);
                    break;

                default:
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID format.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred.");
        }
    }

    private void handleBestSellingAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> bestSellingProducts = productService.findBestSellingProducts();
        request.setAttribute("bestSellingProducts", bestSellingProducts);
        request.getRequestDispatcher("/WEB-INF/thi/bestSellingProducts.jsp").forward(request, response);
    }


    private void handleSalesInDateRange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(request.getParameter("startDate"));
            Date endDate = dateFormat.parse(request.getParameter("endDate"));

            int totalSales = productService.getTotalSalesInDateRange(startDate, endDate);
            request.setAttribute("totalSales", totalSales);
            request.getRequestDispatcher("/WEB-INF/thi/salesReport.jsp").forward(request, response);
        } catch (ParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving sales data.");
        }
    }

    private void handleViewAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int productId = Integer.parseInt(request.getParameter("id"));
            Product product = productService.findById(productId);
            if (product != null) {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/thi/viewProduct.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found.");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID format.");
        }
    }

    private void handleListAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/thi/listProducts.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            try {
                String name = request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                String discount = request.getParameter("discount");
                String inventory = request.getParameter("inventory");

                Product newProduct = new Product(0, name, price, discount, inventory);
                productService.save(newProduct);

                response.sendRedirect("home?action=list");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid price format.");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while adding the product.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not recognized.");
        }
    }
}
