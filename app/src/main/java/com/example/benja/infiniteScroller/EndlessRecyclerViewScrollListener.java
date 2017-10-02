package com.example.benja.infiniteScroller;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Benjamin Richardson on 9/22/2017.
 */

public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    private int viewThreshold = 5;
    private int previousTotalItems = 0;
    private boolean loading = true;


    RecyclerView.LayoutManager layoutManager;

    public EndlessRecyclerViewScrollListener(LinearLayoutManager llm){
        this.layoutManager = llm;
    }

    @Override
    public void onScrolled(RecyclerView rv, int dx, int dy){

        // get current number of items
        int lastVisibleItemPosition = 0;
        int totalNumItems = this.layoutManager.getItemCount();

        lastVisibleItemPosition = ((LinearLayoutManager) this.layoutManager).findLastVisibleItemPosition();

        if(previousTotalItems > totalNumItems){
            //uhoh something is wrong
            previousTotalItems = totalNumItems;
            if(totalNumItems == 0){
                loading = true;
            }
        }

        if(loading && (previousTotalItems < totalNumItems)){
            loading = false;
            previousTotalItems = totalNumItems;
        }

        if( !loading && (lastVisibleItemPosition + viewThreshold > totalNumItems)){
            loading = true;
            onLoadMore(rv);
        }

    }

    public void setViewThreshold(int newThreshold){
        this.viewThreshold = newThreshold;
    }

    public void resetState(){
        previousTotalItems = 0;
        loading = true;
    }

    public abstract void onLoadMore(RecyclerView view);

}
