package ru.kalugin19.vkmessenger.android.pub.v1.data;

public class Optional<T> {

    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}