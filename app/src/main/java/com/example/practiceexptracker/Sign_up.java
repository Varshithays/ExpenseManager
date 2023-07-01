package com.example.practiceexptracker;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity implements View.OnClickListener {
    EditText signupuser,signuppass,signupemail;
    Button signup;
    String regx="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$#@!&])[A-Za-z\\d!@#$&]{8,}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupuser = (EditText) findViewById(R.id.UserNameid);
        signupemail=(EditText) findViewById(R.id.Emailid);
        signuppass=(EditText) findViewById(R.id.Passwordid);
        signup = (Button) findViewById(R.id.signupbtn);
        signup.setOnClickListener(this);

        TextView signup=findViewById(R.id.Tosigninid);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sign_up.this,Sign_in.class);
                try {
                    startActivity(i);
                }
                catch (Exception e)
                {
                    // error catch
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        String username = signupuser.getText().toString();
        String emailid = signupemail.getText().toString();
        String password = signuppass.getText().toString();
        if(validatepass(password)){
            Toast.makeText(getBaseContext(),"valid password",Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle();
            bundle.putString("user",username);
            bundle.putString("email",emailid);
            bundle.putString("pass",password);
            Intent intent = new Intent(this,Sign_in.class);
            intent.putExtra("data",bundle);
            startActivity(intent);
        }
        else{
            Toast.makeText(getBaseContext(),"Invalid password",Toast.LENGTH_LONG).show();

        }
    }

    private boolean validatepass(String password) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}