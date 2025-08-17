package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.c.a;
import java.util.Map;

public class q extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f19972c = "q";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f19973d;

    /* renamed from: e  reason: collision with root package name */
    private final c f19974e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public p f19975f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19976g;

    public q(Context context, c cVar, a aVar, com.facebook.ads.internal.r.a aVar2, c cVar2) {
        super(context, cVar2, aVar2);
        this.f19974e = cVar;
        this.f19973d = aVar;
    }

    public void a(p pVar) {
        this.f19975f = pVar;
    }

    /* access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        p pVar = this.f19975f;
        if (pVar != null && !TextUtils.isEmpty(pVar.c())) {
            this.f19974e.a(this.f19975f.c(), map);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f19976g     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            com.facebook.ads.internal.adapters.p r0 = r2.f19975f     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0027
        L_0x000a:
            r1 = 1
            r2.f19976g = r1     // Catch:{ all -> 0x0029 }
            com.facebook.ads.internal.q.c.a r1 = r2.f19973d     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0025
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x0029 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0025
            com.facebook.ads.internal.q.c.a r0 = r2.f19973d     // Catch:{ all -> 0x0029 }
            com.facebook.ads.internal.adapters.q$1 r1 = new com.facebook.ads.internal.adapters.q$1     // Catch:{ all -> 0x0029 }
            r1.<init>()     // Catch:{ all -> 0x0029 }
            r0.post(r1)     // Catch:{ all -> 0x0029 }
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            monitor-exit(r2)
            return
        L_0x0029:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.q.b():void");
    }
}
