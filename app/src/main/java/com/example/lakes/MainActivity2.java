package com.example.lakes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.OnClick;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

  private   EditText fp,tp;
private Button en_b;

DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
databaseReference = FirebaseDatabase.getInstance().getReference("trees");
        setContentView(R.layout.activity_main2);

        fp= (EditText)findViewById(R.id.edit1);
        en_b=(Button)findViewById(R.id.e_button);
      //  sp= (EditText)findViewById(R.id.edit2);
        tp= (EditText)findViewById(R.id.edit3);
       en_b.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
   saveData();
    }

    private void saveData() {
        String name=fp.getText().toString().trim();
        String distance=tp.getText().toString().trim();

       String  key= databaseReference.push().getKey();
       trees tree =new trees(name,distance);
       databaseReference.child(key).setValue(tree);



    }

}
