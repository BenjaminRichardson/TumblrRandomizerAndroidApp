package com.example.benja.simpletumblrviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SingleImageView extends Fragment {

    final public static String ARG_DESCRIPTION = "Desc";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View newFragView = inflater.inflate(R.layout.single_image_view, container, false);

        Bundle args = getArguments();
        if(args.getString(SingleImageView.ARG_DESCRIPTION) != null) {
            String imageDetails = args.getString(SingleImageView.ARG_DESCRIPTION);

            TextView description = (TextView) newFragView.findViewById(R.id.imageDescription);
            description.setText(imageDetails);
        }
        return newFragView;
    }
}
