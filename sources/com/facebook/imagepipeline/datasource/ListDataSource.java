package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    private final DataSource<CloseableReference<T>>[] mDataSources;
    private int mFinishedDataSources = 0;

    private class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        boolean mFinished;

        private InternalDataSubscriber() {
            this.mFinished = false;
        }

        private synchronized boolean tryFinish() {
            if (this.mFinished) {
                return false;
            }
            this.mFinished = true;
            return true;
        }

        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceCancelled();
        }

        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceFailed(dataSource);
        }

        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            if (dataSource.isFinished() && tryFinish()) {
                ListDataSource.this.onDataSourceFinished();
            }
        }

        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceProgress();
        }
    }

    protected ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.mDataSources = dataSourceArr;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        boolean z2;
        Preconditions.checkNotNull(dataSourceArr);
        if (dataSourceArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        ListDataSource<T> listDataSource = new ListDataSource<>(dataSourceArr);
        for (DataSource<CloseableReference<T>> dataSource : dataSourceArr) {
            if (dataSource != null) {
                dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
            }
        }
        return listDataSource;
    }

    private synchronized boolean increaseAndCheckIfLast() {
        boolean z2;
        z2 = true;
        int i2 = this.mFinishedDataSources + 1;
        this.mFinishedDataSources = i2;
        if (i2 != this.mDataSources.length) {
            z2 = false;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void onDataSourceCancelled() {
        setFailure(new CancellationException());
    }

    /* access modifiers changed from: private */
    public void onDataSourceFailed(DataSource<CloseableReference<T>> dataSource) {
        Throwable failureCause = dataSource.getFailureCause();
        if (failureCause == null) {
            failureCause = new Throwable("Unknown failure cause");
        }
        setFailure(failureCause);
    }

    /* access modifiers changed from: private */
    public void onDataSourceFinished() {
        if (increaseAndCheckIfLast()) {
            setResult(null, true, (Map<String, Object>) null);
        }
    }

    /* access modifiers changed from: private */
    public void onDataSourceProgress() {
        float f2 = 0.0f;
        for (DataSource<CloseableReference<T>> progress : this.mDataSources) {
            f2 += progress.getProgress();
        }
        setProgress(f2 / ((float) this.mDataSources.length));
    }

    public boolean close() {
        if (!super.close()) {
            return false;
        }
        for (DataSource<CloseableReference<T>> close : this.mDataSources) {
            close.close();
        }
        return true;
    }

    public synchronized boolean hasResult() {
        boolean z2;
        if (isClosed() || this.mFinishedDataSources != this.mDataSources.length) {
            z2 = false;
        } else {
            z2 = true;
        }
        return z2;
    }

    public synchronized List<CloseableReference<T>> getResult() {
        if (!hasResult()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.mDataSources.length);
        for (DataSource<CloseableReference<T>> result : this.mDataSources) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
