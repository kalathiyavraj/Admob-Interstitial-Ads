package com.example.admobinterstitialads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class AdGoogle {
    private static AdGoogle mInstance;
    public InterstitialAd MyInterstitial;
    AdRequest adRequest;
    MyCallback myCallback;
    private ProgressDialog progressDialog;
    Activity activity;
    boolean b=false;


    Context ctx;

    public static AdGoogle getInstance() {
        if (mInstance == null) {
            mInstance = new AdGoogle();
        }

        return mInstance;
    }

    public interface MyCallback {
        void callbackCall();
    }

    public void showInterDialog(Context context, Activity act, MyCallback _myCallback) {

        activity = act;
        ctx = context;

            this.myCallback = _myCallback;
            showProgress(context);

            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {

                }
            });


            MyInterstitial = new InterstitialAd(context);
            MyInterstitial.setAdUnitId(context.getString(R.string.interstatial));
            adRequest = new Builder().build();
            MyInterstitial.loadAd(adRequest);


            MyInterstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {



                    b=false;

                    if (MyInterstitial.isLoaded()) {
                        MyInterstitial.show();
                        dismissProgress();
                    }


                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);



                    dismissProgress();
                    if (myCallback != null) {
                        myCallback.callbackCall();
                        myCallback = null;
                    }
                    Log.e("failed",""+errorCode);
                    b = true;

                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    dismissProgress();
                    if (myCallback != null) {
                        myCallback.callbackCall();
                        myCallback = null;
                    }
                }
            });

       // }
    }




    public void showProgress(Context context) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Wait");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
