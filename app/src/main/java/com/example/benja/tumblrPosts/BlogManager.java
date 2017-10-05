package com.example.benja.tumblrPosts;

import com.tumblr.jumblr.JumblrClient;

/**
 * Created by Benjamin Richardson on 9/27/2017.
 */

public class PostRequestManager {

    private JumblrClient jumblrClient;
    private String blogName;
    int numPosts;

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public void setJumblrClient(JumblrClient jumblrClient) {
        this.jumblrClient = jumblrClient;
    }
}
