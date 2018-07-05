package ru.kalugin19.vkmessenger.android.pub.v1.data.remote;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.GetFriendsResponse;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.GetUserDataResponse;

/**
 * Интерфейс Rest сервиса
 *
 * @author Gusev Andrey
 */
public interface RestService {
    @GET("users.get")
    Single<Response<GetUserDataResponse>> getProfile(@QueryMap HashMap<String, String> params);

    @GET("friends.get")
    Single<Response<GetFriendsResponse>> getFriends(@QueryMap HashMap<String, String> params);
}
