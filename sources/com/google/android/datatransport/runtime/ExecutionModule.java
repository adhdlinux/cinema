package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

abstract class ExecutionModule {
    ExecutionModule() {
    }

    @Singleton
    static Executor a() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
