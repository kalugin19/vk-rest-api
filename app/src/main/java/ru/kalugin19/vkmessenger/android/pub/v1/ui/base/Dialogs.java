package ru.kalugin19.vkmessenger.android.pub.v1.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;

import ru.kalugin19.vkmessenger.android.pub.v1.R;


/**
 * Класс для работы с алертами
 *
 * @author Gusev Andrey.
 */
public class Dialogs {

    /**
     * Тип алерт диалога
     */
    public enum TypeAlert {
        /**
         * Алерт, только с одной кнопкой "ОК"
         */
        ALERT_OK,

        /**
         * Алерт, если версия приложения устарела
         */
        ALERT_API_VERSION,
        /**
         * Алрет, если пользователь не принял правила игры
         */
        ALERT_RIGHTS,
        /**
         * Алерт подтверждение покупки точки
         */
        ALERT_CONFIRM,
    }

    @SuppressWarnings("unused")
    public interface IClickButtonDialog {
        void clickPositiveButton();

        @SuppressWarnings("EmptyMethod")
        void clickNegativeButton();
    }

    @SuppressWarnings("unused")
    public static AlertDialog showAlert(final Context context, final TypeAlert typeAlert, String titleId, String messageId, final IClickButtonDialog clickButton) {
        AlertDialog alert = createAlert(context, titleId, messageId);
        alert.setCanceledOnTouchOutside(false);
        switch (typeAlert) {
            case ALERT_OK:
                alert.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (clickButton != null) {
                            clickButton.clickPositiveButton();
                        }
                    }
                });
                break;
            case ALERT_API_VERSION:
                alert.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.update_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException ex) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                        if (clickButton != null) {
                            clickButton.clickPositiveButton();
                        }
                    }
                });
                break;
            case ALERT_RIGHTS:
                alert.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.accept_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (clickButton != null) {
                            clickButton.clickPositiveButton();
                        }
                    }
                });
                break;
            case ALERT_CONFIRM:
                alert.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.yes_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (clickButton != null) {
                            clickButton.clickPositiveButton();
                        }
                    }
                });
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.no_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (clickButton != null) {
                            clickButton.clickNegativeButton();
                        }
                    }
                });
                break;

        }

        alert.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_BACK:
                        dialog.cancel();
                        if (clickButton != null) {
                            clickButton.clickNegativeButton();
                        }
                        break;
                }
                return true;
            }
        });
        alert.show();
        return alert;

    }

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    public static AlertDialog showAlert(final Context context, final TypeAlert typeAlert, @android.support.annotation.StringRes Integer titleId, @android.support.annotation.StringRes int messageId, final IClickButtonDialog clickButton) {
        return showAlert(context, typeAlert, context.getString(titleId), context.getString(messageId), clickButton);
    }

    private static AlertDialog createAlert(Context context, String title, String message) {
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        if (title != null) {
            ad.setTitle(title);
        }
        return ad.setMessage(message)
                .create();
    }


    public  interface IActionInSelectDialog<T>{
        void selectItem(T item);
    }
}
