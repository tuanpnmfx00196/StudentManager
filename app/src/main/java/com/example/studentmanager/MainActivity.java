package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> StudentList;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new StudentAdapter(StudentList,MainActivity.this);
        StudentList = new ArrayList<>();
        ReadJSON("http://10.248.136.62/android/getdata.php");
    }
    /*======================Menu==========================*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    /*===============Click listener Menu==================*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                Intent intent = new Intent(MainActivity.this, AddStudent.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /*======================READ JSON==========================*/
    private void ReadJSON(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                StudentList.add(new Student(
                                        jsonObject.getString("ID"),
                                        jsonObject.getString("Name"),
                                        jsonObject.getInt("Birthday"),
                                        jsonObject.getString("Address")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Size arraylist"+StudentList.size(), Toast.LENGTH_SHORT).show();
                        initView();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    /*======================INIT RECYCLERVIEW==========================*/

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        StudentAdapter studentAdapter = new StudentAdapter(StudentList, getApplicationContext());
        recyclerView.setAdapter(studentAdapter);
    }
}
