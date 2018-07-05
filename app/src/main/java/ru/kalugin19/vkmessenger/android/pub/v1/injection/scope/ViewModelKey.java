package ru.kalugin19.vkmessenger.android.pub.v1.injection.scope;

import android.arch.lifecycle.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Scope: ViewModel
 *
 * @author Abu-Khalil Jumana
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    @SuppressWarnings("unused") Class<? extends ViewModel> value();
}
