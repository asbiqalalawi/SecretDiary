package com.example.secretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        Button btnOke = (Button) findViewById(R.id.btn_oke);
        btnOke.setOnClickListener(this);

        TextView TvLupaPass = (TextView) findViewById(R.id.lupaPass);
        TvLupaPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_oke:
                Intent oke = new Intent(PasswordActivity.this, MainActivity.class);
                startActivity(oke);
                break;
            case R.id.lupaPass:
                Intent lupaPass =  new Intent(PasswordActivity.this, MoodFragment.class);
                startActivity(lupaPass);
                break;
        }
    }
}