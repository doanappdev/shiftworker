package com.example.doan.shiftworker.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 * Annotation to which specifies a 'Scope'.
 * The scope we are creating is the life time of the activity
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
