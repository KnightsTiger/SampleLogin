package com.xsample.samplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText editText;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = new DatabaseHelper(this);
    }

    public void update(View view) {
        editText = findViewById(R.id.editText3);
        String updatedPassword  = editText.getText().toString().trim();
        updatevalues(updatedPassword);
    }

    private void updatevalues(String updatedPassword) {
        if(!updatedPassword.isEmpty()){
            if(db.updatevalues("saman","updatedPassword")){
                Toast.makeText(this, "Updated successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
