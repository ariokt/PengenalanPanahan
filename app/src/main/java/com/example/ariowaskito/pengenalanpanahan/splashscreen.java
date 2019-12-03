package com.example.ariowaskito.pengenalanpanahan;

import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.widget.TextView;





public class splashscreen extends AppCompatActivity {
    TextView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        splash = (TextView) findViewById(R.id.splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashscreen.this, MainActivity.class));
                splashscreen.this.finish();
            }
        },4000);
    }
}
