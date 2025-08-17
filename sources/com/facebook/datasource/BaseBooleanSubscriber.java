package com.facebook.datasource;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
    public void onCancellation(DataSource<Boolean> dataSource) {
    }

    public void onFailure(DataSource<Boolean> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onFailureImpl(DataSource<Boolean> dataSource);

    public void onNewResult(DataSource<Boolean> dataSource) {
        try {
            onNewResultImpl(dataSource.getResult().booleanValue());
        } finally {
            dataSource.close();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(boolean z2);

    public void onProgressUpdate(DataSource<Boolean> dataSource) {
    }
}
