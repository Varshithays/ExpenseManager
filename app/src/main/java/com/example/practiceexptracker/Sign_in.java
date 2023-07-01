package com.example.practiceexptracker;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {
    EditText loginemail,loginpass;
    Button btnlogin;

    String email1,pass1;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        loginemail=(EditText) findViewById(R.id.signInEmailid);
        loginpass=(EditText) findViewById(R.id.signinPasswordid);
        btnlogin=(Button) findViewById(R.id.login);
        btnlogin.setOnClickListener(this);


        TextView signup=findViewById(R.id.Tosignupid);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new
                        Intent(Sign_in.this,Sign_up.class);
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
        Bundle bundle=getIntent().getBundleExtra("data");
        email1 = bundle.getString("email");
        pass1 = bundle.getString("pass");
        String email2=loginemail.getText().toString();
        String pass2 = loginpass.getText().toString();
        if (TextUtils.isEmpty(email2) || TextUtils.isEmpty(pass2)){
            Toast.makeText(Sign_in.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();

        }else if(email1.equals(email2) && pass1.equals(pass2) ){
            Toast.makeText(getBaseContext(),"login successful",Toast.LENGTH_LONG).show();
            Intent in=new Intent(Sign_in.this,MainActivity.class);
            startActivity(in);

        }else
        {
            count++;
            if(count==3){
                btnlogin.setEnabled(false);
            }
            Toast.makeText(getBaseContext(),"Login failed",Toast.LENGTH_LONG).show();
        }
    }


}