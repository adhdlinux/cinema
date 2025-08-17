package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {119, 121}, m = "invokeSuspend")
final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {

    /* renamed from: j  reason: collision with root package name */
    Object f2790j;

    /* renamed from: k  reason: collision with root package name */
    Object f2791k;

    /* renamed from: l  reason: collision with root package name */
    int f2792l;

    /* renamed from: m  reason: collision with root package name */
    int f2793m;

    /* renamed from: n  reason: collision with root package name */
    int f2794n;

    /* renamed from: o  reason: collision with root package name */
    private /* synthetic */ Object f2795o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2796p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation<? super ViewGroupKt$descendants$1> continuation) {
        super(2, continuation);
        this.f2796p = viewGroup;
    }

    /* renamed from: a */
    public final Object invoke(SequenceScope<? super View> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ViewGroupKt$descendants$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.f2796p, continuation);
        viewGroupKt$descendants$1.f2795o = obj;
        return viewGroupKt$descendants$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r1 = r11.f2794n
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r11.f2793m
            int r4 = r11.f2792l
            java.lang.Object r5 = r11.f2790j
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r11.f2795o
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.b(r12)
            r12 = r11
            goto L_0x0091
        L_0x0020:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0028:
            int r1 = r11.f2793m
            int r4 = r11.f2792l
            java.lang.Object r5 = r11.f2791k
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r11.f2790j
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r11.f2795o
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.b(r12)
            r12 = r11
            goto L_0x0071
        L_0x003d:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.f2795o
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            android.view.ViewGroup r1 = r11.f2796p
            int r4 = r1.getChildCount()
            r5 = 0
            r6 = r11
        L_0x004c:
            if (r5 >= r4) goto L_0x00a1
            android.view.View r7 = r1.getChildAt(r5)
            java.lang.String r8 = "getChildAt(index)"
            kotlin.jvm.internal.Intrinsics.e(r7, r8)
            r6.f2795o = r12
            r6.f2790j = r1
            r6.f2791k = r7
            r6.f2792l = r5
            r6.f2793m = r4
            r6.f2794n = r3
            java.lang.Object r8 = r12.a(r7, r6)
            if (r8 != r0) goto L_0x006a
            return r0
        L_0x006a:
            r9 = r7
            r7 = r12
            r12 = r6
            r6 = r1
            r1 = r4
            r4 = r5
            r5 = r9
        L_0x0071:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L_0x0098
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            kotlin.sequences.Sequence r5 = androidx.core.view.ViewGroupKt.b(r5)
            r12.f2795o = r7
            r12.f2790j = r6
            r8 = 0
            r12.f2791k = r8
            r12.f2792l = r4
            r12.f2793m = r1
            r12.f2794n = r2
            java.lang.Object r5 = r7.i(r5, r12)
            if (r5 != r0) goto L_0x008f
            return r0
        L_0x008f:
            r5 = r6
            r6 = r7
        L_0x0091:
            r9 = r6
            r6 = r12
            r12 = r9
            r10 = r5
            r5 = r1
            r1 = r10
            goto L_0x009c
        L_0x0098:
            r5 = r1
            r1 = r6
            r6 = r12
            r12 = r7
        L_0x009c:
            int r4 = r4 + r3
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x004c
        L_0x00a1:
            kotlin.Unit r12 = kotlin.Unit.f40298a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
