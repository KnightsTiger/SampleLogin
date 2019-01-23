package com.xsample.samplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText editTextEmail,editTextPassword,editTextCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
    }

    public void register(View view) {
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextCPassword = findViewById(R.id.cpassword);

        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        String cpassword  = editTextCPassword.getText().toString().trim();

        if(email.equals("")||password.equals("")||cpassword.equals("")){
            Toast.makeText(this, "Please add infor", Toast.LENGTH_SHORT).show();
        }else {
            if(password.equals(cpassword)){
                boolean checkmail= db.checkmail(email);
                if(checkmail==true){
                    boolean insert = db.insert(email,password);
                    if(insert==true){
                        Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "Not saved ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Email already registerd", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "password not matching", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void goTOLogin(View view) {
        startActivity(new Intent(this,Login.class));
    }

    public void goUpdate(View view) {
        startActivity(new Intent(this,Update.class));
    }
}
