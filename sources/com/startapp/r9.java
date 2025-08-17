package com.startapp;

import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import java.util.concurrent.Executor;

public class r9 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35771a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f35772b;

    /* renamed from: c  reason: collision with root package name */
    public final t9 f35773c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f35774d;

    /* renamed from: e  reason: collision with root package name */
    public final ua<NetworkDiagnosticConfig> f35775e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f35776f = new a();

    /* renamed from: g  reason: collision with root package name */
    public final d9 f35777g = new b();

    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.startapp.r9$a} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.startapp.r9$a} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.startapp.r9} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.startapp.r9} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.startapp.r9$a} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x012e A[Catch:{ all -> 0x0139 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r24 = this;
                java.lang.String r0 = ";"
                r1 = r24
                com.startapp.r9 r2 = com.startapp.r9.this
                com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig r3 = r2.a()
                if (r3 != 0) goto L_0x000e
                goto L_0x0140
            L_0x000e:
                android.content.SharedPreferences r4 = r2.f35772b
                r5 = 0
                java.lang.String r7 = "181bb7005f9db75a"
                long r4 = r4.getLong(r7, r5)
                int r6 = r3.c()
                r8 = 60000(0xea60, float:8.4078E-41)
                int r6 = r6 * r8
                long r8 = (long) r6
                long r4 = r4 + r8
                long r8 = java.lang.System.currentTimeMillis()
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 > 0) goto L_0x0140
                r4 = 2
                r5 = 0
                com.startapp.t9 r6 = r2.f35773c     // Catch:{ all -> 0x0125 }
                android.database.sqlite.SQLiteDatabase r6 = r6.a()     // Catch:{ all -> 0x0125 }
                r10 = 1
                java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x0125 }
                java.lang.String r12 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0125 }
                r13 = 0
                r11[r13] = r12     // Catch:{ all -> 0x0125 }
                java.lang.String r12 = "SELECT requestId, statusId, requests.value AS request, statuses.value AS status, COUNT(*), MIN(durationNanos), MAX(durationNanos), AVG(durationNanos), MIN(timeMillis) FROM traces JOIN requests ON requests.id = traces.requestId JOIN statuses ON statuses.id = traces.statusId WHERE timeMillis < ? GROUP BY requestId, statusId"
                android.database.Cursor r5 = r6.rawQuery(r12, r11)     // Catch:{ all -> 0x0125 }
                if (r5 == 0) goto L_0x0122
            L_0x0045:
                boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x0125 }
                if (r6 == 0) goto L_0x010d
                long r11 = r5.getLong(r13)     // Catch:{ all -> 0x0125 }
                long r14 = r5.getLong(r10)     // Catch:{ all -> 0x0125 }
                java.lang.String r6 = r5.getString(r4)     // Catch:{ all -> 0x0125 }
                r10 = 3
                java.lang.String r10 = r5.getString(r10)     // Catch:{ all -> 0x0125 }
                r13 = 4
                r16 = r2
                long r1 = r5.getLong(r13)     // Catch:{ all -> 0x0109 }
                int r13 = r3.b()     // Catch:{ all -> 0x0109 }
                r17 = r5
                long r4 = (long) r13     // Catch:{ all -> 0x0109 }
                int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r13 >= 0) goto L_0x0078
                r1 = r24
                r2 = r16
                r5 = r17
                r4 = 2
                r10 = 1
                r13 = 0
                goto L_0x0045
            L_0x0078:
                r4 = 5
                r13 = r3
                r5 = r17
                long r3 = r5.getLong(r4)     // Catch:{ all -> 0x0109 }
                r17 = r13
                r13 = 6
                r19 = r6
                r18 = r7
                long r6 = r5.getLong(r13)     // Catch:{ all -> 0x0109 }
                r13 = 7
                r20 = r14
                long r13 = r5.getLong(r13)     // Catch:{ all -> 0x0109 }
                r15 = 8
                r22 = r11
                r12 = r10
                long r10 = r5.getLong(r15)     // Catch:{ all -> 0x0109 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
                r15.<init>()     // Catch:{ all -> 0x0109 }
                r15.append(r1)     // Catch:{ all -> 0x0109 }
                r15.append(r0)     // Catch:{ all -> 0x0109 }
                r15.append(r3)     // Catch:{ all -> 0x0109 }
                r15.append(r0)     // Catch:{ all -> 0x0109 }
                r15.append(r6)     // Catch:{ all -> 0x0109 }
                r15.append(r0)     // Catch:{ all -> 0x0109 }
                r15.append(r13)     // Catch:{ all -> 0x0109 }
                r15.append(r0)     // Catch:{ all -> 0x0109 }
                r15.append(r10)     // Catch:{ all -> 0x0109 }
                r15.append(r0)     // Catch:{ all -> 0x0109 }
                r15.append(r8)     // Catch:{ all -> 0x0109 }
                java.lang.String r1 = r15.toString()     // Catch:{ all -> 0x0109 }
                com.startapp.y8 r2 = new com.startapp.y8     // Catch:{ all -> 0x0109 }
                com.startapp.z8 r3 = com.startapp.z8.f37001h     // Catch:{ all -> 0x0109 }
                r2.<init>((com.startapp.z8) r3)     // Catch:{ all -> 0x0109 }
                java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0109 }
                r2.f36958h = r3     // Catch:{ all -> 0x0109 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
                r3.<init>()     // Catch:{ all -> 0x0109 }
                r6 = r22
                r3.append(r6)     // Catch:{ all -> 0x0109 }
                java.lang.String r4 = ","
                r3.append(r4)     // Catch:{ all -> 0x0109 }
                r6 = r20
                r3.append(r6)     // Catch:{ all -> 0x0109 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0109 }
                r2.f36961k = r3     // Catch:{ all -> 0x0109 }
                r3 = r19
                r2.f36959i = r3     // Catch:{ all -> 0x0109 }
                r2.f36954d = r12     // Catch:{ all -> 0x0109 }
                r2.f36955e = r1     // Catch:{ all -> 0x0109 }
                r1 = r16
                android.content.Context r3 = r1.f35771a     // Catch:{ all -> 0x0120 }
                com.startapp.d9 r4 = r1.f35777g     // Catch:{ all -> 0x0120 }
                r2.a((android.content.Context) r3, (com.startapp.d9) r4)     // Catch:{ all -> 0x0120 }
                r2 = r1
                r3 = r17
                r7 = r18
                r4 = 2
                r10 = 1
                r13 = 0
                r1 = r24
                goto L_0x0045
            L_0x0109:
                r0 = move-exception
                r1 = r16
                goto L_0x0127
            L_0x010d:
                r1 = r2
                r18 = r7
                android.content.SharedPreferences r0 = r1.f35772b     // Catch:{ all -> 0x0120 }
                android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0120 }
                r2 = r18
                android.content.SharedPreferences$Editor r0 = r0.putLong(r2, r8)     // Catch:{ all -> 0x0120 }
                r0.commit()     // Catch:{ all -> 0x0120 }
                goto L_0x0122
            L_0x0120:
                r0 = move-exception
                goto L_0x0127
            L_0x0122:
                if (r5 == 0) goto L_0x0140
                goto L_0x0135
            L_0x0125:
                r0 = move-exception
                r1 = r2
            L_0x0127:
                r2 = 2
                boolean r2 = r1.a(r2)     // Catch:{ all -> 0x0139 }
                if (r2 == 0) goto L_0x0133
                android.content.Context r1 = r1.f35771a     // Catch:{ all -> 0x0139 }
                com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0139 }
            L_0x0133:
                if (r5 == 0) goto L_0x0140
            L_0x0135:
                r5.close()
                goto L_0x0140
            L_0x0139:
                r0 = move-exception
                if (r5 == 0) goto L_0x013f
                r5.close()
            L_0x013f:
                throw r0
            L_0x0140:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.r9.a.run():void");
        }
    }

    public class b implements d9 {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ y8 f35780a;

            public a(y8 y8Var) {
                this.f35780a = y8Var;
            }

            public void run() {
                c cVar;
                String str;
                r9 r9Var = r9.this;
                y8 y8Var = this.f35780a;
                r9Var.getClass();
                Long l2 = y8Var.f36958h;
                String str2 = y8Var.f36961k;
                if (str2 != null) {
                    String[] split = str2.split(",");
                    if (!(split.length != 2 || (str = split[0]) == null || split[1] == null)) {
                        try {
                            cVar = new c(Long.parseLong(str), Long.parseLong(split[1]));
                        } catch (NumberFormatException unused) {
                        }
                        if (l2 != null && cVar != null) {
                            try {
                                t9 t9Var = r9Var.f35773c;
                                long j2 = cVar.f35782a;
                                long j3 = cVar.f35783b;
                                long longValue = l2.longValue();
                                t9Var.a().delete("traces", "requestId = ? AND statusId = ? AND timeMillis < ?", new String[]{String.valueOf(j2), String.valueOf(j3), String.valueOf(longValue)});
                                return;
                            } catch (Throwable th) {
                                if (r9Var.a(4)) {
                                    y8.a(r9Var.f35771a, th);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                cVar = null;
                if (l2 != null) {
                }
            }
        }

        public b() {
        }

        public void a(y8 y8Var, int i2) {
            if (i2 == 1) {
                r9.this.f35774d.execute(new a(y8Var));
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f35782a;

        /* renamed from: b  reason: collision with root package name */
        public final long f35783b;

        public c(long j2, long j3) {
            this.f35782a = j2;
            this.f35783b = j3;
        }
    }

    public r9(Context context, SharedPreferences sharedPreferences, t9 t9Var, Executor executor, ua<NetworkDiagnosticConfig> uaVar) {
        this.f35771a = context;
        this.f35772b = sharedPreferences;
        this.f35773c = t9Var;
        this.f35774d = executor;
        this.f35775e = uaVar;
    }

    public final NetworkDiagnosticConfig a() {
        NetworkDiagnosticConfig call = this.f35775e.call();
        if (call == null || !call.e()) {
            return null;
        }
        return call;
    }

    public boolean a(int i2) {
        NetworkDiagnosticConfig a2 = a();
        return a2 != null && (a2.a() & i2) == i2;
    }
}
