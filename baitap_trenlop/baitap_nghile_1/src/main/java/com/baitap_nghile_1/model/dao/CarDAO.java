package com.baitap_nghile_1.model.dao;

import com.baitap_nghile_1.Connection.JbdcConnection;
import com.baitap_nghile_1.model.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO{
    private Connection connection;

    public CarDAO() throws SQLException {
        this.connection = JbdcConnection.getConnection();
    }

    @Override
    public void insertCar(Car car) throws SQLException {
        connection = JbdcConnection.getConnection();
        String sqlQuery = "insert into cars (code, name, producer, price, avatar) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, car.getCode());
        preparedStatement.setString(2, car.getName());
        preparedStatement.setString(3, car.getProducer());
        preparedStatement.setDouble(4, car.getPrice());
        preparedStatement.setString(5, car.getAvatar());
        preparedStatement.executeUpdate();
    }

    @Override
    public Car getCar(int carId) throws SQLException {
        connection = JbdcConnection.getConnection();
        String sqlQuery = "select * from cars where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, carId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("code"),
                    resultSet.getString("name"),
                    resultSet.getString("producer"),
                    resultSet.getDouble("price"),
                    resultSet.getString("avatar")
            );
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        connection = JbdcConnection.getConnection();
        String sqlQuery = "select * from cars";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Car> cars = new ArrayList<>();
        while (resultSet.next()) {
            cars.add(new Car(
                    resultSet.getInt("id"),
                    resultSet.getString("code"),
                    resultSet.getString("name"),
                    resultSet.getString("producer"),
                    resultSet.getDouble("price"),
                    resultSet.getString("avatar")
            ));
        }
        return cars;
    }

    @Override
    public boolean updateCar(Car car) throws SQLException {
        connection = JbdcConnection.getConnection();
        String sqlQuery = "update cars set id = ?, code = ?, name = ?, producer = ?, price = ?, avatar = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, car.getId());
        preparedStatement.setString(2, car.getCode());
        preparedStatement.setString(3, car.getName());
        preparedStatement.setString(4, car.getProducer());
        preparedStatement.setDouble(5, car.getPrice());
        preparedStatement.setString(6, car.getAvatar());
        preparedStatement.setInt(7, car.getId());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean deleteCar(int carID) throws SQLException {
        connection = JbdcConnection.getConnection();
        String sqlQuery = "delete from cars where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, carID);

        return preparedStatement.executeUpdate() > 0;
    }
}
