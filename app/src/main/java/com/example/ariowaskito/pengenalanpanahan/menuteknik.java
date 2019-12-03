package com.example.ariowaskito.pengenalanpanahan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class menuteknik extends AppCompatActivity {
    Spinner spinteknik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuteknik);
        spinteknik=findViewById(R.id.spinner1);

        spinteknik.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int a, long b) {
                String teknik = String.valueOf(adapterView.getSelectedItem());
                if (adapterView.getSelectedItem().toString().equalsIgnoreCase("Teknik Dasar")){

                    Toast.makeText(getApplicationContext(), "Anda belum memilih Teknik Dasar !!", Toast.LENGTH_SHORT).show();
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("1. Stance")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(menuteknik.this, stance.class);
                    startActivity(i);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("2. Nocking")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(menuteknik.this, nocking.class);
                    startActivity(j);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("3. Set-up")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(menuteknik.this, setup.class);
                    startActivity(k);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("4. Drawing")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent l = new Intent(menuteknik.this, drawing.class);
                    startActivity(l);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("5. Anchoring")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent m = new Intent(menuteknik.this, anchoring.class);
                    startActivity(m);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("6. Tighten")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent n = new Intent(menuteknik.this, tighten.class);
                    startActivity(n);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("7. Aiming")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent o = new Intent(menuteknik.this, aiming.class);
                    startActivity(o);
                }
                else if(adapterView.getSelectedItem().toString().equalsIgnoreCase("8. Release")) {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent p = new Intent(menuteknik.this, release.class);
                    startActivity(p);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Anda memilih Teknik Dasar "+teknik,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(menuteknik.this, afterhold.class);
                    startActivity(i);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
