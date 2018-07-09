package ru.kalugin19.vkmessenger.android.pub.v1.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences.PreferencesHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences.UserPreferenceHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.remote.RestService;
import ru.kalugin19.vkmessenger.android.pub.v1.data.remote.RetrofitHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.service.ConnectionService;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.qualifiers.ApplicationContext;


/**
 * AppModule
 */
@Module(includes = PresenterModule.class)
public class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    Context provideAppContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    ConnectionService provideConnectionService() {
        return ConnectionService.getInstance();
    }

    @Singleton
    @Provides
    UserPreferenceHelper provideUserPreferenceHelper(PreferencesHelper preferencesHelper) {
        return new UserPreferenceHelper(preferencesHelper);
    }

    @Singleton
    @Provides
    RestService provideRestService() {
        return RetrofitHelper.getInstanceRestService();
    }

}