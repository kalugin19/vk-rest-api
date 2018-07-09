package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.kalugin19.vkmessenger.android.pub.v1.R;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.base.view.fragments.BaseFragment;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.adapter.FriendsAdapter;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.contract.IChatContract;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.util.scroll_listener.EndlessScrollListener;

/**
 * Фргамент "Спиоск друзей"
 */
public class ChatsFragment extends BaseFragment implements IChatContract.View {

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.recyclerChats)
    RecyclerView recyclerChats;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.name)
    TextView name;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.imgBtnSend)
    ImageButton btnSend;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.edit_text_message)
    EditText editTextMessage;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.emptyState)
    TextView emptyState;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.bottom_sheet)
    ConstraintLayout bottomSheet;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.text_input_text_message)
    TextInputLayout textInputLayout;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.progressSending)
    ProgressBar progressBarSending;

    @SuppressWarnings("WeakerAccess")
    @Inject
    IChatContract.Presenter presenter;

    private FriendsAdapter friendsAdapter;

    private EndlessScrollListener endlessScrollListener;

    private BottomSheetBehavior bottomSheetBehavior;

    public static ChatsFragment newInstance() {
        return new ChatsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.attachView(this);
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        if (getActivity() != null) {
            recyclerChats.setLayoutManager(linearLayoutManager);
            recyclerChats.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        }

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        endlessScrollListener = new EndlessScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                endlessScrollListener.setLoading(true);
                presenter.loadFriends(page);
            }
        };
        recyclerChats.addOnScrollListener(endlessScrollListener);
        friendsAdapter = new FriendsAdapter(new FriendsAdapter.IFriendInteraction() {
            @Override
            public void onClick(final Friend friend) {
                if (friend != null) {
                    editTextMessage.setText("");
                    toggleBottomSheet();
                    name.setText(getActivity().getString(R.string.first_last_name, friend.getFirstName(), friend.getLastName()));
                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (friend.getId() != null) {
                                String message = editTextMessage.getText().toString();
                                if (!TextUtils.isEmpty(message)) {
                                    presenter.sendMessage(friend.getId(), message);
                                } else {
                                    textInputLayout.setError(getString(R.string.chats_friends_empty_message_error));
                                }
                            }
                        }
                    });
                }
            }
        });
        recyclerChats.setAdapter(friendsAdapter);
        return view;
    }


    private void toggleBottomSheet() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        presenter.loadFriends(0);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    public void showUserEmptyState(boolean flag) {
        emptyState.setVisibility(flag ? View.VISIBLE : View.GONE);
        recyclerChats.setVisibility(flag ? View.GONE : View.VISIBLE);
    }

    @Override
    public void closeBottomSheet() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
            toggleBottomSheet();
        }
    }

    @Override
    public void showProgressSending(boolean flag) {
        progressBarSending.setVisibility(flag ? View.VISIBLE : View.INVISIBLE);
        btnSend.setVisibility(!flag ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void showErrorSending() {
        if (getActivity() != null) {
            editTextMessage.setError(getActivity().getString(R.string.chats_friends_sending_message_error));
        }
    }

    @Override
    public void messageWasSuccessfullySend() {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.chats_friends_sending_was_success, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void setFirstPageFriends(List<Friend> friends, boolean isEnd) {
        if (friends.isEmpty()) {
            showUserEmptyState(true);
        } else {
            showUserEmptyState(false);
            endlessScrollListener.setEnd(isEnd);
            endlessScrollListener.setLoading(false);
            friendsAdapter.clearList();
            addFriends(friends, isEnd);
        }
    }

    @Override
    public void addFriends(List<Friend> friends, boolean isEnd) {
        endlessScrollListener.setEnd(isEnd);
        endlessScrollListener.setLoading(false);
        if (friendsAdapter != null) {
            friendsAdapter.addFriends(friends);
        }
    }

    @Override
    public void startProgressLoadMoreUsers() {
        if (friendsAdapter != null) {
            friendsAdapter.enableLoad();
            endlessScrollListener.setLoading(true);
        }
    }

    @Override
    public void stopProgressLoadMoreUsers() {
        if (friendsAdapter != null) {
            friendsAdapter.disableLoad();
            endlessScrollListener.setLoading(false);
        }
    }

    @Override
    public void showProgressUsers(boolean flag) {
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);
    }
}
