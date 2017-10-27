package com.example.benja.tumblrPosts.postViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benja.simpletumblrviewer.R;
import com.tumblr.jumblr.types.Post;

/**
 * Created by Ben Richardson on 10/16/2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    //TODO: make more versatile, set item and retrieve text etc in the view holder
    public String url;
    public static Button linkButton;

    public PostViewHolder(View itemView) {
        super(itemView);
        this.linkButton = (Button)itemView.findViewById(R.id.link_button);
        url = "http://www.tumblr.com";
    }

    public void bind(Post post){
        url = post.getPostUrl();
    }
}