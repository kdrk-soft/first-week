package com.kdrk.clickcounter1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.kdrk.clickcounter1.MainActivity.counter;
import static com.kdrk.clickcounter1.MainActivity.tvResult;

public class MainMenu extends Activity {
    private TextView  tvLarge;
    String count;
    private Button reset;
    int a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvLarge = findViewById(R.id.tvLarge);
        reset = findViewById(R.id.reset);
        count = getIntent().getStringExtra("count");
        tvLarge.setText(count);

    }

    public void onClickReset(View view) {
//        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra("exit1", 0);
        counter = 0;
        tvResult.setText("0");
        tvLarge.setText("0");

    }

}
