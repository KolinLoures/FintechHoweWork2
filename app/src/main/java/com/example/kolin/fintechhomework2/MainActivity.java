package com.example.kolin.fintechhomework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bnt_open_share_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareActivity.start(MainActivity.this);
            }
        });

        findViewById(R.id.btn_open_result_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        findViewById(R.id.btn_open_flag_activity_single_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlagActivity.startActivitySingleTop(MainActivity.this);
            }
        });


        findViewById(R.id.btn_open_activity_new_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlagActivity.startActivityNewTask(MainActivity.this);
            }
        });


        findViewById(R.id.btn_open_activity_new_task_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlagActivity.startActivityNewTaskClearTop(MainActivity.this);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE)
                ((TextView) findViewById(R.id.text_result_activity)).setText(data.getStringExtra("text"));
        } else
            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
    }
}
