package com.example.secretdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.secretdiary.db.StoryHelper;

public class AddUpdateActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtTitle, edtDescription;
    private boolean isEdit = false;
    private Parcelable[] story;
    private int position;
    private StoryHelper storyHelper;

    public static final String EXTRA_STORY = "extra_story";
    public static final String EXTRA_POSITION = "extra_position";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;
    public static final int REQUEST_UPDATE = 200;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private final int ALERT_DIALOG_CLOSE = 10;
    private final int ALERT_DIALOG_DELETE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update);

        edtTitle = findViewById(R.id.edt_title);
        edtDescription = findViewById(R.id.edt_description);
        Button btnSubmit = findViewById(R.id.btn_submit);

//        btnKembali = (Button) findViewById(R.id.btn_kembali);
//        btnKembali.setOnClickListener((View.OnClickListener) this);

        StoryHelper = StoryHelper.getInstance(getApplicationContext());
        storyHelper.open();

        story = getIntent().getParcelableArrayExtra(EXTRA_STORY);
        if (story != null){
            position = getIntent().getIntExtra(EXTRA_POSITION, 0);
            isEdit = true;
        } else {
            story = new Story();
        }
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_kembali:
            Intent intent = new Intent(AddUpdateActivity.this, MainActivity.class);
            startActivity(intent);

        }
    }
}
