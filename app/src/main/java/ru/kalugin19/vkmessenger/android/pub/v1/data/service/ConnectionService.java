package ru.kalugin19.vkmessenger.android.pub.v1.data.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ru.kalugin19.vkmessenger.android.pub.v1.VKMessengerApplication;

/**
 * Connection Service
 *
 * @author Gusev Andrey
 */
public class ConnectionService {

    private static ConnectionService instance;

    private ConnectionService() {

    }

    public static ConnectionService getInstance() {

        ConnectionService localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = new ConnectionService();
                }
            }
        }

        return instance;
    }


    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean checkInternetConnection() {
        Context context = VKMessengerApplication.getAppContext();
        if (context != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = null;
            if (cm != null) {
                activeNetwork = cm.getActiveNetworkInfo();
            }
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }
}