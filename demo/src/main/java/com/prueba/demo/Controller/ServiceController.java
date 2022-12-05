package com.prueba.demo.Controller;

import com.prueba.demo.Dto.MessageDto;
import com.prueba.demo.Dto.UserDto;
import com.prueba.demo.Model.Entity.Phones;
import com.prueba.demo.Model.Entity.User;
import com.prueba.demo.Service.UserService;
import com.prueba.demo.Utils.Constants;
import com.prueba.demo.Utils.ValidateEmail;
import com.prueba.demo.Utils.ValidatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceController {

    @Autowired
        UserService userService;

        @PostMapping("/createuser")
        public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
            if (!ValidateEmail.validacion(userDto.getEmail()))
                return new ResponseEntity(new MessageDto(Constants.INVALIDATEEMAIL
                ), HttpStatus.BAD_REQUEST);
            if (!ValidatePassword.validacion(userDto.getPassword()))
                return new ResponseEntity(new MessageDto(Constants.INVALIDATEPASSWORD), HttpStatus.BAD_REQUEST);
            Optional<User> usr = userService.existsByEmail(userDto.getEmail());
            if(!usr.isEmpty()){
                return new ResponseEntity(new MessageDto(Constants.EMAILEXIST), HttpStatus.BAD_REQUEST);
            }
            Phones phones = new Phones(userDto.getPhones().get(0).getId(), userDto.getPhones().get(0).getNumber(), userDto.getPhones().get(0).getCitycode(), userDto.getPhones().get(0).getCountrycode());
            userService.savePhones(phones);
            User user = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword(), phones);
            userService.saveUsers(user);
            return new ResponseEntity(new MessageDto( "DATOS DE REGISTRO:" + " Fecha de registro: " +  user.getCreated() + " Fecha de modificacion: " +
                    user.getModified() + " Token: " + user.getToken() + " Estado de usuario: " +
                    user.getIsactive() + " Ultimo ingreso: " + user.getLastlogin() + " Id del usuario: " + user.getId()),
            HttpStatus.CREATED);
        }

        @GetMapping("/listuser")
        public ResponseEntity<List<User>> listUser(){
            List<User> list = userService.getUsers();
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }

}

