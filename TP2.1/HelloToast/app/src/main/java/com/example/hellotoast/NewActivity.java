package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.*;
import android.widget.*;
public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent= getIntent();
        String msg= intent.getStringExtra("msg");

        TextView text = findViewById(R.id.count_id);
        text.setText(msg);
    }
}