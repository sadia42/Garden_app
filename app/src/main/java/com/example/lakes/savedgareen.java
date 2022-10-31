package com.example.lakes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class savedgareen extends AppCompatActivity {
ImageView garden;
String img,uri,iupd;
Context context;
TextView home;
RecyclerView recyclerView;
 savedadapter saveadapt;
    DatabaseReference databasereference;
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
List<Upload> uploadlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedgareen);
        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAuth=FirebaseAuth.getInstance();
        firebaseUser= mAuth.getCurrentUser();
        uploadlist=new ArrayList<>();
        String profid=firebaseUser.getUid();
       garden=findViewById(R.id.wer);
        home=findViewById(R.id.gohome);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null) {
            iupd = bundle.getString("kp");
        }

//databasereference= FirebaseDatabase.getInstance().getReference("Upload").child(iupd);

        databasereference= FirebaseDatabase.getInstance().getReference().child("Upload").child(profid);

databasereference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        uploadlist.clear();
        for(DataSnapshot snapshot1:snapshot.getChildren()) {

            Upload upload = snapshot1.getValue(Upload.class);
            uploadlist.add(upload);


           // Glide.with(getApplicationContext()).load(upload.getImuri()).into(garden);
        }
        //saveadapt=new savedadapter(savedgareen.this,uploadlist);
        saveadapt= new savedadapter(savedgareen.this,uploadlist);
        recyclerView.setAdapter(saveadapt);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});


    }
}