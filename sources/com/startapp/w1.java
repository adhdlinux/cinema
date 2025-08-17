package com.startapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.TriggerEvents;
import com.startapp.networkTest.enums.voice.CallStates;
import com.startapp.networkTest.results.NetworkInformationResult;
import java.util.ArrayList;
import java.util.Arrays;

public class w1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36767a = "w1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f36768b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final int f36769c = 30000;

    /* renamed from: d  reason: collision with root package name */
    private static final String f36770d = "p3insnir";

    /* renamed from: e  reason: collision with root package name */
    private static final String f36771e = "P3INS_PFK_NIR_FIRSTCELLID_LATITUDE";

    /* renamed from: f  reason: collision with root package name */
    private static final String f36772f = "P3INS_PFK_NIR_FIRSTCELLID_LONGITUDE";

    /* renamed from: g  reason: collision with root package name */
    private static final String f36773g = "P3INS_PFK_NIR_FIRSTCELLID_GSMCELLID";

    /* renamed from: h  reason: collision with root package name */
    private SharedPreferences f36774h;

    /* renamed from: i  reason: collision with root package name */
    private Context f36775i;

    /* renamed from: j  reason: collision with root package name */
    private x0 f36776j;

    /* renamed from: k  reason: collision with root package name */
    private String f36777k;

    /* renamed from: l  reason: collision with root package name */
    private a1 f36778l;

    /* renamed from: m  reason: collision with root package name */
    private b1 f36779m;

    /* renamed from: n  reason: collision with root package name */
    private LocationController f36780n;

    /* renamed from: o  reason: collision with root package name */
    private TelephonyManager f36781o;

    /* renamed from: p  reason: collision with root package name */
    private b f36782p;

    /* renamed from: q  reason: collision with root package name */
    private c f36783q;

    /* renamed from: r  reason: collision with root package name */
    private int f36784r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f36785s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f36786t;

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f36787a;

        /* renamed from: b  reason: collision with root package name */
        public double f36788b;

        /* renamed from: c  reason: collision with root package name */
        public double f36789c;

        public b(String str, double d2, double d3) {
            this.f36787a = str;
            this.f36788b = d2;
            this.f36789c = d3;
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f36791a;

        /* renamed from: b  reason: collision with root package name */
        public String f36792b;

        /* renamed from: c  reason: collision with root package name */
        public String f36793c;

        /* renamed from: d  reason: collision with root package name */
        public NetworkTypes f36794d;

        /* renamed from: e  reason: collision with root package name */
        public String f36795e;

        /* renamed from: f  reason: collision with root package name */
        public String f36796f;

        /* renamed from: g  reason: collision with root package name */
        public int f36797g;

        private c() {
            this.f36791a = "";
            this.f36792b = "";
            this.f36793c = "";
            this.f36794d = NetworkTypes.Unknown;
            this.f36795e = "";
            this.f36796f = "";
        }

        public void a(String str, String str2, String str3, NetworkTypes networkTypes, String str4, String str5, int i2) {
            this.f36792b = str;
            this.f36791a = str2;
            this.f36793c = str3;
            this.f36794d = networkTypes;
            this.f36795e = str4;
            this.f36796f = str5;
            this.f36797g = i2;
        }
    }

    public w1(Context context) {
        int i2;
        this.f36775i = context;
        this.f36776j = new x0(context);
        this.f36777k = w0.b().PROJECT_ID();
        this.f36774h = context.getSharedPreferences(f36770d, 0);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.f36781o = telephonyManager;
        if (!(Build.VERSION.SDK_INT < 24 || telephonyManager == null || (i2 = z0.i(context).SubscriptionId) == -1)) {
            this.f36781o = this.f36781o.createForSubscriptionId(i2);
        }
        this.f36778l = new a1(this.f36775i);
        this.f36779m = new b1(this.f36775i);
        this.f36780n = new LocationController(this.f36775i);
        this.f36783q = new c();
        this.f36786t = w0.b().NIR_COLLECT_CELLINFO();
        int NIR_COLLECT_CELLINFO_THRESHOLD = w0.b().NIR_COLLECT_CELLINFO_THRESHOLD();
        this.f36785s = NIR_COLLECT_CELLINFO_THRESHOLD;
        if (NIR_COLLECT_CELLINFO_THRESHOLD <= 0) {
            this.f36785s = 1;
        }
    }

    private void d() {
        String string = this.f36774h.getString(f36773g, "");
        if (!string.isEmpty()) {
            this.f36782p = new b(string, Double.longBitsToDouble(this.f36774h.getLong(f36771e, 0)), Double.longBitsToDouble(this.f36774h.getLong(f36772f, 0)));
        }
    }

    public NetworkInformationResult a(TriggerEvents triggerEvents, boolean z2) {
        return a(this.f36780n.c(), triggerEvents, z2);
    }

    public void b(c1 c1Var) {
        a1 a1Var = this.f36778l;
        if (a1Var != null) {
            a1Var.b(c1Var);
        }
    }

    public void c() {
        LocationController locationController = this.f36780n;
        if (locationController != null) {
            locationController.a((LocationController.c) null);
        }
    }

    public void e() {
        this.f36780n.a(LocationController.ProviderMode.Passive);
        this.f36778l.x();
        this.f36779m.f();
    }

    public void f() {
        this.f36780n.f();
        this.f36778l.y();
        this.f36779m.g();
    }

    public NetworkInformationResult a(LocationInfo locationInfo, TriggerEvents triggerEvents, boolean z2) {
        String str;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        NetworkInformationResult networkInformationResult = new NetworkInformationResult(this.f36777k, this.f36776j.p());
        if (locationInfo != null) {
            networkInformationResult.LocationInfo = locationInfo;
        } else {
            networkInformationResult.LocationInfo = this.f36780n.c();
        }
        TimeInfo e2 = r2.e();
        networkInformationResult.TimeInfo = e2;
        networkInformationResult.Timestamp = e2.TimestampTableau;
        networkInformationResult.timestampMillis = e2.TimestampMillis;
        networkInformationResult.NirId = y2.a(e2, networkInformationResult.GUID);
        networkInformationResult.WifiInfo = this.f36779m.c();
        networkInformationResult.TriggerEvent = triggerEvents;
        networkInformationResult.ScreenState = z0.h(this.f36775i);
        networkInformationResult.CallState = a();
        if (this.f36786t) {
            int i2 = this.f36784r;
            this.f36784r = i2 + 1;
            if (i2 % this.f36785s == 0 || z2) {
                networkInformationResult.CellInfo = new ArrayList<>(Arrays.asList(this.f36778l.c()));
            }
        }
        networkInformationResult.RadioInfo = this.f36778l.h();
        String str2 = "";
        synchronized (this) {
            if (this.f36782p == null) {
                d();
            }
            if (!networkInformationResult.RadioInfo.GsmCellId.isEmpty()) {
                if (networkInformationResult.LocationInfo.LocationAge < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS && ((bVar4 = this.f36782p) == null || !bVar4.f36787a.equals(networkInformationResult.RadioInfo.GsmCellId))) {
                    String str3 = networkInformationResult.RadioInfo.GsmCellId;
                    LocationInfo locationInfo2 = networkInformationResult.LocationInfo;
                    b bVar5 = new b(str3, locationInfo2.LocationLatitude, locationInfo2.LocationLongitude);
                    this.f36782p = bVar5;
                    networkInformationResult.CellIdDeltaDistance = 0.0d;
                    a(bVar5);
                }
                str2 = networkInformationResult.RadioInfo.GsmCellId;
            } else if (!networkInformationResult.RadioInfo.CdmaBaseStationId.isEmpty()) {
                if (networkInformationResult.LocationInfo.LocationAge < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS && ((bVar3 = this.f36782p) == null || !bVar3.f36787a.equals(networkInformationResult.RadioInfo.CdmaBaseStationId))) {
                    String str4 = networkInformationResult.RadioInfo.CdmaBaseStationId;
                    LocationInfo locationInfo3 = networkInformationResult.LocationInfo;
                    b bVar6 = new b(str4, locationInfo3.LocationLatitude, locationInfo3.LocationLongitude);
                    this.f36782p = bVar6;
                    networkInformationResult.CellIdDeltaDistance = 0.0d;
                    a(bVar6);
                }
                str2 = networkInformationResult.RadioInfo.CdmaBaseStationId;
            }
            str = str2;
        }
        if ((!networkInformationResult.RadioInfo.GsmCellId.isEmpty() && networkInformationResult.CellIdDeltaDistance == -1.0d && (bVar2 = this.f36782p) != null && bVar2.f36787a.equals(networkInformationResult.RadioInfo.GsmCellId)) || (!networkInformationResult.RadioInfo.CdmaBaseStationId.isEmpty() && networkInformationResult.CellIdDeltaDistance == -1.0d && (bVar = this.f36782p) != null && bVar.f36787a.equals(networkInformationResult.RadioInfo.CdmaBaseStationId))) {
            b bVar7 = this.f36782p;
            double d2 = bVar7.f36788b;
            double d3 = bVar7.f36789c;
            LocationInfo locationInfo4 = networkInformationResult.LocationInfo;
            networkInformationResult.CellIdDeltaDistance = x2.a(d2, d3, locationInfo4.LocationLatitude, locationInfo4.LocationLongitude);
        }
        if (!str.isEmpty() && !str.equals(this.f36783q.f36791a)) {
            c cVar = this.f36783q;
            networkInformationResult.PrevNirId = cVar.f36792b;
            networkInformationResult.PrevCellId = cVar.f36791a;
            networkInformationResult.PrevLAC = cVar.f36793c;
            networkInformationResult.PrevNetworkType = cVar.f36794d;
            networkInformationResult.PrevMCC = cVar.f36795e;
            networkInformationResult.PrevMNC = cVar.f36796f;
            networkInformationResult.PrevRXLevel = cVar.f36797g;
        }
        c cVar2 = this.f36783q;
        String str5 = networkInformationResult.NirId;
        RadioInfo radioInfo = networkInformationResult.RadioInfo;
        cVar2.a(str5, str, radioInfo.GsmLAC, radioInfo.NetworkType, radioInfo.MCC, radioInfo.MNC, radioInfo.RXLevel);
        return networkInformationResult;
    }

    public a1 b() {
        return this.f36778l;
    }

    private CallStates a() {
        TelephonyManager telephonyManager = this.f36781o;
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

    @SuppressLint({"ApplySharedPref"})
    private void a(b bVar) {
        this.f36774h.edit().putString(f36773g, bVar.f36787a).commit();
        this.f36774h.edit().putLong(f36771e, Double.doubleToRawLongBits(bVar.f36788b)).commit();
        this.f36774h.edit().putLong(f36772f, Double.doubleToRawLongBits(bVar.f36789c)).commit();
    }

    public void a(LocationController.c cVar) {
        LocationController locationController = this.f36780n;
        if (locationController != null) {
            locationController.a(cVar);
        }
    }

    public void a(c1 c1Var) {
        a1 a1Var = this.f36778l;
        if (a1Var != null) {
            a1Var.a(c1Var);
        }
    }
}
