package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayListActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        linearLayout = findViewById(R.id.linear_layout);

        ArrayList<String> nameList = getIntent().getStringArrayListExtra("nameList");
        ArrayList<Integer> ageList = getIntent().getIntegerArrayListExtra("ageList");
        ArrayList<String> sexList = getIntent().getStringArrayListExtra("sexList");

        for (int i = 0; i < 20; i++) {
            TextView nameTextView = new TextView(this);
            nameTextView.setText("Name: " + nameList.get(0));
            linearLayout.addView(nameTextView);

            TextView ageTextView = new TextView(this);
            ageTextView.setText("Age: " + ageList.get(0));
            linearLayout.addView(ageTextView);

            TextView sexTextView = new TextView(this);
            sexTextView.setText("Sex: " + sexList.get(0));
            linearLayout.addView(sexTextView);

            View dividerView = new View(this);
            dividerView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            dividerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2));
            linearLayout.addView(dividerView);
        }
    }
}