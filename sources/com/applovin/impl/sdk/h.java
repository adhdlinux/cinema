package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class h extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    public static int f15469a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f15470b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f15471c;

    /* renamed from: d  reason: collision with root package name */
    private final m f15472d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<a> f15473e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Object f15474f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f15475g;

    /* renamed from: h  reason: collision with root package name */
    private int f15476h;

    public interface a {
        void a(int i2);
    }

    h(m mVar) {
        this.f15472d = mVar;
        Context L = mVar.L();
        this.f15471c = L;
        this.f15470b = (AudioManager) L.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    private void b() {
        if (v.a()) {
            this.f15472d.A().b("AudioSessionManager", "Observing ringer mode...");
        }
        this.f15476h = f15469a;
        this.f15471c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f15472d.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f15472d.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    private void b(final int i2) {
        if (!this.f15475g) {
            if (v.a()) {
                v A = this.f15472d.A();
                A.b("AudioSessionManager", "Ringer mode is " + i2);
            }
            synchronized (this.f15474f) {
                for (final a next : this.f15473e) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            next.a(i2);
                        }
                    });
                }
            }
        }
    }

    private void c() {
        if (v.a()) {
            this.f15472d.A().b("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.f15471c.unregisterReceiver(this);
        this.f15472d.aj().unregisterReceiver(this);
    }

    public int a() {
        return this.f15470b.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.sdk.h.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f15474f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f15473e     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f15473e     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.f15473e     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.b()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.h.a(com.applovin.impl.sdk.h$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.applovin.impl.sdk.h.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f15474f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f15473e     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.f15473e     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.f15473e     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.h.b(com.applovin.impl.sdk.h$a):void");
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            b(this.f15470b.getRingerMode());
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f15475g = true;
            this.f15476h = this.f15470b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f15475g = false;
            if (this.f15476h != this.f15470b.getRingerMode()) {
                this.f15476h = f15469a;
                b(this.f15470b.getRingerMode());
            }
        }
    }
}
