package com.example.benja.JumblrHelpers;

/**
 * Created by Ben Richardson on 10/13/2017.
 */

//For some reason Jumblr does not expose this in the API so I have to recreate
public enum PostType {
    TEXT("text"),
    PHOTO("photo"),
    QUOTE("quote"),
    LINK("link"),
    CHAT("chat"),
    AUDIO("audio"),
    VIDEO("video"),
    ANSWER("answer"),
    POSTCARD("postcard"),
    UNKNOWN("unknown");

    private final String mType;

    PostType(final String type) {
        this.mType = type;
    }

}
