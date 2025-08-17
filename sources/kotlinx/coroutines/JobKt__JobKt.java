package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob a(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.E0);
        if (job != null) {
            job.L(cancellationException);
        }
    }

    public static final DisposableHandle d(Job job, DisposableHandle disposableHandle) {
        return job.z(new DisposeOnCompletion(disposableHandle));
    }

    public static final void e(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.E0);
        if (job != null) {
            JobKt.f(job);
        }
    }

    public static final void f(Job job) {
        if (!job.isActive()) {
            throw job.s();
        }
    }
}
