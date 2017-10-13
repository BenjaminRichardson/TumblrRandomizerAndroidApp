package com.example.benja.simpletumblrviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benja.JumblrHelpers.JumblrWorkItems.WorkItem;
import com.example.benja.JumblrHelpers.TumblrRequestTask;
import  com.example.benja.infiniteScroller.EndlessRecyclerViewScrollListener;
import com.example.benja.tumblrPosts.PostAdapter;
import com.example.benja.tumblrPosts.RequestManager;

import java.util.*;
import com.tumblr.jumblr.types.*;

/**
 * Created by Benjamin Richardson on 9/22/2017.
 */

public class PostBrowser extends Activity {

    private EndlessRecyclerViewScrollListener scrollListener;
    private PostAdapter postAdapter;
    private List<Post> posts;
    private RequestManager requestManager;
    //TODO: manage where we are getting the posts from
    //TODO: write tool to get posts from tumblr - use jumblr

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_browser);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        posts = new ArrayList<>();
        requestManager = new RequestManager(getApplicationContext(),"eve-nings.tumblr.com");
        RecyclerView rv = (RecyclerView) findViewById(R.id.postDisplay);
        postAdapter = new PostAdapter(posts);
        rv.setAdapter(postAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        scrollListener = new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(RecyclerView view) {
                requestMorePosts(5);
            }
        };
        rv.addOnScrollListener(scrollListener);
        requestMorePosts(20);//start with something in the view
    }

    private void requestMorePosts(int numToRequest) {
        if(numToRequest > 20 || numToRequest < 1){
            throw new IllegalArgumentException("Must request between 1 and 20 posts inclusive.");
        }
        WorkItem workItem = requestManager.createPostsRequestTask(5);
        new TumblrRequestTask<List<Post>>(workItem){
            @Override
            public void onPostExecute(List<Post> newPosts){
                int oldLength = posts.size();
                posts.addAll(newPosts);
                postAdapter.notifyItemRangeInserted(oldLength,newPosts.size());
            }
        }.execute();
    }




}
