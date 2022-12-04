package com.prueba.demo.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {

    public static boolean validacion(String email) {

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("la password ingresado es válido.");
        } else {
            System.out.println("la password ingresado es inválido.");
        }
        return false;
    }
}
