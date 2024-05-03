package com.case1.controller;

import com.case1.model.dao.AccountDAO;
import jakarta.servlet.http.HttpServlet;

public class AccountServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();
}
