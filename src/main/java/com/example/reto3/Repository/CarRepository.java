package com.example.reto3.Repository;

import com.example.reto3.Repository.CRUD.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.reto3.Model.Car;
import java.util.List;
import java.util.Optional;

//Crear
//Retrieve (Obtener)
//Update (Actuqalizar)
//Delete (Eliminar)

@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository; //Instanciar la interfaz carCrudRepository
    //Metodos
    public List<Car> findAll(){  //Metodo para la lista de carros que retorne todos los carros.
        return (List<Car>) carCrudRepository.findAll();
    }
    public Optional<Car> getCar(int id){  //Metodo para trae un carro en especifico.
        return carCrudRepository.findById(id);
    }
    public Car save(Car car){  //Metodo Guardar (Este metodo guarda, actualiza y crea)
        return carCrudRepository.save(car);
    }
    public void delete(Car car){  //Metodo Eliminar
        carCrudRepository.delete(car);
    }
}
