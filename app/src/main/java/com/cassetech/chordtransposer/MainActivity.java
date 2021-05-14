package com.cassetech.chordtransposer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    ImageView appLogo;
    Timer time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarations//
        appLogo = (ImageView)findViewById(R.id.appLogo);
        time = new Timer();

        //Animations On Creation //
        appLogo.animate().alpha(1).setDuration(2000);
        time.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(MainActivity.this, FieldActiviy.class);
                startActivity(intent);
            }
        },2500);
    }
}