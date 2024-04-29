package com.baitap_nghile.controller;

import com.baitap_nghile.model.dao.CarDAO;
import com.baitap_nghile.model.entity.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarServlet extends HttpServlet {
    private CarDAO carDAO;

    public void init() throws ServletException {
        try {
            carDAO = new CarDAO();
        } catch (SQLException e) {
            throw new ServletException("Lỗi kết nối cơ sở dữ liệu",e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listCars(request, response);
                break;

            case "view":
                viewCar(request, response);
                break;

            case "create":
                showCreateForm(request, response);
                break;

            case "update":
                showUpdateForm(request, response);
                break;

            case "delete":
                deleteCar(request, response);
                break;

            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createCar(request, response);
                break;

            case "update":
                updateCar(request, response);
                break;

            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }

    private void listCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Car> cars = carDAO.getAllCars();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("car-list.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Lỗi lấy danh sách xe", e);
        }
    }

    private void viewCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Car car = carDAO.getCar(id);
            if (car != null) {
                request.setAttribute("car", car);
                request.getRequestDispatcher("car-view.jsp").forward(request, response);
            } else {
                response.sendRedirect("car-list.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi lấy thông tin xe", e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("car-create.jsp").forward(request, response);
    }

    protected void createCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        double price = Double.parseDouble(request.getParameter("price"));
        String avatar = request.getParameter("avatar");

        Car car = new Car(code, name, producer, price, avatar);
        try {
            carDAO.insertCar(car);
            response.sendRedirect("car?action=list");
        } catch (SQLException e) {
            throw new ServletException("Lỗi thêm mới xe", e);
        }
    }

    protected void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Car car = carDAO.getCar(id);
            if (car != null) {
                request.setAttribute("car", car);
                request.getRequestDispatcher("car-view.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi lấy thông tin xe", e);
        }
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        double price = Double.parseDouble(request.getParameter("price"));
        String avatar = request.getParameter("avatar");

        Car car = new Car(code, name, producer, price, avatar);
        try {
            if (carDAO.updateCar(car)) {
                response.sendRedirect("car?action=list");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi cập nhật xe", e);
        }
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (carDAO.deleteCar(id)) {
                response.sendRedirect("car?action=list");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi xóa xe", e);
        }
    }
}
