package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.kalugin19.vkmessenger.android.pub.v1.data.Optional;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.data.models.ChatsModel;

public class ChatPresenter implements IChatContract.Presenter {

    private IChatContract.View view;
    private final ChatsModel chatsModel;
    private final int COUNT = 5;

    @Inject
    ChatPresenter(ChatsModel chatsModel) {
        this.chatsModel = chatsModel;
    }

    @Override
    public void attachView(IChatContract.View view) {
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
    public void loadFriends(final int page) {
        int offset = COUNT * page;
        chatsModel.requestFriends(COUNT, offset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Optional<List<Friend>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Optional<List<Friend>> listOptional) {
                        if (page == 0) {
                            view.showProgressUsers(true);
                        } else {
                            view.startProgressLoadMoreUsers();
                        }

                        if (listOptional != null) {
                            List<Friend> friends = listOptional.getValue();
                            if (friends != null && !friends.isEmpty()) {
                                if (page == 0) {
                                    view.showProgressUsers(false);
                                    view.setFirstPageFriends(friends, friends.size() < COUNT);
                                } else {
                                    view.stopProgressLoadMoreUsers();
                                    view.addFriends(friends, friends.size() < COUNT);
                                }
                            }
                        } else {
                            if (page == 0) {
                                view.showProgressUsers(false);
                            } else {
                                view.stopProgressLoadMoreUsers();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (page == 0) {
                            view.showProgressUsers(false);
                        } else {
                            view.stopProgressLoadMoreUsers();
                        }                    }
                });
    }
}
