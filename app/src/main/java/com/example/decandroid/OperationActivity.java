package com.example.decandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {

    EditText edtfirstno,edtsecondno;
    Button btnadd;
    TextView tvresult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);
        edtfirstno=findViewById(R.id.edtfirstno);
        edtsecondno=findViewById(R.id.edtsecondno);
        btnadd=findViewById(R.id.btnadd);
        tvresult=findViewById(R.id.tvresult);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstno=edtfirstno.getText().toString();
                String secondno=edtsecondno.getText().toString();
                int a=Integer.parseInt(firstno);
                int b=Integer.parseInt(secondno);
                int c=add(a,b);
                tvresult.setText(String.valueOf(c));

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int add(int a,int b){

        return a+b;
    }
}