package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.s();
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                try {
                    Worker.this.mFuture.o(Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.p(th);
                }
            }
        });
        return this.mFuture;
    }
}
