package com.example.decandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ApiService apiService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.rv_list);
        progressBar=findViewById(R.id.progrss_bar);
        apiService=ApiClient.getClient().create(ApiService.class);


//        MyList[] myListData=new MyList[]{
//                new MyList("Taskmo","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//
//                new MyList("Conduent","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//
//                new MyList("Google","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//
//                new MyList("Micrsoft","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//
//                new MyList("Amazon","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//
//                new MyList("Taskmo","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//                new MyList("TechAhead","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//                new MyList("AppInventive","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//                new MyList("Infosys","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_),
//                new MyList("TCS","Taskmo is a B2B Company",R.drawable.onx_logo_wallpaper__1_)
//
//        };

//        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(List.of(myListData),getApplicationContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(recyclerViewAdapter);
        fetchGet();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void fetchGet(){
        Call<List<Repository>> call=apiService.getList();
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
             if (response.isSuccessful()){
                 progressBar.setVisibility(View.GONE);
                 List<Repository> repositories = response.body();
                 RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(repositories,getApplicationContext());
                 recyclerView.setHasFixedSize(true);
                 recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                 recyclerView.setAdapter(recyclerViewAdapter);

             }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {

            }
        });
    }
}