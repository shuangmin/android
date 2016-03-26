package rander.com.randerc.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import rander.com.randerc.utils.L;

/**
 * Created by rander on 16-3-26.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.d(getClass().getCanonicalName() + " onCreate");
        L.d(getClass().getSimpleName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.d(getClass().getCanonicalName() + " onStart");
        L.d(getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        L.d(getClass().getCanonicalName() + " onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        L.d(getClass().getCanonicalName() + " onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        L.d(getClass().getCanonicalName() + " onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        L.d(getClass().getCanonicalName() + " onConfigurationChanged");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.d(getClass().getCanonicalName() + " onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.d(getClass().getCanonicalName() + " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.d(getClass().getCanonicalName() + " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.d(getClass().getCanonicalName() + " onDestroy");
    }
}
