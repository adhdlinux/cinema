package com.google.ar.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.dependencies.g;
import com.google.ar.core.dependencies.h;
import com.google.ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f30365a;

    /* renamed from: b  reason: collision with root package name */
    private Context f30366b;

    /* renamed from: c  reason: collision with root package name */
    private h f30367c;

    /* renamed from: d  reason: collision with root package name */
    private final ServiceConnection f30368d;

    /* renamed from: e  reason: collision with root package name */
    private BroadcastReceiver f30369e;

    /* renamed from: f  reason: collision with root package name */
    private Context f30370f;

    /* renamed from: g  reason: collision with root package name */
    private PackageInstaller f30371g;

    /* renamed from: h  reason: collision with root package name */
    private PackageInstaller.SessionCallback f30372h;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f30373i;

    x() {
    }

    x(byte[] bArr) {
        this();
        this.f30365a = new ArrayDeque();
        this.f30373i = 1;
        this.f30368d = new y(this);
    }

    static /* synthetic */ Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("package.name", "com.google.ar.core");
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final synchronized void d(IBinder iBinder) {
        h b2 = g.b(iBinder);
        Log.i("ARCore-InstallService", "Install service connected");
        this.f30367c = b2;
        this.f30373i = 3;
        for (Runnable run : this.f30365a) {
            run.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final synchronized void e() {
        Log.i("ARCore-InstallService", "Install service disconnected");
        this.f30373i = 1;
        this.f30367c = null;
    }

    private final synchronized void n(Runnable runnable) throws ag {
        int i2 = this.f30373i;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        } else if (i3 == 0) {
            throw new ag();
        } else if (i3 == 1) {
            this.f30365a.offer(runnable);
        } else if (i3 == 2) {
            runnable.run();
        }
    }

    private static void o(Activity activity, v vVar) {
        boolean z2;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core"));
            k a2 = k.a();
            Iterator<ResolveInfo> it2 = activity.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                ActivityInfo activityInfo = it2.next().activityInfo;
                if (activityInfo != null && activityInfo.name.equals("com.sec.android.app.samsungapps.MainForChina")) {
                    z2 = true;
                    break;
                }
            }
            a2.f30332d = !z2;
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            vVar.b(new FatalException("Failed to launch installer.", e2));
        }
    }

    private static void p(Activity activity, Bundle bundle, v vVar) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1234, new Intent(activity, activity.getClass()), 0, 0, 0);
            } catch (IntentSender.SendIntentException e2) {
                vVar.b(new FatalException("Installation Intent failed", e2));
            }
        } else {
            Log.e("ARCore-InstallService", "Did not get pending intent.");
            vVar.b(new FatalException("Installation intent failed to unparcel."));
        }
    }

    public final synchronized void a(Context context) {
        this.f30366b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f30368d, 1)) {
            this.f30373i = 2;
            return;
        }
        this.f30373i = 1;
        this.f30366b = null;
        Log.w("ARCore-InstallService", "bindService returned false.");
        context.unbindService(this.f30368d);
    }

    public final synchronized void b() {
        int i2 = this.f30373i;
        int i3 = i2 - 1;
        if (i2 != 0) {
            if (i3 == 1 || i3 == 2) {
                this.f30366b.unbindService(this.f30368d);
                this.f30366b = null;
                this.f30373i = 1;
            }
            BroadcastReceiver broadcastReceiver = this.f30369e;
            if (broadcastReceiver != null) {
                this.f30370f.unregisterReceiver(broadcastReceiver);
            }
            PackageInstaller.SessionCallback sessionCallback = this.f30372h;
            if (sessionCallback != null) {
                this.f30371g.unregisterSessionCallback(sessionCallback);
                this.f30372h = null;
                return;
            }
            return;
        }
        throw null;
    }

    public final synchronized void c(Context context, h hVar) {
        try {
            n(new aa(this, context, hVar));
        } catch (ag unused) {
            Log.e("ARCore-InstallService", "Play Store install service could not be bound.");
            hVar.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ h f() {
        return this.f30367c;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ PackageInstaller g() {
        return this.f30371g;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final void h(Activity activity, v vVar) {
        if (this.f30372h == null) {
            try {
                this.f30371g = activity.getPackageManager().getPackageInstaller();
                ab abVar = new ab(this, vVar);
                this.f30372h = abVar;
                this.f30371g.registerSessionCallback(abVar);
            } catch (NullPointerException unused) {
                vVar.b(new FatalException("Unable to obtain Android PackageInstaller; is this a Play Instant App?"));
            }
        }
        if (this.f30369e == null) {
            ac acVar = new ac(vVar);
            this.f30369e = acVar;
            this.f30370f = activity;
            if (Build.VERSION.SDK_INT >= 33) {
                Intent unused2 = activity.registerReceiver(acVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), 2);
            } else {
                activity.registerReceiver(acVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
            }
        }
        try {
            n(new af(this, activity, vVar));
        } catch (ag unused3) {
            Log.w("ARCore-InstallService", "requestInstall bind failed, launching fullscreen.");
            o(activity, vVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void i(Activity activity, v vVar) {
        o(activity, vVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void j(Activity activity, Bundle bundle, v vVar) {
        p(activity, bundle, vVar);
    }
}
