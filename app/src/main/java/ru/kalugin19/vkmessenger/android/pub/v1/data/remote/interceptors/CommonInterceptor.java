package ru.kalugin19.vkmessenger.android.pub.v1.data.remote.interceptors;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import ru.kalugin19.vkmessenger.android.pub.v1.data.service.ConnectionService;


/**
 * Common Interceptor
 *
 * @author Gusev Andrey
 */
public class CommonInterceptor implements Interceptor {

    private final ConnectionService connectionService;
//    private final UserPreferenceHelper userPreferenceHelper;
    private final static int ERROR_AUTHORIZATION = 401;
    final private static int UN_AUTHORIZE_CODE = 3;
    final private static int SUCCESS_CODE = 1;
    private final static String X_API_KEY = "X-API-Key";
    private final static String X_AUTH_TOKEN = "X-Auth-Token";


    @SuppressWarnings("unused")
    public CommonInterceptor() {
        this.connectionService = ConnectionService.getInstance();
//        this.userPreferenceHelper = UserPreferenceHelper.getInstance();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
//        try {
////            Request originalRequest = chain.request().newBuilder().addHeader(X_API_KEY, BuildConfig.X_API_KEY).build();
//            FriendsResponse originalResponse = chain.proceed(originalRequest);
////            String responseBodyString = originalResponse.body() != null ? convertResponseBodyToString(originalResponse.body()) : "";
//
//            if (!originalResponse.isSuccessful()) {
//                if (originalResponse.code() == ERROR_AUTHORIZATION) {
//                    Request authRequest = createAuthRequest();
//                    if (authRequest == null) {
//                        RestExceptionFactory.throwException(ERROR_AUTHORIZATION, "Пользовательская сессия истекла");
//                    } else {
//                        FriendsResponse authResponse = chain.proceed(authRequest);
//                        if (authResponse.isSuccessful()) {
//                            responseBodyString = authResponse.body().toString();
//                            BaseResponse baseResponse = new Gson().fromJson(responseBodyString, BaseResponse.class);
//                            if (baseResponse.getResponseData() != null && baseResponse.getResponseData() instanceof String) {
//                                userPreferenceHelper.setToken((String) baseResponse.getResponseData());
//                                FriendsResponse lastChanceResponse = chain.proceed(originalRequest.newBuilder().header(X_AUTH_TOKEN, (String) baseResponse.getResponseData()).build());
//                                if (lastChanceResponse.isSuccessful()) {
//                                    return lastChanceResponse;
//                                } else {
//                                    if (lastChanceResponse.code() == ERROR_AUTHORIZATION) {
//                                        RestExceptionFactory.throwException(ERROR_AUTHORIZATION, "Пользовательская сессия истекла");
//                                    } else {
//                                        RestExceptionFactory.throwException(originalResponse);
//                                    }
//                                }
//                            } else {
//                                RestExceptionFactory.throwException(ERROR_AUTHORIZATION, "Пользовательская сессия истекла");
//                            }
//                        } else {
//                            RestExceptionFactory.throwException(ERROR_AUTHORIZATION, "Пользовательская сессия истекла");
//                        }
//                    }
//                } else {
//                    RestExceptionFactory.throwException(originalResponse);
//                }
//
//            } else {
//
//                BaseResponse<String> stringBaseResponse = new BaseResponse<>();
//                BaseResponse baseResponse = new Gson().fromJson(responseBodyString, stringBaseResponse.getClass());
//                if (baseResponse.getResponseCode() != SUCCESS_CODE) {
//                    if (baseResponse.getResponseCode() == UN_AUTHORIZE_CODE) {
//                        Request authRequest = createAuthRequest();
//                        if (authRequest == null) {
//                            RestExceptionFactory.throwException(UN_AUTHORIZE_CODE, "Пользовательская сессия истекла");
//                        } else {
//                            FriendsResponse authResponse = chain.proceed(authRequest);
//                            if (authResponse.isSuccessful()) {
//                                String responseBodyStringLast = authResponse.body().string();
//                                BaseResponse response = new Gson().fromJson(responseBodyStringLast, BaseResponse.class);
//
//                                if (response.getResponseData() != null && response.getResponseData() instanceof String) {
//                                    userPreferenceHelper.setToken((String) response.getResponseData());
//                                    FriendsResponse lastChanceResponse = chain.proceed(originalRequest.newBuilder().header(X_AUTH_TOKEN, (String) response.getResponseData()).build());
//                                    if (lastChanceResponse.isSuccessful()) {
//                                        String lastChanceResponseBody = convertResponseBodyToString(lastChanceResponse.body());
//                                        BaseResponse baseResponseLast = new Gson().fromJson(lastChanceResponseBody, BaseResponse.class);
//                                        if (baseResponseLast.getResponseCode() != SUCCESS_CODE) {
//                                            RestExceptionFactory.throwException(baseResponseLast.getResponseCode(), baseResponseLast.getResponseMessage());
//                                        } else {
//                                            userPreferenceHelper.setToken((String) response.getResponseData());
//                                            return lastChanceResponse;
//                                        }
//                                    } else {
//                                        RestExceptionFactory.throwException(originalResponse);
//                                    }
//                                } else {
//                                    RestExceptionFactory.throwException(UN_AUTHORIZE_CODE, "Пользовательская сессия истекла");
//                                }
//                            } else {
//                                RestExceptionFactory.throwException(UN_AUTHORIZE_CODE, "Пользовательская сессия истекла");
//                            }
//                        }
//                    } else {
//                        RestExceptionFactory.throwException(baseResponse.getResponseCode(), baseResponse.getResponseMessage());
//                    }
//                }
//
//            }
//            return originalResponse;
//        } catch (IOException e) {
//            if (!connectionService.checkInternetConnection()) {
//                throw new NoInternetException();
//            }
//            throw e;
//        }
        return null;
    }

    private String convertResponseBodyToString(ResponseBody responseBody) {
        try {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = Charset.forName("UTF8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }

            if (!isPlaintext(buffer)) {
                return "";
            }

            if (responseBody.contentLength() != 0) {
                if (charset != null) {
                    return buffer.clone().readString(charset);
                }
            }
        } catch (IOException e) {
            return "";
        }
        return "";
    }

    private boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private Request createAuthRequest() {
//        if (userPreferenceHelper != null) {
//            UserAuthInfo userInfo = userPreferenceHelper.getUserInfo();
//            if (userInfo != null) {
//                String log = userPreferenceHelper.getUserInfo().getLogin();
//                String pass = userPreferenceHelper.getUserInfo().getPassword();
//                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), "{\"login\": \"" + log + "\",\"password\": \"" + pass + "\"}");
//                return new Request.Builder()
//                        .url(BuildConfig.REST_END_POINT + "login")
//                        .header(X_API_KEY, BuildConfig.X_API_KEY)
//                        .method("POST", requestBody)
//                        .build();
//            }
//        }
        return null;
    }

}
