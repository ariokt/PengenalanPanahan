package com.example.ariowaskito.pengenalanpanahan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Pendahuluan extends AppCompatActivity {
ImageView pengertian, sejarah, prestasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendahuluan);


        pengertian = (ImageView) findViewById(R.id.pengertian);
        pengertian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Pendahuluan.this, Pengertian.class);
                startActivity(j);
            }
        });

        sejarah = (ImageView) findViewById(R.id.sejarah);
        sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Pendahuluan.this, Sejarah.class);
                startActivity(j);
            }
        });

        prestasi = (ImageView) findViewById(R.id.prestasi);
        prestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Pendahuluan.this, Prestasi.class);
                startActivity(j);
            }
        });


    }
}
