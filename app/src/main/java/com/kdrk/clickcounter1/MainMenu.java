package com.kdrk.clickcounter1;

import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;

public class MainMenu extends Activity {
    private TextView  tvLarge;
    String count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvLarge = findViewById(R.id.tvLarge);
        count = getIntent().getStringExtra("count");
        tvLarge.setText(count.toString());

    }


}
