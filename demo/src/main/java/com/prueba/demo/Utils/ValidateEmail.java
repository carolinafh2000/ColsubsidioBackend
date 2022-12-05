package com.prueba.demo.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
 /**     "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
         + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"       **/
    public static boolean validacion(String email) {
        boolean validate = false;
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("(\\W|^)[\\w.\\-]{0,25}@(colsubsidio)\\.com(\\W|$)");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            validate = true;
        } else {
            validate = false;
        }
        return validate;
    }
}
