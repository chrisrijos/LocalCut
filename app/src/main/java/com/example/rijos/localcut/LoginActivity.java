package com.example.rijos.localcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * @Author: Chris Rijos
 * Handles all of the front end login information and the listeners for the signin and signup buttons
 * will be expanded to include googleOAuth and FacebookOAuth.
 */
public class LoginActivity extends Activity {

    private static final String FIREBASE_URL = "https://shining-heat-4421.firebaseio.com/";
    public Firebase myFireBaseRef;
    private Button signin;
    private Button signup;
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        myFireBaseRef = new Firebase(FIREBASE_URL);



        username = (EditText)findViewById(R.id.userEditText);
        password = (EditText)findViewById(R.id.passwordEditText);

        signin = (Button)findViewById(R.id.signinButton);
        signup = (Button)findViewById(R.id.signupButton);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set up user authentication to handle activity
                Toast.makeText(getApplicationContext(), "TEST_SIGNIN", Toast.LENGTH_LONG).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
            }
        });
    }
}
