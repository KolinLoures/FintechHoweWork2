package com.example.kolin.fintechhomework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final EditText editText = findViewById(R.id.edit_text_result_activity);

        findViewById(R.id.btn_result_activity_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

        findViewById(R.id.btn_result_activity_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    setResult(RESULT_OK, new Intent().putExtra("text", text));
                    finish();
                }
                else
                    Toast.makeText(ResultActivity.this, "Empty text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
