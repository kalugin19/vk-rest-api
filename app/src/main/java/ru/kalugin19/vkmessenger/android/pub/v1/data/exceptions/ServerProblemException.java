package ru.kalugin19.vkmessenger.android.pub.v1.data.exceptions;

/**
 * Проблема на стороне сервера
 */
@SuppressWarnings("WeakerAccess")
public class ServerProblemException extends RuntimeException {
    public ServerProblemException(String detailMessage) {
        super(detailMessage);
    }
}
