package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private Button loadDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        loadDataButton = findViewById(R.id.loadDataButton);
        loadDataButton.setOnClickListener(v -> loadData());
    }

    private void loadData() {
        Api apiService = RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<List<Post>> call = apiService.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> dataList = response.body();
                    adapter.setData(dataList); // 어댑터에 데이터 설정
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // API 호출 실패 시
                if (t.getMessage() != null) {
                    String errorMessage = t.getMessage();
                    Log.e("Network", "onFailure: " + t.getMessage());
                }
            }
        });
    }
}