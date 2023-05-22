package com.example.reto3.Service;

import com.example.reto3.Model.Car;
import com.example.reto3.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;//Instanciar el repositorio de Car

    //Metodos
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getCar(int id) {
        return carRepository.getCar(id);
    }

    //Validaciones del metodo de Guardar
    public Car save(Car car) {
        if (car.getIdCar() == null) { //Si el id no existe esta null
            return carRepository.save(car);  // retorna un nuevo carro y lo guarda en el carRepository
        } else {  //De lo contrario
            Optional<Car> carEncontrado = getCar(car.getIdCar());  // Si nos pasan un carro con ID, buscar si existe
            if (carEncontrado.isEmpty()) {  //Si el carro encontrado esta vacio o no existe
                return carRepository.save(car);  //Guardelo como un carro nuevo en el carRepository
            } else {  // De lo contrario si el id si existe
                return car; //Retorne el carro que ya existe sin realizar cambios
            }
        }
    }

    //Validaciones del metodo de Actualizar

    public Car Update(Car car) {
        if (car.getIdCar() != null) { //Si el id que nos llego es diferente a null
            Optional<Car> carEncontrado = getCar(car.getIdCar()); //Buscar ese Id
            if (carEncontrado.isPresent()) {  //Si el id esta presente o si existe
                //Validar
                if (car.getBrand() != null) {  //Si Brand es diferente a null
                    carEncontrado.get().setBrand(car.getBrand()); //Actualizar la marca del carro
                }
                if (car.getName() != null) {   //Si name es diferente a null
                    carEncontrado.get().setName(car.getName()); //Actualizar el nombre del carro
                }
                if (car.getGama() != null) {  //Si Gama es diferente a null
                    carEncontrado.get().setGama(car.getGama()); //Actualizar la gama del carro
                }
                if (car.getYear() != null) {
                    carEncontrado.get().setYear(car.getYear());  //Actualizar el año del carro
                }
                if (car.getDescription() != null) {
                    carEncontrado.get().setDescription(car.getDescription());   //Actualizar la descripcion del carro
                }
                return carRepository.save(carEncontrado.get());  //Retorne el carro guaradado

                //En caso contrario que el id este null retorne el carro y no actualice nada.
            } else {
                return car;
            }
        } else {  //En caso contrario que el id del carro que pasaron estubiera en null y no exista
            return car;
        }
    }

    //Validaciones del metodo de Eliminar
    public boolean deleteCar(int id) {
        Boolean respuesta = getCar(id).map(car -> {  //boolean llamado respuesta con el id que se obtiene y se mapea
            carRepository.delete(car);  //funcion flecha, intentar eliminar el carro que llego
            return true;  //retornar true si se elimina
        }).orElse(false);  //De lo contrario retorne la respuesta en false
        return respuesta;
    }

}
