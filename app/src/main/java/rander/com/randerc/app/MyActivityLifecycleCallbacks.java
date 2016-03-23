package rander.com.randerc.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import rander.com.randerc.utils.L;

/**
 * Created by rander on 16-3-23.
 */
public class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        L.d("");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        L.d("");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        L.d("");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        L.d("");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        L.d("");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        L.d("");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        L.d("");
    }
}
