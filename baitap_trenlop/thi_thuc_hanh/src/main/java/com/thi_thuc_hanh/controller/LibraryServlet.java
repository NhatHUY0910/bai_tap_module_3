package com.thi_thuc_hanh.controller;

import com.thi_thuc_hanh.model.entity.Book;
import com.thi_thuc_hanh.model.service.BookService;
import com.thi_thuc_hanh.model.service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/library")
public class LibraryServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
    private IBookService bookService = new BookService();

    public void init(ServletConfig config) throws ServletException {
//        super.init();
        bookService = new BookService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list":
                    showAllBooks(request, response);
                    break;

                default:
                    showAllBooks(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    private void showAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/book_list.jsp");
        dispatcher.forward(request, response);
    }
}
