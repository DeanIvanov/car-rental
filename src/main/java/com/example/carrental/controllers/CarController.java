package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.services.CarService;
import com.example.carrental.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Controller
public class CarController {

    private CarService carService;
    private LocationService locationService;

    @Autowired
    public CarController(CarService carService, LocationService locationService) {
        this.carService = carService;
        this.locationService = locationService;
    }

    @GetMapping(value = "/car-register")
    public String showRegister(){
        return "add-car";
    }

    @PostMapping(value = "/car-register")
    public String registerUser(@Valid @ModelAttribute("car") Car car, @RequestParam("locationName") String locationName,
                               @RequestParam("file") MultipartFile multipart) {
        car.setLocation(locationService.getLocation(locationName).get(0));
        car.setCarPicture(uploadFile(multipart));
        carService.create(car.getId(), car, multipart);
        return "index";
    }

    private String uploadFile(MultipartFile file) {
        if(!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();
                String rootPath = "C:\\uploads";
                File dir = new File("C:/");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String name = String.valueOf("/uploads/"+new Date().getTime()) + ".jpg";
                File serverFile = new File(dir.getAbsolutePath()
                        +File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);

                return name;
            }
            catch (IOException e){
                e.printStackTrace();
            }
        } else {
            return "/uploads/car.jpg";
        }
        return null;
    }
}