package ru.kalugin19.vkmessenger.android.pub.v1.data.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Базовый класс ответа
 *
 * @author Gusev Andrey
 */
public class BaseResponse<T> {

    @SerializedName("ResponseData")
    private T responseData;
    @SerializedName("ResponseCode")
    private int responseCode;
    @SerializedName("ResponseMessage")
    private String responseMessage;

    public T getResponseData() {
        return responseData;
    }

    @SuppressWarnings("unused")
    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @SuppressWarnings("unused")
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    @SuppressWarnings("unused")
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
