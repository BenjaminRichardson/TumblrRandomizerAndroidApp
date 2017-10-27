package com.example.benja.tumblrPosts.postViewHolders;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.benja.helpers.jumblrHelpers.PostType;
import com.example.benja.simpletumblrviewer.R;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;

import java.util.List;

/**
 * Created by Ben Richardson on 10/16/2017.
 */

public class PhotoPostViewHolder extends PostViewHolder {

    public ImageView image;

    public PhotoPostViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.post_img);
    }

    //TODO: get photo to stretch
    public void bind(Post post){
        if(android.os.Debug.isDebuggerConnected())
            android.os.Debug.waitForDebugger();
        this.url = post.getPostUrl();

        if(!post.getType().equalsIgnoreCase(PostType.PHOTO.toString())){ throw new IllegalArgumentException("Must be photo post to bind to photo post view holder"); }
        List<Photo> photos = ((PhotoPost)post).getPhotos();
        Photo photo = photos.get(0);
        String photoUrl = photo.getOriginalSize().getUrl();
        Glide.with(this.itemView).load(photoUrl).into(this.image);
    }
}
