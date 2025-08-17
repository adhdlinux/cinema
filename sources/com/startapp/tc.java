package com.startapp;

import com.startapp.sdk.components.ComponentLocator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class tc implements ua<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f36581a;

    public tc(ComponentLocator.n nVar, Executor executor) {
        this.f36581a = executor;
    }

    public Object call() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f36581a;
        return Integer.valueOf(threadPoolExecutor.getMaximumPoolSize() - threadPoolExecutor.getActiveCount());
    }
}
