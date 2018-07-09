package ru.kalugin19.vkmessenger.android.pub.v1.ui.profile.contract;

import android.text.TextUtils;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.kalugin19.vkmessenger.android.pub.v1.data.Optional;
import ru.kalugin19.vkmessenger.android.pub.v1.data.entity.Profile;
import ru.kalugin19.vkmessenger.android.pub.v1.data.local.preferences.UserPreferenceHelper;
import ru.kalugin19.vkmessenger.android.pub.v1.data.models.ProfileModel;

/**
 * Реализация презентера Профиля
 */
public class ProfilePresenter implements IProfileContract.Presenter {

    private IProfileContract.View view;
    private final ProfileModel profileModel;
    private final UserPreferenceHelper userPreferenceHelper;

    @Inject
    ProfilePresenter(ProfileModel profileModel, UserPreferenceHelper userPreferenceHelper) {
        this.profileModel = profileModel;
        this.userPreferenceHelper = userPreferenceHelper;
    }

    @Override
    public void attachView(IProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void loadProfile() {
        String token = userPreferenceHelper.getToken();
        String userId = userPreferenceHelper.getUserId();
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(userId)) {
            profileModel.getProfile(userId, token)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<Optional<Profile>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(Optional<Profile> profileOptional) {
                            if (profileOptional != null && profileOptional.getValue() != null) {
                                view.setProfile(profileOptional.getValue());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }
                    });
        }
    }
}
