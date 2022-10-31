package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Dhaka extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);
        listView=(ListView)findViewById(R.id.listi);
        final String [] dhaka=getResources().getStringArray(R.array.smalltree);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(Dhaka.this,R.layout.sampletree,R.id.textid1,dhaka);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent =new Intent (Dhaka.this,Jack.class);
                    Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent =new Intent (Dhaka.this,Mango.class);
                    Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();

                    startActivity(intent);
                }
            }
        });
    }
}