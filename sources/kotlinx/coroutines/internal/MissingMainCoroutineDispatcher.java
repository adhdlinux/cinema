package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f40765c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40766d;

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.f40765c = th;
        this.f40766d = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void u0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f40765c
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f40766d
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f40765c
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.MainDispatchersKt.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.u0():java.lang.Void");
    }

    public DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        u0();
        throw new KotlinNothingValueException();
    }

    public boolean p0(CoroutineContext coroutineContext) {
        u0();
        throw new KotlinNothingValueException();
    }

    public MainCoroutineDispatcher r0() {
        return this;
    }

    /* renamed from: t0 */
    public Void o0(CoroutineContext coroutineContext, Runnable runnable) {
        u0();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f40765c != null) {
            str = ", cause=" + this.f40765c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: v0 */
    public Void k(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        u0();
        throw new KotlinNothingValueException();
    }
}
