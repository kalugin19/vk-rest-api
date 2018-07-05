package ru.kalugin19.vkmessenger.android.pub.v1.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;

import ru.kalugin19.vkmessenger.android.pub.v1.R;


/**
 * Класс для отображения прогресс диалога
 *
 * @author Gusev Andrey
 */
@SuppressWarnings("WeakerAccess")
public class ProgressDialogCustom {

    private final ProgressDialog progressDialog;

    public ProgressDialogCustom(Context context, @SuppressWarnings("SameParameterValue") @StringRes int title) {
        this(context, context.getString(title));
    }

    public ProgressDialogCustom(Context context, String title) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(title);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
    }

    @SuppressWarnings("unused")
    public void setNegativeButton(DialogInterface.OnClickListener clickListener) {
        if (progressDialog != null) {
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, progressDialog.getContext().getString(R.string.cancel_button), clickListener);
        }
    }

    /**
     * Показать ProgressBar с сообщением на экране
     */
    public void showProgress() {
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    /**
     * Скрыть диалог
     */
    public void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
