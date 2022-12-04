package com.prueba.demo.Controller;

import com.prueba.demo.Dto.MessageDto;
import com.prueba.demo.Dto.UserDto;
import com.prueba.demo.Model.Entity.Phones;
import com.prueba.demo.Model.Entity.User;
import com.prueba.demo.Service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceController {
        @Autowired
        SecurityUserService userService;

        @PostMapping("/createuser")
        public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
            Phones phones = new Phones(userDto.getPhones().get(0).getId(), userDto.getPhones().get(0).getNumber(), userDto.getPhones().get(0).getCitycode(), userDto.getPhones().get(0).getCountrycode());
            userService.savePhones(phones);
            User user = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword(), phones);
            userService.saveUsers(user);
            return new ResponseEntity(new MessageDto("Creado con exito"), HttpStatus.OK);
        }

        @GetMapping("/listuser")
        public ResponseEntity<List<User>> listUser(){
            List<User> list = userService.getUsers();
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }

}

