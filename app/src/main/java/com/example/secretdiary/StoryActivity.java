package com.example.secretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StoryActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Button btnKembali = (Button) findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_kembali:
            Intent btn_kembali = new Intent(StoryActivity.this, MainActivity.class);
            startActivity(btn_kembali);

        }
    }
}
