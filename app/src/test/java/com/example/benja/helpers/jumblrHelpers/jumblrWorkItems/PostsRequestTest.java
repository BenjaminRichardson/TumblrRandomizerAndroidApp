package com.example.benja.helpers.jumblrHelpers.jumblrWorkItems;

import com.tumblr.jumblr.JumblrClient;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

/**
 * Created by Ben Richardson on 11/6/2017.
 */
public class PostsRequestTest {
    private PostsRequest pr;

    @Mock
    private JumblrClient cli;

    @Before
    public void setUp() throws Exception{
        cli = Mockito.mock(JumblrClient.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeWithNullClient() throws Exception {
        pr = new PostsRequest("blogName");
        pr.execute(null);
    }

    @Test
    public void executeWithoutOptions

}