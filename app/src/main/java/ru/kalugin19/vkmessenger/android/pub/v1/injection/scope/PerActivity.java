package ru.kalugin19.vkmessenger.android.pub.v1.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Scope : Per Activity
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
