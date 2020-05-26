package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText edtName, edtBirthday, edtAddress;
    Button btnAdd, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);
        MapID();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO DO CLICK ADD
                ToastMessage("Insert data");
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO DO
                ToastMessage("Cancel");
            }
        });
    }
    public void MapID(){
        edtName = (EditText)findViewById(R.id.edtName);
        edtBirthday = (EditText)findViewById(R.id.edtBirthday);
        edtAddress = (EditText)findViewById(R.id.edtAddress);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCancel = (Button)findViewById(R.id.btnCancel);
    }
    public void ToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
