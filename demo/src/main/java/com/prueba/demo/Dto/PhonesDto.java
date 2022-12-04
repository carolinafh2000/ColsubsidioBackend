package com.prueba.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhonesDto implements Serializable {
    private String id;
    private Long number;
    private Long citycode;
    private Long countrycode;
}
