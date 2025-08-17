package com.utils.Getlink.Provider;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.utils.Getlink.Provider.SmashyWebview", f = "SmashyWebview.kt", l = {138}, m = "waitForKeyToBeAttached")
final class SmashyWebview$waitForKeyToBeAttached$1 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    Object f37445i;

    /* renamed from: j  reason: collision with root package name */
    int f37446j;

    /* renamed from: k  reason: collision with root package name */
    int f37447k;

    /* renamed from: l  reason: collision with root package name */
    /* synthetic */ Object f37448l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ SmashyWebview f37449m;

    /* renamed from: n  reason: collision with root package name */
    int f37450n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SmashyWebview$waitForKeyToBeAttached$1(SmashyWebview smashyWebview, Continuation<? super SmashyWebview$waitForKeyToBeAttached$1> continuation) {
        super(continuation);
        this.f37449m = smashyWebview;
    }

    public final Object invokeSuspend(Object obj) {
        this.f37448l = obj;
        this.f37450n |= Integer.MIN_VALUE;
        return this.f37449m.W(this);
    }
}
