package com.thi_thuc_hanh.model.service;

import com.thi_thuc_hanh.connection.JdbcConnection;
import com.thi_thuc_hanh.model.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();

        try(Connection connection = JdbcConnection.getConnection()) {
            String sqlQuery = "select * from sach";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book = new Book(
                        resultSet.getInt("masach"),
                        resultSet.getString("tensach"),
                        resultSet.getString("tacgia"),
                        resultSet.getString("mota"),
                        resultSet.getInt("soluong")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
