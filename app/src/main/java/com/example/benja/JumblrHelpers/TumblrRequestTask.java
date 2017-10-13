package com.example.benja.JumblrHelpers;

import android.os.AsyncTask;

import com.example.benja.JumblrHelpers.JumblrWorkItems.WorkItem;
import com.tumblr.jumblr.JumblrClient;

/**
 * Created by Ben Richardson on 10/10/2017.
 */

public class TumblrRequestTask<T> extends AsyncTask<Void,Void,T> {

    //TODO: hide the key information somewhere safer
    String consumerKey = "du3am2LzgIHJNx8VzVQMXsXAcCwBowT6rQh0eV58zr3bJAYrsO";
    String secretKey = "OZoXOpGmyidazZEbV3AjVvx9cVORXku6j4lOk4XWuLNSPwH40c";
    JumblrClient jumblrClient;
    WorkItem<T> mWorkItem;

    public TumblrRequestTask(WorkItem<T> workItem){
        mWorkItem = workItem;
    }

    @Override
    protected T doInBackground(Void... params) {
        if(android.os.Debug.isDebuggerConnected())
            android.os.Debug.waitForDebugger();
        return mWorkItem.execute(jumblrClient);
    }

    @Override
    protected void onPreExecute() {
        jumblrClient = new JumblrClient(consumerKey,secretKey);
    }

    /**
     * If you want something to happen, override it when you instantiate the tumblr request
     * @param t
     */
    @Override
    protected void onPostExecute(T t) {
    }
}
