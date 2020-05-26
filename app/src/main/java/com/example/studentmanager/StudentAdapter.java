package com.example.studentmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList <Student> StudentList;
    Context context;
    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        StudentList = studentList;
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
        holder.txtName.setText(StudentList.get(position).getName());
        holder.txtBirthday.setText(StudentList.get(position).getBirthday()+"");
        holder.txtAddress.setText(StudentList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return StudentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtBirthday, txtAddress;
        public ViewHolder (View itemView){
            super (itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtBirthday = (TextView)itemView.findViewById(R.id.txtBirthday);
            txtAddress = (TextView)itemView.findViewById(R.id.txtAddress);
        }
    }


}
