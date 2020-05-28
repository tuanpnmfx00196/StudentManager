package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class EditStudent extends AppCompatActivity {
    EditText editName, editBirthday, editAddress;
    Button saveEdit, cancelEdit;
    String idEdit, nameEdit, addressEdit;
    int birthdayEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        editName = (EditText) findViewById(R.id.editName);
        editBirthday = (EditText) findViewById(R.id.editBirthday);
        editAddress = (EditText) findViewById(R.id.editAddress);
        saveEdit = (Button)findViewById(R.id.saveEdit);
        cancelEdit = (Button)findViewById(R.id.cancelEdit);
        getDataEdit();
        MapLayout(nameEdit,birthdayEdit,addressEdit);
        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData("http://10.248.136.62/android/update.php");
                Intent intent = new Intent(EditStudent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    /*==================GET DATA====================*/
    private void getDataEdit(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle !=null){
            idEdit = bundle.getString("transId");
            nameEdit = bundle.getString("transName");
            birthdayEdit = bundle.getInt("transBirthday");
            addressEdit = bundle.getString("transAddress");
        }
    }
    private void MapLayout(String name, int birthday, String address){
        editName.setText(name);
        editBirthday.setText(birthday+"");
        editAddress.setText(address);
    }
    protected void updateData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Insert success")) {

                } else {

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams()throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id",idEdit);
                params.put("editName",editName.getText().toString());
                params.put("editBirthday",editBirthday.getText().toString());
                params.put("editAddress",editAddress.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
