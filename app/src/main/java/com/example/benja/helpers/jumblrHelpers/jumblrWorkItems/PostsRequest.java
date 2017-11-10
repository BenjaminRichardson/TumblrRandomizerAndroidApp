package com.example.benja.helpers.jumblrHelpers.jumblrWorkItems;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Post;
import java.util.Map;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ben Richardson on 10/8/2017.
 */

public class PostsRequest implements WorkItem<List<Post>> {

    String blogName;
    Map<String,?> options;

    public PostsRequest(String blogName, Map<String,?> options){
        String fullBlogName = blogName.trim();

        this.blogName = blogName;
        this.options = options;
    }

    @Override
    public List<Post> execute(JumblrClient client) {
        if (client == null) {
            throw new IllegalArgumentException("Jumblr client must be instantiated");
        }
        return client.blogPosts(blogName,options);
    }
}
