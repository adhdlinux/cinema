package com.startapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.enums.CtCriteriaTypes;
import com.startapp.networkTest.enums.voice.CallStates;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.speedtest.SpeedtestEngineError;
import com.startapp.networkTest.speedtest.SpeedtestEngineStatus;
import com.startapp.networkTest.threads.ThreadManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class e2 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f34396a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f34397b = "e2";

    /* renamed from: c  reason: collision with root package name */
    private static final int f34398c = 30000;

    /* renamed from: d  reason: collision with root package name */
    private static final String f34399d = "\r\n";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f34400e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a1 f34401f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b1 f34402g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public LocationController f34403h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public x0 f34404i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public i2 f34405j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f34406k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f34407l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f34408m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f34409n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public Random f34410o = new Random();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f34411p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f34412q;

    public e2(Context context) {
        this.f34400e = context;
        this.f34404i = new x0(context);
        u0 b2 = w0.b();
        this.f34406k = b2.PROJECT_ID();
        this.f34407l = b2.CONNECTIVITY_TEST_HOSTNAME();
        this.f34408m = b2.CONNECTIVITY_TEST_FILENAME();
        this.f34409n = b2.CONNECTIVITY_TEST_IP();
        this.f34411p = b2.CONNECTIVITY_TEST_MIN_BATTERY_LEVEL();
        this.f34412q = b2.CONNECTIVITY_TEST_ENABLED_IN_ROAMING();
        this.f34403h = new LocationController(context);
        this.f34401f = new a1(context);
        this.f34402g = new b1(context);
    }

    public void b() {
        this.f34403h.f();
        this.f34401f.y();
        this.f34402g.g();
    }

    public void a() {
        this.f34403h.a(LocationController.ProviderMode.Passive);
        this.f34401f.x();
        this.f34402g.f();
    }

    public class a extends AsyncTask<Void, String, ConnectivityTestResult> implements j2 {

        /* renamed from: a  reason: collision with root package name */
        private ConnectivityTestResult f34413a;

        /* renamed from: b  reason: collision with root package name */
        private u1 f34414b;

        /* renamed from: com.startapp.e2$a$a  reason: collision with other inner class name */
        public class C0052a implements Comparator<f2> {
            public C0052a() {
            }

            /* renamed from: a */
            public int compare(f2 f2Var, f2 f2Var2) {
                return f2Var.DNSSuccess - f2Var2.DNSSuccess;
            }
        }

        public class b implements Comparator<f2> {
            public b() {
            }

            /* renamed from: a */
            public int compare(f2 f2Var, f2 f2Var2) {
                return f2Var.TCPSuccess - f2Var2.TCPSuccess;
            }
        }

        public class c implements Comparator<f2> {
            public c() {
            }

            /* renamed from: a */
            public int compare(f2 f2Var, f2 f2Var2) {
                return f2Var.successfulTests - f2Var2.successfulTests;
            }
        }

        public class d implements Comparator<f2> {
            public d() {
            }

            /* renamed from: a */
            public int compare(f2 f2Var, f2 f2Var2) {
                return f2Var.totalTests - f2Var2.totalTests;
            }
        }

        public class e {

            /* renamed from: a  reason: collision with root package name */
            public final int f34420a;

            /* renamed from: b  reason: collision with root package name */
            public final String f34421b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f34422c;

            public e(int i2, String str, boolean z2) {
                this.f34420a = i2;
                this.f34421b = str;
                this.f34422c = z2;
            }
        }

        public a() {
        }

        private e a(InputStream inputStream) throws IOException {
            boolean z2;
            byte[] bArr = new byte[1024];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int read = inputStream.read();
                z2 = true;
                i2++;
                if (read == 10) {
                    z2 = false;
                    break;
                } else if (read < 0) {
                    break;
                } else {
                    int i4 = i3 + 1;
                    bArr[i3] = (byte) read;
                    if (i4 == bArr.length) {
                        bArr = Arrays.copyOf(bArr, i4 + 1024);
                    }
                    i3 = i4;
                }
            }
            if (i3 > 0 && bArr[i3 - 1] == 13) {
                i3--;
            }
            return new e(i2, new String(bArr, 0, i3, "UTF-8"), z2);
        }

        private CallStates b() {
            TelephonyManager telephonyManager = (TelephonyManager) e2.this.f34400e.getSystemService("phone");
            if (telephonyManager == null) {
                return CallStates.Unknown;
            }
            int callState = telephonyManager.getCallState();
            if (callState == 0) {
                return CallStates.Idle;
            }
            if (callState == 1) {
                return CallStates.Ringing;
            }
            if (callState != 2) {
                return CallStates.Unknown;
            }
            return CallStates.Offhook;
        }

        public void a(float f2, int i2) {
        }

        public void b(float f2, int i2) {
        }

        public void c(float f2, int i2) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:153:0x04d4 A[SYNTHETIC, Splitter:B:153:0x04d4] */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x0501  */
        /* JADX WARNING: Removed duplicated region for block: B:171:0x0584 A[SYNTHETIC, Splitter:B:171:0x0584] */
        /* JADX WARNING: Removed duplicated region for block: B:210:0x064e  */
        /* JADX WARNING: Removed duplicated region for block: B:211:0x0654  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x0671  */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x067f A[SYNTHETIC, Splitter:B:226:0x067f] */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x0692 A[SYNTHETIC, Splitter:B:231:0x0692] */
        /* JADX WARNING: Removed duplicated region for block: B:246:0x06c2 A[SYNTHETIC, Splitter:B:246:0x06c2] */
        /* JADX WARNING: Removed duplicated region for block: B:269:0x072e A[SYNTHETIC, Splitter:B:269:0x072e] */
        /* JADX WARNING: Removed duplicated region for block: B:282:0x0752  */
        /* JADX WARNING: Removed duplicated region for block: B:292:0x0805  */
        /* JADX WARNING: Removed duplicated region for block: B:295:0x0815  */
        /* JADX WARNING: Removed duplicated region for block: B:298:0x0824  */
        /* JADX WARNING: Removed duplicated region for block: B:342:0x0919 A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:348:0x0933  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:354:0x091c A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:356:0x0643 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:361:0x0664 A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.startapp.networkTest.results.ConnectivityTestResult doInBackground(java.lang.Void... r39) {
            /*
                r38 = this;
                r1 = r38
                java.lang.String r2 = "\r\n"
                com.startapp.y0 r0 = new com.startapp.y0
                com.startapp.e2 r3 = com.startapp.e2.this
                android.content.Context r3 = r3.f34400e
                r0.<init>(r3)
                com.startapp.networkTest.data.BatteryInfo r3 = r0.a()
                com.startapp.e2 r0 = com.startapp.e2.this
                float r0 = r0.f34411p
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                r5 = 0
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x002d
                float r0 = r3.BatteryLevel
                com.startapp.e2 r4 = com.startapp.e2.this
                float r4 = r4.f34411p
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 >= 0) goto L_0x002d
                return r5
            L_0x002d:
                com.startapp.e2 r0 = com.startapp.e2.this
                android.content.Context r0 = r0.f34400e
                com.startapp.r1 r4 = com.startapp.z0.i(r0)
                com.startapp.e2 r0 = com.startapp.e2.this
                boolean r0 = r0.f34412q
                if (r0 != 0) goto L_0x005c
                com.startapp.e2 r0 = com.startapp.e2.this
                com.startapp.a1 r0 = r0.f34401f
                com.startapp.networkTest.enums.ConnectionTypes r0 = r0.d()
                com.startapp.networkTest.enums.ConnectionTypes r6 = com.startapp.networkTest.enums.ConnectionTypes.Mobile
                if (r0 != r6) goto L_0x005c
                com.startapp.e2 r0 = com.startapp.e2.this
                com.startapp.a1 r0 = r0.f34401f
                int r6 = r4.SubscriptionId
                boolean r0 = r0.j((int) r6)
                if (r0 == 0) goto L_0x005c
                return r5
            L_0x005c:
                com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x0085 }
                long r7 = r0.w()     // Catch:{ all -> 0x0085 }
                long r9 = com.startapp.r2.d()     // Catch:{ all -> 0x0085 }
                com.startapp.u0 r0 = com.startapp.w0.b()     // Catch:{ all -> 0x0085 }
                long r11 = r0.CONNECTIVITY_TEST_TRUSTSTORE_UPDATE_INTERVAL()     // Catch:{ all -> 0x0085 }
                long r11 = r11 + r7
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 < 0) goto L_0x0079
                int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r0 <= 0) goto L_0x0089
            L_0x0079:
                com.startapp.e2 r0 = com.startapp.e2.this     // Catch:{ all -> 0x0085 }
                android.content.Context r0 = r0.f34400e     // Catch:{ all -> 0x0085 }
                boolean r0 = com.startapp.h3.a((android.content.Context) r0)     // Catch:{ all -> 0x0085 }
                r7 = r0
                goto L_0x008a
            L_0x0085:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0089:
                r7 = 0
            L_0x008a:
                com.startapp.x0 r0 = com.startapp.w0.c()     // Catch:{ all -> 0x00ab }
                long r8 = r0.t()     // Catch:{ all -> 0x00ab }
                long r10 = com.startapp.r2.d()     // Catch:{ all -> 0x00ab }
                com.startapp.u0 r0 = com.startapp.w0.b()     // Catch:{ all -> 0x00ab }
                long r12 = r0.CONNECTIVITY_TEST_CDNCONFIG_UPDATE_INTERVAL()     // Catch:{ all -> 0x00ab }
                long r12 = r12 + r8
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 < 0) goto L_0x00a7
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x00af
            L_0x00a7:
                com.startapp.u2.a()     // Catch:{ all -> 0x00ab }
                goto L_0x00af
            L_0x00ab:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x00af:
                boolean r0 = com.startapp.w0.h()
                if (r0 == 0) goto L_0x0933
                com.startapp.e2 r0 = com.startapp.e2.this
                com.startapp.b1 r0 = r0.f34402g
                if (r0 != 0) goto L_0x00bf
                goto L_0x0933
            L_0x00bf:
                com.startapp.networkTest.results.ConnectivityTestResult r0 = new com.startapp.networkTest.results.ConnectivityTestResult
                com.startapp.e2 r8 = com.startapp.e2.this
                java.lang.String r8 = r8.f34406k
                com.startapp.e2 r9 = com.startapp.e2.this
                com.startapp.x0 r9 = r9.f34404i
                java.lang.String r9 = r9.p()
                r0.<init>(r8, r9)
                r1.f34413a = r0
                com.startapp.e2 r8 = com.startapp.e2.this
                com.startapp.networkTest.controller.LocationController r8 = r8.f34403h
                com.startapp.networkTest.data.LocationInfo r8 = r8.c()
                r0.LocationInfo = r8
                com.startapp.x0 r0 = com.startapp.w0.c()
                java.lang.String[] r0 = r0.i()
                com.startapp.x0 r8 = com.startapp.w0.c()
                java.lang.String r8 = r8.h()
                com.startapp.networkTest.enums.CtCriteriaTypes r8 = com.startapp.networkTest.enums.CtCriteriaTypes.valueOf(r8)
                com.startapp.networkTest.results.ConnectivityTestResult r9 = r1.f34413a
                int r10 = com.startapp.networkTest.startapp.NetworkTester.isAppInForeground()
                r9.IsAppInForeground = r10
                com.startapp.networkTest.results.ConnectivityTestResult r9 = r1.f34413a
                java.lang.String r10 = "20211123190300"
                r9.Version = r10
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                com.startapp.e2 r11 = com.startapp.e2.this
                java.lang.String r11 = r11.f34408m
                r10.append(r11)
                java.lang.String r11 = "?id="
                r10.append(r11)
                com.startapp.e2 r11 = com.startapp.e2.this
                java.util.Random r11 = r11.f34410o
                long r11 = r11.nextLong()
                r10.append(r11)
                java.lang.String r10 = r10.toString()
                r9.ServerFilename = r10
                com.startapp.networkTest.results.ConnectivityTestResult r9 = r1.f34413a
                r9.BatteryInfo = r3
                com.startapp.e2 r3 = com.startapp.e2.this
                android.content.Context r3 = r3.f34400e
                com.startapp.f1 r3 = com.startapp.z0.b((android.content.Context) r3)
                r9.DeviceInfo = r3
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                android.content.Context r9 = r9.f34400e
                com.startapp.h1 r9 = com.startapp.z0.e(r9)
                r3.MemoryInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                com.startapp.a1 r9 = r9.f34401f
                com.startapp.networkTest.data.RadioInfo r9 = r9.h()
                r3.RadioInfo = r9
                com.startapp.u0 r3 = com.startapp.w0.b()
                boolean r3 = r3.CT_COLLECT_CELLINFO()
                if (r3 == 0) goto L_0x0177
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                java.util.ArrayList r9 = new java.util.ArrayList
                com.startapp.e2 r10 = com.startapp.e2.this
                com.startapp.a1 r10 = r10.f34401f
                com.startapp.networkTest.data.radio.CellInfo[] r10 = r10.c()
                java.util.List r10 = java.util.Arrays.asList(r10)
                r9.<init>(r10)
                r3.CellInfo = r9
            L_0x0177:
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                java.util.ArrayList r9 = new java.util.ArrayList
                com.startapp.e2 r10 = com.startapp.e2.this
                com.startapp.a1 r10 = r10.f34401f
                com.startapp.networkTest.data.radio.ApnInfo[] r10 = r10.a()
                java.util.List r10 = java.util.Arrays.asList(r10)
                r9.<init>(r10)
                r3.ApnInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                java.util.ArrayList r9 = new java.util.ArrayList
                com.startapp.e2 r10 = com.startapp.e2.this
                com.startapp.a1 r10 = r10.f34401f
                com.startapp.e2 r11 = com.startapp.e2.this
                com.startapp.a1 r11 = r11.f34401f
                com.startapp.q1 r11 = r11.b()
                int r11 = r11.DefaultDataSimId
                com.startapp.networkTest.data.radio.NetworkRegistrationInfo[] r10 = r10.g((int) r11)
                java.util.List r10 = java.util.Arrays.asList(r10)
                r9.<init>(r10)
                r3.NetworkRegistrationInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                com.startapp.a1 r9 = r9.f34401f
                com.startapp.e2 r10 = com.startapp.e2.this
                com.startapp.a1 r10 = r10.f34401f
                com.startapp.q1 r10 = r10.b()
                int r10 = r10.DefaultDataSimId
                com.startapp.networkTest.enums.NetworkTypes r9 = r9.i((int) r10)
                r3.VoiceNetworkType = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.networkTest.enums.voice.CallStates r9 = r38.b()
                r3.CallState = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                android.content.Context r9 = r9.f34400e
                com.startapp.k1 r9 = com.startapp.z0.k(r9)
                r3.StorageInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                com.startapp.b1 r9 = r9.f34402g
                com.startapp.networkTest.data.WifiInfo r9 = r9.c()
                r3.WifiInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                com.startapp.b1 r9 = r9.f34402g
                com.startapp.l1 r9 = com.startapp.z0.a((com.startapp.b1) r9)
                r3.TrafficInfo = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                android.content.Context r9 = r9.f34400e
                com.startapp.networkTest.enums.ScreenStates r9 = com.startapp.z0.h(r9)
                r3.ScreenState = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.e2 r9 = com.startapp.e2.this
                android.content.Context r9 = r9.f34400e
                com.startapp.networkTest.enums.IdleStates r9 = com.startapp.z0.d(r9)
                r3.IdleStateOnStart = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                r3.SimInfo = r4
                com.startapp.networkTest.data.TimeInfo r4 = com.startapp.r2.e()
                r3.TimeInfo = r4
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.networkTest.data.TimeInfo r4 = r3.TimeInfo
                java.lang.String r4 = r4.TimestampTableau
                r3.TestTimestamp = r4
                com.startapp.x0 r4 = com.startapp.w0.c()
                long r9 = r4.F()
                r3.TruststoreTimestamp = r9
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                com.startapp.networkTest.data.TimeInfo r4 = r3.TimeInfo
                java.lang.String r9 = r3.GUID
                java.lang.String r4 = com.startapp.y2.a(r4, r9)
                r3.CtId = r4
                com.startapp.e2 r3 = com.startapp.e2.this
                com.startapp.x0 r3 = r3.f34404i
                boolean r3 = r3.l()
                r4 = 1
                if (r3 == 0) goto L_0x025e
                com.startapp.e2 r3 = com.startapp.e2.this
                com.startapp.x0 r3 = r3.f34404i
                boolean r3 = r3.m()
                if (r3 != 0) goto L_0x025e
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a
                r3.IsKeepAlive = r4
            L_0x025e:
                long r9 = android.os.SystemClock.elapsedRealtime()
                long r11 = android.os.SystemClock.uptimeMillis()
                javax.net.ssl.HostnameVerifier r3 = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier()
                com.startapp.d1 r13 = new com.startapp.d1
                com.startapp.e2 r14 = com.startapp.e2.this
                android.content.Context r14 = r14.f34400e
                r13.<init>(r14, r7)
                java.util.List r7 = r1.a((java.lang.String[]) r0, (com.startapp.networkTest.enums.CtCriteriaTypes) r8)
                java.util.LinkedList r8 = new java.util.LinkedList
                r8.<init>()
                com.startapp.e2 r0 = com.startapp.e2.this
                java.lang.String r0 = r0.f34407l
                com.startapp.e2 r14 = com.startapp.e2.this
                java.lang.String r14 = r14.f34409n
                r16 = r5
                r19 = r16
                r20 = r19
                r5 = 0
                r17 = 0
                r18 = 0
                r34 = r9
                r9 = r0
                r36 = r11
                r12 = r14
                r10 = r34
                r14 = r36
            L_0x029f:
                int r0 = r7.size()
                r22 = r7
                java.lang.String r6 = ""
                java.lang.String r7 = "; "
                if (r5 < r0) goto L_0x02cb
                boolean r0 = r22.isEmpty()
                if (r0 == 0) goto L_0x02b8
                int r0 = r9.length()
                if (r0 <= 0) goto L_0x02b8
                goto L_0x02cb
            L_0x02b8:
                r31 = r8
                r8 = r16
                r5 = r17
                r9 = r18
                r12 = r19
                r0 = r20
                r4 = 0
                r16 = 0
                r21 = 0
                goto L_0x0437
            L_0x02cb:
                com.startapp.i1 r4 = new com.startapp.i1
                r4.<init>()
                long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x08e3 }
                long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x08dd }
                com.startapp.f2 r25 = new com.startapp.f2     // Catch:{ all -> 0x08d5 }
                r25.<init>()     // Catch:{ all -> 0x08d5 }
                int r17 = r17 + 1
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x08bd }
                r26 = r10
                boolean r10 = r38.a()     // Catch:{ all -> 0x08b0 }
                r0.LocalhostPingSuccess = r10     // Catch:{ all -> 0x08b0 }
                long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x08b0 }
                boolean r0 = r22.isEmpty()     // Catch:{ all -> 0x08b0 }
                r28 = r14
                if (r0 != 0) goto L_0x0380
                r15 = r22
                java.lang.Object r0 = r15.get(r5)     // Catch:{ all -> 0x0372 }
                r14 = r0
                com.startapp.f2 r14 = (com.startapp.f2) r14     // Catch:{ all -> 0x0372 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x0366 }
                r22 = r15
                java.lang.String r15 = r14.address     // Catch:{ all -> 0x035a }
                r0.ServerHostname = r15     // Catch:{ all -> 0x035a }
                int r0 = r14.totalTests     // Catch:{ all -> 0x035a }
                r15 = 1
                int r0 = r0 + r15
                r14.totalTests = r0     // Catch:{ all -> 0x035a }
                int r0 = r5 + 1
                r4.Try = r0     // Catch:{ all -> 0x035a }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
                r0.<init>()     // Catch:{ all -> 0x035a }
                com.startapp.networkTest.results.ConnectivityTestResult r15 = r1.f34413a     // Catch:{ all -> 0x035a }
                java.lang.String r15 = r15.ServerHostname     // Catch:{ all -> 0x035a }
                r0.append(r15)     // Catch:{ all -> 0x035a }
                com.startapp.networkTest.results.ConnectivityTestResult r15 = r1.f34413a     // Catch:{ all -> 0x035a }
                java.lang.String r15 = r15.ServerFilename     // Catch:{ all -> 0x035a }
                r0.append(r15)     // Catch:{ all -> 0x035a }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x035a }
                r4.HostFile = r0     // Catch:{ all -> 0x035a }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x035a }
                com.startapp.a2 r15 = new com.startapp.a2     // Catch:{ all -> 0x035a }
                r15.<init>()     // Catch:{ all -> 0x035a }
                r30 = r14
                com.startapp.networkTest.results.ConnectivityTestResult r14 = r1.f34413a     // Catch:{ all -> 0x0358 }
                java.lang.String r14 = r14.ServerHostname     // Catch:{ all -> 0x0358 }
                r31 = r8
                r8 = 30000(0x7530, float:4.2039E-41)
                java.lang.String r14 = r15.a((java.lang.String) r14, (int) r8)     // Catch:{ all -> 0x034e }
                r0.ServerIp = r14     // Catch:{ all -> 0x034e }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x034e }
                long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x034e }
                long r14 = r14 - r10
                r0.DurationDNS = r14     // Catch:{ all -> 0x034e }
                r8 = r30
                r15 = 1
                goto L_0x03d2
            L_0x034e:
                r0 = move-exception
                r23 = r2
                r2 = r22
                r16 = r30
                r10 = r31
                goto L_0x0364
            L_0x0358:
                r0 = move-exception
                goto L_0x035d
            L_0x035a:
                r0 = move-exception
                r30 = r14
            L_0x035d:
                r23 = r2
                r10 = r8
                r2 = r22
                r16 = r30
            L_0x0364:
                r15 = 1
                goto L_0x03aa
            L_0x0366:
                r0 = move-exception
                r30 = r14
                r23 = r2
                r22 = r3
                r10 = r8
                r2 = r15
                r16 = r30
                goto L_0x037b
            L_0x0372:
                r0 = move-exception
                r23 = r2
                r22 = r3
                r10 = r8
                r2 = r15
                r16 = r25
            L_0x037b:
                r15 = 1
                r21 = 0
                goto L_0x08ce
            L_0x0380:
                r31 = r8
                int r0 = r12.length()     // Catch:{ all -> 0x08a8 }
                if (r0 <= 0) goto L_0x03b0
                int r0 = r9.length()     // Catch:{ all -> 0x03a0 }
                if (r0 <= 0) goto L_0x03b0
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x03a0 }
                r0.ServerIp = r12     // Catch:{ all -> 0x03a0 }
                r0.ServerHostname = r9     // Catch:{ all -> 0x03a0 }
                r10 = 0
                r0.DurationDNS = r10     // Catch:{ all -> 0x03a0 }
                int r5 = r5 + -1
                r9 = r6
                r12 = r9
            L_0x039c:
                r8 = r25
                r15 = 0
                goto L_0x03d2
            L_0x03a0:
                r0 = move-exception
                r23 = r2
                r2 = r22
                r16 = r25
                r10 = r31
                r15 = 0
            L_0x03aa:
                r21 = 0
            L_0x03ac:
                r22 = r3
                goto L_0x08ce
            L_0x03b0:
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x08a8 }
                r0.ServerHostname = r9     // Catch:{ all -> 0x08a8 }
                int r5 = r5 + -1
                com.startapp.a2 r8 = new com.startapp.a2     // Catch:{ all -> 0x0897 }
                r8.<init>()     // Catch:{ all -> 0x0897 }
                com.startapp.networkTest.results.ConnectivityTestResult r9 = r1.f34413a     // Catch:{ all -> 0x0897 }
                java.lang.String r9 = r9.ServerHostname     // Catch:{ all -> 0x0897 }
                r14 = 30000(0x7530, float:4.2039E-41)
                java.lang.String r8 = r8.a((java.lang.String) r9, (int) r14)     // Catch:{ all -> 0x0897 }
                r0.ServerIp = r8     // Catch:{ all -> 0x0897 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x0897 }
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0897 }
                long r8 = r8 - r10
                r0.DurationDNS = r8     // Catch:{ all -> 0x0897 }
                r9 = r6
                goto L_0x039c
            L_0x03d2:
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x0886 }
                long r10 = r0.DurationDNS     // Catch:{ all -> 0x0886 }
                r32 = 30000(0x7530, double:1.4822E-319)
                int r14 = (r10 > r32 ? 1 : (r10 == r32 ? 0 : -1))
                if (r14 > 0) goto L_0x086d
                java.lang.String r0 = r0.ServerIp     // Catch:{ all -> 0x085f }
                r4.ServerIp = r0     // Catch:{ all -> 0x085f }
                r4.DurationDNS = r10     // Catch:{ all -> 0x085f }
                int r0 = r8.DNSSuccess     // Catch:{ all -> 0x085f }
                r10 = 1
                int r0 = r0 + r10
                r8.DNSSuccess = r0     // Catch:{ all -> 0x085f }
                int r18 = r18 + 1
                r0 = 30000(0x7530, float:4.2039E-41)
                javax.net.SocketFactory r10 = android.net.SSLCertificateSocketFactory.getDefault(r0)     // Catch:{ all -> 0x085f }
                android.net.SSLCertificateSocketFactory r10 = (android.net.SSLCertificateSocketFactory) r10     // Catch:{ all -> 0x085f }
                r11 = 1
                javax.net.ssl.TrustManager[] r0 = new javax.net.ssl.TrustManager[r11]     // Catch:{ all -> 0x084b }
                r21 = 0
                r0[r21] = r13     // Catch:{ all -> 0x0844 }
                r10.setTrustManagers(r0)     // Catch:{ all -> 0x0844 }
                java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0844 }
                com.startapp.networkTest.results.ConnectivityTestResult r11 = r1.f34413a     // Catch:{ all -> 0x0844 }
                java.lang.String r11 = r11.ServerIp     // Catch:{ all -> 0x0844 }
                r14 = 443(0x1bb, float:6.21E-43)
                r0.<init>(r11, r14)     // Catch:{ all -> 0x0844 }
                java.net.Socket r11 = r10.createSocket()     // Catch:{ all -> 0x0844 }
                javax.net.ssl.SSLSocket r11 = (javax.net.ssl.SSLSocket) r11     // Catch:{ all -> 0x0844 }
                long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0839 }
                r14 = 30000(0x7530, float:4.2039E-41)
                r11.connect(r0, r14)     // Catch:{ all -> 0x0839 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x0839 }
                long r32 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0839 }
                r14 = r9
                r16 = r10
                long r9 = r32 - r19
                r0.DurationTcpConnect = r9     // Catch:{ all -> 0x0830 }
                int r0 = r8.TCPSuccess     // Catch:{ all -> 0x0830 }
                r9 = 1
                int r0 = r0 + r9
                r8.TCPSuccess = r0     // Catch:{ all -> 0x0830 }
                r12 = r11
                r0 = r16
                r5 = r17
                r9 = r18
                r10 = r26
                r14 = r28
                r4 = 1
                r16 = 1
            L_0x0437:
                if (r16 == 0) goto L_0x0746
                long r17 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06f9 }
                r19 = r4
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06f4 }
                java.lang.String r4 = r4.ServerHostname     // Catch:{ Exception -> 0x06f4 }
                r0.setHostname(r12, r4)     // Catch:{ Exception -> 0x06f4 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x048d }
                java.lang.String r0 = r0.ServerHostname     // Catch:{ all -> 0x048d }
                javax.net.ssl.SSLSession r4 = r12.getSession()     // Catch:{ all -> 0x048d }
                boolean r0 = r3.verify(r0, r4)     // Catch:{ all -> 0x048d }
                if (r0 != 0) goto L_0x0488
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x048d }
                r0.<init>()     // Catch:{ all -> 0x048d }
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a     // Catch:{ all -> 0x048d }
                java.lang.String r4 = r3.SslException     // Catch:{ all -> 0x048d }
                r0.append(r4)     // Catch:{ all -> 0x048d }
                java.lang.String r4 = "Expected "
                r0.append(r4)     // Catch:{ all -> 0x048d }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ all -> 0x048d }
                java.lang.String r4 = r4.ServerHostname     // Catch:{ all -> 0x048d }
                r0.append(r4)     // Catch:{ all -> 0x048d }
                java.lang.String r4 = " found "
                r0.append(r4)     // Catch:{ all -> 0x048d }
                javax.net.ssl.SSLSession r4 = r12.getSession()     // Catch:{ all -> 0x048d }
                java.security.Principal r4 = r4.getPeerPrincipal()     // Catch:{ all -> 0x048d }
                r0.append(r4)     // Catch:{ all -> 0x048d }
                r0.append(r7)     // Catch:{ all -> 0x048d }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x048d }
                r3.SslException = r0     // Catch:{ all -> 0x048d }
                r16 = r9
                goto L_0x04b4
            L_0x0488:
                r3 = r16
                r16 = r9
                goto L_0x04b5
            L_0x048d:
                r0 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06f4 }
                r3.<init>()     // Catch:{ Exception -> 0x06f4 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06f4 }
                r16 = r9
                java.lang.String r9 = r4.SslException     // Catch:{ Exception -> 0x06ee }
                r3.append(r9)     // Catch:{ Exception -> 0x06ee }
                java.lang.String r9 = "Cannot validate hostname: "
                r3.append(r9)     // Catch:{ Exception -> 0x06ee }
                java.lang.String r9 = r0.getMessage()     // Catch:{ Exception -> 0x06ee }
                r3.append(r9)     // Catch:{ Exception -> 0x06ee }
                r3.append(r7)     // Catch:{ Exception -> 0x06ee }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x06ee }
                r4.SslException = r3     // Catch:{ Exception -> 0x06ee }
                com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x06ee }
            L_0x04b4:
                r3 = 0
            L_0x04b5:
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06ee }
                long r25 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06ee }
                r9 = r3
                long r3 = r25 - r17
                r0.DurationSSL = r3     // Catch:{ Exception -> 0x06ee }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06e2 }
                com.startapp.networkTest.enums.CtTestTypes r3 = r13.b()     // Catch:{ Exception -> 0x06e2 }
                r0.TestType = r3     // Catch:{ Exception -> 0x06e2 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06e2 }
                com.startapp.networkTest.enums.CtTestTypes r0 = r0.TestType     // Catch:{ Exception -> 0x06e2 }
                com.startapp.networkTest.enums.CtTestTypes r3 = com.startapp.networkTest.enums.CtTestTypes.SSLOwnTs     // Catch:{ Exception -> 0x06e2 }
                boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x06e2 }
                if (r0 != 0) goto L_0x0501
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f7 }
                r0.<init>()     // Catch:{ Exception -> 0x04f7 }
                com.startapp.networkTest.results.ConnectivityTestResult r3 = r1.f34413a     // Catch:{ Exception -> 0x04f7 }
                java.lang.String r4 = r3.SslException     // Catch:{ Exception -> 0x04f7 }
                r0.append(r4)     // Catch:{ Exception -> 0x04f7 }
                java.lang.String r4 = "We couldn't use our own truststore, used: "
                r0.append(r4)     // Catch:{ Exception -> 0x04f7 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x04f7 }
                com.startapp.networkTest.enums.CtTestTypes r4 = r4.TestType     // Catch:{ Exception -> 0x04f7 }
                r0.append(r4)     // Catch:{ Exception -> 0x04f7 }
                r0.append(r7)     // Catch:{ Exception -> 0x04f7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04f7 }
                r3.SslException = r0     // Catch:{ Exception -> 0x04f7 }
                r0 = 0
                goto L_0x0502
            L_0x04f7:
                r0 = move-exception
                r18 = r5
                r30 = r7
                r6 = r9
                r28 = r10
                goto L_0x0705
            L_0x0501:
                r0 = r9
            L_0x0502:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06e2 }
                r3.<init>()     // Catch:{ Exception -> 0x06e2 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06e2 }
                r17 = r0
                java.lang.String r0 = r4.SslException     // Catch:{ Exception -> 0x06e2 }
                r3.append(r0)     // Catch:{ Exception -> 0x06e2 }
                java.lang.String r0 = r13.a()     // Catch:{ Exception -> 0x06e2 }
                r3.append(r0)     // Catch:{ Exception -> 0x06e2 }
                r3.append(r7)     // Catch:{ Exception -> 0x06e2 }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x06e2 }
                r4.SslException = r0     // Catch:{ Exception -> 0x06e2 }
                r0 = 2048(0x800, float:2.87E-42)
                byte[] r3 = new byte[r0]     // Catch:{ Exception -> 0x06d4 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ Exception -> 0x06d4 }
                java.io.OutputStream r4 = r12.getOutputStream()     // Catch:{ Exception -> 0x06d4 }
                r0.<init>(r4)     // Catch:{ Exception -> 0x06d4 }
                long r25 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = "GET "
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = r4.ServerFilename     // Catch:{ Exception -> 0x06d4 }
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = " HTTP/1.1"
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                r0.print(r2)     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = "HOST: "
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = r4.ServerHostname     // Catch:{ Exception -> 0x06d4 }
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                r0.print(r2)     // Catch:{ Exception -> 0x06d4 }
                java.lang.String r4 = "Connection: close"
                r0.print(r4)     // Catch:{ Exception -> 0x06d4 }
                r0.print(r2)     // Catch:{ Exception -> 0x06d4 }
                r0.print(r2)     // Catch:{ Exception -> 0x06d4 }
                r0.print(r2)     // Catch:{ Exception -> 0x06d4 }
                r0.flush()     // Catch:{ Exception -> 0x06d4 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06d4 }
                long r27 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06d4 }
                r18 = r5
                long r4 = r27 - r25
                r0.DurationHttpGetCommand = r4     // Catch:{ Exception -> 0x06d2 }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06d2 }
                java.io.InputStream r2 = r12.getInputStream()     // Catch:{ Exception -> 0x06d2 }
                r20 = r9
                r9 = -1
                r25 = 0
            L_0x057e:
                com.startapp.e2$a$e r0 = r1.a((java.io.InputStream) r2)     // Catch:{ all -> 0x06b5 }
                if (r0 == 0) goto L_0x0643
                int r13 = r0.f34420a     // Catch:{ all -> 0x063c }
                r28 = r10
                long r10 = (long) r13
                long r25 = r25 + r10
                java.lang.String r10 = r0.f34421b     // Catch:{ all -> 0x063a }
                java.lang.String r10 = r10.toUpperCase()     // Catch:{ all -> 0x063a }
                java.lang.String r11 = "HTTP"
                boolean r11 = r10.startsWith(r11)     // Catch:{ all -> 0x063a }
                if (r11 == 0) goto L_0x05d8
                java.lang.String r0 = " "
                java.lang.String[] r0 = r10.split(r0)     // Catch:{ all -> 0x063a }
                com.startapp.networkTest.results.ConnectivityTestResult r10 = r1.f34413a     // Catch:{ all -> 0x063a }
                r11 = 1
                r0 = r0[r11]     // Catch:{ all -> 0x063a }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x063a }
                r10.HTTPStatus = r0     // Catch:{ all -> 0x063a }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x063a }
                int r0 = r0.HTTPStatus     // Catch:{ all -> 0x063a }
                r10 = 200(0xc8, float:2.8E-43)
                if (r0 == r10) goto L_0x0636
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x063a }
                r0.<init>()     // Catch:{ all -> 0x063a }
                com.startapp.networkTest.results.ConnectivityTestResult r10 = r1.f34413a     // Catch:{ all -> 0x063a }
                java.lang.String r11 = r10.ErrorReason     // Catch:{ all -> 0x063a }
                r0.append(r11)     // Catch:{ all -> 0x063a }
                java.lang.String r11 = "Request failed! Unexcepted HTTP code: "
                r0.append(r11)     // Catch:{ all -> 0x063a }
                com.startapp.networkTest.results.ConnectivityTestResult r11 = r1.f34413a     // Catch:{ all -> 0x063a }
                int r11 = r11.HTTPStatus     // Catch:{ all -> 0x063a }
                r0.append(r11)     // Catch:{ all -> 0x063a }
                r0.append(r7)     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x063a }
                r10.ErrorReason = r0     // Catch:{ all -> 0x063a }
                r10 = r28
                r17 = 0
                goto L_0x057e
            L_0x05d8:
                java.lang.String r11 = "CONTENT-LENGTH:"
                boolean r11 = r10.startsWith(r11)     // Catch:{ all -> 0x063a }
                r13 = 15
                if (r11 == 0) goto L_0x05f4
                java.lang.String r0 = r10.substring(r13)     // Catch:{ all -> 0x05ef }
                java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x05ef }
                int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x05ef }
                goto L_0x0636
            L_0x05ef:
                r0 = move-exception
                com.startapp.l2.b(r0)     // Catch:{ all -> 0x063a }
                goto L_0x0636
            L_0x05f4:
                java.lang.String r11 = "X-AMZ-CF-ID:"
                boolean r11 = r10.startsWith(r11)     // Catch:{ all -> 0x063a }
                if (r11 == 0) goto L_0x060b
                com.startapp.networkTest.results.ConnectivityTestResult r10 = r1.f34413a     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.f34421b     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.substring(r13)     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x063a }
                r10.AmazonId = r0     // Catch:{ all -> 0x063a }
                goto L_0x0636
            L_0x060b:
                boolean r11 = r0.f34422c     // Catch:{ all -> 0x063a }
                if (r11 != 0) goto L_0x0645
                boolean r11 = r10.equals(r6)     // Catch:{ all -> 0x063a }
                if (r11 == 0) goto L_0x0616
                goto L_0x0645
            L_0x0616:
                java.lang.String r11 = "X-AMZ-CF-POP:"
                boolean r10 = r10.startsWith(r11)     // Catch:{ all -> 0x063a }
                if (r10 == 0) goto L_0x0636
                com.startapp.networkTest.results.ConnectivityTestResult r10 = r1.f34413a     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.f34421b     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x063a }
                r11 = 13
                java.lang.String r0 = r0.substring(r11)     // Catch:{ all -> 0x063a }
                java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x063a }
                java.lang.String r0 = com.startapp.c3.b(r0)     // Catch:{ all -> 0x063a }
                r10.AirportCode = r0     // Catch:{ all -> 0x063a }
            L_0x0636:
                r10 = r28
                goto L_0x057e
            L_0x063a:
                r0 = move-exception
                goto L_0x063f
            L_0x063c:
                r0 = move-exception
                r28 = r10
            L_0x063f:
                r30 = r7
                goto L_0x06ba
            L_0x0643:
                r28 = r10
            L_0x0645:
                r10 = r25
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x06b0 }
                r0.HeaderBytesRead = r10     // Catch:{ all -> 0x06b0 }
                r6 = -1
                if (r9 == r6) goto L_0x0654
                int r0 = (int) r10
                int r0 = r0 + r9
                r30 = r7
                long r6 = (long) r0
                goto L_0x065b
            L_0x0654:
                r30 = r7
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x065b:
                r25 = r10
            L_0x065d:
                int r0 = r2.read(r3)     // Catch:{ all -> 0x06ae }
                r9 = -1
                if (r0 != r9) goto L_0x0671
                int r0 = (r25 > r6 ? 1 : (r25 == r6 ? 0 : -1))
                if (r0 < 0) goto L_0x0669
                goto L_0x067b
            L_0x0669:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x06ae }
                java.lang.String r2 = "Could not read all bytes"
                r0.<init>(r2)     // Catch:{ all -> 0x06ae }
                throw r0     // Catch:{ all -> 0x06ae }
            L_0x0671:
                long r10 = (long) r0
                long r25 = r25 + r10
                int r10 = (r25 > r6 ? 1 : (r25 == r6 ? 0 : -1))
                if (r10 < 0) goto L_0x0679
                goto L_0x067b
            L_0x0679:
                if (r0 > 0) goto L_0x065d
            L_0x067b:
                r2 = r25
                if (r17 == 0) goto L_0x068c
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ all -> 0x068a }
                r6 = 1
                r0.Success = r6     // Catch:{ all -> 0x068a }
                int r0 = r8.successfulTests     // Catch:{ all -> 0x068a }
                int r0 = r0 + r6
                r8.successfulTests = r0     // Catch:{ all -> 0x068a }
                goto L_0x068c
            L_0x068a:
                r0 = move-exception
                goto L_0x06bc
            L_0x068c:
                r6 = 0
                int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x069f
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06d0 }
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06d0 }
                long r6 = r6 - r4
                r0.DurationHttpReceive = r6     // Catch:{ Exception -> 0x06d0 }
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a     // Catch:{ Exception -> 0x06d0 }
                r0.BytesRead = r2     // Catch:{ Exception -> 0x06d0 }
            L_0x069f:
                r12.close()     // Catch:{ all -> 0x06a7 }
                r0 = r20
                r6 = 1
                goto L_0x0750
            L_0x06a7:
                r0 = move-exception
                r6 = r20
                r21 = 1
                goto L_0x0733
            L_0x06ae:
                r0 = move-exception
                goto L_0x06ba
            L_0x06b0:
                r0 = move-exception
                r30 = r7
                r2 = r10
                goto L_0x06bc
            L_0x06b5:
                r0 = move-exception
                r30 = r7
                r28 = r10
            L_0x06ba:
                r2 = r25
            L_0x06bc:
                r6 = 0
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x06cf
                com.startapp.networkTest.results.ConnectivityTestResult r6 = r1.f34413a     // Catch:{ Exception -> 0x06d0 }
                long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x06d0 }
                long r7 = r7 - r4
                r6.DurationHttpReceive = r7     // Catch:{ Exception -> 0x06d0 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ Exception -> 0x06d0 }
                r4.BytesRead = r2     // Catch:{ Exception -> 0x06d0 }
            L_0x06cf:
                throw r0     // Catch:{ Exception -> 0x06d0 }
            L_0x06d0:
                r0 = move-exception
                goto L_0x06dd
            L_0x06d2:
                r0 = move-exception
                goto L_0x06d7
            L_0x06d4:
                r0 = move-exception
                r18 = r5
            L_0x06d7:
                r30 = r7
                r20 = r9
                r28 = r10
            L_0x06dd:
                r6 = r20
                r21 = 1
                goto L_0x0705
            L_0x06e2:
                r0 = move-exception
                r18 = r5
                r30 = r7
                r20 = r9
                r28 = r10
                r6 = r20
                goto L_0x0705
            L_0x06ee:
                r0 = move-exception
                r18 = r5
                r30 = r7
                goto L_0x0702
            L_0x06f4:
                r0 = move-exception
                goto L_0x06fc
            L_0x06f6:
                r0 = move-exception
                r2 = r0
                goto L_0x073a
            L_0x06f9:
                r0 = move-exception
                r19 = r4
            L_0x06fc:
                r18 = r5
                r30 = r7
                r16 = r9
            L_0x0702:
                r28 = r10
                r6 = 0
            L_0x0705:
                com.startapp.e2 r2 = com.startapp.e2.this     // Catch:{ all -> 0x06f6 }
                java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x06f6 }
                java.lang.String r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x06f6 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x06f6 }
                r3.<init>()     // Catch:{ all -> 0x06f6 }
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a     // Catch:{ all -> 0x06f6 }
                java.lang.String r5 = r4.ErrorReason     // Catch:{ all -> 0x06f6 }
                r3.append(r5)     // Catch:{ all -> 0x06f6 }
                r3.append(r2)     // Catch:{ all -> 0x06f6 }
                r7 = r30
                r3.append(r7)     // Catch:{ all -> 0x06f6 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x06f6 }
                r4.ErrorReason = r2     // Catch:{ all -> 0x06f6 }
                com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x06f6 }
                if (r12 == 0) goto L_0x0736
                r12.close()     // Catch:{ all -> 0x0732 }
                goto L_0x0736
            L_0x0732:
                r0 = move-exception
            L_0x0733:
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0736:
                r0 = r6
                r6 = r21
                goto L_0x0750
            L_0x073a:
                if (r12 == 0) goto L_0x0745
                r12.close()     // Catch:{ all -> 0x0740 }
                goto L_0x0745
            L_0x0740:
                r0 = move-exception
                r3 = r0
                com.startapp.l2.a((java.lang.Throwable) r3)
            L_0x0745:
                throw r2
            L_0x0746:
                r19 = r4
                r18 = r5
                r16 = r9
                r28 = r10
                r0 = 0
                r6 = 0
            L_0x0750:
                if (r6 == 0) goto L_0x078a
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                com.startapp.networkTest.data.RadioInfo r3 = r2.RadioInfo
                com.startapp.networkTest.enums.ConnectionTypes r3 = r3.ConnectionType
                com.startapp.networkTest.enums.ConnectionTypes r4 = com.startapp.networkTest.enums.ConnectionTypes.WiFi
                if (r3 != r4) goto L_0x076b
                com.startapp.s1 r3 = com.startapp.s1.a()
                com.startapp.networkTest.results.ConnectivityTestResult r4 = r1.f34413a
                com.startapp.networkTest.data.WifiInfo r4 = r4.WifiInfo
                com.startapp.networkTest.data.IspInfo r3 = r3.a(r4)
                r2.IspInfo = r3
                goto L_0x078a
            L_0x076b:
                com.startapp.u0 r2 = com.startapp.w0.b()
                boolean r2 = r2.GEOIP_MOBILE_ENABLED()
                if (r2 == 0) goto L_0x078a
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                com.startapp.networkTest.data.RadioInfo r3 = r2.RadioInfo
                com.startapp.networkTest.enums.ConnectionTypes r3 = r3.ConnectionType
                com.startapp.networkTest.enums.ConnectionTypes r4 = com.startapp.networkTest.enums.ConnectionTypes.Mobile
                if (r3 != r4) goto L_0x078a
                com.startapp.s1 r3 = com.startapp.s1.a()
                r4 = 0
                com.startapp.networkTest.data.IspInfo r3 = r3.a(r4)
                r2.IspInfo = r3
            L_0x078a:
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                com.startapp.e2 r3 = com.startapp.e2.this
                com.startapp.a1 r3 = r3.f34401f
                com.startapp.networkTest.data.RadioInfo r3 = r3.h()
                r2.RadioInfoOnEnd = r3
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                long r3 = android.os.SystemClock.uptimeMillis()
                long r3 = r3 - r14
                r2.DurationOverallNoSleep = r3
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                long r3 = android.os.SystemClock.elapsedRealtime()
                long r3 = r3 - r28
                r2.DurationOverall = r3
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                com.startapp.e2 r3 = com.startapp.e2.this
                android.content.Context r3 = r3.f34400e
                com.startapp.networkTest.enums.IdleStates r3 = com.startapp.z0.d(r3)
                r2.IdleStateOnEnd = r3
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                java.util.ArrayList r3 = new java.util.ArrayList
                r10 = r31
                r3.<init>(r10)
                r2.MultiCdnInfo = r3
                com.startapp.networkTest.results.ConnectivityTestResult r2 = r1.f34413a
                r3 = r18
                long r3 = (long) r3
                r5 = r16
                long r5 = (long) r5
                r7 = 4611686018427387904(0x4000000000000000, double:2.0)
                r9 = 4621819117588971520(0x4024000000000000, double:10.0)
                double r7 = java.lang.Math.pow(r9, r7)
                long r7 = java.lang.Math.round(r7)
                long r5 = r5 * r7
                long r3 = r3 + r5
                r5 = r19
                long r5 = (long) r5
                r7 = 4616189618054758400(0x4010000000000000, double:4.0)
                double r7 = java.lang.Math.pow(r9, r7)
                long r7 = java.lang.Math.round(r7)
                long r5 = r5 * r7
                long r3 = r3 + r5
                long r5 = (long) r0
                r7 = 4618441417868443648(0x4018000000000000, double:6.0)
                double r7 = java.lang.Math.pow(r9, r7)
                long r7 = java.lang.Math.round(r7)
                long r5 = r5 * r7
                long r3 = r3 + r5
                r2.ServerMultiSuccess = r3
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a
                java.lang.String r0 = r0.AirportCode
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x080f
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a
                java.lang.String r2 = r0.ServerIp
                java.lang.String r2 = com.startapp.c3.a(r2)
                r0.AirportCode = r2
            L_0x080f:
                int r0 = r22.size()
                if (r0 <= 0) goto L_0x081a
                r9 = r22
                r1.a((java.util.List<com.startapp.f2>) r9)
            L_0x081a:
                com.startapp.u0 r0 = com.startapp.w0.b()
                boolean r0 = r0.CLEAR_CT_LOCATION_INFO()
                if (r0 == 0) goto L_0x082d
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a
                com.startapp.networkTest.data.LocationInfo r2 = new com.startapp.networkTest.data.LocationInfo
                r2.<init>()
                r0.LocationInfo = r2
            L_0x082d:
                com.startapp.networkTest.results.ConnectivityTestResult r0 = r1.f34413a
                return r0
            L_0x0830:
                r0 = move-exception
                r10 = r31
                r23 = r2
                r19 = r11
                r9 = r14
                goto L_0x0855
            L_0x0839:
                r0 = move-exception
                r14 = r9
                r16 = r10
                r10 = r31
                r23 = r2
                r19 = r11
                goto L_0x0855
            L_0x0844:
                r0 = move-exception
                r14 = r9
                r16 = r10
                r10 = r31
                goto L_0x0853
            L_0x084b:
                r0 = move-exception
                r14 = r9
                r16 = r10
                r10 = r31
                r21 = 0
            L_0x0853:
                r23 = r2
            L_0x0855:
                r20 = r16
                r2 = r22
                r22 = r3
                r16 = r8
                goto L_0x08ce
            L_0x085f:
                r0 = move-exception
                r14 = r9
                r10 = r31
                r21 = 0
                r23 = r2
                r16 = r8
                r2 = r22
                goto L_0x03ac
            L_0x086d:
                r23 = r2
                r14 = r9
                r9 = r22
                r10 = r31
                r21 = 0
                r22 = r3
                r2 = -1
                r0.DurationDNS = r2     // Catch:{ all -> 0x0884 }
                java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0884 }
                java.lang.String r2 = "DNS Timeout"
                r0.<init>(r2)     // Catch:{ all -> 0x0884 }
                throw r0     // Catch:{ all -> 0x0884 }
            L_0x0884:
                r0 = move-exception
                goto L_0x0892
            L_0x0886:
                r0 = move-exception
                r23 = r2
                r14 = r9
                r9 = r22
                r10 = r31
                r21 = 0
                r22 = r3
            L_0x0892:
                r16 = r8
                r2 = r9
                r9 = r14
                goto L_0x08ce
            L_0x0897:
                r0 = move-exception
                r23 = r2
                r9 = r22
                r10 = r31
                r21 = 0
                r22 = r3
                r2 = r9
                r16 = r25
                r15 = 0
                r9 = r6
                goto L_0x08ce
            L_0x08a8:
                r0 = move-exception
                r23 = r2
                r2 = r22
                r10 = r31
                goto L_0x08b8
            L_0x08b0:
                r0 = move-exception
                r23 = r2
                r10 = r8
                r28 = r14
                r2 = r22
            L_0x08b8:
                r21 = 0
                r22 = r3
                goto L_0x08cb
            L_0x08bd:
                r0 = move-exception
                r23 = r2
                r26 = r10
                r28 = r14
                r2 = r22
                r21 = 0
                r22 = r3
                r10 = r8
            L_0x08cb:
                r16 = r25
                r15 = 0
            L_0x08ce:
                r3 = r10
                r6 = r15
                r10 = r26
                r14 = r28
                goto L_0x08ee
            L_0x08d5:
                r0 = move-exception
                r23 = r2
                r26 = r10
                r28 = r14
                goto L_0x08e6
            L_0x08dd:
                r0 = move-exception
                r23 = r2
                r26 = r10
                goto L_0x08e6
            L_0x08e3:
                r0 = move-exception
                r23 = r2
            L_0x08e6:
                r2 = r22
                r21 = 0
                r22 = r3
                r3 = r8
                r6 = 0
            L_0x08ee:
                com.startapp.e2 r8 = com.startapp.e2.this     // Catch:{ all -> 0x092c }
                r24 = r2
                java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x092c }
                java.lang.String r2 = r8.a((java.lang.String) r2)     // Catch:{ all -> 0x092c }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x092c }
                r8.<init>()     // Catch:{ all -> 0x092c }
                r25 = r9
                com.startapp.networkTest.results.ConnectivityTestResult r9 = r1.f34413a     // Catch:{ all -> 0x092c }
                java.lang.String r1 = r9.ErrorReason     // Catch:{ all -> 0x092c }
                r8.append(r1)     // Catch:{ all -> 0x092c }
                r8.append(r2)     // Catch:{ all -> 0x092c }
                r8.append(r7)     // Catch:{ all -> 0x092c }
                java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x092c }
                r9.ErrorReason = r1     // Catch:{ all -> 0x092c }
                com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x092c }
                if (r6 == 0) goto L_0x091c
                r3.add(r4)
            L_0x091c:
                r1 = 1
                int r5 = r5 + r1
                r1 = r38
                r8 = r3
                r3 = r22
                r2 = r23
                r7 = r24
                r9 = r25
                r4 = 1
                goto L_0x029f
            L_0x092c:
                r0 = move-exception
                if (r6 == 0) goto L_0x0932
                r3.add(r4)
            L_0x0932:
                throw r0
            L_0x0933:
                r1 = r5
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.e2.a.doInBackground(java.lang.Void[]):com.startapp.networkTest.results.ConnectivityTestResult");
        }

        /* renamed from: a */
        public void onPostExecute(ConnectivityTestResult connectivityTestResult) {
            boolean z2;
            e2.this.f34404i.f(SystemClock.elapsedRealtime());
            if (e2.this.f34405j != null) {
                e2.this.f34405j.onConnectivityTestResult(connectivityTestResult);
            }
            if (connectivityTestResult != null) {
                if (!e2.this.f34404i.m() || connectivityTestResult.ServerIp.length() <= 0) {
                    z2 = false;
                } else {
                    u1 u1Var = new u1(this, e2.this.f34400e);
                    this.f34414b = u1Var;
                    u1Var.g(connectivityTestResult.CtId);
                    this.f34414b.b(connectivityTestResult.AirportCode);
                    this.f34414b.e(String.valueOf(connectivityTestResult.TimeInfo.TimestampMillis + connectivityTestResult.DurationDNS + connectivityTestResult.DurationTcpConnect + connectivityTestResult.DurationHttpReceive));
                    this.f34414b.a(w0.b().LTR_LOCATIONPROVIDER());
                    this.f34414b.a(connectivityTestResult.ServerIp, 10, 200, 30000, 56, true);
                    z2 = true;
                }
                if (!z2 && e2.this.f34405j != null) {
                    e2.this.f34405j.a();
                }
            } else if (e2.this.f34405j != null) {
                e2.this.f34405j.a();
            }
        }

        public void a(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j2) {
            if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ABORTED) {
                this.f34414b.c();
                if (e2.this.f34405j != null) {
                    e2.this.f34405j.onLatencyTestResult((LatencyResult) this.f34414b.a());
                    e2.this.f34405j.a();
                }
            }
        }

        private List<f2> a(String[] strArr, CtCriteriaTypes ctCriteriaTypes) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            Set<String> f2 = w0.c().f();
            LinkedList<f2> linkedList3 = new LinkedList<>();
            if (f2 != null) {
                for (String a2 : f2) {
                    f2 f2Var = (f2) z2.a(a2, f2.class);
                    if (f2Var != null) {
                        linkedList3.add(f2Var);
                    }
                }
            }
            for (String str : strArr) {
                f2 f2Var2 = new f2();
                f2Var2.address = str;
                linkedList2.add(f2Var2);
            }
            for (f2 f2Var3 : linkedList3) {
                for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                    if (((f2) linkedList2.get(i2)).address.equals(f2Var3.address)) {
                        linkedList2.set(i2, f2Var3);
                    }
                }
            }
            int ordinal = ctCriteriaTypes.ordinal();
            if (ordinal == 0) {
                Collections.sort(linkedList2, new d());
                return new LinkedList(linkedList2);
            } else if (ordinal == 1) {
                Collections.sort(linkedList2, new C0052a());
                return new LinkedList(linkedList2);
            } else if (ordinal == 2) {
                Collections.sort(linkedList2, new b());
                return new LinkedList(linkedList2);
            } else if (ordinal == 3) {
                Collections.sort(linkedList2, new c());
                return new LinkedList(linkedList2);
            } else if (ordinal == 4) {
                Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                return new LinkedList(linkedList2);
            } else if (ordinal != 5) {
                return linkedList;
            } else {
                return linkedList2;
            }
        }

        private void a(List<f2> list) {
            HashSet hashSet = new HashSet();
            for (f2 f2Var : list) {
                hashSet.add(f2Var.toString());
            }
            w0.c().a((Set<String>) hashSet);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a() {
            /*
                r3 = this;
                java.lang.String r0 = "ping -W 3 -c 1 -s 56 127.0.0.1"
                java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0042 }
                java.lang.Process r0 = r1.exec(r0)     // Catch:{ all -> 0x0042 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0042 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0042 }
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ all -> 0x0042 }
                r2.<init>(r0)     // Catch:{ all -> 0x0042 }
                r1.<init>(r2)     // Catch:{ all -> 0x0042 }
                r1.readLine()     // Catch:{ all -> 0x0040 }
                java.lang.String r0 = r1.readLine()     // Catch:{ all -> 0x0040 }
                if (r0 == 0) goto L_0x003c
                int r2 = r0.length()     // Catch:{ all -> 0x0040 }
                if (r2 <= 0) goto L_0x003c
                java.lang.String r2 = " "
                java.lang.String[] r0 = r0.split(r2)     // Catch:{ all -> 0x0040 }
                int r0 = r0.length     // Catch:{ all -> 0x0040 }
                r2 = 8
                if (r0 != r2) goto L_0x003c
                r1.close()     // Catch:{ all -> 0x0036 }
                goto L_0x003a
            L_0x0036:
                r0 = move-exception
                com.startapp.l2.b(r0)
            L_0x003a:
                r0 = 1
                return r0
            L_0x003c:
                r1.close()     // Catch:{ all -> 0x004d }
                goto L_0x0051
            L_0x0040:
                r0 = move-exception
                goto L_0x0044
            L_0x0042:
                r0 = move-exception
                r1 = 0
            L_0x0044:
                com.startapp.l2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0053 }
                if (r1 == 0) goto L_0x0051
                r1.close()     // Catch:{ all -> 0x004d }
                goto L_0x0051
            L_0x004d:
                r0 = move-exception
                com.startapp.l2.b(r0)
            L_0x0051:
                r0 = 0
                return r0
            L_0x0053:
                r0 = move-exception
                if (r1 == 0) goto L_0x005e
                r1.close()     // Catch:{ all -> 0x005a }
                goto L_0x005e
            L_0x005a:
                r1 = move-exception
                com.startapp.l2.b(r1)
            L_0x005e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.e2.a.a():boolean");
        }
    }

    public void a(i2 i2Var) {
        this.f34405j = i2Var;
        new a().executeOnExecutor(ThreadManager.b().a(), new Void[0]);
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll("(?:[0-9]{1,3}\\.){3}[0-9]{1,3}", "XXX").replaceAll("([A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4}", "XXX");
    }
}
