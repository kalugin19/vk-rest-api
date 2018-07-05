package ru.kalugin19.vkmessenger.android.pub.v1.data.exceptions;


import retrofit2.Response;

/**
 * Фабрика исключений сервера
 *
 * @author Gusev Andrey
 */
@SuppressWarnings("WeakerAccess")
public class RestExceptionFactory {

    @SuppressWarnings("unused")
    final private static int SYSTEM_ERROR = -1;
    final private static int UN_AUTHORIZE_CODE = 3;
    final private static int PALLET_NOT_FOUND_CODE = 10;
    final private static int PALLET_USED_CODE = 11;
    final private static int INVALID_USER_CODE = 7;
    final private static int USER_NOT_FOUND_CODE = 8;
    final private static int FORBIDDEN = 403;

    /**
     * Фабричный метод генерации исключений при ошибках HTTP
     *
     * @param response Ответ от сервера
     */
    public static void throwException(Response response) throws RuntimeException {
        switch (response.code()) {
            case (FORBIDDEN): {
                throw new ForbiddenException();
            }
            default: {
                String msg = "Неизвестная ошибка";
                throw new ServerProblemException(msg);
            }
        }
    }

    public static void throwException(okhttp3.Response response) throws RuntimeException {
        switch (response.code()) {
            case (FORBIDDEN): {
                throw new ForbiddenException();
            }
            default: {
                String msg = "Неизвестная ошибка";
                throw new ServerProblemException(msg);
            }
        }
    }

    /**
     * Фабричный метод генерации исключений при ошибках передаваемых с сервера
     *
     * @param code    Код ошибки, который вернул сервер
     * @param message Описание ошибки, которое вернул сервер
     */
    public static void throwException(int code, String message) throws RuntimeException {
        switch (code) {
            case (UN_AUTHORIZE_CODE): {
                throw new SessionExpiredException();
            }
            case (PALLET_NOT_FOUND_CODE): {
                throw new PalletNotFoundException();
            }
            case (PALLET_USED_CODE): {
                throw new PalletUsedException();
            }
            case (INVALID_USER_CODE): {
                throw new InvalidUserException();
            }
            case (USER_NOT_FOUND_CODE): {
                throw new UserNotFoundException();
            }
            default:
                throw new ServerProblemException(message);
        }
    }
}
