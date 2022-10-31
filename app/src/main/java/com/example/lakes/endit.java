package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class endit extends AppCompatActivity {
    private Button dhaka,rajshahi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endit);

        dhaka = findViewById(R.id.kln1);
        rajshahi= findViewById(R.id.bar1);

        dhaka.setOnClickListener((View.OnClickListener) view -> {
                    Intent inten = new Intent(endit.this, Dhaka.class);

                    startActivity(inten);
                }
        );
        rajshahi.setOnClickListener((View.OnClickListener) view -> {
                    Intent inten = new Intent(endit.this, Rajshahi.class);

                    startActivity(inten);
                }
        );
    }
}