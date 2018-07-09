package ru.kalugin19.vkmessenger.android.pub.v1.data;

import ru.kalugin19.vkmessenger.android.pub.v1.BuildConfig;


public class Util {
    public static final String AUTH_URL = "https://oauth.vk.com/authorize?client_id=" + BuildConfig.APP_ID + "&display=page&scope=offline,messages,friends&response_type=token&v=" + BuildConfig.VERSION;
    public static final String FIELDS_KEY_WORD = "fields";
    public static final String USER_IDS = "user_ids";
    public static final String USER_ID = "user_id";
    public static final String PROFILE_FIELDS = "nickname, domain, sex, bdate, counters, city, country, timezone, photo_50, photo_100, photo_200_orig, has_mobile, contacts, education, online, relation, last_seen, status, can_write_private_message, can_see_all_posts, can_post, universities";
    public static final String VERSION = "version";
    public static final String NAME_CASE = "name_case";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String NOM = " nom";
    public static final String ORDER_KEYWORD = "order";
    public static final String ORDER_HINTS = "hints";
    public static final String COUNT_KEYWORD = "count";
    public static final String COUNT_OFFSET = "offset";
    public static final String FRIENDS_FIELD = "city, photo_100";
    public static final String MESSAGE = "message";


}
