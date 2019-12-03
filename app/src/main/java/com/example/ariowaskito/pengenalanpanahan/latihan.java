package com.example.ariowaskito.pengenalanpanahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class latihan extends AppCompatActivity {
    Spinner spinlat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);
        spinlat=findViewById(R.id.spinner1);

        spinlat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int a, long b) {
                String latihan = String.valueOf(adapterView.getSelectedItem());
                if (adapterView.getSelectedItem().toString().equalsIgnoreCase("Archery Club")){

                    Toast.makeText(getApplicationContext(), "Anda belum memilih Archery Club !!", Toast.LENGTH_SHORT).show();
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("1. Jakarta Archery Club")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Archery Club "+latihan,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(latihan.this, club1.class);
                    startActivity(i);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("2. DSR TMII Archery Club")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Archery Club "+latihan,Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(latihan.this, club2.class);
                    startActivity(j);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Anda memilih Archery Club "+latihan,Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(latihan.this, club3.class);
                    startActivity(k);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}

