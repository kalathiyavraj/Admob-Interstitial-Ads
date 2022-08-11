package com.example.admobinterstitialads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        Button button = findViewById(R.id.dialogads);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdGoogle.getInstance().showInterDialog(MainActivity.this, MainActivity.this, new AdGoogle.MyCallback() {
                    @Override
                    public void callbackCall() {


                        Toast.makeText(MainActivity.this, "Ads Show :)", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}