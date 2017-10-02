package com.example.benja.simpletumblrviewer;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPostViewer(View view){
        Intent intent = new Intent(this, PostBrowser.class);
        startActivity(intent);
    }
}
