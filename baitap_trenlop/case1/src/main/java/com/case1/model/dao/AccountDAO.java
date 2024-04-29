package com.case1.model.dao;

import com.case1.connection.JdbcConnection;
import com.case1.model.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDTO {
    public static void updateAccount(Account account) {
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  account SET birth = ?, address = ?, wallet = ? WHERE userName = ?")) {
            preparedStatement.setString(1, account.getBirth());
            preparedStatement.setString(2, account.getAddress());
            preparedStatement.setDouble(3, account.getWallet());
            preparedStatement.setString(4, account.getUserName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount(String userName) {
        Account account = null;
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select * from account where userName = ?")) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String accUserName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                String birth = resultSet.getString("birth");
                String address = resultSet.getString("address");
                String role = resultSet.getString("role");
                double wallet = resultSet.getDouble("wallet");

                account = new Account(accUserName, password, birth, address, gender, role, wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static void deleteAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("delete from account where userName = ?")) {
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkAccountStatus(String userName, String password) {
        try (Connection connection = JdbcConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select * from account where binary userName = ? and password =?;")) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}


