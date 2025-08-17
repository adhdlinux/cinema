package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: b  reason: collision with root package name */
    private final CompletableJob f12156b = JobKt__JobKt.b((Job) null, 1, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    private final SettableFuture<ListenableWorker.Result> f12157c;

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineDispatcher f12158d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.f(context, "appContext");
        Intrinsics.f(workerParameters, "params");
        SettableFuture<ListenableWorker.Result> s2 = SettableFuture.s();
        Intrinsics.e(s2, "create()");
        this.f12157c = s2;
        s2.addListener(new Runnable(this) {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CoroutineWorker f12159b;

            {
                this.f12159b = r1;
            }

            public final void run() {
                if (this.f12159b.g().isCancelled()) {
                    Job.DefaultImpls.a(this.f12159b.h(), (CancellationException) null, 1, (Object) null);
                }
            }
        }, getTaskExecutor().getBackgroundExecutor());
        this.f12158d = Dispatchers.a();
    }

    static /* synthetic */ Object e(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object a(Continuation<? super ListenableWorker.Result> continuation);

    public CoroutineDispatcher c() {
        return this.f12158d;
    }

    public Object d(Continuation<? super ForegroundInfo> continuation) {
        return e(this, continuation);
    }

    public final SettableFuture<ListenableWorker.Result> g() {
        return this.f12157c;
    }

    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        CompletableJob b2 = JobKt__JobKt.b((Job) null, 1, (Object) null);
        CoroutineScope a2 = CoroutineScopeKt.a(c().plus(b2));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(b2, (SettableFuture) null, 2, (DefaultConstructorMarker) null);
        Job unused = BuildersKt__Builders_commonKt.b(a2, (CoroutineContext) null, (CoroutineStart) null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, (Continuation<? super CoroutineWorker$getForegroundInfoAsync$1>) null), 3, (Object) null);
        return jobListenableFuture;
    }

    public final CompletableJob h() {
        return this.f12156b;
    }

    public final void onStopped() {
        super.onStopped();
        this.f12157c.cancel(false);
    }

    public final ListenableFuture<ListenableWorker.Result> startWork() {
        Job unused = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(c().plus(this.f12156b)), (CoroutineContext) null, (CoroutineStart) null, new CoroutineWorker$startWork$1(this, (Continuation<? super CoroutineWorker$startWork$1>) null), 3, (Object) null);
        return this.f12157c;
    }
}
