package org.learn.carservice.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarService {

    static final List<Car> CARS = Arrays.asList(
        new Car(0, "vw golf", "red", 5),
        new Car(1, "vw polo", "white", 5)
    );

    @GetMapping("/cars")
    public ResponseEntity getCars() {
        return ResponseEntity.ok(CARS);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity getCar(@PathVariable("id") Integer id) {
        return CARS.stream()
            .filter(car -> car.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
}
