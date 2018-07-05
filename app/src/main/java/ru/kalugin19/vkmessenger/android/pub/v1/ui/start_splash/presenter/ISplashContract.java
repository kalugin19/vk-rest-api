package ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter;

import android.view.View;

import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;


public interface ISplashContract {

    interface View extends ViewContract {

        void showAuthorizationWebForm();

        void showNoInternetConnectionError();

        void showUnknownError();

        void goToMainActivity();

        void showProgressBar(boolean flag);

        void showWebView(boolean flag);

        void showSignIn(boolean flag);
    }

    interface Presenter extends BasePresenter<View> {
        void saveAuthData(String token, String userId);

        void authorization();
    }
}
