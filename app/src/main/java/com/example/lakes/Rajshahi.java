package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Rajshahi extends AppCompatActivity {
private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi2);
        listView=(ListView)findViewById(R.id.listi);
        final String [] rajshahi=getResources().getStringArray(R.array.largetree);
        ArrayAdapter<String>adapter =new ArrayAdapter<String>(Rajshahi.this,R.layout.sampletree,R.id.textid1,rajshahi);
             listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent =new Intent (Rajshahi.this,Mango.class);
                     Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent =new Intent (Rajshahi.this,Jack.class);
                    Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                } if(position==2)
                {
                    Intent intent =new Intent (Rajshahi.this,Mango.class);
                    Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent =new Intent (Rajshahi.this,woodapple.class);
                    Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }

                if(position==4)
                {
                    Intent intent =new Intent (Rajshahi.this,tamarind.class);
                     Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
            }
        });
    }
}