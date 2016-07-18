package com.example.testhttps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.content.Context;
import android.util.Log;

public class AccountApiConnector {

    private static AccountApiConnector mInstance;
    public static final int ACCOUNT_IMAGE_SELECT_MAX_COUNT = 4;
    private static Context mcontext = null;

    private AccountApiConnector() {
    };

    public static AccountApiConnector instance(Context context) {
        if (mInstance == null) {
            mInstance = new AccountApiConnector();
            mcontext  =  context;
        }
        return mInstance;
    }

    public void getHotBrandList(TextHttpResponseHandler handler) {
        Log.i(Constants.TAG, "-start to -get all hot brand --");

        //String url = "https://kyfw.12306.cn/otn/leftTicket/init";
        String url = "https://192.168.1.220/jz/tags/";
        AccountRestClient.instance(mcontext).get(url, null, handler);

    }





}

