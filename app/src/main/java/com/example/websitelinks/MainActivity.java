package com.example.websitelinks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);
        editText3 = (EditText) findViewById(R.id.edit3);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void goPhoto(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                String s = editText1.getText().toString();
                Uri uri = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                if (intent.resolveActivity(getPackageManager())!=null) startActivity(intent);
                break;
            }
            case R.id.button2: {
                String s = editText2.getText().toString();
                Uri uri = Uri.parse("geo:0,0?q="+s);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                if (intent.resolveActivity(getPackageManager())!=null) startActivity(intent);
                break;
            }
            case R.id.button3: {
                String txt = editText3.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType(mimeType)
                        .setText(txt)
                        .startChooser();
                break;
            }
        }
    }
}