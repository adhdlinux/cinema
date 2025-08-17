package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.dependencies.i;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;

final class ad extends i {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f30259b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ af f30260c;

    ad(af afVar, AtomicBoolean atomicBoolean) {
        this.f30260c = afVar;
        this.f30259b = atomicBoolean;
    }

    public final void b(Bundle bundle) throws RemoteException {
        if (!this.f30259b.getAndSet(true)) {
            int i2 = bundle.getInt("error.code", -100);
            int i3 = bundle.getInt("install.status", 0);
            if (i3 == 4) {
                this.f30260c.f30264c.a(w.COMPLETED);
            } else if (i2 != 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 40);
                sb.append("requestInstall = ");
                sb.append(i2);
                sb.append(", launching fullscreen.");
                Log.w("ARCore-InstallService", sb.toString());
                af afVar = this.f30260c;
                afVar.f30265d.i(afVar.f30263b, afVar.f30264c);
            } else if (bundle.containsKey("resolution.intent")) {
                af afVar2 = this.f30260c;
                afVar2.f30265d.j(afVar2.f30263b, bundle, afVar2.f30264c);
            } else if (i3 != 10) {
                switch (i3) {
                    case 1:
                    case 2:
                    case 3:
                        this.f30260c.f30264c.a(w.ACCEPTED);
                        return;
                    case 4:
                        this.f30260c.f30264c.a(w.COMPLETED);
                        return;
                    case 5:
                        this.f30260c.f30264c.b(new FatalException("Unexpected FAILED install status without error."));
                        return;
                    case 6:
                        this.f30260c.f30264c.a(w.CANCELLED);
                        return;
                    default:
                        this.f30260c.f30264c.b(new FatalException(p.b((byte) 27, i3, "Unexpected install status: ")));
                        return;
                }
            } else {
                this.f30260c.f30264c.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
            }
        }
    }

    public final void c(Bundle bundle) throws RemoteException {
    }
}
