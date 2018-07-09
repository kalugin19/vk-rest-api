package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract;

import java.util.List;

import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.presenter.BasePresenter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.ViewContract;

/**
 * контраки для "Спиоск друзей"
 */
public interface IChatContract {

    interface View extends ViewContract {

        void setFirstPageFriends(List<Friend> friends, boolean isEnd);

        void addFriends(List<Friend> friends, boolean isEnd);

        void startProgressLoadMoreUsers();

        void stopProgressLoadMoreUsers();

        void showProgressUsers(boolean flag);

        void showUserEmptyState(boolean flag);

        void closeBottomSheet();

        void showProgressSending(boolean flag);

        void showErrorSending();

        void messageWasSuccessfullySend();
    }

    /**
     * презентер для "Списка друзей"
     */
    interface Presenter extends BasePresenter<View> {

        /**
         * загрузить список друзей
         *
         * @param page - страница
         */
        void loadFriends(int page);

        /**
         * Отправить сообщение
         *
         * @param userId  - id пользователя, которому отправляем сообщение
         * @param message - сообщение
         */
        void sendMessage(int userId, String message);
    }
}
