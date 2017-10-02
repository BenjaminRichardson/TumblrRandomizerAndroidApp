package com.example.benja.simpletumblrviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import  com.example.benja.infiniteScroller.EndlessRecyclerViewScrollListener;
import com.example.benja.tumblrPosts.PostAdapter;
import com.tumblr.jumblr.JumblrClient;

import org.scribe.builder.api.TumblrApi;

import java.util.*;
import com.tumblr.jumblr.types.*;

/**
 * Created by Benjamin Richardson on 9/22/2017.
 */

public class PostBrowser extends Activity {

    private EndlessRecyclerViewScrollListener scrollListener;
    private PostAdapter postAdapter;
    private ArrayList<Post> posts;
    //TODO: manage where we are getting the posts from
    //TODO: write tool to get posts from tumblr - use jumblr

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_browser);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        String consumerKey = getString(R.string.tumblr_consumer_key);
        String secretKey = getString(R.string.tumblr_secret_key);

        JumblrClient jumblrClient = new JumblrClient(consumerKey,secretKey);
        List<Post> tempPosts = jumblrClient.blogPosts("eve-nings.tumblr.com/");
        posts = new ArrayList<Post>(tempPosts);

        RecyclerView rv = (RecyclerView) findViewById(R.id.postDisplay);
        postAdapter = new PostAdapter(posts);
        rv.setAdapter(postAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        scrollListener = new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(RecyclerView view) {
                postAdapter.notifyItemInserted();
            }
        };
        rv.addOnScrollListener(scrollListener);
    }
}
