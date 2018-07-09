package ru.kalugin19.vkmessenger.android.pub.v1.data.exceptions;


import retrofit2.Response;

/**
 * Фабрика исключений сервера
 */
@SuppressWarnings("WeakerAccess")
public class RestExceptionFactory {

    @SuppressWarnings("unused")
    final private static int SYSTEM_ERROR = -1;
    final private static int UNKNOWN_ERROR = 1;
    final private static int AUTH_ERROR = 5;
    final private static int MANY_REQUESTS_PER_SECOND_ERROR = 6;
    final private static int WRONG_REQUEST_ERROR = 8;
    final private static int WRONG_TOKEN_ERROR = 113;
    final private static int INTERNAL_SERVER_ERROR = 10;
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

    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public static void throwException(int code, String message) throws RuntimeException {
        switch (code) {
            case (WRONG_TOKEN_ERROR ): {
                throw new SessionExpiredException();
            }
            case (UNKNOWN_ERROR): {
                throw new UnknownException();
            }
            case (AUTH_ERROR): {
                throw new AuthorizationException();
            }
            case (MANY_REQUESTS_PER_SECOND_ERROR): {
                throw new ManyRequestsException();
            }
            case (WRONG_REQUEST_ERROR): {
                throw new WrongRequestException();
            }
            case (INTERNAL_SERVER_ERROR):{
                throw new InternalServerException();
            }
            default:
                throw new ServerProblemException(message);
        }
    }
}
