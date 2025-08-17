package com.utils.installer;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.utils.installer.PackageInstallerService", f = "PackageInstallerService.kt", l = {312}, m = "downloadUpdate")
final class PackageInstallerService$downloadUpdate$1 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    Object f37676i;

    /* renamed from: j  reason: collision with root package name */
    Object f37677j;

    /* renamed from: k  reason: collision with root package name */
    Object f37678k;

    /* renamed from: l  reason: collision with root package name */
    Object f37679l;

    /* renamed from: m  reason: collision with root package name */
    /* synthetic */ Object f37680m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ PackageInstallerService f37681n;

    /* renamed from: o  reason: collision with root package name */
    int f37682o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PackageInstallerService$downloadUpdate$1(PackageInstallerService packageInstallerService, Continuation<? super PackageInstallerService$downloadUpdate$1> continuation) {
        super(continuation);
        this.f37681n = packageInstallerService;
    }

    public final Object invokeSuspend(Object obj) {
        this.f37680m = obj;
        this.f37682o |= Integer.MIN_VALUE;
        return this.f37681n.d((String) null, (String) null, this);
    }
}
