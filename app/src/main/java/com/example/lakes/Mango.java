package com.example.lakes;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Mango extends AppCompatActivity {
    private TextView ino,infod,cult,cultd;
    private static final String TAG = "Mango";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mango);
     //   info = findViewById(R.id.t1);

        ino = findViewById(R.id.infor);
        infod= findViewById(R.id.t2);

        cult= findViewById(R.id.cult);
        cultd = findViewById(R.id.cultdesc);
        additemsfromjson();
    }
    private void additemsfromjson() {
        try {
            String jsondata=readjsondatafromfile();
            JSONArray jsonArray=new JSONArray(jsondata);
            for (int i=0;i<jsonArray.length();++i){
                JSONObject itemobj=jsonArray.getJSONObject(i);
                String name=itemobj.getString("info");
                String infor=itemobj.getString("bookname");

                String cultivat=itemobj.getString("cult");
                String cultivatd=itemobj.getString("author");
                // String image=itemobj.getString("cover");
                Treejson Dramatic=new Treejson(name,infor,cultivat,cultivatd);

                ino.setText(Dramatic.getName());
                infod.setText(Dramatic.getInfo());
                cult.setText(Dramatic.getCulti());
                cultd.setText(Dramatic.getCultinfo());
            //    .setText(Dramatic.getName());
            ////    author.setText(Dramatic.getAuthor());
           ////     description.setText(Dramatic.getDescrip());
           //     ratings.setText(Dramatic.getRating());

            }
        }catch (Exception e){
            Log.d(TAG,"additemsfromjson",e);
        }
    }
    private String readjsondatafromfile() throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try {
            String jsonstring=null;
            inputStream=getResources().openRawResource(R.raw.mango);
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream,"UTF-8"));

            while ((jsonstring=bufferedReader.readLine())!=null){
                builder.append(jsonstring);
                // Toast.makeText(romance.this, "Please read", Toast.LENGTH_SHORT).show();

            }

        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }
        return new String(builder);
    }

}