package ru.kalugin19.vkmessenger.android.pub.v1.injection.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.ChatsFragment;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.ProfileFragment;


/**
 * FragmentBuildersModule
 */
@SuppressWarnings("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract ChatsFragment contributeChatsFragment();
}