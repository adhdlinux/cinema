package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public final class MoreExecutors {
    private MoreExecutors() {
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }
}
