package com.xsample.samplelogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editTextemail, editTextpassword;

    DatabaseHelper db;

    String mail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHelper(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        editTextemail = findViewById(R.id.username);
        editTextpassword = findViewById(R.id.loginpassword);
    }


    public void canlog(View view) {
        mail=editTextemail.getText().toString().trim();
        password = editTextpassword.getText().toString().trim();
        if (isEmpty(mail, password)) {
            if (db.letlogin(mail, password)) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean isEmpty(String mail, String password) {
        return !mail.isEmpty() && !password.isEmpty();
    }
}
