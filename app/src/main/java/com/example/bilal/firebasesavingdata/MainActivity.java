package com.example.bilal.firebasesavingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAdd;
    Spinner spinJob;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName=(EditText) findViewById(R.id.editTextName);
        btnAdd=(Button) findViewById(R.id.btnAddName);
        spinJob=(Spinner)findViewById(R.id.spinner);
        databaseReference= FirebaseDatabase.getInstance().getReference("name");


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             addName();
            }
        });
    }

    private void addName()
    {
        String name=etName.getText().toString().trim();
        String job=spinJob.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name)){

        String id=databaseReference.push().getKey();
            Name newname=new Name(id,name,job);
         databaseReference.child(id).setValue(newname);
            Toast.makeText(getApplicationContext(),"new Name added",Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getApplicationContext(),"please enter a name",Toast.LENGTH_SHORT).show();

        }

    }
}
