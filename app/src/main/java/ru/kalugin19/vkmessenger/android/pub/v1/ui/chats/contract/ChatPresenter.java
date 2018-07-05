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
    public void loadFriends(int page) {
        chatsModel.requestFriends(100, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Optional<List<Friend>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Optional<List<Friend>> listOptional) {
                        if (listOptional!=null){
                            List<Friend> friends = listOptional.getValue();
                            if (friends!=null && !friends.isEmpty()){
                                view.setFirstPageFriends(friends);
                            }
                        }
//                        if (view != null) {
//                            if (pageListMessage > 0) {
//                                view.stopProgressGetPageListMessage();
//                            } else {
//                                view.stopProgressGetListMessage();
//                            }
//                            if (listResponseFromObservable.getException() != null) {
//                                ActionInMessageScreen actionInMessageScreen = null;
//                                if (pageListMessage == 0) {
//                                    view.showErrorGetListMessage();
//                                    actionInMessageScreen = ActionInMessageScreen.LOAD_MESSAGE_FIRST_PAGE;
//                                } else {
//                                    view.showErrorLoadPageMessage();
//                                }
//                                processError(listResponseFromObservable.getException(), actionInMessageScreen);
//                            } else {
//                                if (listResponseFromObservable.getData() != null) {
//                                    view.addListMessage(listResponseFromObservable.getData().getPageListMessage(), listResponseFromObservable.getData().isEndPage());
//                                } else {
//                                    view.addListMessage(new ArrayList<MessageInfo>(), false);
//                                }
//                            }
//
//                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }
                });
    }
}
