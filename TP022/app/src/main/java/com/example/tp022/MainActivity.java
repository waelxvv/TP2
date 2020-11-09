package com.example.tp022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    TextView mshowCount;
    EditText editText;
    int mCount=0;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mshowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mshowCount.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mshowCount= findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");

            if (isVisible) {
                mshowCount.setVisibility(View.VISIBLE);
                mshowCount.setText(savedInstanceState.getString("reply_text"));
                mshowCount.setVisibility(View.VISIBLE);

                editText.setVisibility(View.VISIBLE);
                editText.setText(savedInstanceState.getString("reply_text"));
                editText.setVisibility(View.VISIBLE);
            }
        }
    }

    public void countButton(View view) {
        mCount++;
        if (mshowCount !=null)
            mshowCount.setText(Integer.toString(mCount));
    }
}