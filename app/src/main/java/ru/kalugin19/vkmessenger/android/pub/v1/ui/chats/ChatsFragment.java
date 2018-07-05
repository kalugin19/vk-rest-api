package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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

public class ChatsFragment extends BaseFragment implements IChatContract.View {

    @BindView(R.id.recyclerChats)
    RecyclerView recyclerChats;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    IChatContract.Presenter presenter;

    private FriendsAdapter friendsAdapter;

    private EndlessScrollListener endlessScrollListener;

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

        endlessScrollListener = new EndlessScrollListener(linearLayoutManager, 5, true) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                endlessScrollListener.setLoading(true);
            }
        };
        recyclerChats.addOnScrollListener(endlessScrollListener);
        friendsAdapter = new FriendsAdapter(new FriendsAdapter.IFriendClickListener() {
            @Override
            public void onFriendClick(Friend friend) {

            }
        });
        recyclerChats.setAdapter(friendsAdapter);
        return view;
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
        presenter.loadFriends(1);
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

    @Override
    public void setFirstPageFriends(List<Friend> friends) {
        if (friends != null) {
            friendsAdapter.setData(friends);
        }
    }

    @Override
    public void addFriends(List<Friend> friends) {
        if (friends != null && !friends.isEmpty()) {
            friendsAdapter.addFriends(friends);
        }
    }
}
