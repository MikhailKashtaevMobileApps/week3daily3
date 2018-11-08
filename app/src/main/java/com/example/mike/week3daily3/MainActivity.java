package com.example.mike.week3daily3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMessenger(View view) {

    }

    public void goToRandomObjects(View view) {
    }

    public void goToMusic(View view) {
        goToActivity( MusicPlayerActivity.class );
    }

    public void goToActivity( Class c ){
        Intent intent = new Intent( getApplicationContext(), c );
        startActivity(intent);
    }
}
