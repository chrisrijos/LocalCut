package com.example.rijos.localcut;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        //Take button input
        fullname = (EditText)findViewById(R.id.fullname);
        email = (EditText)findViewById(R.id.emailaddress);
        password = (EditText)findViewById(R.id.password);
        dummy = (EditText)findViewById(R.id.dummy);
        createAccount = (Button)findViewById(R.id.create);

        /*Sets android context for this part of the firebase activity*/
        Firebase.setAndroidContext(this);


        //Set OnFocusActionListener for password field and include validator below
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            /*Helper to validate fields in forms*/
            FieldValidation validator = new FieldValidation(SignupActivity.this);

            @Override
            public void onFocusChange(View v, boolean hasFocus){
                /*When focus is lost check, if the text field has valid values*/
                if(!(password.getText().toString().length() > 6)){
                    if(validator.isPasswordMatching(password.getText().toString(),dummy.getText().toString())){
                        createAccount.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SignupActivity.this,"Passwords match",Toast.LENGTH_LONG).show();

                                //Firebase create user if email validates
                                Firebase mRef = new Firebase(FIREBASE_URL);

                                //continue to next activity
                                Intent i = new Intent(getApplicationContext(),ClientServiceViewer.class);
                                startActivity(i);

                            }
                        });
                    }else{
                        //if passwords do not match make this toast otherwise continue to let the user make the account
                        Toast.makeText(SignupActivity.this,"Passwords do not match",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }


}
