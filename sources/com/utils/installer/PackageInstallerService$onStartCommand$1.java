package com.utils.installer;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.utils.installer.PackageInstallerService$onStartCommand$1", f = "PackageInstallerService.kt", l = {253, 257}, m = "invokeSuspend")
final class PackageInstallerService$onStartCommand$1 extends SuspendLambda implements Function3<CoroutineScope, PackageInstallerService, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f37687i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ PackageInstallerService f37688j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ String f37689k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ String f37690l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PackageInstallerService$onStartCommand$1(PackageInstallerService packageInstallerService, String str, String str2, Continuation<? super PackageInstallerService$onStartCommand$1> continuation) {
        super(3, continuation);
        this.f37688j = packageInstallerService;
        this.f37689k = str;
        this.f37690l = str2;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, PackageInstallerService packageInstallerService, Continuation<? super Unit> continuation) {
        return new PackageInstallerService$onStartCommand$1(this.f37688j, this.f37689k, this.f37690l, continuation).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f37687i;
        if (i2 == 0) {
            ResultKt.b(obj);
            PackageInstallerService packageInstallerService = this.f37688j;
            String str = this.f37689k;
            String str2 = this.f37690l;
            this.f37687i = 1;
            if (packageInstallerService.d(str, str2, this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else if (i2 == 2) {
            ResultKt.b(obj);
            this.f37688j.stopSelf();
            return Unit.f40298a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f37687i = 2;
        if (DelayKt.a(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, this) == e2) {
            return e2;
        }
        this.f37688j.stopSelf();
        return Unit.f40298a;
    }
}
