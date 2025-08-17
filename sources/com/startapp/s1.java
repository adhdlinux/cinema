package com.startapp;

import android.os.AsyncTask;
import com.startapp.networkTest.data.IspInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.net.WebApiClient;
import com.startapp.networkTest.threads.ThreadManager;
import java.util.HashMap;

public class s1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35826a = "s1";

    /* renamed from: b  reason: collision with root package name */
    private static final String f35827b = "ispinfo";

    /* renamed from: c  reason: collision with root package name */
    private static final String f35828c = "anonymize";

    /* renamed from: d  reason: collision with root package name */
    private static s1 f35829d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f35830e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f35831f = false;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, IspInfo> f35832g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private IspInfo f35833h;

    public class a extends AsyncTask<WifiInfo, Void, IspInfo> {
        public a() {
        }

        /* renamed from: a */
        public IspInfo doInBackground(WifiInfo... wifiInfoArr) {
            return s1.this.a(wifiInfoArr[0]);
        }

        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = s1.this.f35830e = true;
        }

        /* renamed from: a */
        public void onPostExecute(IspInfo ispInfo) {
            super.onPostExecute(ispInfo);
            boolean unused = s1.this.f35830e = false;
        }
    }

    public class b extends AsyncTask<Void, Void, IspInfo> {
        public b() {
        }

        /* renamed from: a */
        public IspInfo doInBackground(Void... voidArr) {
            return s1.this.a((WifiInfo) null);
        }

        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = s1.this.f35831f = true;
        }

        /* renamed from: a */
        public void onPostExecute(IspInfo ispInfo) {
            super.onPostExecute(ispInfo);
            boolean unused = s1.this.f35831f = false;
        }
    }

    private s1() {
    }

    public static s1 a() {
        if (f35829d == null) {
            f35829d = new s1();
        }
        return f35829d;
    }

    public IspInfo b(WifiInfo wifiInfo, boolean z2) {
        String str;
        t1 t1Var;
        IspInfo ispInfo = new IspInfo();
        if (z2) {
            try {
                str = w0.b().GEOIP_URL() + f35827b;
            } catch (Throwable th) {
                l2.a(th);
            }
        } else {
            str = w0.b().GEOIP_URL() + f35827b + "?" + f35828c + "=false";
        }
        c2 a2 = WebApiClient.a(WebApiClient.RequestMethod.GET, str);
        if (a2.f34283b.length() > 0 && (t1Var = (t1) z2.a(a2.f34283b, t1.class)) != null) {
            ispInfo.AutonomousSystemNumber = f3.a(t1Var.AutonomousSystemNumber);
            ispInfo.AutonomousSystemOrganization = f3.a(t1Var.AutonomousSystemOrganization);
            ispInfo.IpAddress = f3.a(t1Var.IpAddress);
            ispInfo.IspName = f3.a(t1Var.IspName);
            ispInfo.IspOrganizationalName = f3.a(t1Var.IspOrganizationalName);
            ispInfo.SuccessfulIspLookup = true;
            if (wifiInfo != null) {
                synchronized (this.f35832g) {
                    this.f35832g.put(wifiInfo.WifiBSSID_Full, ispInfo);
                }
            } else {
                this.f35833h = ispInfo;
            }
        }
        return ispInfo;
    }

    public IspInfo a(WifiInfo wifiInfo, boolean z2) {
        IspInfo ispInfo;
        synchronized (this.f35832g) {
            ispInfo = this.f35832g.get(wifiInfo.WifiBSSID_Full);
        }
        if (ispInfo != null) {
            return ispInfo;
        }
        if (z2 && !this.f35830e) {
            new a().executeOnExecutor(ThreadManager.b().a(), new WifiInfo[]{wifiInfo});
        }
        return new IspInfo();
    }

    public IspInfo a(boolean z2, boolean z3) {
        IspInfo ispInfo = this.f35833h;
        if ((z2 && !this.f35831f && ispInfo == null) || (z2 && !this.f35831f && z3)) {
            new b().executeOnExecutor(ThreadManager.b().a(), new Void[0]);
        }
        return ispInfo == null ? new IspInfo() : ispInfo;
    }

    public IspInfo a(WifiInfo wifiInfo) {
        return b(wifiInfo, true);
    }
}
