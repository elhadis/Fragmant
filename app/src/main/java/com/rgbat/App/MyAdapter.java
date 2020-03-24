package com.rgbat.App;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.taskHolder>{

ArrayList<TASK>tasks;
OnItemClickListener listener;

    public MyAdapter(ArrayList<TASK> tasks,OnItemClickListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }
    public  void addTask(TASK task){
        tasks.add(task);
    }

    @NonNull
    @Override
    public taskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_custom,parent,false);
        taskHolder holder =new taskHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull taskHolder holder, int position) {
       // holder.tName.setText(tasks.get(position).getName());
        TASK task = tasks.get(position);
       holder.bind(task);

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class taskHolder extends RecyclerView.ViewHolder {
        TASK task;
        TextView tName;

        public taskHolder(@NonNull View itemView) {
            super(itemView);
            tName = itemView.findViewById(R.id.tv_main);
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   listener.onItemClick(task);
                }
        });
        }
       void bind(TASK task){
            this.task = task;
           tName.setText(task.getName());
        }
    }

}
