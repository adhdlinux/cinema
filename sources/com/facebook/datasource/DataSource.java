package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;

public interface DataSource<T> {
    boolean close();

    Map<String, Object> getExtras();

    Throwable getFailureCause();

    float getProgress();

    T getResult();

    boolean hasFailed();

    boolean hasMultipleResults();

    boolean hasResult();

    boolean isClosed();

    boolean isFinished();

    void subscribe(DataSubscriber<T> dataSubscriber, Executor executor);
}
