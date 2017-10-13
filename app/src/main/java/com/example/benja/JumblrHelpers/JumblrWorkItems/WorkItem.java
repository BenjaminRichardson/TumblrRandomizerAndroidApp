package com.example.benja.JumblrHelpers.JumblrWorkItems;

import com.tumblr.jumblr.JumblrClient;

/**
 * Created by Ben Richardson on 10/8/2017.
 */

public interface WorkItem<T> {
    T execute(JumblrClient client);
}
