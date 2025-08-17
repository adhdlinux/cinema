package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

final class CompletedContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f40599a;

    /* renamed from: b  reason: collision with root package name */
    public final CancelHandler f40600b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1<Throwable, Unit> f40601c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f40602d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f40603e;

    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f40599a = obj;
        this.f40600b = cancelHandler;
        this.f40601c = function1;
        this.f40602d = obj2;
        this.f40603e = th;
    }

    public static /* synthetic */ CompletedContinuation b(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1<Throwable, Unit> function1, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = completedContinuation.f40599a;
        }
        if ((i2 & 2) != 0) {
            cancelHandler = completedContinuation.f40600b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i2 & 4) != 0) {
            function1 = completedContinuation.f40601c;
        }
        Function1<Throwable, Unit> function12 = function1;
        if ((i2 & 8) != 0) {
            obj2 = completedContinuation.f40602d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = completedContinuation.f40603e;
        }
        return completedContinuation.a(obj, cancelHandler2, function12, obj4, th);
    }

    public final CompletedContinuation a(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, th);
    }

    public final boolean c() {
        return this.f40603e != null;
    }

    public final void d(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.f40600b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.n(cancelHandler, th);
        }
        Function1<Throwable, Unit> function1 = this.f40601c;
        if (function1 != null) {
            cancellableContinuationImpl.o(function1, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.a(this.f40599a, completedContinuation.f40599a) && Intrinsics.a(this.f40600b, completedContinuation.f40600b) && Intrinsics.a(this.f40601c, completedContinuation.f40601c) && Intrinsics.a(this.f40602d, completedContinuation.f40602d) && Intrinsics.a(this.f40603e, completedContinuation.f40603e);
    }

    public int hashCode() {
        Object obj = this.f40599a;
        int i2 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f40600b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f40601c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f40602d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f40603e;
        if (th != null) {
            i2 = th.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f40599a + ", cancelHandler=" + this.f40600b + ", onCancellation=" + this.f40601c + ", idempotentResume=" + this.f40602d + ", cancelCause=" + this.f40603e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? null : cancelHandler, (i2 & 4) != 0 ? null : function1, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
