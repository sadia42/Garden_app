package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class trial extends AppCompatActivity {
    Context context;

    RecyclerView recyclerView;
   CostAdapter costadapt;


    int r,t,i,k;
    String pl1,pl2,pl3;

    int g,h,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            r=bundle.getInt("y");
            t=bundle.getInt("te");
            k=bundle.getInt("ry");

            g=bundle.getInt("a");
            h=bundle.getInt("b");
            j=bundle.getInt("c");

            pl1=bundle.getString("n");
            pl2=bundle.getString("e");
            pl3=bundle.getString("m");
            Toast.makeText(getApplicationContext(),"first:"+g,Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"second:"+h, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"third:"+j,Toast.LENGTH_LONG).show();

        }
        if(r>0 && t>0 && k>0)
        {
            i=3;
        }
        else if(r>0 && t>0)
            i=2;
        else
            i=1;
       
        costadapt= new CostAdapter(trial.this,pl1,pl2,pl3,r,t,k,g,h,j,i);
        recyclerView.setAdapter(costadapt);

    }
}