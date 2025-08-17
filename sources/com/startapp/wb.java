package com.startapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class wb {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f36828a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static wb f36829b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f36830c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<BroadcastReceiver, ArrayList<IntentFilter>> f36831d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f36832e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f36833f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f36834g;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r3 >= r1) goto L_0x000b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            r4 = r2[r3];
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
            if (r5 >= r4.f36837b.size()) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
            r6 = r4.f36837b.get(r5).f36839b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
            if (r6 == null) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            r6.onReceive(r10.f36830c, r4.f36836a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
            r3 = r3 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r10) {
            /*
                r9 = this;
                int r0 = r10.what
                r1 = 1
                if (r0 == r1) goto L_0x0009
                super.handleMessage(r10)
                goto L_0x0017
            L_0x0009:
                com.startapp.wb r10 = com.startapp.wb.this
            L_0x000b:
                java.util.Map<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r0 = r10.f36831d
                monitor-enter(r0)
                java.util.ArrayList<com.startapp.wb$b> r1 = r10.f36833f     // Catch:{ all -> 0x004d }
                int r1 = r1.size()     // Catch:{ all -> 0x004d }
                if (r1 > 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
            L_0x0017:
                return
            L_0x0018:
                com.startapp.wb$b[] r2 = new com.startapp.wb.b[r1]     // Catch:{ all -> 0x004d }
                java.util.ArrayList<com.startapp.wb$b> r3 = r10.f36833f     // Catch:{ all -> 0x004d }
                r3.toArray(r2)     // Catch:{ all -> 0x004d }
                java.util.ArrayList<com.startapp.wb$b> r3 = r10.f36833f     // Catch:{ all -> 0x004d }
                r3.clear()     // Catch:{ all -> 0x004d }
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                r0 = 0
                r3 = 0
            L_0x0027:
                if (r3 >= r1) goto L_0x000b
                r4 = r2[r3]
                r5 = 0
            L_0x002c:
                java.util.ArrayList<com.startapp.wb$c> r6 = r4.f36837b
                int r6 = r6.size()
                if (r5 >= r6) goto L_0x004a
                java.util.ArrayList<com.startapp.wb$c> r6 = r4.f36837b
                java.lang.Object r6 = r6.get(r5)
                com.startapp.wb$c r6 = (com.startapp.wb.c) r6
                android.content.BroadcastReceiver r6 = r6.f36839b
                if (r6 == 0) goto L_0x0047
                android.content.Context r7 = r10.f36830c
                android.content.Intent r8 = r4.f36836a
                r6.onReceive(r7, r8)
            L_0x0047:
                int r5 = r5 + 1
                goto L_0x002c
            L_0x004a:
                int r3 = r3 + 1
                goto L_0x0027
            L_0x004d:
                r10 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.wb.a.handleMessage(android.os.Message):void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f36836a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<c> f36837b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f36836a = intent;
            this.f36837b = arrayList;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f36838a;

        /* renamed from: b  reason: collision with root package name */
        public final BroadcastReceiver f36839b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36840c;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f36838a = intentFilter;
            this.f36839b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f36839b);
            sb.append(" filter=");
            sb.append(this.f36838a);
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        hc.a((Class<?>) wb.class);
    }

    public wb(Context context) {
        this.f36830c = context;
        this.f36834g = new a(context.getMainLooper());
    }

    public static wb a(Context context) {
        wb wbVar;
        synchronized (f36828a) {
            if (f36829b == null) {
                Context a2 = ia.a(context);
                if (a2 != null) {
                    context = a2;
                }
                f36829b = new wb(context);
            }
            wbVar = f36829b;
        }
        return wbVar;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f36831d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f36831d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f36831d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList arrayList2 = this.f36832e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f36832e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f36831d) {
            ArrayList remove = this.f36831d.remove(broadcastReceiver);
            if (remove != null) {
                for (int i2 = 0; i2 < remove.size(); i2++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList arrayList = this.f36832e.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (((c) arrayList.get(i4)).f36839b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i4--;
                                }
                                i4++;
                            }
                            if (arrayList.size() <= 0) {
                                this.f36832e.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bc, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.Map<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r2 = r1.f36831d
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x00bd }
            android.content.Context r3 = r1.f36830c     // Catch:{ all -> 0x00bd }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x00bd }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x00bd }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x00bd }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x00bd }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x00bd }
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.startapp.wb$c>> r3 = r1.f36832e     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00bd }
            r15 = r3
            java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00bd }
            r9 = 0
            if (r15 == 0) goto L_0x00ba
            r3 = 0
            r8 = r3
            r7 = 0
        L_0x0034:
            int r3 = r15.size()     // Catch:{ all -> 0x00bd }
            r6 = 1
            if (r7 >= r3) goto L_0x0089
            java.lang.Object r3 = r15.get(r7)     // Catch:{ all -> 0x00bd }
            r5 = r3
            com.startapp.wb$c r5 = (com.startapp.wb.c) r5     // Catch:{ all -> 0x00bd }
            boolean r3 = r5.f36840c     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x0051
            r19 = r7
            r17 = r10
            r18 = r11
            r20 = r12
            r12 = 0
            r11 = r8
            goto L_0x007e
        L_0x0051:
            android.content.IntentFilter r3 = r5.f36838a     // Catch:{ all -> 0x00bd }
            java.lang.String r16 = "LocalBroadcastManager"
            r4 = r10
            r17 = r10
            r10 = r5
            r5 = r11
            r18 = r11
            r11 = 1
            r6 = r13
            r19 = r7
            r7 = r12
            r11 = r8
            r8 = r14
            r20 = r12
            r12 = 0
            r9 = r16
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00bd }
            if (r3 < 0) goto L_0x007e
            if (r11 != 0) goto L_0x0076
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00bd }
            r8.<init>()     // Catch:{ all -> 0x00bd }
            goto L_0x0077
        L_0x0076:
            r8 = r11
        L_0x0077:
            r8.add(r10)     // Catch:{ all -> 0x00bd }
            r3 = 1
            r10.f36840c = r3     // Catch:{ all -> 0x00bd }
            goto L_0x007f
        L_0x007e:
            r8 = r11
        L_0x007f:
            int r7 = r19 + 1
            r10 = r17
            r11 = r18
            r12 = r20
            r9 = 0
            goto L_0x0034
        L_0x0089:
            r11 = r8
            r12 = 0
            if (r11 == 0) goto L_0x00bb
            r9 = 0
        L_0x008e:
            int r3 = r11.size()     // Catch:{ all -> 0x00bd }
            if (r9 >= r3) goto L_0x009f
            java.lang.Object r3 = r11.get(r9)     // Catch:{ all -> 0x00bd }
            com.startapp.wb$c r3 = (com.startapp.wb.c) r3     // Catch:{ all -> 0x00bd }
            r3.f36840c = r12     // Catch:{ all -> 0x00bd }
            int r9 = r9 + 1
            goto L_0x008e
        L_0x009f:
            java.util.ArrayList<com.startapp.wb$b> r3 = r1.f36833f     // Catch:{ all -> 0x00bd }
            com.startapp.wb$b r4 = new com.startapp.wb$b     // Catch:{ all -> 0x00bd }
            r4.<init>(r0, r11)     // Catch:{ all -> 0x00bd }
            r3.add(r4)     // Catch:{ all -> 0x00bd }
            android.os.Handler r0 = r1.f36834g     // Catch:{ all -> 0x00bd }
            r3 = 1
            boolean r0 = r0.hasMessages(r3)     // Catch:{ all -> 0x00bd }
            if (r0 != 0) goto L_0x00b7
            android.os.Handler r0 = r1.f36834g     // Catch:{ all -> 0x00bd }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x00bd }
        L_0x00b7:
            monitor-exit(r2)     // Catch:{ all -> 0x00bd }
            r0 = 1
            return r0
        L_0x00ba:
            r12 = 0
        L_0x00bb:
            monitor-exit(r2)     // Catch:{ all -> 0x00bd }
            return r12
        L_0x00bd:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00bd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.wb.a(android.content.Intent):boolean");
    }
}
