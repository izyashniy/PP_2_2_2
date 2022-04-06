package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private static List<Car> cars = new ArrayList<>();
    static {
        cars.add(new Car("Toyota Camry", 444, "Black"));
        cars.add(new Car("Nissan Cefiro", 555, "Red"));
        cars.add(new Car("Nissan Primero", 666, "Yellow"));
        cars.add(new Car("Range Rover Sport", 777, "Blue"));
        cars.add(new Car("Lamborghini Huracan", 888, "White"));
    }

    @GetMapping( "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Long count, Model model) {
        if (count == null) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", CarService.getCar(cars, count));
        }
        return "cars";
    }
}
