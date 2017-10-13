package com.example.benja.JumblrHelpers.JumblrWorkItems;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Post;

import java.util.Map;
import java.util.List;

/**
 * Created by Ben Richardson on 10/8/2017.
 */

public class PostsRequest implements WorkItem<List<Post>> {

    String blogName;
    Map<String,?> options;

    public PostsRequest(String blogName,Map<String,?> options){
        this.blogName = blogName;
        this.options = options;
    }

    @Override
    public List<Post> execute(JumblrClient client) {
        return client.blogPosts(blogName,options);
    }
}
