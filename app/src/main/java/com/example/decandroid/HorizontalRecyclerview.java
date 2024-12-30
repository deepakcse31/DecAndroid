package com.example.decandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerview extends AppCompatActivity {
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_horizontal_recyclerview);
        recyclerView=findViewById(R.id.rv_list);

        MyList[] myListData=new MyList[]{
                new MyList("Taskmo","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),

                new MyList("Conduent","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),

                new MyList("Google","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),

                new MyList("Micrsoft","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),

                new MyList("Amazon","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),

                new MyList("Taskmo","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
                new MyList("TechAhead","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
                new MyList("AppInventive","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
                new MyList("Infosys","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
                new MyList("TCS","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_)

        };

        HorizontalRecyclerViewAdapter recyclerViewAdapter=new HorizontalRecyclerViewAdapter(List.of(myListData),getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerViewAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}