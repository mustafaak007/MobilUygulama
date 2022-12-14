package com.example.yeapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yeapp.R;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Button button = (Button) findViewById(R.id.button4);


    }

    public void getGithub(View view){
        Intent gitHub=new Intent(Intent.ACTION_VIEW   );
        gitHub.setData(Uri.parse("https://github.com/mustafaak007/MobilUygulama"));
        startActivity(gitHub);
    }

}