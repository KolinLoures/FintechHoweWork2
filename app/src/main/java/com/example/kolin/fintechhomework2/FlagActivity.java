package com.example.kolin.fintechhomework2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FlagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        findViewById(R.id.flag_activity_btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivitySingleTop(FlagActivity.this);
            }
        });
    }

    public static void startActivityNewTask(Context context) {
        Intent starter = new Intent(context, FlagActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    public static void startActivitySingleTop(Context context){
        Intent starter = new Intent(context, FlagActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(starter);
    }

    public static void startActivityNewTaskClearTop(Context context) {
        Intent starter = new Intent(context, FlagActivity.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(this, "NEW INTENT HERE", Toast.LENGTH_SHORT).show();
    }
}
