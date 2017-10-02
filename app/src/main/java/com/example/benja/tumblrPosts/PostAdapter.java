package com.example.benja.tumblrPosts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benja.simpletumblrviewer.R;
import com.tumblr.jumblr.types.Post;

import java.util.ArrayList;

/**
 * Created by Benjamin Richardson on 9/26/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private ArrayList<Post> posts;

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        //TODO: make more versatile, set item and retrieve text etc in the view holder
        public ImageView image;
        public TextView desc;

        public PostViewHolder(View itemView) {
            super(itemView);

            this.image = (ImageView) itemView.findViewById(R.id.imageView);
            this.desc = (TextView) itemView.findViewById(R.id.imageDescription);
        }
    }

    public PostAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_image_view,parent,false);
        PostViewHolder pvh = new PostViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder viewHolder, int position){
        viewHolder.image.setImageResource(R.drawable.bill_gates);
        viewHolder.desc.setText(posts.get(position).getPostUrl());
    }

    @Override
    public int getItemCount(){
        return posts.size();
    }

}
