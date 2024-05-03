package com.baitap_nghile_1.model.dao;

import com.baitap_nghile_1.model.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarDAO {
    public void insertCar(Car car) throws SQLException;
    public Car getCar(int carId) throws SQLException;
    public List<Car> getAllCars() throws SQLException;
    public boolean updateCar(Car car) throws SQLException;
    public boolean deleteCar(int carID) throws SQLException;
}
