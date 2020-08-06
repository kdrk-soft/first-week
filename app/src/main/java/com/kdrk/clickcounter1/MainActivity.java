package com.kdrk.clickcounter1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static TextView tvResult;
    public static int counter = 0;

    SharedPreferences sharedPreferences;
    private Animation anim;
    private ImageView viewAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        LoadInt();
//        Bundle passedDate = getIntent().getExtras();
//        if(passedDate != null){
//            counter = passedDate.getInt("exit1");}
        tvResult.setText(Integer.toString(counter));

    }

    public void init(){
        tvResult = findViewById(R.id.tvResult);
        viewAnim = findViewById(R.id.imageView);
        anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
    }
    public void SaveInt(String key, int counter){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, counter);
        editor.commit();
    }

    public void LoadInt() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        counter = sharedPreferences.getInt("key", counter);
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
        //Toast toast = Toast.makeText(getApplicationContext(), "ещё", Toast.LENGTH_SHORT);
        //toast.setGravity(Gravity.CENTER, 0,400);
        //toast.show();
        viewAnim.startAnimation(anim);

    }


    @Override
    protected void onStop() {
        SaveInt("key", counter);
        super.onStop();
    }
}
