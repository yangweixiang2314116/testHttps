package com.example.testhttps;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLSocketFactory;

public class AccountRestClient {
    //private static final String BASE_URL = "http://192.168.1.104:8000/";
    private static final String BASE_URL = "https://192.168.1.220/";

    private static AsyncHttpClient client = null;
    private static String TokenPre = " Token ";
    private static String Token = "";
    private static Context mContext = null;

    private static AccountRestClient mInstance;
    private static final String KEY_PASS = "pw12306";

    private AccountRestClient() {
    };

    public static AccountRestClient instance(Context context) {
        if (mInstance == null) {
            mInstance = new AccountRestClient();
            client = new AsyncHttpClient();
            mContext = context;
            mInstance.Init(context);
        }
        return mInstance;
    }

    private void Init(Context context)
    {
        Log.i(Constants.TAG, "-AccountRestClient -- Init--start-");

        KeyStore localTrustStore = null;
        MySSLSocketFactory sslFactory = null;
        try {
            localTrustStore = KeyStore.getInstance("BKS");
        } catch (KeyStoreException e) {
            Log.i(Constants.TAG, "--KeyStoreException-" + e);
            e.printStackTrace();
        }
        InputStream input = context.getResources().openRawResource(R.raw.cert12306);
        try {
            try {
                localTrustStore.load(input, KEY_PASS.toCharArray());
                sslFactory = new MySSLSocketFactory(localTrustStore);
            } catch (IOException e) {
                Log.i(Constants.TAG, "--IOException-" + e);
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                Log.i(Constants.TAG, "--NoSuchAlgorithmException-" + e);
                e.printStackTrace();
            } catch (CertificateException e) {
                Log.i(Constants.TAG, "--CertificateException-" + e);
                e.printStackTrace();
            } catch (UnrecoverableKeyException e) {
                Log.i(Constants.TAG, "--UnrecoverableKeyException-" + e);
                e.printStackTrace();
            } catch (KeyStoreException e) {
                Log.i(Constants.TAG, "--KeyStoreException-" + e);
                e.printStackTrace();
            } catch (KeyManagementException e) {
                Log.i(Constants.TAG, "--KeyManagementException-" + e);
                e.printStackTrace();
            }
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.i(Constants.TAG, "--setSSLSocketFactory--");
        client.setSSLSocketFactory(sslFactory);

        Log.i(Constants.TAG, "--AccountRestClient -- Init--end--");
    }

    private void InitPKCS12(Context context)
    {
        Log.i(Constants.TAG, "-AccountRestClient -- InitPKCS12--start-");

        KeyStore localTrustStore = null;
        MySSLSocketFactory sslFactory = null;
        try {
            localTrustStore = KeyStore.getInstance("PKCS12");
        } catch (KeyStoreException e) {
            Log.i(Constants.TAG, "--KeyStoreException-" + e);
            e.printStackTrace();
        }
        InputStream input = context.getResources().openRawResource(R.raw.cert12306);
        try {
            try {
                localTrustStore.load(input, KEY_PASS.toCharArray());
                sslFactory = new MySSLSocketFactory(localTrustStore);
            } catch (IOException e) {
                Log.i(Constants.TAG, "--IOException-" + e);
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                Log.i(Constants.TAG, "--NoSuchAlgorithmException-" + e);
                e.printStackTrace();
            } catch (CertificateException e) {
                Log.i(Constants.TAG, "--CertificateException-" + e);
                e.printStackTrace();
            } catch (UnrecoverableKeyException e) {
                Log.i(Constants.TAG, "--UnrecoverableKeyException-" + e);
                e.printStackTrace();
            } catch (KeyStoreException e) {
                Log.i(Constants.TAG, "--KeyStoreException-" + e);
                e.printStackTrace();
            } catch (KeyManagementException e) {
                Log.i(Constants.TAG, "--KeyManagementException-" + e);
                e.printStackTrace();
            }
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.i(Constants.TAG, "--setSSLSocketFactory--");
        client.setSSLSocketFactory(sslFactory);

        Log.i(Constants.TAG, "--AccountRestClient -- -InitPKCS12 -end--");
    }

    public static void get(String url, RequestParams params, TextHttpResponseHandler responseHandler) {
        client.setTimeout(5000);
        //Log.i(Constants.TAG, "--get getAbsoluteUrl--" + getAbsoluteUrl(url));
        Log.i(Constants.TAG, "--get url--" + url);
        //client.get(getAbsoluteUrl(url), params, responseHandler);
        client.get(url, params, responseHandler);
    }


}
