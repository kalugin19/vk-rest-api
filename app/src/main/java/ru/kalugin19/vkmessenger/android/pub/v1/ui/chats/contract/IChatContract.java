package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract;

import java.util.List;

import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;


public interface IChatContract {

    interface View extends ViewContract {

        void setFirstPageFriends(List<Friend> friends, boolean isEnd);

        void addFriends(List<Friend> friends, boolean isEnd);

        void startProgressLoadMoreUsers();

        void stopProgressLoadMoreUsers();

        void showProgressUsers(boolean flag);
    }

    interface Presenter extends BasePresenter<View> {
        void loadFriends(int page);
    }
}
