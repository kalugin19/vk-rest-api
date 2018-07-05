package ru.kalugin19.vkmessenger.android.pub.v1.data.models;

import android.text.TextUtils;

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
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.Counters;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.GetUserDataResponse;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.RelationPartner;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.user_profile.ResponseItem;
import ru.kalugin19.vkmessenger.android.pub.v1.data.entity.Profile;
import ru.kalugin19.vkmessenger.android.pub.v1.data.exceptions.RestExceptionFactory;
import ru.kalugin19.vkmessenger.android.pub.v1.data.remote.RestService;


public class ProfileModel {

    private final RestService restService;

    @Inject
    public ProfileModel(RestService restService) {
        this.restService = restService;
    }

    public Single<Optional<Profile>> getProfile(String userId, String oauth) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Util.USER_IDS, userId);
        params.put(Util.FIELDS_KEY_WORD, Util.PROFILE_FIELDS);
        params.put(Util.VERSION, BuildConfig.VERSION);
        params.put(Util.NAME_CASE, Util.NOM);
        params.put(Util.ACCESS_TOKEN, oauth);
        return restService.getProfile(params)
                .subscribeOn(Schedulers.io())
                .map(new Function<Response<GetUserDataResponse>, Optional<Profile>>() {
                    @Override
                    public Optional<Profile> apply(Response<GetUserDataResponse> response) throws Exception {
                        if (response != null) {
                            if (!response.isSuccessful()) {
                                RestExceptionFactory.throwException(response);
                            }
                            GetUserDataResponse getUserDataResponse = response.body();
                            if (getUserDataResponse != null) {
                                Profile profile = convertGetUserDataResponseToProfile(getUserDataResponse);
                                if (profile != null) {
                                    return new Optional<>(profile);
                                }
                            }
                        }
                        return new Optional<>(null);
                    }
                });
    }


    private Profile convertGetUserDataResponseToProfile(GetUserDataResponse getUserDataResponse) {
        if (getUserDataResponse != null) {
            List<ResponseItem> responseList = getUserDataResponse.getResponse();
            if (responseList != null && !responseList.isEmpty()) {
                ResponseItem responseItem = responseList.get(0);
                if (responseItem != null) {
                    Profile profile = new Profile();
                    if (!TextUtils.isEmpty(responseItem.getFirstName())) {
                        profile.setFirstName(responseItem.getFirstName());
                    }
                    if (!TextUtils.isEmpty(responseItem.getLastName())) {
                        profile.setLastName(responseItem.getLastName());
                    }
                    if (!TextUtils.isEmpty(responseItem.getBdate())) {
                        profile.setBirthday(responseItem.getBdate());
                    }
                    if (!TextUtils.isEmpty(responseItem.getPhoto100())) {
                        profile.setThumbPhoto(responseItem.getPhoto100());
                    }
                    if (!TextUtils.isEmpty(responseItem.getUniversityName())) {
                        profile.setUniversityName(responseItem.getUniversityName());
                    }
                    RelationPartner relationPartner = responseItem.getRelationPartner();
                    if (relationPartner != null) {
                        if (!TextUtils.isEmpty(relationPartner.getFirstName()) && !TextUtils.isEmpty(relationPartner.getLastName())) {
                            profile.setRelationPartner(relationPartner.getFirstName() + " " + relationPartner.getLastName());
                        }
                    }
                    Counters counters = responseItem.getCounters();
                    if (counters != null) {
                        profile.setFriendsCount(counters.getFriends());
                        profile.setFollowersCount(counters.getFollowers());
                    }
                    return profile;
                }
            }
        }
        return null;
    }

}
