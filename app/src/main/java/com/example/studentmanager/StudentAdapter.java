package com.example.studentmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.io.Serializable;
import java.text.CollationElementIterator;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList <Student> List;
    Context context;
    ImageButton btnDelete, btnEdit;
    private ItemClickListener itemClickListener;
    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        List = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(List.get(position).getName());
        holder.txtBirthday.setText(List.get(position).getBirthday()+"");
        holder.txtAddress.setText(List.get(position).getAddress());
    }
    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtBirthday, txtAddress;
        public ViewHolder (final View itemView){
            super (itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtBirthday = (TextView)itemView.findViewById(R.id.txtBirthday);
            txtAddress = (TextView)itemView.findViewById(R.id.txtAddress);
            btnEdit = (ImageButton)itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton)itemView.findViewById(R.id.btnDelete);
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 final Student student = List.get(getLayoutPosition());
                    Toast.makeText(context, student.getName().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,EditStudent.class);
                    intent.putExtra("transId", student.getId());
                    intent.putExtra("transName", student.getName());
                    intent.putExtra("transBirthday", student.getBirthday());
                    intent.putExtra("transAddress", student.getAddress());
                    context.startActivity(intent);
                }
            });
        }
    }


}
