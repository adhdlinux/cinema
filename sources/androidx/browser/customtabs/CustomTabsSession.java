package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

public final class CustomTabsSession {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1627a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ICustomTabsService f1628b;

    /* renamed from: c  reason: collision with root package name */
    private final ICustomTabsCallback f1629c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f1630d;

    /* renamed from: e  reason: collision with root package name */
    private final PendingIntent f1631e;

    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.f1628b = iCustomTabsService;
        this.f1629c = iCustomTabsCallback;
        this.f1630d = componentName;
        this.f1631e = pendingIntent;
    }

    /* access modifiers changed from: package-private */
    public IBinder a() {
        return this.f1629c.asBinder();
    }

    /* access modifiers changed from: package-private */
    public ComponentName b() {
        return this.f1630d;
    }

    /* access modifiers changed from: package-private */
    public PendingIntent c() {
        return this.f1631e;
    }
}
