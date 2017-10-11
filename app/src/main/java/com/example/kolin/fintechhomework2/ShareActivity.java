package com.example.kolin.fintechhomework2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ((EditText) findViewById(R.id.edit_share_text)).getText().toString();
                if (!s.isEmpty())
                    shareText(s);
                else
                    Toast.makeText(ShareActivity.this, "Empty text", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ShareActivity.class);
        context.startActivity(intent);
    }

    private void shareText(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
