package ru.kalugin19.vkmessenger.android.pub.v1.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Scope : Per Activity
 */
@SuppressWarnings("unused")
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
