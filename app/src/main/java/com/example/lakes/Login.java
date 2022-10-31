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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText loginemail,loginpassword;
    private TextView signup;
    private Button login;
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        loginemail=findViewById(R.id.editText1);
        loginpassword=findViewById(R.id.editText2);
        signup=findViewById(R.id.signuptext);
        login=findViewById(R.id.button);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);

}

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:
                userLogin();
                break;

            case R.id.signuptext:
                Intent tm =new Intent(Login.this,Signup.class);
                startActivity(tm);
        }

    }

    private void userLogin() {
        String email=loginemail.getText().toString().trim();
        String password=loginpassword.getText().toString().trim();
        if(email.isEmpty())
        {    loginemail.setError("enter your email address");
            loginpassword.requestFocus();
            return;
        }
        if(password.isEmpty())
        { loginpassword.setError("enter a password");
            loginpassword.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            loginpassword.setError(("Minimum length of password should be 8 charcaters"));
           loginpassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    DatabaseReference refere = FirebaseDatabase.getInstance().getReference().child("Users").
                            child(mAuth.getCurrentUser().getUid());
                    Intent go =new Intent(Login.this,optionpage.class);
                    go.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(go);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unsuccessful Login",Toast.LENGTH_SHORT).show(); }
                }


        });

    }


}