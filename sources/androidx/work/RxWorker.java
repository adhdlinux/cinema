package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

public abstract class RxWorker extends ListenableWorker {

    /* renamed from: c  reason: collision with root package name */
    static final Executor f12201c = new SynchronousExecutor();

    /* renamed from: b  reason: collision with root package name */
    private SingleFutureAdapter<ListenableWorker.Result> f12202b;

    static class SingleFutureAdapter<T> implements SingleObserver<T>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final SettableFuture<T> f12203b;

        /* renamed from: c  reason: collision with root package name */
        private Disposable f12204c;

        SingleFutureAdapter() {
            SettableFuture<T> s2 = SettableFuture.s();
            this.f12203b = s2;
            s2.addListener(this, RxWorker.f12201c);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Disposable disposable = this.f12204c;
            if (disposable != null) {
                disposable.dispose();
            }
        }

        public void onError(Throwable th) {
            this.f12203b.p(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f12204c = disposable;
        }

        public void onSuccess(T t2) {
            this.f12203b.o(t2);
        }

        public void run() {
            if (this.f12203b.isCancelled()) {
                a();
            }
        }
    }

    public RxWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract Single<ListenableWorker.Result> a();

    /* access modifiers changed from: protected */
    public Scheduler c() {
        return Schedulers.b(getBackgroundExecutor());
    }

    public void onStopped() {
        super.onStopped();
        SingleFutureAdapter<ListenableWorker.Result> singleFutureAdapter = this.f12202b;
        if (singleFutureAdapter != null) {
            singleFutureAdapter.a();
            this.f12202b = null;
        }
    }

    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.f12202b = new SingleFutureAdapter<>();
        a().k(c()).h(Schedulers.b(getTaskExecutor().getBackgroundExecutor())).a(this.f12202b);
        return this.f12202b.f12203b;
    }
}
