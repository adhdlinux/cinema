package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: l  reason: collision with root package name */
        private final CountDownLatch f3795l = new CountDownLatch(1);

        /* renamed from: m  reason: collision with root package name */
        boolean f3796m;

        LoadTask() {
        }

        /* access modifiers changed from: protected */
        public void h(D d2) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, d2);
            } finally {
                this.f3795l.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void i(D d2) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.f3795l.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public D b(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e2) {
                if (f()) {
                    return null;
                }
                throw e2;
            }
        }

        public void o() {
            try {
                this.f3795l.await();
            } catch (InterruptedException unused) {
            }
        }

        public void run() {
            this.f3796m = false;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f3800i);
    }

    public void cancelLoadInBackground() {
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == loadTask) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        if (this.mTask != loadTask) {
            dispatchOnCancelled(loadTask, d2);
        } else if (isAbandoned()) {
            onCanceled(d2);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d2);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f3796m);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f3796m);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.c(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.b(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: package-private */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f3796m) {
                this.mTask.f3796m = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.c(this.mExecutor, (Params[]) null);
                return;
            }
            this.mTask.f3796m = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f3796m) {
                this.mTask.f3796m = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f3796m) {
            this.mTask.f3796m = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean a2 = this.mTask.a(false);
            if (a2) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return a2;
        }
    }

    public void onCanceled(D d2) {
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j2) {
        this.mUpdateThrottle = j2;
        if (j2 != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.mTask;
        if (loadTask != null) {
            loadTask.o();
        }
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }
}
