package com.carsapi.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    @Autowired
    private CarRepository repository;

    @PostMapping
    public Object create(@RequestBody @Valid CarDTO req){
      repository.save(new Car(req));
      return req;
    }

    @GetMapping
    public List<Car> listAll(){
      return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> list(@PathVariable Long id){
      return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
      repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
      repository.findById(id).map(car -> {
        car.setAnoModelo(req.anoModelo());
        car.setDataFabricacao(req.dataFabricacao());
        car.setFabricante(req.fabricante());
        car.setModelo(req.modelo());
        car.setValor(req.valor());
        return repository.save(car);
      });
    }
}
