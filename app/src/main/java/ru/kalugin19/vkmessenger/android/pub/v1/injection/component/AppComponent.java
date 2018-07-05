package ru.kalugin19.vkmessenger.android.pub.v1.injection.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ru.kalugin19.vkmessenger.android.pub.v1.VKMessengerApplication;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.module.ActivityModule;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.module.AppModule;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.module.BroadcastReceiverBuilder;
import ru.kalugin19.vkmessenger.android.pub.v1.injection.module.ServiceBuilderModule;


/**
 * AppComponent
 *
 * @author Abu-Khalil Jumana
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        ServiceBuilderModule.class,
        BroadcastReceiverBuilder.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(VKMessengerApplication vkMessengerApplication);
}