package com.example.ariowaskito.pengenalanpanahan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class peralatan extends AppCompatActivity {
Button Btnlist, Btngambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peralatan);

        Btnlist=(Button)findViewById(R.id.btnlist);
        Btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(peralatan.this, listTittle.class);
                startActivity(i);
            }
        });

        Btngambar=(Button)findViewById(R.id.btngambar);
        Btngambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(peralatan.this, gambarperalatan.class);
                startActivity(j);
            }
        });
    }
}
