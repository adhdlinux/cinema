package com.utils.installer;

import com.utils.installer.ApkInstaller;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class PackageInstallerService$downloadUpdate$4$1 extends Lambda implements Function2<Float, ApkInstaller.InstallProgressStatus, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PackageInstallerService f37683f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PackageInstallerService$downloadUpdate$4$1(PackageInstallerService packageInstallerService) {
        super(2);
        this.f37683f = packageInstallerService;
    }

    public final void a(float f2, ApkInstaller.InstallProgressStatus installProgressStatus) {
        Intrinsics.f(installProgressStatus, "status");
        this.f37683f.g(f2, installProgressStatus);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(((Number) obj).floatValue(), (ApkInstaller.InstallProgressStatus) obj2);
        return Unit.f40298a;
    }
}
