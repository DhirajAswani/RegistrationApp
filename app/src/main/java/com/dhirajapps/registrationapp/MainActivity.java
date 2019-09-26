package com.dhirajapps.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText first_name;
    private EditText last_name;
    private EditText address;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    Button register;

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);

        register = findViewById(R.id.button);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if(!checkDataEntered())
               {

               }
               else
               {
                   Intent intent = new Intent(MainActivity.this , second_activity.class);
                   startActivity(intent);
               }



            }


        });







    }

    public boolean checkDataEntered()
    {
        if (isEmpty(first_name)) {
            Toast.makeText(MainActivity.this, "You must enter first name to register!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (isEmpty(last_name)) {
            last_name.setError("Last name is required!");
            return false;
        }

        if (isEmpty(password)) {
            password.setError("Password is required!");
            return false;
        }

        if (isEmpty(confirm_password)) {
            confirm_password.setError("Confirm Password is required!");
            return false;
        }

        if(!password.getText().toString().equals(confirm_password.getText().toString()))
        {
            Toast.makeText(this, "Password and Confirm Password Doesn't match!!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            return false;
        }

        return true;

    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}



