package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choosetrees extends AppCompatActivity {
Button large,medium,small;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosetrees);
        large=findViewById(R.id.large);

        small=findViewById(R.id.small);
        large.setOnClickListener((View.OnClickListener)view ->{
                    Intent inten = new Intent (choosetrees.this,First.class);
                    inten.putExtra("L",10);
                    startActivity(inten);
                }
        );

        small.setOnClickListener((View.OnClickListener)view ->{
                    Intent inten = new Intent (choosetrees.this,First.class);
                    inten.putExtra("L",6);
                    startActivity(inten);
                }
        );
    }
}