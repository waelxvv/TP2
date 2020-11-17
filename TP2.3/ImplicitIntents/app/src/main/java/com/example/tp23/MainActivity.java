package com.example.tp23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int TAKE_PICTURE = 1;
    private EditText mWebsiteEditText;
    private  EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri web = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, web);
        if(intent.resolveActivity(getPackageManager()) != null){ startActivity(intent);}
        else{ Log.d("ImplicitIntents", "Can't handle this!"); }
    }

    public void openLocation(View view) {
        String location = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" +location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else{
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_title)
                .setText(txt)
                .startChooser();
    }

    public void take_picture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, TAKE_PICTURE);
        } else{
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
}
