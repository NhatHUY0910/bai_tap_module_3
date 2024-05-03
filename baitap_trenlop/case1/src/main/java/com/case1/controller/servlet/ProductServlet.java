package com.case1.controller;

import com.case1.model.dao.ProductDAO;
import com.case1.model.entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/webapp")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                try {
                    searchProduct(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            case "create":
                try {
                    getTypeList(request, response);
                    addProduct(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                ProductDAO productDAO = new ProductDAO();

                try {
                    Product product = productDAO.getProduct(id);
                    request.setAttribute("product", product);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }

                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            case "delete":
                try {
                    deleteProduct(request);
                    response.sendRedirect("/webapp");
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            case "filter":
                try {
                    filterProduct(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            case "all":
                try {
                    showAllProducts(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;

            default:
                try {
                    showAllProducts(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    createProduct(request, response);
                    response.sendRedirect("/webapp");
                    break;

                case "edit":
                    try {
                        updateProduct(request, response);
                        response.sendRedirect("/webapp");
                    } catch (SQLException e) {
                        throw new ServletException(e);
                    }
                    break;

                default:
                    try {
                        showAllProducts(request, response);
                    } catch (SQLException e) {
                        throw new ServletException(e);
                    }
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

        public void showAllProducts(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            List<Product> productList;
            List<String> typeList;
            try {
                typeList = productDAO.getTypeList();
                productList = productDAO.getAllProduct(request, response);
                RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
                request.setAttribute("productList", productList);
                request.setAttribute("typeList", typeList);
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        public void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            String searchQuery = request.getParameter("searchQuery");
            searchQuery = searchQuery.trim();
            List<String> typeList = productDAO.getTypeList();
            if (searchQuery.equals("")) {
                searchQuery = "%%";
                request.setAttribute("searchQuery", searchQuery);
            } else {
                request.setAttribute("searchQuery", searchQuery);
            }

            List<Product> productList = productDAO.searchProduct(request, response);
            request.setAttribute("productList", productList);
            request.setAttribute("action", "search");
            request.setAttribute("searchQuery", searchQuery);
            request.setAttribute("typeList", typeList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
            dispatcher.forward(request, response);
        }

        public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            HttpSession session = request.getSession();

            if (session.getAttribute("isSignIn") == null) {
                session.setAttribute("isSignIn", false);
            }

            if ((Boolean) session.getAttribute("isSignIn")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/authing");
            }
        }

        public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            List<String> typeList = productDAO.getTypeList();
            request.setAttribute("typeList", typeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editProduct.jsp");
            dispatcher.forward(request, response);
        }

        public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String productName = request.getParameter("name");
            double productPrice = Double.parseDouble(request.getParameter("price"));
            int productQuantity = Integer.parseInt(request.getParameter("quantity"));
            String type = "";
            String inputType = request.getParameter("type");
            String otherType = request.getParameter("otherType");

            if (inputType.equals("other")) {
                type = otherType;
            } else {
                type = inputType;
            }

            String country = request.getParameter("country");
            Product product = new Product(productId, productName, productPrice, productQuantity, type, country);

            productDAO.updateProduct(product);
        }

        public void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String productName = request.getParameter("name");
        double productPrice = Double.parseDouble(request.getParameter("price"));
        int productQuantity = Integer.parseInt(request.getParameter("quantity"));
        String type = "";
        String inputType = request.getParameter("type");
        String otherType = request.getParameter("otherType");

        if (inputType.equals("other")) {
            type = otherType;
        } else {
            type = inputType;
        }
        String country = request.getParameter("country");
        Product product = new Product(productName, productPrice, productQuantity, type, country);

        try {
            productDAO.insertProduct(product);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void deleteProduct(HttpServletRequest request) throws ServletException, IOException, SQLException {
        productDAO.deleteProduct(Integer.parseInt(request.getParameter("productId")));
    }

    public void filterProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> productList;
        List<String> typeList = productDAO.getTypeList();
        String type = request.getParameter("type");
        productList = productDAO.filter(type);
        request.setAttribute("typeList", typeList);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request, response);
    }

    public void getTypeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<String> typeList = productDAO.getTypeList();
        request.setAttribute("typeList", typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
        dispatcher.forward(request, response);
    }

    public void sendTypeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<String> typeList = productDAO.getTypeList();
        request.setAttribute("typeList", typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request, response);
    }
}


