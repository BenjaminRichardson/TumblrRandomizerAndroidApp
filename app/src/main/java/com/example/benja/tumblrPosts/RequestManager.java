package com.example.benja.tumblrPosts;

import android.content.Context;

import com.example.benja.JumblrHelpers.JumblrWorkItems.WorkItem;
import com.tumblr.jumblr.types.*;

import java.util.*;

/**
 * Created by Ben Richardson on 10/3/2017.
 */

public class RequestManager{

    private Context mContext;
    private List<BlogManager> blogs;

    public RequestManager(Context context){
        blogs = new ArrayList<>();
        mContext = context;
    }

    public RequestManager(Context context, String firstBlogName){
        this(context);
        addBlog(firstBlogName);
    }

    public void addBlog(String blogName){
        BlogManager blogManager = new BlogManager(blogName);
        blogs.add(blogManager);
    }

    public WorkItem<List<Post>> createPostsRequestTask(){
        return createPostsRequestTask(5);
    }

    public WorkItem<List<Post>> createPostsRequestTask(Integer numPosts){
        BlogManager bm = blogs.get(0);
        WorkItem<List<Post>> work = bm.createGetPostsWorkItem(numPosts);
        return work;
    }

    public void updateWithNewPost(List<Post> posts){

    }

}
