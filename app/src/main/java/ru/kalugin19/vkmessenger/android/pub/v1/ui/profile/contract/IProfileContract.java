package ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract;


import ru.kalugin19.vkmessenger.android.pub.v1.data.entity.Profile;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;

public interface IProfileContract {

    interface View extends ViewContract {
        void setProfile(Profile profile);
    }

    interface Presenter extends BasePresenter<View> {
        void loadProfile();
    }
}
