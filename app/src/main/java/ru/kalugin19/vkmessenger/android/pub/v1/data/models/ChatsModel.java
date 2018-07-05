package ru.kalugin19.vkmessenger.android.pub.v1.data.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import ru.kalugin19.vkmessenger.android.pub.v1.BuildConfig;
import ru.kalugin19.vkmessenger.android.pub.v1.data.Optional;
import ru.kalugin19.vkmessenger.android.pub.v1.data.Util;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.GetFriendsResponse;
import ru.kalugin19.vkmessenger.android.pub.v1.data.exceptions.RestExceptionFactory;
import ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences.UserPreferenceHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.remote.RestService;
import ru.kalugin19.vkmessenger.android.pub.v1.data.remote.RetrofitHelper;

public class ChatsModel {

    private final RestService restService;
    private final UserPreferenceHelper userPreferenceHelper;

    @Inject
    public ChatsModel(RestService restService, UserPreferenceHelper userPreferenceHelper) {
        this.restService = RetrofitHelper.getInstanceRestService();
        this.userPreferenceHelper = userPreferenceHelper;
    }

    public Single<Optional<List<Friend>>> requestFriends(int count, int offset) {
        HashMap<String, String> params = new HashMap<>();

        String userId = userPreferenceHelper.getUserId();
        String token = userPreferenceHelper.getToken();

        params.put(Util.USER_IDS, userId);
        params.put(Util.VERSION, BuildConfig.VERSION);
        params.put(Util.NAME_CASE, Util.NOM);
        params.put(Util.ACCESS_TOKEN, token);
        params.put(Util.ORDER_KEYWORD, Util.ORDER_HINTS);
        params.put(Util.COUNT_KEYWORD, String.valueOf(count));
        params.put(Util.COUNT_OFFSET, String.valueOf(offset));
        params.put(Util.FIELDS_KEY_WORD, Util.FRIENDS_FIELD);

        return restService.getFriends(params)
                .subscribeOn(Schedulers.io())
                .map(new Function<Response<GetFriendsResponse>, Optional<List<Friend>>>() {
                    @Override
                    public Optional<List<Friend>> apply(Response<GetFriendsResponse> response) throws Exception {
                        if (response != null) {
                            if (!response.isSuccessful()) {
                                RestExceptionFactory.throwException(response);
                            }
                            GetFriendsResponse getFriendsResponse = response.body();
                            if (getFriendsResponse != null) {
                                List<Friend> friends = convertResponseToFriends(getFriendsResponse);
                                if (friends != null) {
                                    return new Optional<>(friends);
                                }
                            }
                        }
                        return new Optional<>(null);
                    }
                });
    }


    private List<Friend> convertResponseToFriends(GetFriendsResponse getFriendsResponse) {
        if (getFriendsResponse != null) {
            List<Friend> friends = getFriendsResponse.getItems();
            if (friends != null && !friends.isEmpty()) {
                return friends;
            }
        }
        return null;
    }
}
