package com.example.reto3.Repository.CRUD;

import com.example.reto3.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCrudRepository extends CrudRepository<Car, Integer> {


}
