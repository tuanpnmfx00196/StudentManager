package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
                InsertData("http://10.248.136.62/android/insert.php");
                Intent intent = new Intent(AddStudent.this, MainActivity.class);
                startActivity(intent);
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
    /*=============================Insert==============================*/
    protected void InsertData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Insert success")) {
                    ToastMessage("Insert success");
                } else {
                    ToastMessage("ERROR");
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ToastMessage(error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("addName",edtName.getText().toString());
                    params.put("addBirthday",edtBirthday.getText().toString());
                    params.put("addAddress",edtAddress.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
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
