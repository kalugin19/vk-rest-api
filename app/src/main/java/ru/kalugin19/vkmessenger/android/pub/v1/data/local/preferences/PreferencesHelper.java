package ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import ru.kalugin19.vkmessenger.android.pub.v1.injection.qualifiers.ApplicationContext;


/**
 * Класс предоставляющий доступ к PRIVATE настройкам.
 */
public class PreferencesHelper {

    private static final String PREF_FILE_NAME = "android_vk_messenger_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPrefs() {
        return mPref;
    }
}
