package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class First extends AppCompatActivity implements View.OnClickListener {
    private   EditText fp,sp,tp,c,r;
    private Button en_b;
FirebaseAuth mAuth;
String aq,sq,mq,cols,rows;
int k1,k2,k3,dist;
    DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
mAuth=FirebaseAuth.getInstance();
        dataref=FirebaseDatabase.getInstance().getReference("Trees");

        fp= (EditText)findViewById(R.id.edit1);
        en_b=(Button)findViewById(R.id.e_button);
        sp= (EditText)findViewById(R.id.edit2);
        tp= (EditText)findViewById(R.id.edit3);
        c= (EditText)findViewById(R.id.col);
        r= (EditText)findViewById(R.id.row);
        en_b.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
       // savedata();
        aq =fp.getText().toString();
        sq = sp.getText().toString();
        mq = tp.getText().toString();
        rows = r.getText().toString();
        cols = c.getText().toString();
        if(aq.equals(" "))
            k1=0;
        if(sq.equals(" "))
            k2=0;
        if(mq.equals(" "))
            k3=0;
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            dist=bundle.getInt("L");

        }
        //Toast.makeText(getApplicationContext(),"first:"+dist,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(First.this,entry.class);
       intent.putExtra("key",aq);
        intent.putExtra("tey",sq);   intent.putExtra("rey",mq);
        intent.putExtra("row",rows);  intent.putExtra("column",cols);

        intent.putExtra("f",k1);
        intent.putExtra("s",k2);  intent.putExtra("t",k3);
        intent.putExtra("qw",dist);

        //Toast.makeText(getApplicationContext(),"swapped:"+aq,Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulayout, menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.signout)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void savedata()
    {
        String  name =fp.getText().toString().trim();
        // String  cost = sp.getText().toString().trim();
        String  distance = tp.getText().toString().trim();
        String key = dataref.push().getKey();

        trees trees=new trees(name,distance);
        dataref.child(key).setValue(trees);
    }

}