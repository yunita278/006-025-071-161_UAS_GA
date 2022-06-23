package com.example.a006025071161_uasga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lihatlokasi(View view) {
            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);
    }

    public void tambahlapor(View view) {
        Intent intent = new Intent(MainActivity.this, Tambah_Laporan.class);
        startActivity(intent);
    }
}