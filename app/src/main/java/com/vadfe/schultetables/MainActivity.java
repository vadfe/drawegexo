package com.vadfe.schultetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vadfe.schultetables.views.mDrawView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new mDrawView(this));
    }
}
