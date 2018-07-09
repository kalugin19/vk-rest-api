package ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract;


import ru.kalugin19.vkmessenger.android.pub.v1.data.entity.Profile;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;

/**
 * Контракт для профиля
 */
public interface IProfileContract {

    interface View extends ViewContract {
        /**
         * установить данные профиля для отображения
         */
        void setProfile(Profile profile);
    }

    /**
     * Presenter для профиля
     */
    interface Presenter extends BasePresenter<View> {
        /**
         * Загрузить данные профиля
         */
        void loadProfile();
    }
}
