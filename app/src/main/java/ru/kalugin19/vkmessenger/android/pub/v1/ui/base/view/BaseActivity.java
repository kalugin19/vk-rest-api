package ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Activity : Base
 */
public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @SuppressWarnings("WeakerAccess")
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
