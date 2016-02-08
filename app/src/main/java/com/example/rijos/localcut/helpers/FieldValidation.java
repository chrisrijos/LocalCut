package com.example.rijos.localcut.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Chris Rijos
 * Helper class used for validating fields in text input forms.
 */
public class FieldValidation {

    public FieldValidation(){

    }
    public boolean isPasswordMatching(String password, String confirmPassword) {
        Pattern pattern = Pattern.compile(password, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(confirmPassword);

        if (!matcher.matches()) {
            // do your Toast("passwords are not matching");

            return false;
        }

        return true;
    }
}
