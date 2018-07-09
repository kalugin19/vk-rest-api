package ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter;

import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;

/**
 * Main BasePresenter contract
 */
public interface BasePresenter<V extends ViewContract> {

    @SuppressWarnings("EmptyMethod")
    void attachView(@SuppressWarnings("UnusedParameters") V view);

    @SuppressWarnings({"unused", "EmptyMethod"})
    void detachView();

    @SuppressWarnings("EmptyMethod")
    void onStart();

    @SuppressWarnings("EmptyMethod")
    void onStop();

    @SuppressWarnings("EmptyMethod")
    void onResume();

    @SuppressWarnings("EmptyMethod")
    void onPause();
}