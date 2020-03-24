package com.rgbat.App;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {
Button btn;
EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        et_name =findViewById(R.id.et_add_task);
        btn =findViewById(R.id.btn_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();

                Intent intent = new Intent();
                TASK task = new TASK(name);

                intent.putExtra("name",task);
                setResult(2,intent);
                finish();
            }
        });
    }
}
