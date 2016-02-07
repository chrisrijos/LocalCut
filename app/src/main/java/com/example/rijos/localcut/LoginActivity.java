package com.example.rijos.localcut;
import com.example.rijos.localcut.controllers.UserAuthenticationHandler;
import com.example.rijos.localcut.models.User;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseApp;

public class LoginActivity extends AppCompatActivity {

    private static final String FIREBASE_URL = "https://shining-heat-4421.firebaseio.com/";
    private Firebase myFireBaseRef;
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
                Toast.makeText(getApplicationContext(), "TEST_SIGNIN", Toast.LENGTH_LONG).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(username.getText().toString(),password.getText().toString());
                UserAuthenticationHandler _authenticationHandler = new UserAuthenticationHandler(user);
                _authenticationHandler.createUser();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
