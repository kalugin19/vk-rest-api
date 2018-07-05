package ru.kalugin19.vkmessenger.android.pub.v1.ui.chats.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ru.kalugin19.vkmessenger.android.pub.v1.R;
import ru.kalugin19.vkmessenger.android.pub.v1.data.dto.friends.Friend;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.util.ViewUtil;


/**
 * Адаптер для списка друзей
 */
public class FriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private final List<Friend> friends;
    private final IFriendClickListener mListener;
    private final static int ITEM_FRIEND = 0;
    private final static int ITEM_LOAD = 1;

    public FriendsAdapter(IFriendClickListener mListener) {
        friends = new ArrayList<>();
        this.mListener = mListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < friends.size()) {
            if (friends.get(position) == null) {
                return ITEM_LOAD;
            }
            return ITEM_FRIEND;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_FRIEND) {
            View view = inflater.inflate(R.layout.item_friend, parent, false);
            return new FriendViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FriendViewHolder) {
            FriendViewHolder friendViewHolder = (FriendViewHolder) holder;
            Friend friend = friends.get(position);
            if (friend != null) {
                if (!TextUtils.isEmpty(friend.getFirstName()) && !TextUtils.isEmpty(friend.getLastName())) {
                    String name = context.getString(R.string.first_last_name, friend.getFirstName(), friend.getLastName());
                    friendViewHolder.name.setText(name);
                }
                ViewUtil.loadProfilePhoto(context, friendViewHolder.friendPhoto, friend.getPhoto100());
            }
        }
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public void addFriends(List<Friend> items) {
        int previousDataSize = this.friends.size();
        this.friends.addAll(items);
        try {
            notifyItemRangeInserted(previousDataSize, items.size());
        } catch (IllegalStateException ex) {
            notifyDataSetChanged();
        }
    }

    public void enableLoad() {
        if (friends.isEmpty() || friends.get(friends.size() - 1) != null) {
            friends.add(null);
            notifyItemInserted(friends.size() - 1);
        }
    }

    public void disableLoad() {
        if (!friends.isEmpty() && friends.get(friends.size() - 1) == null) {
            friends.remove(friends.size() - 1);
            notifyItemRemoved(friends.size());
        }
    }

    /**
     * Очистить список
     */
    public void clearList() {
        friends.clear();
        notifyDataSetChanged();
    }


    //==============================================================================================
    //                                        View Holder
    //==============================================================================================

    class FriendViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.friendsName)
        TextView name;

        @BindView(R.id.friendImage)
        CircleImageView friendPhoto;

        FriendViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progressLoading)
        ProgressBar progressBar;

        LoadingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface IFriendClickListener {
        void onFriendClick(Friend friend);
    }
}
