package ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences;

import android.content.SharedPreferences;

import javax.inject.Inject;



/**
 * Класс для работы с локальными данными пользователя
 *
 * @author Gusev Andrey
 */

public class UserPreferenceHelper {

    private static final String PREF_TOKEN = "token";
    private static final String PREF_USER_ID = "user_id";


    private static UserPreferenceHelper instance;
    private final PreferencesHelper mPref;


    @Inject
    public UserPreferenceHelper(PreferencesHelper preferencesHelper) {
        mPref = preferencesHelper;
    }

    /**
     * Запрос токена пользователя
     *
     * @return - сессия авторизации или null, если сессия авторизации не была установлена
     */
    public String getToken() {
        return mPref.getSharedPrefs().getString(PREF_TOKEN, null);
    }

    /**
     * Сохранение токена авторизации пользователя
     *
     * @param authSession - сессия авторизации пользователя
     */
    public void setToken(String authSession) {
        mPref.getSharedPrefs().edit().putString(PREF_TOKEN, authSession).apply();
    }

    /**
     * Запрос сессии авторизации
     *
     * @return - сессия авторизации или null, если сессия авторизации не была установлена
     */
    public String getUserId() {
        return mPref.getSharedPrefs().getString(PREF_USER_ID, null);
    }

    /**
     * Сохранение сессии авторизации пользователя
     *
     * @param userId - сессия авторизации пользователя
     */
    public void setUserId(String userId) {
        mPref.getSharedPrefs().edit().putString(PREF_USER_ID, userId).apply();
    }

}
