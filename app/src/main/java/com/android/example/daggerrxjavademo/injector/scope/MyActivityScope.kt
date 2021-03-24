package com.android.example.daggerrxjavademo.injector.scope

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MyActivityScope
