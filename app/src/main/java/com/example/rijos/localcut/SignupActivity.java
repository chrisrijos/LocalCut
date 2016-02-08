package com.example.rijos.localcut;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rijos.localcut.helpers.FieldValidation;
import com.firebase.client.Firebase;

public class SignupActivity extends AppCompatActivity {

    private static final String FIREBASE_URL = "https://shining-heat-4421.firebaseio.com/";
    private EditText fullname;
    private EditText email;
    private EditText password;
    private EditText dummy;
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /*Sets android context for this part of the firebase activity*/
        Firebase.setAndroidContext(this);
        AlertDialog validationDialog = new AlertDialog.Builder(SignupActivity.this).create(); //Sets alert dialog for android

    }


}
