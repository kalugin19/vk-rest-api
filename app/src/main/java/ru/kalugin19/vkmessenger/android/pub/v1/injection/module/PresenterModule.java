package ru.kalugin19.vkmessenger.android.pub.v1.injection.module;

import dagger.Binds;
import dagger.Module;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract.ChatPresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract.IChatContract;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract.IProfileContract;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract.ProfilePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter.ISplashContract;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter.SplashPresenter;


/**
 * PresenterModule
 */
@SuppressWarnings("unused")
@Module
public abstract class PresenterModule {

    @Binds
    abstract ISplashContract.Presenter bindSplashPresenter(SplashPresenter splashPresenter);

    @Binds
    abstract IProfileContract.Presenter bindProfilePresenter(ProfilePresenter profilePresenter);

    @Binds
    abstract IChatContract.Presenter bindChatPresenter(ChatPresenter chatPresenter);
}
