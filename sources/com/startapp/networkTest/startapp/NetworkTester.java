package com.startapp.networkTest.startapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.startapp.e2;
import com.startapp.i2;
import com.startapp.l2;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.startapp.CoverageMapperManager;
import com.startapp.o2;
import com.startapp.v1;
import com.startapp.w0;
import com.startapp.z2;

public final class NetworkTester {
    private static final String CTLT_CHECK_INTERVAL_KEY = "StartappCtLtCheckIntervalKey";
    private static final String CTLT_GUARD_DIFF_KEY = "StartappGuardDiffKey";
    private static final String CTLT_PREV_TIME_CHECK_KEY = "StartappCtLtPrevTimeCheckKey";
    public static final String LOG_TAG = "NetworkTester";
    private static final String P3WRAPPER_PREFS = "StartappP3WrapperPrefs";
    @SuppressLint({"StaticFieldLeak"})
    public static NetworkTester sInstance;
    public Thread mActiveThread;
    public ConnectivityTestListener mConnectivityTestListener;
    private Context mContext;
    public CoverageMapperManager mCoverageMapper;
    public v1 mForegroundTestManager;

    public static final class Config {
        public String CONNECTIVITY_TEST_CDNCONFIG_URL = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/cdnconfig.zip";
        public boolean CONNECTIVITY_TEST_ENABLED = true;
        public String CONNECTIVITY_TEST_FILENAME = "/favicon.ico";
        public String CONNECTIVITY_TEST_HOSTNAME = "d2to8y50b3n6dq.cloudfront.net";
        public boolean CT_COLLECT_CELLINFO = true;
        public boolean FOREGROUND_TEST_CT_ENABLED = true;
        public long FOREGROUND_TEST_CT_MIN_INTERVAL = 180000;
        public long FOREGROUND_TEST_CT_SCHEDULE_INTERVAL = 300000;
        public boolean FOREGROUND_TEST_NIR_ENABLED = true;
        public String GEOIP_URL = "https://geoip.api.c0nnectthed0ts.com/geoip/";
        public boolean NIR_COLLECT_CELLINFO = true;
        public int NIR_COLLECT_CELLINFO_THRESHOLD = 2;
        public String PROJECT_ID = "20050";
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f35510a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35511b;

        /* renamed from: com.startapp.networkTest.startapp.NetworkTester$a$a  reason: collision with other inner class name */
        public class C0056a implements i2 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f35512a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Looper f35513b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e2 f35514c;

            /* renamed from: com.startapp.networkTest.startapp.NetworkTester$a$a$a  reason: collision with other inner class name */
            public class C0057a implements Runnable {
                public C0057a() {
                }

                public void run() {
                    a.this.f35511b.a(false);
                }
            }

            public C0056a(boolean[] zArr, Looper looper, e2 e2Var) {
                this.f35512a = zArr;
                this.f35513b = looper;
                this.f35514c = e2Var;
            }

            public void a() {
                this.f35514c.b();
                Looper looper = this.f35513b;
                if (looper != null) {
                    NetworkTester.sInstance.mActiveThread = null;
                    looper.quit();
                }
                ConnectivityTestListener connectivityTestListener = NetworkTester.sInstance.mConnectivityTestListener;
                if (connectivityTestListener != null) {
                    connectivityTestListener.onConnectivityTestFinished(new o2(new C0057a()));
                } else {
                    a.this.f35511b.a(false);
                }
            }

            public void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult) {
                boolean[] zArr = this.f35512a;
                if (zArr[0]) {
                    Looper looper = this.f35513b;
                    if (looper != null) {
                        NetworkTester.sInstance.mActiveThread = null;
                        looper.quit();
                        a.this.f35511b.a(false);
                        return;
                    }
                    return;
                }
                zArr[0] = true;
                ConnectivityTestListener connectivityTestListener = NetworkTester.sInstance.mConnectivityTestListener;
                if (connectivityTestListener != null) {
                    connectivityTestListener.onConnectivityTestResult(connectivityTestResult);
                }
            }

            public void onLatencyTestResult(LatencyResult latencyResult) {
                boolean[] zArr = this.f35512a;
                if (zArr[1]) {
                    Looper looper = this.f35513b;
                    if (looper != null) {
                        NetworkTester.sInstance.mActiveThread = null;
                        looper.quit();
                        a.this.f35511b.a(false);
                        return;
                    }
                    return;
                }
                zArr[1] = true;
                ConnectivityTestListener connectivityTestListener = NetworkTester.sInstance.mConnectivityTestListener;
                if (connectivityTestListener != null) {
                    connectivityTestListener.onLatencyTestResult(latencyResult);
                }
            }
        }

        public a(Context context, b bVar) {
            this.f35510a = context;
            this.f35511b = bVar;
        }

        public void run() {
            Looper.prepare();
            Looper myLooper = Looper.myLooper();
            e2 e2Var = new e2(this.f35510a.getApplicationContext());
            e2Var.a();
            e2Var.a((i2) new C0056a(new boolean[2], myLooper, e2Var));
            Looper.loop();
        }
    }

    public interface b {
        void a(boolean z2);
    }

    private NetworkTester() {
    }

    public static void init(Context context, Config config) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (config != null) {
            String a2 = z2.a(config);
            if (a2 == null) {
                throw new IllegalArgumentException("Wrong format of config");
            } else if (sInstance == null) {
                NetworkTester networkTester = new NetworkTester();
                sInstance = networkTester;
                networkTester.mContext = context;
                w0.a(context, a2.getBytes());
                sInstance.mCoverageMapper = new CoverageMapperManager(context);
                sInstance.mForegroundTestManager = new v1(context, sInstance.mCoverageMapper);
            }
        } else {
            throw new IllegalArgumentException("config is null");
        }
    }

    public static int isAppInForeground() {
        v1 v1Var;
        NetworkTester networkTester = sInstance;
        if (networkTester == null || (v1Var = networkTester.mForegroundTestManager) == null) {
            return -1;
        }
        return v1Var.d();
    }

    public static boolean isPermissionGranted(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.checkSelfPermission(str) == 0) {
                    return true;
                }
                return false;
            } else if (context.checkCallingOrSelfPermission(str) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable th) {
            l2.a(th);
            return false;
        }
    }

    public static void runTests(Context context, b bVar) {
        CoverageMapperManager coverageMapperManager;
        CoverageMapperManager coverageMapperManager2;
        if (sInstance == null) {
            bVar.a(false);
        } else if (isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION") || isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(P3WRAPPER_PREFS, 0);
            long j2 = sharedPreferences.getLong(CTLT_GUARD_DIFF_KEY, 120000);
            if (System.currentTimeMillis() - sharedPreferences.getLong(CTLT_PREV_TIME_CHECK_KEY, 0) < sharedPreferences.getLong(CTLT_CHECK_INTERVAL_KEY, j2) - j2) {
                bVar.a(false);
            } else if (!w0.h()) {
                bVar.a(false);
            } else if (sInstance.mActiveThread != null) {
                bVar.a(false);
            } else {
                sharedPreferences.edit().putLong(CTLT_PREV_TIME_CHECK_KEY, System.currentTimeMillis()).commit();
                NetworkTester networkTester = sInstance;
                if (!(networkTester == null || (coverageMapperManager = networkTester.mCoverageMapper) == null)) {
                    coverageMapperManager.b();
                }
                if (networkTester != null) {
                    networkTester.mActiveThread = new Thread(new o2(new a(context, bVar)));
                }
                sInstance.mActiveThread.start();
            }
        } else {
            NetworkTester networkTester2 = sInstance;
            if (!(networkTester2 == null || (coverageMapperManager2 = networkTester2.mCoverageMapper) == null)) {
                coverageMapperManager2.e();
            }
            bVar.a(false);
        }
    }

    public static void setOnConnectivityLatencyListener(ConnectivityTestListener connectivityTestListener) {
        NetworkTester networkTester = sInstance;
        if (networkTester != null) {
            networkTester.mConnectivityTestListener = connectivityTestListener;
        }
    }

    public static void setOnNetworkInfoListener(CoverageMapperManager.OnNetworkInfoResultListener onNetworkInfoResultListener) {
        CoverageMapperManager coverageMapperManager;
        NetworkTester networkTester = sInstance;
        if (networkTester != null && (coverageMapperManager = networkTester.mCoverageMapper) != null) {
            coverageMapperManager.a(onNetworkInfoResultListener);
        }
    }

    public static void startListening(long j2, long j3) {
        NetworkTester networkTester = sInstance;
        if (networkTester != null) {
            SharedPreferences sharedPreferences = networkTester.mContext.getSharedPreferences(P3WRAPPER_PREFS, 0);
            sharedPreferences.edit().putLong(CTLT_CHECK_INTERVAL_KEY, j2).commit();
            sharedPreferences.edit().putLong(CTLT_GUARD_DIFF_KEY, j3).commit();
            CoverageMapperManager coverageMapperManager = networkTester.mCoverageMapper;
            if (coverageMapperManager != null) {
                coverageMapperManager.b();
            }
            v1 v1Var = networkTester.mForegroundTestManager;
            if (v1Var != null) {
                v1Var.e();
            }
        }
    }

    public static void stopListening() {
        v1 v1Var;
        CoverageMapperManager coverageMapperManager;
        NetworkTester networkTester = sInstance;
        if (!(networkTester == null || (coverageMapperManager = networkTester.mCoverageMapper) == null)) {
            coverageMapperManager.e();
        }
        if (networkTester != null && (v1Var = networkTester.mForegroundTestManager) != null) {
            v1Var.h();
        }
    }
}
