package ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter;

import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;

/**
 * Контракт для сплэш
 */
public interface ISplashContract {

    interface View extends ViewContract {

        /**
         * Показать форму авторизации
         */
        void showAuthorizationWebForm();

        /**
         * показать ошибку интернет-соединения
         */
        void showNoInternetConnectionError();

        /**
         * показать неизвестную ошибку
         */
        void showUnknownError();

        /**
         * переход на Main Activity
         */
        void goToMainActivity();

        /**
         * Показать/скрыть прогресс
         */
        void showProgressBar(boolean flag);

        /**
         * Показать/скрыть webView
         */
        void showWebView(boolean flag);

        /**
         * Показать/скрыть кнопку входа
         */
        void showSignIn(boolean flag);
    }

    interface Presenter extends BasePresenter<View> {
        /**
         * Сохранить данные авторизации
         */
        void saveAuthData(String token, String userId);

        /**
         * Авторизация
         */
        void authorization();
    }
}
