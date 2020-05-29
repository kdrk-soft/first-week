package com.kdrk.clickcounter1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    public int counter = 0;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        LoadInt();
        tvResult.setText(Integer.toString(counter));


    }
    public void SaveInt(String key, int counter){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, counter); editor.commit();
    }

    public void LoadInt() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        counter = sharedPreferences.getInt("key", counter);
    }


    public void init(){
        tvResult = findViewById(R.id.tvResult);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = new Intent(MainActivity.this, MainMenu.class);

        i.putExtra("count", counter+"");
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }

    public void onClickCount(View view) {
        counter++;
        tvResult.setText(Integer.toString(counter));


    }
    @Override
    protected void onStop() {
        SaveInt("key", counter);
        super.onStop();
    }
}
