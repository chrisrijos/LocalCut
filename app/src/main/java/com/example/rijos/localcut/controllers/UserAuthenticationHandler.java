package com.example.rijos.localcut.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.rijos.localcut.models.User;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * @Author: Chris Rijos
 * Checks for existing user in database before allowing new database creation, will be expanded
 * to include more user authentication handling features such as session handling, etc.
 */
public class UserAuthenticationHandler {

    private User tango;
    private Firebase mRef;

    public UserAuthenticationHandler(){

    }
    /*Constructs User authentication handler passing in each user being created and
    * the firebase reference from the main login activity.*/
    public UserAuthenticationHandler(User tango, Firebase mRef){
        this.tango = tango;
        this.mRef = mRef;
    }

    public User getUser() {
        return tango;
    }

    public void setUser(User tango) {
        this.tango = tango;
    }

    /*Creates a new user in Firebase after checking if the user is not null*/
    public void createUser(){
        try {
            if (this.tango != null) {
                 //creates a user within the database using the firebase reference
                 mRef.createUser(this.tango.getEmail(), this.tango.getPassword(), new Firebase.ValueResultHandler<Map<String, Object>>() {
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
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    /*Authenticates a user attempting to sign into an existing account*/
    public void authenticateUser(){
        mRef.authWithPassword(this.tango.getEmail(), this.tango.getPassword(), new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                //determine if client or barber select intents to launch to next activities
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                //authentication error
            }
        });
    }
}
