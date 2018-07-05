package ru.kalugin19.vkmessenger.android.pub.v1.ui.base;


import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;

/**
 * Класс для проверки валидации
 *
 * @author Gusev Andrey
 */
@SuppressWarnings("WeakerAccess")
public class CustomTextWatcher implements TextWatcher {
    private final WeakReference<EditText> editText;
    private final ICallBack callBack;

    @SuppressWarnings("unused")
    public CustomTextWatcher(EditText editText) {
        this.editText = new WeakReference<>(editText);
        callBack = null;
    }

    @SuppressWarnings("unused")
    public CustomTextWatcher(EditText editText, ICallBack callBack) {
        this.editText = new WeakReference<>(editText);
        this.callBack = callBack;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (editText.get() != null && editText.get().getParent() != null && editText.get().getParent().getParent() != null && editText.get().getParent().getParent() instanceof TextInputLayout) {
            ((TextInputLayout) editText.get().getParent().getParent()).setError(null);
            ((TextInputLayout) editText.get().getParent().getParent()).setErrorEnabled(false);
        }
        if (callBack != null) {
            callBack.fieldOnChange();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @SuppressWarnings("unused")
    public interface ICallBack {
        void fieldOnChange();
    }
}
