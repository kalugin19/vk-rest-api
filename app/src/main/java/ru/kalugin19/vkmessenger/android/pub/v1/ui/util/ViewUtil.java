package ru.kalugin19.vkmessenger.android.pub.v1.ui.util;

import android.content.Context;
import android.widget.ImageView;

import ru.kalugin19.vkmessenger.android.pub.v1.R;


public class ViewUtil {

    public static void loadProfilePhoto(Context context, ImageView imageView, String url) {
        GlideApp
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_account)
                .into(imageView);
    }
}
