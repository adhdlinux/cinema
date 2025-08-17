package com.vungle.ads.internal.executor;

import com.vungle.ads.OutOfMemory;
import com.vungle.ads.internal.task.PriorityRunnable;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VungleThreadPoolExecutor extends ThreadPoolExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleThreadPool";
    private final NamedThreadFactory threadFactory;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final <T> Callable<T> getWrappedCallableWithFallback(Callable<T> callable, Function0<Unit> function0) {
            return new d(callable, function0);
        }

        /* access modifiers changed from: private */
        /* renamed from: getWrappedCallableWithFallback$lambda-0  reason: not valid java name */
        public static final Object m177getWrappedCallableWithFallback$lambda0(Callable callable, Function0 function0) {
            Intrinsics.f(callable, "$command");
            Intrinsics.f(function0, "$failFallback");
            try {
                return callable.call();
            } catch (OutOfMemoryError unused) {
                function0.invoke();
                return null;
            }
        }

        /* access modifiers changed from: private */
        public final ComparableRunnable getWrappedRunnableWithFail(Runnable runnable, Runnable runnable2) {
            if (runnable instanceof PriorityRunnable) {
                return new VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$1(runnable, runnable2);
            }
            return new VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$2(runnable, runnable2);
        }

        /* access modifiers changed from: private */
        public final void wrapRunnableWithFail(Runnable runnable, Runnable runnable2) {
            try {
                runnable.run();
            } catch (OutOfMemoryError unused) {
                runnable2.run();
            }
        }
    }

    public interface ComparableRunnable extends Comparable<Object>, Runnable {
    }

    public VungleThreadPoolExecutor(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, NamedThreadFactory namedThreadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, namedThreadFactory);
        this.threadFactory = namedThreadFactory;
        allowCoreThreadTimeOut(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-0  reason: not valid java name */
    public static final void m174execute$lambda0(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(vungleThreadPoolExecutor, "this$0");
        new OutOfMemory("execute error in " + vungleThreadPoolExecutor.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String executorName() {
        /*
            r1 = this;
            com.vungle.ads.internal.executor.NamedThreadFactory r0 = r1.threadFactory
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getName()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = "VungleThreadPoolExecutor"
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.executor.VungleThreadPoolExecutor.executorName():java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: submit$lambda-1  reason: not valid java name */
    public static final void m175submit$lambda1(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(vungleThreadPoolExecutor, "this$0");
        new OutOfMemory("submit error in " + vungleThreadPoolExecutor.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* access modifiers changed from: private */
    /* renamed from: submit$lambda-2  reason: not valid java name */
    public static final void m176submit$lambda2(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(vungleThreadPoolExecutor, "this$0");
        new OutOfMemory("submit error with result in " + vungleThreadPoolExecutor.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }

    public void execute(Runnable runnable) {
        Intrinsics.f(runnable, "command");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(runnable, new a(this)));
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "execute exception", e2);
        } catch (OutOfMemoryError e3) {
            String str = "execute error in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final NamedThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public Future<?> submit(Runnable runnable) {
        Intrinsics.f(runnable, "task");
        try {
            Future<?> submit = super.submit(Companion.getWrappedRunnableWithFail(runnable, new c(this)));
            Intrinsics.e(submit, "{\n            super.subm…\n            })\n        }");
            return submit;
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "submit exception", e2);
            return new FutureResult((Future) null);
        } catch (OutOfMemoryError e3) {
            String str = "submit error in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult((Future) null);
        }
    }

    public final Future<?> submit$vungle_ads_release(Runnable runnable, Runnable runnable2) {
        Intrinsics.f(runnable, "task");
        Intrinsics.f(runnable2, "fail");
        try {
            Future<?> submit = super.submit(Companion.getWrappedRunnableWithFail(runnable, runnable2));
            Intrinsics.e(submit, "{\n            super.subm…il(task, fail))\n        }");
            return submit;
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "submit exception with fail", e2);
            runnable2.run();
            return new FutureResult((Future) null);
        } catch (OutOfMemoryError e3) {
            String str = "submit error with fail in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            runnable2.run();
            return new FutureResult((Future) null);
        }
    }

    public final void execute(Runnable runnable, Runnable runnable2) {
        Intrinsics.f(runnable, "command");
        Intrinsics.f(runnable2, "fail");
        try {
            super.execute(Companion.getWrappedRunnableWithFail(runnable, runnable2));
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "execute exception with fail", e2);
            runnable2.run();
        } catch (OutOfMemoryError e3) {
            String str = "execute error with fail in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            runnable2.run();
        }
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        Intrinsics.f(runnable, "task");
        try {
            Future<T> submit = super.submit(Companion.getWrappedRunnableWithFail(runnable, new b(this)), t2);
            Intrinsics.e(submit, "{\n            super.subm…     }, result)\n        }");
            return submit;
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "submit exception with result", e2);
            return new FutureResult((Future) null);
        } catch (OutOfMemoryError e3) {
            String str = "submit error with result in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult((Future) null);
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        Intrinsics.f(callable, "task");
        try {
            Future<T> submit = super.submit(Companion.getWrappedCallableWithFallback(callable, new VungleThreadPoolExecutor$submit$3(this)));
            Intrinsics.e(submit, "override fun <T> submit(…Future<T>\n        }\n    }");
            return submit;
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "submit exception callable: " + e2);
            return new FutureResult((Future) null);
        } catch (OutOfMemoryError e3) {
            String str = "submit error callable in " + executorName() + ": " + e3.getLocalizedMessage();
            Logger.Companion.e(TAG, str, e3);
            new OutOfMemory(str).logErrorNoReturnValue$vungle_ads_release();
            return new FutureResult((Future) null);
        }
    }
}
