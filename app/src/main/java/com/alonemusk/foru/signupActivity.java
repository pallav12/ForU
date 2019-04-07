package com.alonemusk.foru;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity {
    FirebaseAuth maut;
    EditText email;
    EditText password;
    String emai,pass;
    Button signup;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        maut=FirebaseAuth.getInstance();
        pd=new ProgressDialog(this);
        pd.setMessage("registering...");
        email=(EditText) findViewById(R.id.email);

        password=(EditText) findViewById(R.id.password);
        signup=(Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 emai=email.getText().toString().trim();
                 pass=email.getText().toString().trim();
                pd.show();
                register();


            }
        });


    }
    void register(){

        maut.createUserWithEmailAndPassword(emai,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pd.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(signupActivity.this,"Completed",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(signupActivity.this,"error",Toast.LENGTH_SHORT).show();


            }
        });


    }
}
