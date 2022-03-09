package com.example.medicord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import android.util.Patterns;


public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    EditText email;
    EditText pass;
    Button login;
    Button clear;
    TextView forgotPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.loginButton);
        clear = (Button) findViewById(R.id.passwordButton);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = email.getText().toString();
                String password = pass.getText().toString();

                // checking if the entered text is empty or not.
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }

                // calling a method to login our user.
                loginUser(userName, password);
            }
        });



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear button clears the edit texts
                email.setText(" ");
                pass.setText(" ");
            }
        });



    }
    private void loginUser(String userName, String password) {
        if(!userName.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(userName).matches() && !password.isEmpty()){
            //intent pass hoga, login hone k baad and user will go to next activity
            Toast.makeText(getApplicationContext(), "User Logged in successfuly", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "User Logged in successfuly");

        }
        else{
            if(password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter the Password", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Please enter the Password");
            }

            else{
                Toast.makeText(getApplicationContext(), "Enter Valid UserName or Password", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Enter Valid UserName or Password");

            }
        }


    }//login method closing
}//AppCompact closing







