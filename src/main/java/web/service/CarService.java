package web.service;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

 public class CarService {
    public static List<Car> getCar(List<Car> cars, Long count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
