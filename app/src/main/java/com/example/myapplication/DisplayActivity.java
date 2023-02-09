package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class DisplayActivity extends AppCompatActivity {
    private static int themeId = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(themeId);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button changeThemeButton = findViewById(R.id.change_theme_button);
        changeThemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (themeId == R.style.AppTheme) {
                    themeId = R.style.DarkTheme;
                } else {
                    themeId = R.style.AppTheme;
                }
                recreate();
            }
        });


        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        int age = intent.getIntExtra("AGE", 0);
        String sex = intent.getStringExtra("SEX");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameTextView = findViewById(R.id.name_text_view);
        nameTextView.setText("Name: " + name);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView ageTextView = findViewById(R.id.age_text_view);
        ageTextView.setText("Age: " + age);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView sexTextView = findViewById(R.id.sex_text_view);
        sexTextView.setText("Sex: " + sex);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button openThirdActivityButton = findViewById(R.id.open_third_activity_button);
        openThirdActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheme(themeId);
                setContentView(R.layout.activity_main);
                Intent intent = getIntent();
                ArrayList<String> data;
//                ArrayList<String> s = savedInstanceState.getStringArrayList("nameList");
                if (intent == null || intent.getStringArrayListExtra("nameList") == null) {
                    intent = new Intent(DisplayActivity.this, DisplayListActivity.class);
                    intent.putStringArrayListExtra("nameList", new ArrayList<>(Collections.singleton(name)));
                    intent.putIntegerArrayListExtra("ageList", new ArrayList<>(Collections.singleton(age)));
                    intent.putStringArrayListExtra("sexList", new ArrayList<>(Collections.singleton(sex)));
                } else {
                    data = intent.getStringArrayListExtra("nameList");
                    data.add(name);
                    intent.putStringArrayListExtra("nameList", data);
                }
                startActivity(intent);
            }
        });
    }
}