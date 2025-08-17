package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.dependencies.i;

final class z extends i {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aa f30375b;

    z(aa aaVar) {
        this.f30375b = aaVar;
    }

    public final void b(Bundle bundle) throws RemoteException {
    }

    public final void c(Bundle bundle) throws RemoteException {
        int i2 = bundle.getInt("error.code", -100);
        if (i2 == -5) {
            Log.e("ARCore-InstallService", "The device is not supported.");
            this.f30375b.f30253c.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
        } else if (i2 == -3) {
            Log.e("ARCore-InstallService", "The Google Play application must be updated.");
            this.f30375b.f30253c.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else if (i2 != 0) {
            Log.e("ARCore-InstallService", p.b((byte) 22, i2, "requestInfo returned: "));
            this.f30375b.f30253c.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else {
            this.f30375b.f30253c.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
        }
    }
}
