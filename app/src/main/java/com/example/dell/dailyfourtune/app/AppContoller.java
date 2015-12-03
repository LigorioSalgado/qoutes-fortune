package com.example.dell.dailyfourtune.app;
import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by DELL on 01/12/2015.
 */
public class AppContoller extends Application {
    private static AppContoller ourInstance = new AppContoller();
    private static final String TAG ="ApplicationController";
    private static AppContoller mInstance;
    public static synchronized AppContoller getmInstance(){
        return mInstance;
    }

    public static AppContoller getInstance() {
        return ourInstance;
    }

    private AppContoller() {
    }

    private RequestQueue mRequestQueue;
    @Override
    public void onCreate(){
        super.onCreate();
        mInstance=this;
    }
    public RequestQueue getmRequestQueue(){
        if(mRequestQueue==null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());

        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request req, String tag){
        req.setTag(TextUtils.isEmpty(tag)? TAG:tag);
        getmRequestQueue().add(req);
    }
    public <T> void addToRequestQue(Request<T> req){
        req.setTag(TAG);
        getmRequestQueue().add(req);


    }

    public void cancelPendingRequest(Object tag){
        if(mRequestQueue !=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
