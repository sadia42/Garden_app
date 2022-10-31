package com.example.lakes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profile extends Fragment {


Button edit_profile;
TextView fields;
ImageButton saved_fileds;
FirebaseUser firebaseuser;
String profileid;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profile, container, false);
        firebaseuser= FirebaseAuth.getInstance().getCurrentUser() ;
        SharedPreferences prefs = getContext().getSharedPreferences(("preeps"), Context.MODE_PRIVATE);
        profileid=prefs.getString("profileid","none");

        saved_fileds=view.findViewById(R.id.saved_fields);
        fields=view.findViewById(R.id.fields);
getFieldnum();
        edit_profile.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                String btn= edit_profile.getText().toString();
                if(btn.equals("Edit Profile"))
                {

                }



            }
        });
        return view;
    }
private void getFieldnum()
{
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Upload");
    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            int i=0;
            for(DataSnapshot snapshot1: snapshot.getChildren()){
                Upload uploads=snapshot.getValue(Upload.class);
                i++;

                }
            fields.setText(""+i);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
}
}