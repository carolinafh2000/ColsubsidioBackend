package com.prueba.demo.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "phones")
    private Phones phones;
    private Date created;
    private Date modified;
    private String token;
    private String isactive;

    public User(String name, String email, String password, Phones phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }
    //private String lastlogin;

}
