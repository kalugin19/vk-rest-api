package ru.kalugin19.vkmessenger.android.pub.v1.data.remote;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.kalugin19.vkmessenger.android.pub.v1.BuildConfig;
import ru.kalugin19.vkmessenger.android.pub.v1.data.service.ConnectionService;

/**
 * Хэлпер для Retrofit сервиса
 *
 * @author Gusev Andrey
 */
@SuppressWarnings("WeakerAccess")
public class RetrofitHelper {


    public static RestService restService;

    /**
     * Создание rest сервиса
     *
     * @return Rest сервис
     */
    public static RestService getInstanceRestService() {
        RestService localInstance = restService;
        if (localInstance == null) {
            synchronized (ConnectionService.class) {
                localInstance = restService;
                if (localInstance == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                    httpClient.cookieJar(new MyCookieJar());
//                    httpClient.addInterceptor(new CommonInterceptor());
                    httpClient.addInterceptor(logging);
                    httpClient.followRedirects(true);
                    httpClient.followSslRedirects(true);
                    OkHttpClient client = httpClient.build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BuildConfig.REST_END_POINT)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build();

                    restService = retrofit.create(RestService.class);
                }
            }
        }

        return restService;
    }

    /**
     * Хранилище cookie
     */
    public static class MyCookieJar implements CookieJar {

        private List<Cookie> cookies;

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            if (cookies != null) {
                return cookies;
            }
            return new ArrayList<>();
        }

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            this.cookies = cookies;
        }
    }
}
