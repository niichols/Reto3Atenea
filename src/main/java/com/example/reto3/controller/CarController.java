package com.example.reto3.controller;

import com.example.reto3.Model.Car;
import com.example.reto3.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Peticiones de CrossOrigin desde cualquier origin
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")

public class CarController {
    @Autowired
    private CarService carService; //Instanciar el servicio de carro.

    @GetMapping("/all") // peticion de tipo get ->>> localhost../api/Car/all
    public List<Car>getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")  //-->>>> localhost../api/Car/12
    public Optional<Car> getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }
}
