package ru.kalugin19.vkmessenger.android.pub.v1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.component.AppInjector;

/**
 * Application
 */
public class VKMessengerApplication extends Application  implements HasActivityInjector {

    private static VKMessengerApplication instance;

    @SuppressWarnings("WeakerAccess")
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
        }
        instance = this;
    }

    @SuppressWarnings("unused")
    public static VKMessengerApplication get(Context context) {
        return (VKMessengerApplication) context.getApplicationContext();
    }

    public static Context getAppContext() {
        if (instance != null) {
            return instance.getApplicationContext();
        }
        return null;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
