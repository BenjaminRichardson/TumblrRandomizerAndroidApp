package com.example.benja.simpletumblrviewer;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends FragmentActivity {
    public static final String BLOG_NAME = "com.example.benja.simpletumblrviewer.BLOGNAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPostViewer(View view){
        Intent intent = new Intent(this, PostBrowser.class);
        EditText blogInput = (EditText) findViewById(R.id.blogInfo);
        String blogName = blogInput.getText().toString();
        intent.putExtra(BLOG_NAME,blogName);
        startActivity(intent);
    }
}
