package com.facebook.datasource;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    public void onCancellation(DataSource<T> dataSource) {
    }

    public void onFailure(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onFailureImpl(DataSource<T> dataSource);

    public void onNewResult(DataSource<T> dataSource) {
        boolean isFinished = dataSource.isFinished();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (isFinished) {
                dataSource.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(DataSource<T> dataSource);

    public void onProgressUpdate(DataSource<T> dataSource) {
    }
}
