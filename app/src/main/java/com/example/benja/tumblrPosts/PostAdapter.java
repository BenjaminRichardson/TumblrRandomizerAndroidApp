package com.example.benja.tumblrPosts;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benja.helpers.jumblrHelpers.PostType;
import com.example.benja.simpletumblrviewer.R;
import com.example.benja.tumblrPosts.postViewHolders.PhotoPostViewHolder;
import com.example.benja.tumblrPosts.postViewHolders.PostViewHolder;
import com.tumblr.jumblr.types.Post;

import java.util.*;

/**
 * Created by Benjamin Richardson on 9/26/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts){
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Log.d("SOMETHING", "Started to create View holder");
        PostViewHolder pvh;
        if(android.os.Debug.isDebuggerConnected())
            android.os.Debug.waitForDebugger();
        PostType viewTypeVal = PostType.values()[viewType];

        if(viewTypeVal.equals(PostType.PHOTO)){
            pvh = this.createPhotoViewHolder(parent);
        }else{
            pvh = this.createPostViewHolder(parent);
        }

        return pvh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder viewHolder, int position){
        Post currPost = posts.get(position);
        viewHolder.bind(currPost);
    }

    @Override
    public int getItemViewType(int position) {
        Post currPost = posts.get(position);
        PostType type = PostType.valueOf(currPost.getType().toUpperCase());
        return type.ordinal();
    }

    @Override
    public int getItemCount(){
        return posts.size();
    }

    private PostViewHolder createPhotoViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_photo,parent,false);
        return new PhotoPostViewHolder(v);
    }

    private PostViewHolder createPostViewHolder(ViewGroup parent){
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.post_footer,parent,false);
        return new PostViewHolder(v);
    }



}
