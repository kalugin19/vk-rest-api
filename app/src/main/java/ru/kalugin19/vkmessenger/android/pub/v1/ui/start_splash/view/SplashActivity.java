package ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.kalugin19.vkmessenger.android.pub.v1.R;
import ru.kalugin19.vkmessenger.android.pub.v1.data.Util;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.main.MainActivity;
import ru.kalugin19.vkmessenger.android.pub.v1.ui.start_splash.presenter.ISplashContract;

/**
 * Сплэш
 */
public class SplashActivity extends AppCompatActivity implements ISplashContract.View {

    @SuppressWarnings("WeakerAccess")
    @Inject
    ISplashContract.Presenter splashPresenter;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.splashProgressBar)
    ProgressBar progressBar;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.activity_splash_screen_global_view)
    View globalView;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.logo)
    ImageView logo;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.signIn)
    Button singInBtn;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.webView)
    WebView webView;

    //====================================================================================================
    //                                              Lifecycle
    //====================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_splash);
        ButterKnife.bind(this);
        splashPresenter.attachView(this);
        singInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                splashPresenter.authorization();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        splashPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        splashPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        splashPresenter.onStop();
    }

    //===================================================================================================
    //                                          Contract methods
    //===================================================================================================

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void showProgressBar(boolean flag) {
        if (flag) {
            showSignIn(false);
            showWebView(false);
        }
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showAuthorizationWebForm() {
        webView.setWebViewClient(new AuthWebViewClient());
        webView.loadUrl(Util.AUTH_URL);
        webView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInternetConnectionError() {
        Snackbar.make(globalView, R.string.no_internet_connection, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showUnknownError() {
        Snackbar.make(globalView, R.string.unknown_error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showWebView(boolean flag) {
        webView.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showSignIn(boolean flag) {
        logo.setVisibility(flag ? View.VISIBLE : View.GONE);
        singInBtn.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    private class AuthWebViewClient extends WebViewClient {
        private final String KEY_WORD_TOKEN = "access_token=";
        private final String KEY_WORD_USER_ID = "user_id=";

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
            if (request != null && request.getUrl() != null) {
                Uri uri = request.getUrl();
                String url = uri.toString();
                return shouldOverrideUrlLoading(url);
            } else {
                return false;
            }
        }

        private boolean shouldOverrideUrlLoading(final String url) {
            if (url.contains(KEY_WORD_TOKEN)) {
                String token = parseToken(url);
                String userId = parseUserId(url);
                if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(userId)) {
                    splashPresenter.saveAuthData(token, userId);
                    goToMainActivity();
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return shouldOverrideUrlLoading(url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            showProgressBar(false);
            showWebView(true);
            showSignIn(false);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            showProgressBar(false);
            showWebView(false);
            showSignIn(true);
            showUnknownError();
        }

        private String parseToken(String url) {
            try {
                if (url.contains(KEY_WORD_TOKEN)) {
                    int startIndexOfToken = url.lastIndexOf(KEY_WORD_TOKEN) + KEY_WORD_TOKEN.length();
                    int endIndexOfToken = url.indexOf("&", startIndexOfToken);
                    return url.substring(startIndexOfToken, endIndexOfToken);
                } else {
                    return "";
                }
            } catch (StringIndexOutOfBoundsException se) {
                return "";
            }
        }

        private String parseUserId(String url) {
            try {
                if (url.contains(KEY_WORD_USER_ID)) {
                    int startIndexOfUserId = url.lastIndexOf(KEY_WORD_USER_ID) + KEY_WORD_USER_ID.length();
                    return url.substring(startIndexOfUserId);
                } else {
                    return "";
                }
            } catch (StringIndexOutOfBoundsException se) {
                return "";
            }
        }
    }
}
