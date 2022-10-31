package com.example.lakes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Signup extends AppCompatActivity implements View.OnClickListener{
    private EditText email,password,name,div;
    private Button signup;
    private TextView Goback;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
            name=(EditText)findViewById(R.id.name);
            email=(EditText)findViewById(R.id.signupemail);
            password=(EditText)findViewById((R.id.signuppassword));
        div=(EditText)findViewById((R.id.area));
            signup=(Button)findViewById(R.id.signup);
            Goback=(TextView) findViewById(R.id.goback);

            mAuth=FirebaseAuth.getInstance();
            progressbar=findViewById(R.id.progressbarid);
            signup.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.signup:
                    userRegister();
                    break;
                case R.id.goback:
                {

                    break;

                }

            }

        }

       private void userRegister() {
            String remail=email.getText().toString().trim();
            String rpassword=password.getText().toString().trim();
            String rname=name.getText().toString().trim();
            String rdivision=div.getText().toString().trim();
            if(remail.isEmpty())
            {    email.setError("enter your email address");
                password.requestFocus();
                return;
            }
            if(rpassword.isEmpty())
            { password.setError("enter a password");
                password.requestFocus();
                return;
            }
           if(rname.isEmpty())
           { password.setError("Enter Your name");
               password.requestFocus();
               return;
           }
            if(rpassword.length()<8)
            {
                password.setError(("Minimum length of password should be 8 charcaters"));
                password.requestFocus();
                return;
            }
            progressbar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(remail,rpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressbar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                       FirebaseUser firebaseUser= mAuth.getCurrentUser();
                       String userid=firebaseUser.getUid();
                       reference = FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
                       HashMap<String,Object> hashmap= new HashMap<>();

                       hashmap.put("id",userid);
                        hashmap.put("username",rname.toLowerCase());
                       hashmap.put("email",firebaseUser.getEmail());
                        hashmap.put("area",rdivision.toLowerCase());
                        area Area=new area(rdivision.toLowerCase());
                       reference.setValue(hashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful())
                               {
                                   progressbar.setVisibility(View.INVISIBLE);
                                   Intent intent=new Intent(Signup.this,optionpage.class);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                                   startActivity(intent);
                               }

                           }
                       });
                        Toast.makeText(getApplicationContext(),"Registeration is succesful",Toast.LENGTH_SHORT).show();

                    } else{
                        if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            Toast.makeText(getApplicationContext(),"Already Registered",Toast.LENGTH_SHORT).show(); }
                        else
                        {{
                            Toast.makeText(getApplicationContext(),"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show(); }

                        }
                    }

                }
            });
        }
    }

