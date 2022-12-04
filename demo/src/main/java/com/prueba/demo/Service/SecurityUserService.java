package com.prueba.demo.Service;

import com.prueba.demo.Model.Entity.Phones;
import com.prueba.demo.Model.Entity.User;
import com.prueba.demo.Model.Repository.PhonesRepository;
import com.prueba.demo.Model.Repository.UserRepository;
import com.prueba.demo.Utils.ValidateEmail;
import com.prueba.demo.Utils.ValidatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SecurityUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhonesRepository phonesRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUsers(User user) {
        ValidateEmail.validacion(user.getEmail());
        ValidatePassword.validacion(user.getPassword());
        userRepository.save(user);
    }
    public void savePhones(Phones phones) {
        phonesRepository.save(phones);
    }

}
