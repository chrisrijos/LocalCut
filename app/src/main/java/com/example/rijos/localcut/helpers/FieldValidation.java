package com.example.rijos.localcut.helpers;

import android.content.Context;
import android.widget.Toast;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Chris Rijos
 * Helper class used for validating fields in text input forms.
 */
public class FieldValidation {

    public Context context;

    public FieldValidation(Context context){
        this.context = context;
    }
    /*Returns a toast saying the passwords are not matching and returns false*/
    public boolean isPasswordMatching(String password, String confirmPassword) {
        Pattern pattern = Pattern.compile(password, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(confirmPassword);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}
