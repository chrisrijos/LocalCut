package com.example.rijos.localcut.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.rijos.localcut.models.User;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * @Author: Chris Rijos
 * Checks for existing user in database before allowing new database creation
 */
public class UserAuthenticationHandler {

    /*Firebase URL for reading and writing to the database*/
    private static final String FIREBASE_URL = "https://shining-heat-4421.firebaseio.com/";

    private User tango;
    private Firebase firebaseRef;

    public UserAuthenticationHandler(){

    }
    public UserAuthenticationHandler(User tango){
        this.tango = tango;
    }

    public User getTango() {
        return tango;
    }

    public void setTango(User tango) {
        this.tango = tango;
    }

    /*Creates a new user in Firebase after checking if the user is not null*/
    public void createUser(){
     if(this.tango != null) {
            firebaseRef.createUser(this.tango.getEmail(), this.tango.getPassword(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> stringObjectMap) {
                    System.out.println("Successfully created user account with uid: \"" + stringObjectMap.get("uid"));
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    //there was an error
                    System.out.println("Database write error");
                }
            });
        }
    }
}
