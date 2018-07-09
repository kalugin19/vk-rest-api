package ru.kalugin19.vkmessenger.android.pub.v1.data.remote;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.BaseResponse;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.ProfileDto;

/**
 * Интерфейс Rest сервиса
 */
public interface RestService {
    @GET("users.get")
    Single<Response<BaseResponse<List<ProfileDto>>>> getProfile(@QueryMap HashMap<String, String> params);

    @GET("friends.get")
    Single<Response<BaseResponse<List<Friend>>>> getFriends(@QueryMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("messages.send")
    Single<Response<BaseResponse<Integer>>> sendMessage(@FieldMap HashMap<String, String> params);
}
