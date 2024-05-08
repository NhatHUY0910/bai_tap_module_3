package com.case_2.controller;

import com.case_2.model.dao.ProductDAO;
import com.case_2.dto.ProducerWithProductsDTO;
import com.case_2.model.entity.Product;
import com.case_2.dto.ProductWithCategoryAndShipperDTO;
import com.case_2.dto.ProductWithProducersDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() throws ServletException {
        productDAO = new ProductDAO();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "view":
                    viewProduct(request, response);
                    break;

                case "list":
                    listProducts(request, response);
                    break;

                case "showProductsWithProducers":
                    showProductsWithProducers(request, response);
                    break;

                case "showProducersWithProducts":
                    showProducersWithProducts(request, response);
                    break;

                case "showProductsWithCategoriesAndShippers":
                    showProductsWithCategoriesAndShippers(request, response);
                    break;

                case "sortByPriceAscending":
                    showProductsByPriceAsc(request, response);
                    break;

                case "sortByPriceDescending":
                    showProductsByPriceDesc(request, response);
                    break;

                case "create":
                    showCreateForm(request, response);
                    break;

                case "delete":
                    deleteProduct(request, response);
                    break;

                case "update":
                    showUpdateForm(request, response);
                    break;

                default:
                    listProducts(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createProduct(request, response);
                break;

            case "update":
                updateProduct(request, response);
                break;

//            case "delete":
//                deleteProduct(request, response);
//                break;

            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductsWithProducers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductWithProducersDTO> productList = productDAO.getProductsWithProducers();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/products_with_producers.jsp");
        dispatcher.forward(request, response);
    }

    private void showProducersWithProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProducerWithProductsDTO> productList = productDAO.getProducersWithProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/producers_with_products.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductsWithCategoriesAndShippers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductWithCategoryAndShipperDTO> productList = productDAO.getProductsWithCategoriesAndShippers();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/products_with_categories_and_shippers.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductsByPriceAsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.sortProductsByPriceAscending();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductsByPriceDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.sortProductsByPriceDescending();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product_list.jsp");
        dispatcher.forward(request, response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));

            Product product = productDAO.getProductById(id);
            if (product != null) {
                request.setAttribute("view", product);
                request.getRequestDispatcher("/jsp/product_view.jsp").forward(request, response);
            } else {
                response.sendRedirect("/products");
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product_create.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String category = request.getParameter("categories");
        String shipper = request.getParameter("shipper");
        String image = request.getParameter("image");

        Product product = new Product(name, price, producer, category, shipper, image);
        productDAO.createProduct(product);
        response.sendRedirect("/products");
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.getProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product_update.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String category = request.getParameter("categories");
        String shipper = request.getParameter("shipper");
        String image = request.getParameter("image");

        Product product = new Product(id, name, price, producer, category, shipper, image);
        productDAO.updateProduct(product);
        response.sendRedirect( "/products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        response.sendRedirect("/products");
    }
}


