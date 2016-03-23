package rander.com.randerc.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by rander on 16-3-23.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
    }
}
