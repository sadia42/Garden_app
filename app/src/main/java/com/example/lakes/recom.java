package com.example.lakes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class recom extends AppCompatActivity {
private RecyclerView mRecyclerView;
private List<Object>viewitem =new ArrayList<>();
private RecyclerView.Adapter mAdapter;
private RecyclerView.LayoutManager layoutManager;
    private static final String TAG = "recom";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recom);


        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);


        layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
mAdapter=new jsonadapter(this,viewitem);

        mRecyclerView.setAdapter(mAdapter);
addItemFromJSON();

    }

    private void addItemFromJSON() {
        try{
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray=new JSONArray(jsonDataString);
            for(int i=0;i<jsonArray.length();++i)
            {
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String name = itemObj.getString("name");
                String info =itemObj.getString("info");
                rectree RTree =new rectree(name,info);
                viewitem.add(RTree);


            }

        } catch (JSONException | IOException e) {
            Log.d(TAG,"addItemsFromJson:",e);
        }
    }
    private String readJSONDataFromFile() throws IOException
    {

        InputStream input=null;
        StringBuilder builder =new StringBuilder();
        try {
            String jsonString =null;
            input=getResources().openRawResource(R.raw.rajshahi);
            BufferedReader bufferReader=new BufferedReader(
                new InputStreamReader(input,"UTF-8"));
                while((jsonString=bufferReader.readLine())!=null)
{
    builder.append(jsonString);
}
            }
            finally
            {
                if(input !=null)
                {
                    input.close();
                }
            }
            return new String(builder);

        }
    }
