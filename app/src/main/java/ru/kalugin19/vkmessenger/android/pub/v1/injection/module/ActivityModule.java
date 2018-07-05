package ru.kalugin19.vkmessenger.android.pub.v1.injection.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.scope.PerActivity;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.main.MainActivity;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.view.SplashActivity;

/**
 * ActivityModule
 */
@SuppressWarnings("unused")
@Module
public abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

    @PerActivity
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

}