package com.example.crsr.controller;

import com.example.crsr.entity.Cars;
import com.example.crsr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/")
    public String getAll(Model model) {
        List<Cars> carsList = carService.getAll();
        model.addAttribute("carsList", carsList);
        model.addAttribute("carsCount", carsList.size());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Cars car) {
        carService.save(car);
        return "redirect:/";
    }
}
