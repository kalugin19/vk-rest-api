package ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter;

import android.text.TextUtils;

import javax.inject.Inject;

import ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences.UserPreferenceHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.service.ConnectionService;

public class SplashPresenter implements ISplashContract.Presenter {

    private ISplashContract.View view;
    private final ConnectionService connectionService;
    private final UserPreferenceHelper userPreferenceHelper;

    @Inject
    public SplashPresenter(ConnectionService connectionService, UserPreferenceHelper userPreferenceHelper) {
        this.connectionService = connectionService;
        this.userPreferenceHelper = userPreferenceHelper;
    }

    @Override
    public void attachView(ISplashContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {
        if (!TextUtils.isEmpty(userPreferenceHelper.getToken())) {
            view.goToMainActivity();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void saveAuthData(String token, String userId) {
        userPreferenceHelper.setToken(token);
        userPreferenceHelper.setUserId(userId);
        view.goToMainActivity();
    }

    @Override
    public void authorization() {
        if (connectionService.checkInternetConnection()) {
            view.showProgressBar(true);
            view.showAuthorizationWebForm();
        } else {
            view.showNoInternetConnectionError();
        }
    }
}
