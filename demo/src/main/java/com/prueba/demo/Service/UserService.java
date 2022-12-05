package com.prueba.demo.Service;

import com.prueba.demo.Model.Entity.Phones;
import com.prueba.demo.Model.Entity.User;
import com.prueba.demo.Model.Repository.PhonesRepository;
import com.prueba.demo.Model.Repository.UserRepository;
import com.prueba.demo.Utils.CreateDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhonesRepository phonesRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> existsByEmail(String email){
        Optional<User> hola = userRepository.findOneByEmail(email);
        return userRepository.findOneByEmail(email);
    }
    public void saveUsers(User user) {
        user.setCreated(CreateDate.createDate());
        user.setModified(null);
        user.setToken("Funcion para generar token");
        user.setIsactive("Activo");
        user.setLastlogin(CreateDate.createDate());
        userRepository.save(user);
    }
    public void savePhones(Phones phones) {
        phonesRepository.save(phones);
    }

}
