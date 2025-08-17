package androidx.work;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
final class CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    Object f12160i;

    /* renamed from: j  reason: collision with root package name */
    int f12161j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ JobListenableFuture<ForegroundInfo> f12162k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ CoroutineWorker f12163l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super CoroutineWorker$getForegroundInfoAsync$1> continuation) {
        super(2, continuation);
        this.f12162k = jobListenableFuture;
        this.f12163l = coroutineWorker;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineWorker$getForegroundInfoAsync$1(this.f12162k, this.f12163l, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineWorker$getForegroundInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        JobListenableFuture<ForegroundInfo> jobListenableFuture;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f12161j;
        if (i2 == 0) {
            ResultKt.b(obj);
            JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.f12162k;
            CoroutineWorker coroutineWorker = this.f12163l;
            this.f12160i = jobListenableFuture2;
            this.f12161j = 1;
            Object d2 = coroutineWorker.d(this);
            if (d2 == e2) {
                return e2;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = d2;
        } else if (i2 == 1) {
            jobListenableFuture = (JobListenableFuture) this.f12160i;
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        jobListenableFuture.b(obj);
        return Unit.f40298a;
    }
}
