package com.example.decandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtmobileno,edtpassword;
    Button btnlogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtmobileno=findViewById(R.id.edtmobileno);
        edtpassword=findViewById(R.id.edtpassword);
        btnlogin=findViewById(R.id.btnsubmit);

        SharedPreferences sharedPreferences=getSharedPreferences("onx",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sharedPreferences.edit();



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileno=edtmobileno.getText().toString();
                String password=edtpassword.getText().toString();

                if (mobileno.equals("9876543210") && password.equals("123456"))
                {

                    myedit.putString("loginstatus","true");
                    myedit.apply();
                    finish();
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }
                else {

                Toast.makeText(getApplicationContext(),"Please Enter Correct Credentials",Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(getApplicationContext(),mobileno+" "+password,Toast.LENGTH_LONG).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}