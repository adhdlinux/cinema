package com.facebook.ads.internal.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.ads.internal.q.d.b;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f20237a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20238b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20239c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f20240d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Messenger f20241e;

    /* renamed from: f  reason: collision with root package name */
    private final ServiceConnection f20242f = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean unused = a.this.f20240d = true;
            Messenger unused2 = a.this.f20241e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, 1);
            obtain.setData(a.this.b());
            try {
                a.this.f20241e.send(obtain);
            } catch (RemoteException e2) {
                com.facebook.ads.internal.q.d.a.a(a.this.f20237a, "generic", b.f20753m, (Exception) e2);
            }
            a.this.f20237a.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            try {
                a.this.f20237a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
            Messenger unused2 = a.this.f20241e = null;
            boolean unused3 = a.this.f20240d = false;
        }
    };

    public a(Context context, String str, String str2) {
        this.f20237a = context;
        this.f20238b = str;
        this.f20239c = str2;
    }

    /* access modifiers changed from: private */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_PROTOCOL_VERSION", 1);
        bundle.putString("PARAM_AN_UUID", this.f20239c);
        bundle.putString("PARAM_REQUEST_ID", this.f20238b);
        return bundle;
    }

    public void a() {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.audiencenetwork.AudienceNetworkService");
        try {
            if (!this.f20237a.bindService(intent, this.f20242f, 1)) {
                this.f20237a.unbindService(this.f20242f);
            }
        } catch (Exception e2) {
            com.facebook.ads.internal.q.d.a.a(this.f20237a, "generic", b.f20754n, e2);
        }
    }
}
