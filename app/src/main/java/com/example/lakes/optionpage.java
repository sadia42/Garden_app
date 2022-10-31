package com.example.lakes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class optionpage extends AppCompatActivity {
LinearLayout op1,op2,op3;
 String userid,m;
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databref;
    StorageReference storef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionpage);
        ////mAuth=FirebaseAuth.getInstance();
       //// firebaseUser= mAuth.getCurrentUser();
      //  userid=firebaseUser.getUid();
      //  databref = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
        op1=findViewById(R.id.histo);
        op2=findViewById(R.id.design);
        op3=findViewById(R.id.treprof);
      /* databref.addValueEventListener(new ValueEventListener() {
        @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                area Area =snapshot.getValue(area.class);
                m=Area.getArea();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        op1.setOnClickListener((View.OnClickListener)view ->{
            Intent inten = new Intent (optionpage.this,savedgareen.class);
                startActivity(inten);
                }
        );
        op2.setOnClickListener((View.OnClickListener)view ->{
                    Intent in = new Intent (optionpage.this,choosetrees.class);

                    startActivity(in);

                }
        );
        op3.setOnClickListener((View.OnClickListener)view -> {
             Intent tys = new Intent (optionpage.this,endit.class);
             startActivity(tys);

        } );



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
}