package com.startapp;

import android.content.Context;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.enums.LtrCriteriaTypes;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.results.P3TestResult;
import com.startapp.networkTest.results.speedtest.MeasurementPointLatency;
import com.startapp.networkTest.speedtest.SpeedtestEngineError;
import com.startapp.networkTest.speedtest.SpeedtestEngineStatus;
import com.startapp.networkTest.threads.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36600a = "u1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f36601b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public j2 f36602c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f36603d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a1 f36604e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b1 f36605f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LocationController f36606g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public y0 f36607h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public P3TestResult f36608i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<j1> f36609j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f36610k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public x0 f36611l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f36612m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f36613n = "";

    /* renamed from: o  reason: collision with root package name */
    private String f36614o = "";

    /* renamed from: p  reason: collision with root package name */
    private String f36615p = "";

    /* renamed from: q  reason: collision with root package name */
    private String f36616q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f36617r = "";

    /* renamed from: s  reason: collision with root package name */
    private String f36618s = "";
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public String f36619t = "";

    public u1(j2 j2Var, Context context) {
        if (j2Var != null) {
            this.f36602c = j2Var;
            this.f36603d = context;
            u0 b2 = w0.b();
            this.f36610k = b2.PROJECT_ID();
            this.f36611l = new x0(this.f36603d);
            a(context, b2);
            return;
        }
        throw new IllegalArgumentException("ISpeedtestListener is NULL");
    }

    public class a extends AsyncTask<Void, Void, LatencyResult> {

        /* renamed from: a  reason: collision with root package name */
        private String f36620a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f36621b;

        /* renamed from: c  reason: collision with root package name */
        private int f36622c;

        /* renamed from: d  reason: collision with root package name */
        private int f36623d;

        /* renamed from: e  reason: collision with root package name */
        private int f36624e;

        /* renamed from: f  reason: collision with root package name */
        private String[] f36625f;

        /* renamed from: g  reason: collision with root package name */
        private LtrCriteriaTypes f36626g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f36627h;

        /* renamed from: com.startapp.u1$a$a  reason: collision with other inner class name */
        public class C0060a implements z1 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f36629a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int[] f36630b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ArrayList f36631c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ x1 f36632d;

            public C0060a(boolean[] zArr, int[] iArr, ArrayList arrayList, x1 x1Var) {
                this.f36629a = zArr;
                this.f36630b = iArr;
                this.f36631c = arrayList;
                this.f36632d = x1Var;
            }

            public void a(int i2, long j2, long j3) {
                int i3 = 0;
                int i4 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                if (i4 >= 0) {
                    this.f36629a[0] = true;
                    int[] iArr = this.f36630b;
                    iArr[0] = iArr[0] + 1;
                }
                int i5 = (int) j3;
                this.f36631c.add(a.this.a(j2, i5));
                if (u1.this.f36602c != null) {
                    j2 a2 = u1.this.f36602c;
                    float a3 = ((float) i2) / ((float) a.this.f36621b);
                    if (i4 >= 0) {
                        i3 = i5;
                    }
                    a2.b(a3, i3);
                }
                if (a.this.isCancelled()) {
                    this.f36632d.b();
                }
            }
        }

        public class b implements Comparator<g2> {
            public b() {
            }

            /* renamed from: a */
            public int compare(g2 g2Var, g2 g2Var2) {
                return g2Var.successfulTests - g2Var2.successfulTests;
            }
        }

        public class c implements Comparator<g2> {
            public c() {
            }

            /* renamed from: a */
            public int compare(g2 g2Var, g2 g2Var2) {
                return g2Var.totalTests - g2Var2.totalTests;
            }
        }

        public a(String str, int i2, int i3, int i4, int i5, boolean z2) {
            this.f36620a = str;
            this.f36621b = i2;
            this.f36622c = i3;
            this.f36623d = i4;
            this.f36624e = i5;
            this.f36627h = z2;
            if (i3 < 200) {
                this.f36622c = 200;
            }
            if (u1.this.f36602c != null) {
                u1.this.f36602c.a(SpeedtestEngineStatus.CONNECT, SpeedtestEngineError.OK, (long) (this.f36621b * this.f36623d));
            }
            x0 c2 = w0.c();
            this.f36625f = c2.k();
            this.f36626g = LtrCriteriaTypes.valueOf(c2.j());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0363, code lost:
            if (r1 != null) goto L_0x0365;
         */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02aa A[Catch:{ all -> 0x02ee, all -> 0x030c }] */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x02d5 A[Catch:{ all -> 0x02ee, all -> 0x030c }] */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x02eb A[Catch:{ all -> 0x02ee, all -> 0x030c }] */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x035a A[SYNTHETIC, Splitter:B:166:0x035a] */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x036a  */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x039e  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x03ba  */
        /* JADX WARNING: Removed duplicated region for block: B:180:0x0431  */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x0438  */
        /* JADX WARNING: Removed duplicated region for block: B:185:0x0460 A[LOOP:0: B:8:0x0028->B:185:0x0460, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x0459 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x014f A[SYNTHETIC, Splitter:B:24:0x014f] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01db  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0217 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0224 A[SYNTHETIC, Splitter:B:72:0x0224] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0250 A[Catch:{ all -> 0x023f, all -> 0x030e }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0258 A[Catch:{ all -> 0x023f, all -> 0x030e }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.startapp.networkTest.results.LatencyResult doInBackground(java.lang.Void... r31) {
            /*
                r30 = this;
                r7 = r30
                java.lang.String r8 = "ping6"
                boolean r0 = r30.isCancelled()
                r9 = 0
                if (r0 == 0) goto L_0x000c
                return r9
            L_0x000c:
                boolean r0 = r7.f36627h
                if (r0 == 0) goto L_0x001b
                java.lang.String[] r0 = r7.f36625f
                com.startapp.networkTest.enums.LtrCriteriaTypes r1 = r7.f36626g
                java.lang.String r2 = r7.f36620a
                java.util.List r0 = r7.a((java.lang.String[]) r0, (com.startapp.networkTest.enums.LtrCriteriaTypes) r1, (java.lang.String) r2)
                goto L_0x0025
            L_0x001b:
                java.lang.String[] r0 = r7.f36625f
                com.startapp.networkTest.enums.LtrCriteriaTypes r1 = com.startapp.networkTest.enums.LtrCriteriaTypes.CTItem
                java.lang.String r2 = r7.f36620a
                java.util.List r0 = r7.a((java.lang.String[]) r0, (com.startapp.networkTest.enums.LtrCriteriaTypes) r1, (java.lang.String) r2)
            L_0x0025:
                r10 = r0
                r0 = r9
                r12 = 0
            L_0x0028:
                int r1 = r10.size()
                if (r12 >= r1) goto L_0x047d
                long r13 = android.os.SystemClock.elapsedRealtime()
                long r15 = android.os.SystemClock.uptimeMillis()
                java.lang.Object r0 = r10.get(r12)
                r6 = r0
                com.startapp.g2 r6 = (com.startapp.g2) r6
                int r0 = r6.totalTests
                r5 = 1
                int r0 = r0 + r5
                r6.totalTests = r0
                java.lang.String r0 = r6.address
                r7.f36620a = r0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                com.startapp.networkTest.results.LatencyResult r3 = new com.startapp.networkTest.results.LatencyResult
                com.startapp.u1 r0 = com.startapp.u1.this
                java.lang.String r0 = r0.f36610k
                com.startapp.u1 r1 = com.startapp.u1.this
                com.startapp.x0 r1 = r1.f36611l
                java.lang.String r1 = r1.p()
                r3.<init>(r0, r1)
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.y0 r0 = r0.f36607h
                com.startapp.networkTest.data.BatteryInfo r0 = r0.a()
                r3.BatteryInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.networkTest.controller.LocationController r0 = r0.f36606g
                com.startapp.networkTest.data.LocationInfo r0 = r0.c()
                r3.LocationInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                android.content.Context r0 = r0.f36603d
                com.startapp.networkTest.enums.ScreenStates r0 = com.startapp.z0.h(r0)
                r3.ScreenStateOnStart = r0
                com.startapp.networkTest.enums.MeasurementTypes r0 = com.startapp.networkTest.enums.MeasurementTypes.IPING
                r3.MeasurementType = r0
                com.startapp.networkTest.data.TimeInfo r0 = com.startapp.r2.e()
                r3.TimeInfoOnStart = r0
                java.lang.String r1 = r3.GUID
                java.lang.String r0 = com.startapp.y2.a(r0, r1)
                r3.LtrId = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                android.content.Context r0 = r0.f36603d
                com.startapp.h1 r0 = com.startapp.z0.e(r0)
                r3.MemoryInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.a1 r0 = r0.f36604e
                com.startapp.networkTest.data.RadioInfo r0 = r0.h()
                r3.RadioInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.b1 r0 = r0.f36605f
                com.startapp.networkTest.data.WifiInfo r0 = r0.c()
                r3.WifiInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.b1 r0 = r0.f36605f
                com.startapp.l1 r0 = com.startapp.z0.a((com.startapp.b1) r0)
                r3.TrafficInfoOnStart = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                android.content.Context r0 = r0.f36603d
                com.startapp.f1 r0 = com.startapp.z0.b((android.content.Context) r0)
                r3.DeviceInfo = r0
                int r0 = com.startapp.networkTest.startapp.NetworkTester.isAppInForeground()
                r3.IsAppInForeground = r0
                int r0 = r7.f36621b
                r3.Pings = r0
                int r0 = r7.f36622c
                r3.Pause = r0
                java.lang.String r1 = r7.f36620a
                r3.Server = r1
                com.startapp.networkTest.enums.IpVersions r0 = com.startapp.networkTest.enums.IpVersions.IPv4
                r3.IpVersion = r0
                java.lang.String r2 = "ping"
                java.net.InetAddress r9 = java.net.InetAddress.getByName(r1)     // Catch:{ UnknownHostException -> 0x00ff }
                java.lang.String r1 = r9.getHostAddress()     // Catch:{ UnknownHostException -> 0x00fd }
                boolean r0 = r9 instanceof java.net.Inet6Address     // Catch:{ UnknownHostException -> 0x00fd }
                if (r0 == 0) goto L_0x0104
                com.startapp.networkTest.enums.IpVersions r0 = com.startapp.networkTest.enums.IpVersions.IPv6     // Catch:{ UnknownHostException -> 0x00fd }
                r3.IpVersion = r0     // Catch:{ UnknownHostException -> 0x00fd }
                r2 = r8
                goto L_0x0104
            L_0x00fd:
                r0 = move-exception
                goto L_0x0101
            L_0x00ff:
                r0 = move-exception
                r9 = 0
            L_0x0101:
                com.startapp.l2.b(r0)
            L_0x0104:
                r18 = r9
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                java.lang.String r9 = " -i "
                r0.append(r9)
                int r9 = r7.f36622c
                r23 = r12
                double r11 = (double) r9
                r19 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r11 = r11 / r19
                r0.append(r11)
                java.lang.String r9 = " -W "
                r0.append(r9)
                int r9 = r7.f36623d
                double r11 = (double) r9
                double r11 = r11 / r19
                r0.append(r11)
                java.lang.String r9 = " -c "
                r0.append(r9)
                int r9 = r7.f36621b
                r0.append(r9)
                java.lang.String r9 = " -s "
                r0.append(r9)
                int r9 = r7.f36624e
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                boolean r0 = r2.equals(r8)
                java.lang.String r2 = ""
                if (r0 == 0) goto L_0x01db
                com.startapp.u1 r0 = com.startapp.u1.this     // Catch:{ all -> 0x01d4 }
                android.content.Context r0 = r0.f36603d     // Catch:{ all -> 0x01d4 }
                java.lang.String r11 = "connectivity"
                java.lang.Object r0 = r0.getSystemService(r11)     // Catch:{ all -> 0x01d4 }
                android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ all -> 0x01d4 }
                if (r0 == 0) goto L_0x01b2
                com.startapp.u1 r11 = com.startapp.u1.this     // Catch:{ all -> 0x01d4 }
                android.content.Context r11 = r11.f36603d     // Catch:{ all -> 0x01d4 }
                java.lang.String r12 = "android.permission.ACCESS_NETWORK_STATE"
                int r11 = r11.checkCallingOrSelfPermission(r12)     // Catch:{ all -> 0x01d4 }
                if (r11 != 0) goto L_0x01b2
                int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d4 }
                r12 = 23
                if (r11 < r12) goto L_0x0184
                android.net.Network r11 = r0.getActiveNetwork()     // Catch:{ all -> 0x01d4 }
                android.net.LinkProperties r0 = r0.getLinkProperties(r11)     // Catch:{ all -> 0x01d4 }
                if (r0 == 0) goto L_0x01b2
                java.lang.String r0 = r0.getInterfaceName()     // Catch:{ all -> 0x01d4 }
                r24 = r6
                goto L_0x01b5
            L_0x0184:
                android.net.Network[] r11 = r0.getAllNetworks()     // Catch:{ all -> 0x01d4 }
                int r12 = r11.length     // Catch:{ all -> 0x01d4 }
                r17 = r2
                r5 = 0
            L_0x018c:
                if (r5 >= r12) goto L_0x01ad
                r24 = r6
                r6 = r11[r5]     // Catch:{ all -> 0x01d2 }
                android.net.NetworkInfo r19 = r0.getNetworkInfo(r6)     // Catch:{ all -> 0x01d2 }
                if (r19 == 0) goto L_0x01a8
                boolean r19 = r19.isConnected()     // Catch:{ all -> 0x01d2 }
                if (r19 == 0) goto L_0x01a8
                android.net.LinkProperties r6 = r0.getLinkProperties(r6)     // Catch:{ all -> 0x01d2 }
                if (r6 == 0) goto L_0x01a8
                java.lang.String r17 = r6.getInterfaceName()     // Catch:{ all -> 0x01d2 }
            L_0x01a8:
                int r5 = r5 + 1
                r6 = r24
                goto L_0x018c
            L_0x01ad:
                r24 = r6
                r0 = r17
                goto L_0x01b5
            L_0x01b2:
                r24 = r6
                r0 = r2
            L_0x01b5:
                if (r0 == 0) goto L_0x01dd
                boolean r5 = r0.isEmpty()     // Catch:{ all -> 0x01d2 }
                if (r5 != 0) goto L_0x01dd
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
                r5.<init>()     // Catch:{ all -> 0x01d2 }
                r5.append(r9)     // Catch:{ all -> 0x01d2 }
                java.lang.String r6 = " -I "
                r5.append(r6)     // Catch:{ all -> 0x01d2 }
                r5.append(r0)     // Catch:{ all -> 0x01d2 }
                java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x01d2 }
                goto L_0x01dd
            L_0x01d2:
                r0 = move-exception
                goto L_0x01d7
            L_0x01d4:
                r0 = move-exception
                r24 = r6
            L_0x01d7:
                com.startapp.l2.a((java.lang.Throwable) r0)
                goto L_0x01dd
            L_0x01db:
                r24 = r6
            L_0x01dd:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r9)
                java.lang.String r5 = " "
                r0.append(r5)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 1
                boolean[] r9 = new boolean[r1]
                r6 = 0
                r9[r6] = r6
                int[] r11 = new int[r1]
                r11[r6] = r6
                java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0349 }
                java.lang.Process r1 = r1.exec(r0)     // Catch:{ all -> 0x0349 }
                java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x033d }
                java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x033d }
                java.io.InputStream r12 = r1.getInputStream()     // Catch:{ all -> 0x033d }
                r0.<init>(r12)     // Catch:{ all -> 0x033d }
                r6.<init>(r0)     // Catch:{ all -> 0x033d }
                java.lang.String r0 = r6.readLine()     // Catch:{ all -> 0x032f }
                if (r0 != 0) goto L_0x021b
                if (r18 == 0) goto L_0x021b
                r12 = 1
                goto L_0x021c
            L_0x021b:
                r12 = 0
            L_0x021c:
                com.startapp.u1 r0 = com.startapp.u1.this     // Catch:{ all -> 0x0321 }
                com.startapp.j2 r0 = r0.f36602c     // Catch:{ all -> 0x0321 }
                if (r0 == 0) goto L_0x0250
                com.startapp.u1 r0 = com.startapp.u1.this     // Catch:{ all -> 0x0243 }
                com.startapp.j2 r0 = r0.f36602c     // Catch:{ all -> 0x0243 }
                r25 = r8
                com.startapp.networkTest.speedtest.SpeedtestEngineStatus r8 = com.startapp.networkTest.speedtest.SpeedtestEngineStatus.PING     // Catch:{ all -> 0x0241 }
                r26 = r10
                com.startapp.networkTest.speedtest.SpeedtestEngineError r10 = com.startapp.networkTest.speedtest.SpeedtestEngineError.OK     // Catch:{ all -> 0x023f }
                r27 = r13
                int r13 = r7.f36621b     // Catch:{ all -> 0x030e }
                int r14 = r7.f36623d     // Catch:{ all -> 0x030e }
                int r13 = r13 * r14
                long r13 = (long) r13     // Catch:{ all -> 0x030e }
                r0.a(r8, r10, r13)     // Catch:{ all -> 0x030e }
                goto L_0x0256
            L_0x023f:
                r0 = move-exception
                goto L_0x0248
            L_0x0241:
                r0 = move-exception
                goto L_0x0246
            L_0x0243:
                r0 = move-exception
                r25 = r8
            L_0x0246:
                r26 = r10
            L_0x0248:
                r27 = r13
            L_0x024a:
                r19 = r1
                r29 = r9
                goto L_0x032c
            L_0x0250:
                r25 = r8
                r26 = r10
                r27 = r13
            L_0x0256:
                if (r12 != 0) goto L_0x0311
                long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x030e }
                r0 = 0
            L_0x025d:
                int r8 = r7.f36621b     // Catch:{ all -> 0x030e }
                if (r0 >= r8) goto L_0x0311
                boolean r8 = r30.isCancelled()     // Catch:{ all -> 0x030e }
                if (r8 == 0) goto L_0x0278
                r6.close()     // Catch:{ all -> 0x030e }
                r6.close()     // Catch:{ all -> 0x026e }
                goto L_0x0273
            L_0x026e:
                r0 = move-exception
                r2 = r0
                com.startapp.l2.b(r2)
            L_0x0273:
                r1.destroy()
                r8 = 0
                return r8
            L_0x0278:
                r8 = 0
                java.lang.String r10 = r6.readLine()     // Catch:{ all -> 0x030e }
                long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x030e }
                r29 = r9
                long r8 = r19 - r13
                r17 = -1
                if (r10 == 0) goto L_0x02f2
                int r19 = r10.length()     // Catch:{ all -> 0x02ee }
                if (r19 <= 0) goto L_0x02f2
                java.lang.String[] r10 = r10.split(r5)     // Catch:{ all -> 0x02ee }
                r19 = r1
                int r1 = r10.length     // Catch:{ all -> 0x030c }
                r20 = r5
                r5 = 8
                if (r1 == r5) goto L_0x02a4
                int r1 = r10.length     // Catch:{ all -> 0x030c }
                r5 = 9
                if (r1 != r5) goto L_0x02a2
                goto L_0x02a4
            L_0x02a2:
                r1 = -1
                goto L_0x02a7
            L_0x02a4:
                int r1 = r10.length     // Catch:{ all -> 0x030c }
                int r1 = r1 + -2
            L_0x02a7:
                r5 = 6
                if (r1 == r5) goto L_0x02b1
                r5 = 7
                if (r1 != r5) goto L_0x02ae
                goto L_0x02b1
            L_0x02ae:
                r21 = r2
                goto L_0x02f8
            L_0x02b1:
                r1 = r10[r1]     // Catch:{ all -> 0x030c }
                java.lang.String r5 = "time="
                java.lang.String r1 = r1.replace(r5, r2)     // Catch:{ all -> 0x030c }
                double r21 = java.lang.Double.parseDouble(r1)     // Catch:{ all -> 0x030c }
                r5 = r2
                long r1 = java.lang.Math.round(r21)     // Catch:{ all -> 0x030c }
                int r2 = (int) r1     // Catch:{ all -> 0x030c }
                r1 = 0
                r10 = 1
                r29[r1] = r10     // Catch:{ all -> 0x030c }
                r17 = r11[r1]     // Catch:{ all -> 0x030c }
                int r17 = r17 + 1
                r11[r1] = r17     // Catch:{ all -> 0x030c }
                com.startapp.u1 r1 = com.startapp.u1.this     // Catch:{ all -> 0x030c }
                com.startapp.j2 r1 = r1.f36602c     // Catch:{ all -> 0x030c }
                if (r1 == 0) goto L_0x02eb
                com.startapp.u1 r1 = com.startapp.u1.this     // Catch:{ all -> 0x030c }
                com.startapp.j2 r1 = r1.f36602c     // Catch:{ all -> 0x030c }
                float r10 = (float) r0     // Catch:{ all -> 0x030c }
                r21 = r5
                int r5 = r7.f36621b     // Catch:{ all -> 0x030c }
                float r5 = (float) r5     // Catch:{ all -> 0x030c }
                float r10 = r10 / r5
                if (r2 >= 0) goto L_0x02e6
                r5 = 0
                goto L_0x02e7
            L_0x02e6:
                r5 = r2
            L_0x02e7:
                r1.b(r10, r5)     // Catch:{ all -> 0x030c }
                goto L_0x02f9
            L_0x02eb:
                r21 = r5
                goto L_0x02f9
            L_0x02ee:
                r0 = move-exception
                r19 = r1
                goto L_0x032c
            L_0x02f2:
                r19 = r1
                r21 = r2
                r20 = r5
            L_0x02f8:
                r2 = -1
            L_0x02f9:
                com.startapp.networkTest.results.speedtest.MeasurementPointLatency r1 = r7.a(r8, r2)     // Catch:{ all -> 0x030c }
                r4.add(r1)     // Catch:{ all -> 0x030c }
                int r0 = r0 + 1
                r1 = r19
                r5 = r20
                r2 = r21
                r9 = r29
                goto L_0x025d
            L_0x030c:
                r0 = move-exception
                goto L_0x032c
            L_0x030e:
                r0 = move-exception
                goto L_0x024a
            L_0x0311:
                r19 = r1
                r29 = r9
                r6.close()     // Catch:{ all -> 0x0319 }
                goto L_0x031e
            L_0x0319:
                r0 = move-exception
                r1 = r0
                com.startapp.l2.b(r1)
            L_0x031e:
                r1 = r19
                goto L_0x0365
            L_0x0321:
                r0 = move-exception
                r19 = r1
                r25 = r8
                r29 = r9
                r26 = r10
                r27 = r13
            L_0x032c:
                r1 = r19
                goto L_0x0355
            L_0x032f:
                r0 = move-exception
                r19 = r1
                r25 = r8
                r29 = r9
                r26 = r10
                r27 = r13
                r1 = r19
                goto L_0x0354
            L_0x033d:
                r0 = move-exception
                r19 = r1
                r25 = r8
                r29 = r9
                r26 = r10
                r27 = r13
                goto L_0x0353
            L_0x0349:
                r0 = move-exception
                r25 = r8
                r29 = r9
                r26 = r10
                r27 = r13
                r1 = 0
            L_0x0353:
                r6 = 0
            L_0x0354:
                r12 = 0
            L_0x0355:
                com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x046a }
                if (r6 == 0) goto L_0x0363
                r6.close()     // Catch:{ all -> 0x035e }
                goto L_0x0363
            L_0x035e:
                r0 = move-exception
                r2 = r0
                com.startapp.l2.b(r2)
            L_0x0363:
                if (r1 == 0) goto L_0x0368
            L_0x0365:
                r1.destroy()
            L_0x0368:
                if (r12 == 0) goto L_0x039e
                com.startapp.networkTest.enums.MeasurementTypes r0 = com.startapp.networkTest.enums.MeasurementTypes.APIIPING
                r3.MeasurementType = r0
                com.startapp.x1 r0 = new com.startapp.x1
                int r1 = r7.f36621b
                int r2 = r7.f36622c
                int r5 = r7.f36623d
                int r6 = r7.f36624e
                r17 = r0
                r19 = r1
                r20 = r2
                r21 = r5
                r22 = r6
                r17.<init>(r18, r19, r20, r21, r22)
                com.startapp.u1$a$a r8 = new com.startapp.u1$a$a
                r1 = r8
                r2 = r30
                r9 = r3
                r3 = r29
                r10 = r4
                r4 = r11
                r12 = 1
                r5 = r10
                r13 = r24
                r6 = r0
                r1.<init>(r3, r4, r5, r6)
                r0.a((com.startapp.z1) r8)
                r0.c()
                goto L_0x03a3
            L_0x039e:
                r9 = r3
                r10 = r4
                r13 = r24
                r12 = 1
            L_0x03a3:
                com.startapp.networkTest.enums.SpeedtestEndStates r0 = com.startapp.networkTest.enums.SpeedtestEndStates.Finish
                r9.TestEndState = r0
                com.startapp.networkTest.speedtest.SpeedtestEngineError r0 = com.startapp.networkTest.speedtest.SpeedtestEngineError.OK
                r9.TestErrorReason = r0
                r1 = 0
                boolean r0 = r29[r1]
                r9.Success = r0
                r0 = r11[r1]
                r9.SuccessfulPings = r0
                int r0 = r10.size()
                if (r0 <= 0) goto L_0x03c2
                r9.calculateStats(r10)
                java.util.ArrayList<com.startapp.networkTest.results.speedtest.MeasurementPointLatency> r0 = r9.MeasurementPoints
                r9.calcRatShare(r0)
            L_0x03c2:
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.y0 r0 = r0.f36607h
                com.startapp.networkTest.data.BatteryInfo r0 = r0.a()
                r9.BatteryInfoOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.networkTest.controller.LocationController r0 = r0.f36606g
                com.startapp.networkTest.data.LocationInfo r0 = r0.c()
                r9.LocationInfoOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                android.content.Context r0 = r0.f36603d
                com.startapp.networkTest.enums.ScreenStates r0 = com.startapp.z0.h(r0)
                r9.ScreenStateOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                android.content.Context r0 = r0.f36603d
                com.startapp.h1 r0 = com.startapp.z0.e(r0)
                r9.MemoryInfoOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.a1 r0 = r0.f36604e
                com.startapp.networkTest.data.RadioInfo r0 = r0.h()
                r9.RadioInfoOnEnd = r0
                com.startapp.networkTest.data.TimeInfo r0 = com.startapp.r2.e()
                r9.TimeInfoOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.b1 r0 = r0.f36605f
                com.startapp.networkTest.data.WifiInfo r0 = r0.c()
                r9.WifiInfoOnEnd = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                com.startapp.b1 r0 = r0.f36605f
                com.startapp.l1 r0 = com.startapp.z0.a((com.startapp.b1) r0)
                r9.TrafficInfoOnEnd = r0
                long r0 = android.os.SystemClock.uptimeMillis()
                long r0 = r0 - r15
                r9.DurationOverallNoSleep = r0
                long r0 = android.os.SystemClock.elapsedRealtime()
                long r0 = r0 - r27
                r9.DurationOverall = r0
                com.startapp.networkTest.enums.LtrCriteriaTypes r0 = r7.f36626g
                com.startapp.networkTest.enums.LtrCriteriaTypes r1 = com.startapp.networkTest.enums.LtrCriteriaTypes.CTItem
                if (r0 != r1) goto L_0x0438
                com.startapp.u1 r0 = com.startapp.u1.this
                java.lang.String r0 = r0.f36619t
                goto L_0x043e
            L_0x0438:
                java.lang.String r0 = r7.f36620a
                java.lang.String r0 = com.startapp.c3.a(r0)
            L_0x043e:
                r9.AirportCode = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                java.lang.String r0 = r0.f36613n
                r9.Meta = r0
                com.startapp.u1 r0 = com.startapp.u1.this
                java.lang.String r0 = r0.f36612m
                java.lang.String r0 = com.startapp.f3.a((java.lang.String) r0)
                r9.QuestionnaireName = r0
                r2 = 0
                boolean r0 = r29[r2]
                if (r0 == 0) goto L_0x0460
                int r0 = r13.successfulTests
                int r0 = r0 + r12
                r13.successfulTests = r0
                r0 = r9
                goto L_0x047f
            L_0x0460:
                int r12 = r23 + 1
                r0 = r9
                r8 = r25
                r10 = r26
                r9 = 0
                goto L_0x0028
            L_0x046a:
                r0 = move-exception
                r2 = r0
                if (r6 == 0) goto L_0x0477
                r6.close()     // Catch:{ all -> 0x0472 }
                goto L_0x0477
            L_0x0472:
                r0 = move-exception
                r3 = r0
                com.startapp.l2.b(r3)
            L_0x0477:
                if (r1 == 0) goto L_0x047c
                r1.destroy()
            L_0x047c:
                throw r2
            L_0x047d:
                r26 = r10
            L_0x047f:
                com.startapp.networkTest.enums.LtrCriteriaTypes r1 = r7.f36626g
                com.startapp.networkTest.enums.LtrCriteriaTypes r2 = com.startapp.networkTest.enums.LtrCriteriaTypes.CTItem
                if (r1 == r2) goto L_0x048a
                r1 = r26
                r7.a((java.util.List<com.startapp.g2>) r1)
            L_0x048a:
                com.startapp.u0 r1 = com.startapp.w0.b()
                boolean r1 = r1.CLEAR_LTR_LOCATION_INFO()
                if (r1 == 0) goto L_0x04a4
                if (r0 == 0) goto L_0x04a4
                com.startapp.networkTest.data.LocationInfo r1 = new com.startapp.networkTest.data.LocationInfo
                r1.<init>()
                r0.LocationInfoOnStart = r1
                com.startapp.networkTest.data.LocationInfo r1 = new com.startapp.networkTest.data.LocationInfo
                r1.<init>()
                r0.LocationInfoOnEnd = r1
            L_0x04a4:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.u1.a.doInBackground(java.lang.Void[]):com.startapp.networkTest.results.LatencyResult");
        }

        /* access modifiers changed from: private */
        public MeasurementPointLatency a(long j2, int i2) {
            MeasurementPointLatency measurementPointLatency = new MeasurementPointLatency();
            measurementPointLatency.Delta = j2;
            RadioInfo h2 = u1.this.f36604e.h();
            measurementPointLatency.ConnectionType = h2.ConnectionType;
            measurementPointLatency.NetworkType = h2.NetworkType;
            measurementPointLatency.NrAvailable = h2.NrAvailable;
            measurementPointLatency.NrState = h2.NrState;
            measurementPointLatency.RxLev = h2.RXLevel;
            measurementPointLatency.Rtt = i2;
            return measurementPointLatency;
        }

        /* renamed from: a */
        public void onPostExecute(LatencyResult latencyResult) {
            super.onPostExecute(latencyResult);
            P3TestResult unused = u1.this.f36608i = latencyResult;
            if (latencyResult != null) {
                if (u1.this.f36602c != null) {
                    u1.this.f36602c.a(SpeedtestEngineStatus.END, SpeedtestEngineError.OK, 0);
                }
            } else if (u1.this.f36602c != null) {
                u1.this.f36602c.a(SpeedtestEngineStatus.ABORTED, SpeedtestEngineError.OK, 0);
            }
        }

        private void a(List<g2> list) {
            HashSet hashSet = new HashSet();
            for (g2 g2Var : list) {
                hashSet.add(g2Var.toString());
            }
            w0.c().d((Set<String>) hashSet);
        }

        private List<g2> a(String[] strArr, LtrCriteriaTypes ltrCriteriaTypes, String str) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            Set<String> q2 = w0.c().q();
            LinkedList<g2> linkedList3 = new LinkedList<>();
            if (q2 != null) {
                for (String a2 : q2) {
                    g2 g2Var = (g2) z2.a(a2, g2.class);
                    if (g2Var != null) {
                        linkedList3.add(g2Var);
                    }
                }
            }
            for (String str2 : strArr) {
                g2 g2Var2 = new g2();
                g2Var2.address = str2;
                linkedList2.add(g2Var2);
            }
            for (g2 g2Var3 : linkedList3) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (strArr[i2].equals(g2Var3.address)) {
                        linkedList2.set(i2, g2Var3);
                    }
                }
            }
            int ordinal = ltrCriteriaTypes.ordinal();
            if (ordinal == 0) {
                Collections.sort(linkedList2, new c());
                return new LinkedList(linkedList2);
            } else if (ordinal == 1) {
                Collections.sort(linkedList2, new b());
                return new LinkedList(linkedList2);
            } else if (ordinal == 2) {
                Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                return new LinkedList(linkedList2);
            } else if (ordinal == 3) {
                return linkedList2;
            } else {
                if (ordinal != 4) {
                    return linkedList;
                }
                g2 g2Var4 = new g2();
                g2Var4.address = str;
                linkedList.add(g2Var4);
                return linkedList;
            }
        }
    }

    public void b() {
        a(LocationController.ProviderMode.GpsAndNetwork);
    }

    public void c() {
        LocationController locationController = this.f36606g;
        if (locationController != null) {
            locationController.f();
        }
        a1 a1Var = this.f36604e;
        if (a1Var != null) {
            a1Var.y();
        }
        b1 b1Var = this.f36605f;
        if (b1Var != null) {
            b1Var.g();
        }
    }

    public void d(String str) {
        this.f36617r = str;
    }

    public void e(String str) {
        this.f36613n = str;
    }

    public void f(String str) {
        this.f36618s = str;
    }

    public void g(String str) {
        this.f36612m = str;
    }

    public P3TestResult a() {
        return this.f36608i;
    }

    public void b(String str) {
        this.f36619t = str;
    }

    private void a(Context context, u0 u0Var) {
        this.f36604e = new a1(context);
        this.f36605f = new b1(context);
        this.f36606g = new LocationController(this.f36603d);
        this.f36607h = new y0(this.f36603d);
        this.f36609j = new ArrayList<>();
        if (u0Var.BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI()) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
    }

    public void c(String str) {
        this.f36614o = str;
    }

    public void a(LocationController.ProviderMode providerMode) {
        LocationController locationController = this.f36606g;
        if (locationController != null) {
            locationController.a(providerMode);
        }
        a1 a1Var = this.f36604e;
        if (a1Var != null) {
            a1Var.x();
        }
        b1 b1Var = this.f36605f;
        if (b1Var != null) {
            b1Var.f();
        }
    }

    public void a(String str) {
        ArrayList<j1> arrayList = this.f36609j;
        arrayList.add(new j1(arrayList.size() + 1, str));
    }

    public void a(String str, int i2, int i3, int i4, int i5, boolean z2) {
        this.f36609j = new ArrayList<>();
        new a(str, i2, i3, i4, i5, z2).executeOnExecutor(ThreadManager.b().a(), new Void[0]);
    }

    public void a(String str, int i2, int i3, int i4, int i5) {
        a(str, i2, i3, i4, i5, false);
    }
}
