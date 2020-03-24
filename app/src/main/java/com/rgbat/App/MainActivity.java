package com.rgbat.App;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView list;
    private Button btn;
    MyAdapter adapter;
    ArrayList<TASK> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn=findViewById(R.id.btn_main);
list=findViewById(R.id.lis);

        list.setLayoutManager(new LinearLayoutManager(this));
        list.setHasFixedSize(true);
        tasks = new ArrayList<>();


        adapter = new MyAdapter(tasks, new OnItemClickListener() {
            @Override
            public void onItemClick(TASK task) {
                Bundle bundle = new Bundle();
                bundle.putString("name",task.getName());
                AddFragment fragment = new AddFragment();
                fragment.setArguments(bundle);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame,fragment);
                ft.commit();
            }
        });
        list.setAdapter(adapter);
        tasks.add(new TASK("ALMA"));
        tasks.add(new TASK("AHMED"));
        tasks.add(new TASK("AVIAD"));
        tasks.add(new TASK("REHAM"));
        tasks.add(new TASK("AVIAD"));
        tasks.add(new TASK("AVIAD"));
        tasks.add(new TASK("AVIAD"));

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,addActivity.class);
       startActivityForResult(intent,2);
      //  startActivity(intent);
    }
});

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == 2){
            TASK t = (TASK)data.getSerializableExtra("name");
            adapter.addTask(t);
            adapter.notifyDataSetChanged();
        }
    }
}
