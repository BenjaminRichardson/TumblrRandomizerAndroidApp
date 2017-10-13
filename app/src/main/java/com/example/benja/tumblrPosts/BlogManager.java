package com.example.benja.tumblrPosts;

import java.util.*;

import com.example.benja.JumblrHelpers.JumblrWorkItems.PostsRequest;
import com.example.benja.JumblrHelpers.JumblrWorkItems.WorkItem;
import com.tumblr.jumblr.types.Post;

/**
 * Created by Benjamin Richardson on 9/27/2017.
 */

public class BlogManager {

    private String blogName;
    private int numPosts;
    private int offset;

    public BlogManager(String blogName){
        offset = 0;
        setBlogName(blogName);
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
        numPosts = -1;
    }

    public int getNumPosts() {
        if(numPosts > 0) {
            return numPosts;
        }else {
            //TODO: Implement something to retrieve from server
            return 0;
        }
    }

    public WorkItem<List<Post>> createGetPostsWorkItem(Integer numPosts){
        if(numPosts > 20 || numPosts < 0){
            throw new IllegalArgumentException("Number of posts requested must be between 1 and 20 inclusive.");
        }
        Map<String,String> options = new HashMap<>();
        //options.put("type","photo");
        options.put("limit",numPosts.toString());
        options.put("offset",Integer.toString(offset));
        offset += numPosts;
        return new PostsRequest(blogName,options);
    }
}
