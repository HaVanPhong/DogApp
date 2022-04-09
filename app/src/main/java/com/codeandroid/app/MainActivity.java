package com.codeandroid.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.codeandroid.app.View.IOnClickDog;
import com.codeandroid.app.Controller.ApiService;
import com.codeandroid.app.Model.Dog;
import com.codeandroid.dogapp.R;
import com.codeandroid.app.View.DogAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    RecyclerView recyclerView;
    DogAdapter adapter;
    List<Dog> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rev);
        edtSearch= findViewById(R.id.edtSearch);
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();

        ApiService.control.getAllDog().enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if (response.isSuccessful()){
                    list= response.body();
                    adapter= new DogAdapter(list, MainActivity.this);
                    RecyclerView.LayoutManager layoutManager= new GridLayoutManager(MainActivity.this, 2, RecyclerView.VERTICAL, false);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);

                    adapter.setiOnClickDog(new IOnClickDog() {
                        @Override
                        public void iOnclickDog(Dog dog, int pos) {
                            Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("dog", (Parcelable) dog);
                            startActivity(intent);
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this, "API không phản hồi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str= editable.toString();
                List<Dog> dogSearch= new ArrayList<>();
                for (int i=0; i<list.size(); i++){
                    if (list.get(i).getName().contains(str)){
                        dogSearch.add(list.get(i));
                        adapter.setList(dogSearch);
                        recyclerView.setAdapter(adapter);
                    }
                }

            }
        });

    }
}