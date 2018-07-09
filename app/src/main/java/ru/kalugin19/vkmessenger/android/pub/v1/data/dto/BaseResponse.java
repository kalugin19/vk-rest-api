package ru.kalugin19.vkmessenger.android.pub.v1.data.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Базовый класс ответа
 */
public class BaseResponse<T> {

    @SerializedName("response")
    private T responseData;

    @SuppressWarnings("unused")
    public T getResponseData() {
        return responseData;
    }

    @SuppressWarnings("unused")
    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }
}
