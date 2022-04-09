package com.codeandroid.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codeandroid.app.Model.Dog;
import com.codeandroid.dogapp.R;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgDog;
    TextView tvBred, tvOrigin, tvTemper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();

        Intent intent= getIntent();
        Dog dog= intent.getParcelableExtra("dog");
        Glide.with(MainActivity2.this).load(dog.getUrl()).into(imgDog);
        tvBred.setText("Bred_for: "+dog.getBred_for());
        tvOrigin.setText("Origin: "+dog.getOrigin());
        tvTemper.setText("Temperament: "+ dog.getTemperament());
    }

    private void anhXa() {
        imgDog= findViewById(R.id.imgDog);
        tvBred= findViewById(R.id.tvBred_forDog);
        tvOrigin= findViewById(R.id.tvOrigin);
        tvTemper= findViewById(R.id.tvTemper);
    }
}