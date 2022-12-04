package com.prueba.demo.Dto;

import com.prueba.demo.Model.Entity.Phones;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<Phones> phones;
}
