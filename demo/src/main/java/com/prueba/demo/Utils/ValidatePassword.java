package com.prueba.demo.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {

    public static boolean validacion(String email) {
        boolean validate = false;

        Pattern pattern = Pattern
                .compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            validate = true;
        } else {
            validate = false;
        }
        return validate;
    }
}
