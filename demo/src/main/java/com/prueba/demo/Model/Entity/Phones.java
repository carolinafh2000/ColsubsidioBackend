package com.prueba.demo.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Long number;
    private Long citycode;
    private Long countrycode;

    public Phones(Long number, Long citycode, Long countrycode) {
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
    }
}
