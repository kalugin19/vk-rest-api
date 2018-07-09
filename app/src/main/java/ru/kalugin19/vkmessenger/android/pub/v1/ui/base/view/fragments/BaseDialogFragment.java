package ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.fragments;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Базовый класс для DialogFragments, обеспечивающий привязку к DI
 */
public class BaseDialogFragment extends DialogFragment implements HasSupportFragmentInjector {
    @SuppressWarnings("WeakerAccess")
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}
