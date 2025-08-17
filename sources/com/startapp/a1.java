package com.startapp;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaTrack;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.radio.ApnInfo;
import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.CellConnectionStatus;
import com.startapp.networkTest.enums.CellNetworkTypes;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.DuplexMode;
import com.startapp.networkTest.enums.NetworkGenerations;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.PreferredNetworkTypes;
import com.startapp.networkTest.enums.ServiceStates;
import com.startapp.networkTest.enums.ThreeStateShort;
import com.startapp.networkTest.enums.radio.SignalStrengths;
import com.startapp.networkTest.enums.wifi.WifiDetailedStates;
import com.startapp.networkTest.threads.ThreadManager;
import com.startapp.networkTest.utils.LteFrequencyUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

public class a1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34079a = "a1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34080b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final int f34081c = 16;

    /* renamed from: d  reason: collision with root package name */
    private static final int f34082d = 17;

    /* renamed from: e  reason: collision with root package name */
    private static final int f34083e = 18;

    /* renamed from: f  reason: collision with root package name */
    private static final int f34084f = 19;
    private Method A;
    private Method B;
    /* access modifiers changed from: private */
    public Field C;
    private Field D;
    /* access modifiers changed from: private */
    public Field E;
    /* access modifiers changed from: private */
    public Field F;
    /* access modifiers changed from: private */
    public Field G;
    /* access modifiers changed from: private */
    public Method H;
    /* access modifiers changed from: private */
    public Field I;
    private Field J;
    private Field K;
    private Field L;
    private Field M;
    private Method N;
    private Method O;
    private Method P;
    /* access modifiers changed from: private */
    public Method Q;
    private Method R;
    private Method S;
    private Method T;
    private ContentResolver U;
    /* access modifiers changed from: private */
    public int[] V;
    public final List<c1> W;
    /* access modifiers changed from: private */
    public boolean X;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f34085g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TelephonyManager f34086h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<TelephonyManager> f34087i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Context f34088j;

    /* renamed from: k  reason: collision with root package name */
    private o f34089k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<o> f34090l;

    /* renamed from: m  reason: collision with root package name */
    private ConnectivityManager f34091m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public i f34092n;

    /* renamed from: o  reason: collision with root package name */
    private SubscriptionManager.OnSubscriptionsChangedListener f34093o;

    /* renamed from: p  reason: collision with root package name */
    private q1 f34094p;

    /* renamed from: q  reason: collision with root package name */
    private j f34095q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public List<CellInfo> f34096r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Method f34097s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Method f34098t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Method f34099u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public Method f34100v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Method f34101w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Method f34102x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public Method f34103y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public Method f34104z;

    public class a extends SubscriptionManager.OnSubscriptionsChangedListener {
        public a() {
        }

        public void onSubscriptionsChanged() {
            super.onSubscriptionsChanged();
            if (!a1.this.X) {
                new h().executeOnExecutor(ThreadManager.b().c(), new Void[0]);
            }
        }
    }

    public class b implements Callable<com.startapp.networkTest.data.radio.CellInfo[]> {
        public b() {
        }

        /* renamed from: a */
        public com.startapp.networkTest.data.radio.CellInfo[] call() {
            try {
                return a1.this.c();
            } catch (Throwable th) {
                l2.a(th);
                return new com.startapp.networkTest.data.radio.CellInfo[0];
            }
        }
    }

    public class c implements Callable<ApnInfo[]> {
        public c() {
        }

        /* renamed from: a */
        public ApnInfo[] call() throws Exception {
            try {
                return a1.this.a();
            } catch (Throwable th) {
                l2.a(th);
                return new ApnInfo[0];
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c1 f34108a;

        public d(c1 c1Var) {
            this.f34108a = c1Var;
        }

        public void run() {
            a1.this.a(this.f34108a);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c1 f34110a;

        public e(c1 c1Var) {
            this.f34110a = c1Var;
        }

        public void run() {
            a1.this.b(this.f34110a);
        }
    }

    public class h extends AsyncTask<Void, Void, Void> {
        public h() {
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            a1.this.z();
            return null;
        }

        public void onPreExecute() {
            boolean unused = a1.this.X = true;
            a1.this.d(false);
            int[] unused2 = a1.this.V = new int[0];
        }

        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            a1 a1Var = a1.this;
            a1Var.a(a1Var.V);
            if (Build.VERSION.SDK_INT >= 29) {
                a1.this.w();
            }
            a1.this.b(false);
            boolean unused = a1.this.X = false;
        }
    }

    public class i {

        /* renamed from: a  reason: collision with root package name */
        private SparseArray<n> f34128a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<m> f34129b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private SparseArray<g> f34130c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        private HashMap<String, k> f34131d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        private SparseArray<NetworkRegistrationInfo[]> f34132e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<l> f34133f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        private Map<String, String> f34134g = new HashMap();

        public i() {
        }

        public void a(int i2, n nVar) {
            this.f34128a.put(i2, nVar);
        }

        public NetworkRegistrationInfo[] b(int i2) {
            return this.f34132e.get(i2);
        }

        public l c(int i2) {
            return this.f34133f.get(i2);
        }

        public m d(int i2) {
            m mVar = this.f34129b.get(i2);
            if (mVar == null) {
                return new m(a1.this, (a) null);
            }
            return mVar;
        }

        public n e(int i2) {
            n nVar = this.f34128a.get(i2);
            if (nVar == null) {
                return new n(a1.this, (a) null);
            }
            return nVar;
        }

        public void a(int i2, m mVar) {
            this.f34129b.put(i2, mVar);
        }

        public void a(int i2, g gVar) {
            this.f34130c.put(i2, gVar);
        }

        public void a(int i2, NetworkRegistrationInfo[] networkRegistrationInfoArr) {
            this.f34132e.put(i2, networkRegistrationInfoArr);
        }

        public void a(String str, k kVar) {
            this.f34131d.put(str, kVar);
        }

        public void a(int i2, String str, String str2) {
            Map<String, String> map = this.f34134g;
            map.put(i2 + str, str2);
        }

        public void a(int i2, l lVar) {
            this.f34133f.put(i2, lVar);
        }

        public g a(int i2) {
            return this.f34130c.get(i2);
        }

        public k a(String str) {
            return this.f34131d.get(str);
        }

        public String a(int i2, String str) {
            Map<String, String> map = this.f34134g;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(str != null ? str.split(",")[0] : "");
            String str2 = map.get(sb.toString());
            return str2 == null ? "" : str2;
        }
    }

    public a1(Context context) {
        this.f34088j = context;
        this.f34086h = (TelephonyManager) context.getSystemService("phone");
        this.f34091m = (ConnectivityManager) context.getSystemService("connectivity");
        z();
        a(this.V);
        if (Build.VERSION.SDK_INT >= 29) {
            w();
        }
        this.f34085g = new Handler(Looper.getMainLooper());
        this.W = new CopyOnWriteArrayList();
        this.f34094p = new q1();
        this.f34092n = new i();
        this.U = this.f34088j.getContentResolver();
        s();
        t();
        u();
        r();
        v();
    }

    private static int b(int i2) {
        if (i2 == 99 || i2 < -5 || i2 > 91) {
            return 0;
        }
        return i2 - 116;
    }

    /* access modifiers changed from: private */
    public static int c(int i2) {
        if (i2 == 99 || i2 < 0 || i2 > 31) {
            return 0;
        }
        return (i2 * 2) - 113;
    }

    /* access modifiers changed from: private */
    public void z() {
        q1 f2 = z0.f(this.f34088j);
        this.f34094p = f2;
        ArrayList<r1> arrayList = f2.SimInfos;
        r1[] r1VarArr = (r1[]) arrayList.toArray(new r1[arrayList.size()]);
        int[] iArr = new int[r1VarArr.length];
        for (int i2 = 0; i2 < r1VarArr.length; i2++) {
            iArr[i2] = r1VarArr[i2].SubscriptionId;
        }
        this.V = iArr;
    }

    public void x() {
        try {
            c(true);
            b(this.f34088j);
        } catch (Throwable th) {
            l2.a(th);
        }
    }

    public void y() {
        try {
            d(true);
            c(this.f34088j);
        } catch (Throwable th) {
            l2.a(th);
        }
    }

    public class g {

        /* renamed from: a  reason: collision with root package name */
        public CellLocation f34124a;

        /* renamed from: b  reason: collision with root package name */
        public long f34125b;

        private g() {
            this.f34125b = 0;
        }

        public /* synthetic */ g(a1 a1Var, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        SubscriptionManager subscriptionManager;
        if (z2 && this.f34093o != null && this.f34088j.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.f34088j.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.removeOnSubscriptionsChangedListener(this.f34093o);
        }
        TelephonyManager telephonyManager = this.f34086h;
        if (telephonyManager != null) {
            o oVar = this.f34089k;
            if (oVar != null) {
                telephonyManager.listen(oVar, 0);
            }
            Iterator<o> it2 = this.f34090l.iterator();
            while (it2.hasNext()) {
                o next = it2.next();
                SparseArray<TelephonyManager> sparseArray = this.f34087i;
                TelephonyManager telephonyManager2 = (sparseArray == null || sparseArray.size() <= 0) ? null : this.f34087i.get(next.a());
                if (telephonyManager2 == null) {
                    telephonyManager2 = this.f34086h;
                }
                telephonyManager2.listen(next, 0);
            }
        }
    }

    @TargetApi(18)
    private void e(CellInfo cellInfo, com.startapp.networkTest.data.radio.CellInfo cellInfo2, long j2) {
        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
        cellInfo2.IsRegistered = cellInfoWcdma.isRegistered();
        cellInfo2.CellNetworkType = CellNetworkTypes.Wcdma;
        cellInfo2.CellInfoAge = j2 - (cellInfoWcdma.getTimeStamp() / 1000000);
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            cellInfo2.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            cellInfo2.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            int cid = cellIdentity.getCid();
            cellInfo2.Cid = cid;
            cellInfo2.CellId = (long) cid;
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            cellInfo2.Lac = cellIdentity.getLac();
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            cellInfo2.Psc = cellIdentity.getPsc();
        }
        if (Build.VERSION.SDK_INT >= 24 && cellIdentity.getUarfcn() != Integer.MAX_VALUE) {
            cellInfo2.Arfcn = cellIdentity.getUarfcn();
        }
        cellInfo2.Dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
    }

    private boolean k(int i2) {
        return this.f34094p.getSimInfoSubId(i2).SubscriptionId != -1;
    }

    @TargetApi(17)
    private boolean m() {
        return Settings.Global.getInt(this.U, "airplane_mode_on", 0) != 0;
    }

    private List<f> q() {
        Network[] allNetworks;
        ArrayList arrayList = new ArrayList();
        if (this.f34091m != null && this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (allNetworks = this.f34091m.getAllNetworks()) != null && allNetworks.length > 0) {
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = this.f34091m.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                    f fVar = new f(this, (a) null);
                    NetworkInfo networkInfo = this.f34091m.getNetworkInfo(network);
                    LinkProperties linkProperties = this.f34091m.getLinkProperties(network);
                    ArrayList arrayList2 = new ArrayList();
                    if (networkCapabilities.hasCapability(4)) {
                        arrayList2.add("ims");
                    }
                    if (networkCapabilities.hasCapability(1)) {
                        arrayList2.add("supl");
                    }
                    if (networkCapabilities.hasCapability(9)) {
                        arrayList2.add("xcap");
                    }
                    if (networkCapabilities.hasCapability(2)) {
                        arrayList2.add("dun");
                    }
                    if (networkCapabilities.hasCapability(5)) {
                        arrayList2.add("cbs");
                    }
                    if (networkCapabilities.hasCapability(3)) {
                        arrayList2.add("fota");
                    }
                    if (networkCapabilities.hasCapability(10)) {
                        arrayList2.add(MediaTrack.ROLE_EMERGENCY);
                    }
                    if (networkCapabilities.hasCapability(7)) {
                        arrayList2.add("ia");
                    }
                    if (networkCapabilities.hasCapability(0)) {
                        arrayList2.add("mms");
                    }
                    if (networkCapabilities.hasCapability(8)) {
                        arrayList2.add("rcs");
                    }
                    if (networkCapabilities.hasCapability(23)) {
                        arrayList2.add("mcx");
                    }
                    fVar.f34115d = TextUtils.join(",", arrayList2);
                    if (networkInfo != null) {
                        fVar.f34113b = networkInfo.getExtraInfo();
                        fVar.f34112a = networkInfo.getSubtype();
                        fVar.f34122k = WifiDetailedStates.a(networkInfo.getDetailedState());
                    }
                    if (linkProperties != null) {
                        fVar.f34116e = s2.a(networkCapabilities);
                        fVar.f34118g = s2.b(networkCapabilities);
                        fVar.f34117f = s2.a(linkProperties);
                        String interfaceName = linkProperties.getInterfaceName();
                        if (interfaceName != null) {
                            try {
                                fVar.f34119h = g3.b(interfaceName);
                                fVar.f34120i = g3.a(interfaceName);
                            } catch (Throwable th) {
                                l2.a(th);
                            }
                            fVar.f34121j = interfaceName;
                        }
                    }
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    @TargetApi(17)
    private void r() {
        Class<CellSignalStrengthLte> cls = CellSignalStrengthLte.class;
        try {
            Field declaredField = cls.getDeclaredField("mSignalStrength");
            this.J = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            l2.b(e2);
        }
        try {
            Field declaredField2 = cls.getDeclaredField("mRsrq");
            this.K = declaredField2;
            declaredField2.setAccessible(true);
        } catch (NoSuchFieldException e3) {
            l2.b(e3);
        }
        try {
            Field declaredField3 = cls.getDeclaredField("mRssnr");
            this.L = declaredField3;
            declaredField3.setAccessible(true);
        } catch (NoSuchFieldException e4) {
            l2.b(e4);
        }
        try {
            Field declaredField4 = cls.getDeclaredField("mCqi");
            this.M = declaredField4;
            declaredField4.setAccessible(true);
        } catch (NoSuchFieldException e5) {
            l2.b(e5);
        }
    }

    private void s() {
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                Field declaredField = ServiceState.class.getDeclaredField("mIsUsingCarrierAggregation");
                this.I = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                l2.b(th);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                this.H = SignalStrength.class.getDeclaredMethod("isUsingCarrierAggregation", new Class[0]);
            } catch (Throwable th2) {
                l2.b(th2);
            }
        }
    }

    @TargetApi(18)
    private void t() {
        Class<SignalStrength> cls = SignalStrength.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                this.f34098t = cls.getDeclaredMethod("getLteSignalStrength", new Class[0]);
            } catch (Throwable th) {
                l2.b(th);
            }
            try {
                this.f34101w = cls.getDeclaredMethod("getLteCqi", new Class[0]);
            } catch (Throwable th2) {
                l2.b(th2);
            }
            try {
                this.f34102x = cls.getDeclaredMethod("getLteRsrp", new Class[0]);
            } catch (Throwable th3) {
                l2.b(th3);
            }
            try {
                this.f34103y = cls.getDeclaredMethod("getLteRsrq", new Class[0]);
            } catch (Throwable th4) {
                l2.b(th4);
            }
            try {
                this.f34104z = cls.getDeclaredMethod("getLteRssnr", new Class[0]);
            } catch (Throwable th5) {
                l2.b(th5);
            }
            try {
                this.f34099u = cls.getDeclaredMethod("getLteDbm", new Class[0]);
            } catch (Throwable th6) {
                l2.b(th6);
            }
            try {
                this.f34097s = cls.getDeclaredMethod("getDbm", new Class[0]);
            } catch (Throwable th7) {
                l2.b(th7);
            }
        }
        try {
            this.f34100v = cls.getDeclaredMethod("getGsmEcno", new Class[0]);
        } catch (Throwable th8) {
            l2.b(th8);
        }
        try {
            Field declaredField = cls.getDeclaredField("mWcdmaRscp");
            this.C = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th9) {
            l2.b(th9);
        }
        try {
            Field declaredField2 = cls.getDeclaredField("mWcdmaEcio");
            this.D = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Throwable th10) {
            l2.b(th10);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Field declaredField3 = cls.getDeclaredField("mNrRsrp");
                this.E = declaredField3;
                declaredField3.setAccessible(true);
            } catch (Throwable th11) {
                l2.b(th11);
            }
            try {
                Field declaredField4 = cls.getDeclaredField("mNrRsrq");
                this.F = declaredField4;
                declaredField4.setAccessible(true);
            } catch (Throwable th12) {
                l2.b(th12);
            }
            try {
                Field declaredField5 = cls.getDeclaredField("mNrRssnr");
                this.G = declaredField5;
                declaredField5.setAccessible(true);
            } catch (Throwable th13) {
                l2.b(th13);
            }
        }
    }

    private void u() {
        try {
            this.N = this.f34086h.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
        } catch (Throwable th) {
            l2.b(th);
        }
        try {
            this.O = this.f34086h.getClass().getDeclaredMethod("getDataEnabled", new Class[]{Integer.TYPE});
        } catch (Throwable th2) {
            l2.b(th2);
        }
        try {
            Class<?> cls = this.f34086h.getClass();
            this.P = cls.getDeclaredMethod("isNetworkRoaming", new Class[]{Integer.TYPE});
        } catch (Throwable th3) {
            l2.b(th3);
        }
        try {
            Class<?> cls2 = this.f34086h.getClass();
            this.Q = cls2.getDeclaredMethod("getNetworkType", new Class[]{Integer.TYPE});
        } catch (Throwable th4) {
            l2.b(th4);
        }
        try {
            Class<?> cls3 = this.f34086h.getClass();
            this.R = cls3.getDeclaredMethod("getNetworkOperatorName", new Class[]{Integer.TYPE});
        } catch (Throwable th5) {
            l2.b(th5);
        }
        try {
            Class<?> cls4 = this.f34086h.getClass();
            this.S = cls4.getDeclaredMethod("getNetworkOperator", new Class[]{Integer.TYPE});
        } catch (Throwable th6) {
            l2.b(th6);
        }
        try {
            Class<?> cls5 = this.f34086h.getClass();
            this.T = cls5.getDeclaredMethod("getNetworkOperatorForSubscription", new Class[]{Integer.TYPE});
        } catch (Throwable th7) {
            l2.b(th7);
        }
        try {
            Method declaredMethod = this.f34086h.getClass().getDeclaredMethod("getVoiceNetworkType", (Class[]) null);
            if (!Modifier.isAbstract(declaredMethod.getModifiers())) {
                this.A = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (Throwable th8) {
            l2.b(th8);
        }
        try {
            Method declaredMethod2 = this.f34086h.getClass().getDeclaredMethod("getVoiceNetworkType", new Class[]{Integer.TYPE});
            if (!Modifier.isAbstract(declaredMethod2.getModifiers())) {
                this.B = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
        } catch (Throwable th9) {
            l2.b(th9);
        }
    }

    @TargetApi(22)
    private void v() {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f34093o = new a();
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(24)
    public void w() {
        this.f34087i = new SparseArray<>();
        int i2 = 0;
        while (true) {
            int[] iArr = this.V;
            if (i2 < iArr.length) {
                SparseArray<TelephonyManager> sparseArray = this.f34087i;
                int i3 = iArr[i2];
                sparseArray.put(i3, this.f34086h.createForSubscriptionId(i3));
                i2++;
            } else {
                return;
            }
        }
    }

    public Future<com.startapp.networkTest.data.radio.CellInfo[]> f() {
        return ThreadManager.b().a().submit(new b());
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x038e  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.networkTest.data.RadioInfo g() {
        /*
            r16 = this;
            r1 = r16
            com.startapp.networkTest.data.RadioInfo r2 = new com.startapp.networkTest.data.RadioInfo
            r2.<init>()
            android.telephony.TelephonyManager r0 = r1.f34086h
            if (r0 == 0) goto L_0x0391
            android.content.Context r0 = r1.f34088j
            android.util.SparseArray r0 = r1.a((android.content.Context) r0)
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.startapp.networkTest.enums.PreferredNetworkTypes r0 = (com.startapp.networkTest.enums.PreferredNetworkTypes) r0
            if (r0 == 0) goto L_0x001c
            r2.PreferredNetwork = r0
        L_0x001c:
            r4 = 3
            r5 = 1
            android.telephony.TelephonyManager r0 = r1.f34086h     // Catch:{ all -> 0x0046 }
            int r0 = r0.getDataState()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0041
            if (r0 == r5) goto L_0x003c
            r6 = 2
            if (r0 == r6) goto L_0x0037
            if (r0 == r4) goto L_0x0032
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Unknown     // Catch:{ all -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0032:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Suspended     // Catch:{ all -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0037:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Connected     // Catch:{ all -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x003c:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Connecting     // Catch:{ all -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0041:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Disconnected     // Catch:{ all -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x004a:
            boolean r0 = r16.m()
            if (r0 == 0) goto L_0x0053
            com.startapp.networkTest.enums.FlightModeStates r0 = com.startapp.networkTest.enums.FlightModeStates.Enabled
            goto L_0x0055
        L_0x0053:
            com.startapp.networkTest.enums.FlightModeStates r0 = com.startapp.networkTest.enums.FlightModeStates.Disabled
        L_0x0055:
            r2.FlightMode = r0
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Unknown
            r2.MobileDataEnabled = r0
            java.lang.reflect.Method r0 = r1.N
            if (r0 == 0) goto L_0x007c
            android.telephony.TelephonyManager r6 = r1.f34086h     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x0077 }
            java.lang.Object r0 = r0.invoke(r6, r7)     // Catch:{ all -> 0x0077 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0077 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x0072
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Enabled     // Catch:{ all -> 0x0077 }
            goto L_0x0074
        L_0x0072:
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Disabled     // Catch:{ all -> 0x0077 }
        L_0x0074:
            r2.MobileDataEnabled = r0     // Catch:{ all -> 0x0077 }
            goto L_0x0092
        L_0x0077:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
            goto L_0x0092
        L_0x007c:
            android.content.ContentResolver r0 = r1.U     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "mobile_data"
            int r0 = android.provider.Settings.Global.getInt(r0, r6)     // Catch:{ all -> 0x008e }
            if (r0 != r5) goto L_0x0089
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Enabled     // Catch:{ all -> 0x008e }
            goto L_0x008b
        L_0x0089:
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Disabled     // Catch:{ all -> 0x008e }
        L_0x008b:
            r2.MobileDataEnabled = r0     // Catch:{ all -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x0092:
            android.telephony.TelephonyManager r0 = r1.f34086h
            boolean r0 = r0.isNetworkRoaming()
            r2.IsRoaming = r0
            com.startapp.networkTest.enums.ThreeStateShort r0 = r16.o()
            r2.IsMetered = r0
            com.startapp.networkTest.enums.ThreeStateShort r0 = r16.n()
            int r0 = com.startapp.v2.a((com.startapp.networkTest.enums.ThreeStateShort) r0)
            r2.IsVpn = r0
            com.startapp.networkTest.enums.ConnectionTypes r0 = r16.d()
            r2.ConnectionType = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 30
            if (r0 < r6) goto L_0x00be
            android.content.Context r0 = r1.f34088j
            boolean r0 = com.startapp.b3.b(r0)
            if (r0 == 0) goto L_0x00cf
        L_0x00be:
            android.telephony.TelephonyManager r0 = r1.f34086h     // Catch:{ SecurityException -> 0x00cb }
            int r0 = r0.getNetworkType()     // Catch:{ SecurityException -> 0x00cb }
            com.startapp.networkTest.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ SecurityException -> 0x00cb }
            r2.NetworkType = r0     // Catch:{ SecurityException -> 0x00cb }
            goto L_0x00cf
        L_0x00cb:
            r0 = move-exception
            com.startapp.l2.b(r0)
        L_0x00cf:
            android.telephony.TelephonyManager r0 = r1.f34086h
            java.lang.String r0 = r0.getNetworkOperatorName()
            java.lang.String r0 = com.startapp.f3.a((java.lang.String) r0)
            r2.OperatorName = r0
            android.telephony.TelephonyManager r0 = r1.f34086h
            java.lang.String r0 = r0.getNetworkOperator()
            if (r0 == 0) goto L_0x00f6
            int r6 = r0.length()
            r7 = 4
            if (r6 <= r7) goto L_0x00f6
            java.lang.String r6 = r0.substring(r3, r4)
            r2.MCC = r6
            java.lang.String r0 = r0.substring(r4)
            r2.MNC = r0
        L_0x00f6:
            r0 = -1
            com.startapp.networkTest.data.radio.NetworkRegistrationInfo[] r4 = r1.g((int) r0)
            com.startapp.a1$i r6 = r1.f34092n
            com.startapp.a1$g r6 = r6.a((int) r0)
            if (r6 != 0) goto L_0x0109
            com.startapp.a1$g r6 = new com.startapp.a1$g
            r7 = 0
            r6.<init>(r1, r7)
        L_0x0109:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 29
            if (r7 >= r8) goto L_0x0119
            android.content.Context r7 = r1.f34088j
            java.lang.String r8 = "android.permission.ACCESS_COARSE_LOCATION"
            int r7 = r7.checkCallingOrSelfPermission(r8)
            if (r7 == 0) goto L_0x012d
        L_0x0119:
            android.content.Context r7 = r1.f34088j
            java.lang.String r8 = "android.permission.ACCESS_FINE_LOCATION"
            int r7 = r7.checkCallingOrSelfPermission(r8)
            if (r7 != 0) goto L_0x013a
            android.content.Context r7 = r1.f34088j
            java.lang.String r8 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r7 = r7.checkCallingOrSelfPermission(r8)
            if (r7 != 0) goto L_0x013a
        L_0x012d:
            android.telephony.CellLocation r5 = r6.f34124a
            if (r5 != 0) goto L_0x013c
            android.telephony.TelephonyManager r5 = r1.f34086h
            android.telephony.CellLocation r5 = r5.getCellLocation()
            r6.f34124a = r5
            goto L_0x013c
        L_0x013a:
            r2.MissingPermission = r5
        L_0x013c:
            android.telephony.CellLocation r5 = r6.f34124a
            r7 = 0
            r9 = 2147483647(0x7fffffff, float:NaN)
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            java.lang.String r12 = ""
            if (r5 == 0) goto L_0x022e
            java.lang.Class r5 = r5.getClass()
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r13 = android.telephony.gsm.GsmCellLocation.class
            boolean r5 = r5.equals(r13)
            if (r5 == 0) goto L_0x019a
            android.telephony.CellLocation r5 = r6.f34124a
            android.telephony.gsm.GsmCellLocation r5 = (android.telephony.gsm.GsmCellLocation) r5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getLac()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.GsmLAC = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getCid()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.GsmCellId = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r5 = r5.getPsc()
            r13.append(r5)
            r13.append(r12)
            java.lang.String r5 = r13.toString()
            r2.PrimaryScramblingCode = r5
            goto L_0x0215
        L_0x019a:
            android.telephony.CellLocation r5 = r6.f34124a
            java.lang.Class r5 = r5.getClass()
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r13 = android.telephony.cdma.CdmaCellLocation.class
            boolean r5 = r5.equals(r13)
            if (r5 == 0) goto L_0x0215
            android.telephony.CellLocation r5 = r6.f34124a
            android.telephony.cdma.CdmaCellLocation r5 = (android.telephony.cdma.CdmaCellLocation) r5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getBaseStationId()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.CdmaBaseStationId = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getBaseStationLatitude()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.CdmaBaseStationLatitude = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getBaseStationLongitude()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.CdmaBaseStationLongitude = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r14 = r5.getNetworkId()
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r2.CdmaNetworkId = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            int r5 = r5.getSystemId()
            r13.append(r5)
            r13.append(r12)
            java.lang.String r5 = r13.toString()
            r2.CdmaSystemId = r5
        L_0x0215:
            long r13 = r6.f34125b
            int r5 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0255
            long r13 = android.os.SystemClock.elapsedRealtime()
            long r5 = r6.f34125b
            long r13 = r13 - r5
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x022a
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x022b
        L_0x022a:
            int r5 = (int) r13
        L_0x022b:
            r2.GsmCellIdAge = r5
            goto L_0x0255
        L_0x022e:
            if (r4 == 0) goto L_0x0255
            int r5 = r4.length
            r6 = 0
        L_0x0232:
            if (r6 >= r5) goto L_0x0255
            r13 = r4[r6]
            java.lang.String r14 = r13.Domain
            java.lang.String r15 = "CS"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0252
            java.lang.String r14 = r13.CellId
            r2.GsmCellId = r14
            java.lang.String r15 = r13.Tac
            r2.GsmLAC = r15
            boolean r14 = r14.isEmpty()
            if (r14 != 0) goto L_0x0252
            int r13 = r13.Age
            r2.GsmCellIdAge = r13
        L_0x0252:
            int r6 = r6 + 1
            goto L_0x0232
        L_0x0255:
            com.startapp.a1$i r5 = r1.f34092n
            com.startapp.a1$m r5 = r5.d(r0)
            com.startapp.networkTest.enums.ServiceStates r6 = r5.f34147a
            r2.ServiceState = r6
            com.startapp.networkTest.enums.DuplexMode r6 = r5.f34149c
            r2.DuplexMode = r6
            com.startapp.networkTest.enums.ThreeStateShort r6 = r5.f34150d
            r2.ManualSelection = r6
            com.startapp.networkTest.enums.ThreeStateShort r6 = r5.f34152f
            r2.CarrierAggregation = r6
            int r6 = r5.f34151e
            r2.ARFCN = r6
            long r13 = r5.f34148b
            int r6 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0287
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r13 = r5.f34148b
            long r6 = r6 - r13
            int r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0284
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0285
        L_0x0284:
            int r5 = (int) r6
        L_0x0285:
            r2.ServiceStateAge = r5
        L_0x0287:
            java.lang.String r5 = r1.c((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r4)
            r2.NrState = r5
            com.startapp.networkTest.enums.ThreeStateShort r5 = r1.d((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r4)
            r2.NrAvailable = r5
            com.startapp.networkTest.enums.NetworkTypes r5 = r2.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r6 = com.startapp.networkTest.enums.NetworkTypes.Unknown
            if (r5 != r6) goto L_0x029f
            com.startapp.networkTest.enums.NetworkTypes r5 = r1.b((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r4)
            r2.NetworkType = r5
        L_0x029f:
            com.startapp.a1$i r5 = r1.f34092n
            com.startapp.a1$n r5 = r5.e(r0)
            int r6 = r5.f34163j
            r2.RSCP = r6
            int r6 = r5.f34156c
            r2.CdmaEcIo = r6
            int r6 = r5.f34154a
            r2.RXLevel = r6
            int r7 = r5.f34155b
            r2.NativeDbm = r7
            int r7 = r5.f34162i
            r2.EcN0 = r7
            int r7 = r5.f34157d
            r2.LteCqi = r7
            int r7 = r5.f34158e
            r2.LteRsrp = r7
            int r8 = r5.f34160g
            r2.LteRsrq = r8
            int r8 = r5.f34159f
            r2.LteRssnr = r8
            int r8 = r5.f34161h
            r2.LteRssi = r8
            int r8 = r5.f34165l
            r2.NrCsiRsrp = r8
            int r8 = r5.f34166m
            r2.NrCsiRsrq = r8
            int r8 = r5.f34167n
            r2.NrCsiSinr = r8
            int r8 = r5.f34168o
            r2.NrSsRsrp = r8
            int r8 = r5.f34169p
            r2.NrSsRsrq = r8
            int r8 = r5.f34170q
            r2.NrSsSinr = r8
            com.startapp.networkTest.enums.NetworkTypes r8 = r2.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r13 = com.startapp.networkTest.enums.NetworkTypes.LTE
            if (r8 == r13) goto L_0x02ef
            com.startapp.networkTest.enums.NetworkTypes r13 = com.startapp.networkTest.enums.NetworkTypes.LTE_CA
            if (r8 != r13) goto L_0x02f3
        L_0x02ef:
            if (r6 <= r0) goto L_0x02f3
            r2.RXLevel = r7
        L_0x02f3:
            com.startapp.networkTest.enums.NetworkTypes r0 = com.startapp.networkTest.enums.NetworkTypes.LTE_CA
            if (r8 != r0) goto L_0x02fb
            com.startapp.networkTest.enums.ThreeStateShort r0 = com.startapp.networkTest.enums.ThreeStateShort.Yes
            r2.CarrierAggregation = r0
        L_0x02fb:
            com.startapp.networkTest.enums.ThreeStateShort r0 = r2.CarrierAggregation
            com.startapp.networkTest.enums.ThreeStateShort r6 = com.startapp.networkTest.enums.ThreeStateShort.Unknown
            if (r0 != r6) goto L_0x0307
            com.startapp.networkTest.enums.ThreeStateShort r0 = r1.a((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r4)
            r2.CarrierAggregation = r0
        L_0x0307:
            com.startapp.networkTest.enums.NetworkTypes r0 = r2.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r4 = com.startapp.networkTest.enums.NetworkTypes.NR
            if (r0 != r4) goto L_0x0382
            java.lang.String r0 = r2.MCC     // Catch:{ NumberFormatException -> 0x031c }
            int r4 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x031c }
            java.lang.String r0 = r2.MNC     // Catch:{ NumberFormatException -> 0x031a }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x031a }
            goto L_0x0321
        L_0x031a:
            r0 = move-exception
            goto L_0x031e
        L_0x031c:
            r0 = move-exception
            r4 = 0
        L_0x031e:
            com.startapp.l2.b(r0)
        L_0x0321:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.startapp.a1$i r3 = r1.f34092n
            com.startapp.a1$k r0 = r3.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x0382
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r6 = r0.f34139a
            r3.append(r6)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r2.GsmCellId = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r0.f34140b
            r3.append(r4)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r2.GsmLAC = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r0.f34141c
            r3.append(r4)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r2.PrimaryScramblingCode = r3
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r6 = r0.f34142d
            r12 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 / r12
            long r3 = r3 - r6
            int r0 = (int) r3
            r2.GsmCellIdAge = r0
        L_0x0382:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r5.f34164k
            long r3 = r3 - r5
            int r0 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x038e
            goto L_0x038f
        L_0x038e:
            int r9 = (int) r3
        L_0x038f:
            r2.RXLevelAge = r9
        L_0x0391:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.a1.g():com.startapp.networkTest.data.RadioInfo");
    }

    public RadioInfo h() {
        try {
            return h(this.f34094p.DefaultDataSimId);
        } catch (Throwable th) {
            l2.a(th);
            return new RadioInfo();
        }
    }

    public RadioInfo i() {
        try {
            return h(this.f34094p.DefaultSmsSimId);
        } catch (Throwable th) {
            l2.a(th);
            return new RadioInfo();
        }
    }

    public RadioInfo j() {
        try {
            return h(this.f34094p.DefaultVoiceSimId);
        } catch (Throwable th) {
            l2.a(th);
            return new RadioInfo();
        }
    }

    public boolean l() {
        NetworkInfo activeNetworkInfo;
        if (this.f34091m == null || this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (activeNetworkInfo = this.f34091m.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public ThreeStateShort n() {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        ThreeStateShort threeStateShort = ThreeStateShort.Unknown;
        if (Build.VERSION.SDK_INT < 23 || this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = this.f34091m) == null || (networkCapabilities = this.f34091m.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
            return threeStateShort;
        }
        return networkCapabilities.hasTransport(4) ? ThreeStateShort.Yes : ThreeStateShort.No;
    }

    public ThreeStateShort o() {
        if (this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return this.f34091m.isActiveNetworkMetered() ? ThreeStateShort.Yes : ThreeStateShort.No;
        }
        return ThreeStateShort.Unknown;
    }

    public boolean p() {
        return this.f34086h.isNetworkRoaming();
    }

    public class j extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f34136a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34137b;

        private j() {
            this.f34136a = "android.intent.action.ANY_DATA_STATE";
            this.f34137b = "com.samsung.ims.action.IMS_REGISTRATION";
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                try {
                    String action = intent.getAction();
                    Bundle extras = intent.getExtras();
                    int i2 = -1;
                    if (action.equalsIgnoreCase("android.intent.action.ANY_DATA_STATE") && extras != null) {
                        String string = extras.getString("reason", "");
                        String string2 = extras.getString("apnType", "");
                        if (extras.get("subscription") instanceof Integer) {
                            i2 = extras.getInt("subscription", -1);
                        } else if (extras.get("subscription") instanceof Long) {
                            i2 = (int) extras.getLong("subscription", -1);
                        }
                        if (string2.equalsIgnoreCase(Constants.COLLATION_DEFAULT)) {
                            string2 = "supl";
                        }
                        a1.this.f34092n.a(i2, string2, string);
                    } else if (action.equalsIgnoreCase("com.samsung.ims.action.IMS_REGISTRATION") && extras != null) {
                        String string3 = extras.getString("SERVICE");
                        int i3 = extras.getInt("PHONE_ID", -1);
                        int i4 = extras.getInt("SIP_ERROR", -1);
                        extras.getBoolean("VOWIFI", false);
                        extras.getBoolean("REGISTERED", false);
                        l lVar = new l(a1.this, (a) null);
                        lVar.f34144a = i4;
                        if (string3 != null) {
                            lVar.f34145b = string3.replaceAll("\\[", "").replaceAll("\\]", "").replace(", ", ",");
                        }
                        Iterator<r1> it2 = z0.f(a1.this.f34088j).SimInfos.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            r1 next = it2.next();
                            if (next.SimSlotIndex == i3) {
                                i2 = next.SubscriptionId;
                                break;
                            }
                        }
                        a1.this.f34092n.a(i2, lVar);
                    }
                } catch (Throwable th) {
                    l2.a(th);
                }
            }
        }

        public /* synthetic */ j(a1 a1Var, a aVar) {
            this();
        }
    }

    public class l {

        /* renamed from: a  reason: collision with root package name */
        public int f34144a;

        /* renamed from: b  reason: collision with root package name */
        public String f34145b;

        private l() {
            this.f34144a = -1;
            this.f34145b = "";
        }

        public /* synthetic */ l(a1 a1Var, a aVar) {
            this();
        }
    }

    public class o extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        private Field f34172a;

        /* renamed from: b  reason: collision with root package name */
        private int f34173b;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ServiceState f34175a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f34176b;

            public a(ServiceState serviceState, int i2) {
                this.f34175a = serviceState;
                this.f34176b = i2;
            }

            public void run() {
                for (c1 a2 : a1.this.W) {
                    a2.a(this.f34175a, this.f34176b);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CellLocation f34178a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f34179b;

            public b(CellLocation cellLocation, int i2) {
                this.f34178a = cellLocation;
                this.f34179b = i2;
            }

            public void run() {
                for (c1 a2 : a1.this.W) {
                    a2.a(this.f34178a, this.f34179b);
                }
            }
        }

        public o() {
            this.f34173b = -1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a() {
            /*
                r4 = this;
                java.lang.reflect.Field r0 = r4.f34172a
                r1 = -1
                if (r0 == 0) goto L_0x0014
                java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0010 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0010 }
                int r0 = r0.intValue()     // Catch:{ all -> 0x0010 }
                goto L_0x0015
            L_0x0010:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0014:
                r0 = -1
            L_0x0015:
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 29
                if (r2 < r3) goto L_0x0024
                if (r0 == r1) goto L_0x0022
                r1 = 2147483647(0x7fffffff, float:NaN)
                if (r0 != r1) goto L_0x0024
            L_0x0022:
                int r0 = r4.f34173b
            L_0x0024:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.a1.o.a():int");
        }

        public void onCellInfoChanged(List<CellInfo> list) {
            a(list);
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            a(cellLocation, a());
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            a(serviceState, a());
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            a(signalStrength, a());
        }

        public o(int i2) {
            this.f34173b = i2;
            try {
                Field declaredField = getClass().getSuperclass().getDeclaredField("mSubId");
                this.f34172a = declaredField;
                declaredField.setAccessible(true);
                this.f34172a.set(this, Integer.valueOf(i2));
            } catch (Throwable th) {
                l2.b(th);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(java.util.List<android.telephony.CellInfo> r10) {
            /*
                r9 = this;
                if (r10 != 0) goto L_0x0003
                return
            L_0x0003:
                com.startapp.a1 r0 = com.startapp.a1.this
                java.util.List unused = r0.f34096r = r10
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto L_0x009f
                java.util.Iterator r10 = r10.iterator()
            L_0x0012:
                boolean r0 = r10.hasNext()
                if (r0 == 0) goto L_0x009f
                java.lang.Object r0 = r10.next()
                android.telephony.CellInfo r0 = (android.telephony.CellInfo) r0
                boolean r1 = r0.isRegistered()
                if (r1 == 0) goto L_0x0012
                boolean r1 = r0 instanceof android.telephony.CellInfoNr
                if (r1 == 0) goto L_0x0012
                android.telephony.CellInfoNr r0 = (android.telephony.CellInfoNr) r0
                android.telephony.CellIdentity r1 = r0.getCellIdentity()
                boolean r2 = r1 instanceof android.telephony.CellIdentityNr
                if (r2 == 0) goto L_0x0012
                android.telephony.CellIdentityNr r1 = (android.telephony.CellIdentityNr) r1
                r2 = 0
                java.lang.String r3 = r1.getMccString()     // Catch:{ NumberFormatException -> 0x0048 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0048 }
                java.lang.String r4 = r1.getMncString()     // Catch:{ NumberFormatException -> 0x0046 }
                int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0046 }
                goto L_0x004d
            L_0x0046:
                r4 = move-exception
                goto L_0x004a
            L_0x0048:
                r4 = move-exception
                r3 = 0
            L_0x004a:
                com.startapp.l2.b(r4)
            L_0x004d:
                long r4 = r1.getNci()
                int r6 = r1.getTac()
                int r1 = r1.getPci()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = ""
                r7.append(r8)
                r7.append(r3)
                r7.append(r2)
                java.lang.String r2 = r7.toString()
                r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r3 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r3 != 0) goto L_0x0076
                r4 = -1
            L_0x0076:
                r3 = -1
                r7 = 2147483647(0x7fffffff, float:NaN)
                if (r6 != r7) goto L_0x007d
                r6 = -1
            L_0x007d:
                if (r1 != r7) goto L_0x0080
                r1 = -1
            L_0x0080:
                com.startapp.a1$k r3 = new com.startapp.a1$k
                com.startapp.a1 r7 = com.startapp.a1.this
                r8 = 0
                r3.<init>(r7, r8)
                r3.f34139a = r4
                r3.f34140b = r6
                r3.f34141c = r1
                long r0 = r0.getTimeStamp()
                r3.f34142d = r0
                com.startapp.a1 r0 = com.startapp.a1.this
                com.startapp.a1$i r0 = r0.f34092n
                r0.a((java.lang.String) r2, (com.startapp.a1.k) r3)
                goto L_0x0012
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.a1.o.a(java.util.List):void");
        }

        private void a(ServiceState serviceState, int i2) {
            ServiceStates serviceStates;
            DuplexMode duplexMode;
            m mVar = new m(a1.this, (a) null);
            if (Build.VERSION.SDK_INT >= 25) {
                if (a1.this.I != null) {
                    try {
                        mVar.f34152f = a1.this.I.getBoolean(serviceState) ? ThreeStateShort.Yes : ThreeStateShort.No;
                    } catch (Throwable th) {
                        l2.a(th);
                    }
                }
                if (mVar.f34152f == ThreeStateShort.Unknown && a1.this.H != null) {
                    try {
                        mVar.f34152f = ((Boolean) a1.this.H.invoke(serviceState, new Object[0])).booleanValue() ? ThreeStateShort.Yes : ThreeStateShort.No;
                    } catch (Throwable th2) {
                        l2.a(th2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    int a2 = serviceState.getDuplexMode();
                    if (a2 == 1) {
                        duplexMode = DuplexMode.FDD;
                    } else if (a2 != 2) {
                        duplexMode = DuplexMode.Unknown;
                    } else {
                        duplexMode = DuplexMode.TDD;
                    }
                    mVar.f34149c = duplexMode;
                    mVar.f34151e = serviceState.getChannelNumber();
                }
            }
            mVar.f34150d = serviceState.getIsManualSelection() ? ThreeStateShort.Yes : ThreeStateShort.No;
            int state = serviceState.getState();
            if (state == 0) {
                serviceStates = ServiceStates.InService;
            } else if (state == 1) {
                serviceStates = ServiceStates.OutOfService;
            } else if (state == 2) {
                serviceStates = ServiceStates.EmergencyOnly;
            } else if (state != 3) {
                serviceStates = ServiceStates.Unknown;
            } else {
                serviceStates = ServiceStates.PowerOff;
            }
            mVar.f34147a = serviceStates;
            mVar.f34148b = SystemClock.elapsedRealtime();
            NetworkRegistrationInfo[] c2 = a3.c(serviceState.toString());
            a1.this.f34092n.a(i2, mVar);
            a1.this.f34092n.a(i2, c2);
            a1.this.f34085g.post(new o2(new a(serviceState, i2)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x010f, code lost:
            r0 = r5;
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0111, code lost:
            r5 = r17;
            r6 = r18;
            r7 = r19;
            r18 = r22;
            r17 = r24;
            r21 = true;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x0238 A[SYNTHETIC, Splitter:B:101:0x0238] */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x02e6 A[Catch:{ all -> 0x0302 }] */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x02ff  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0310  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x035f A[Catch:{ all -> 0x0373 }] */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x0388  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x01b9  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x020c A[Catch:{ all -> 0x022c }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0227  */
        @android.annotation.TargetApi(29)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(android.telephony.SignalStrength r27, int r28) {
            /*
                r26 = this;
                r1 = r26
                r2 = r27
                r3 = r28
                java.lang.Integer r0 = com.startapp.networkTest.data.RadioInfo.INVALID
                int r4 = r0.intValue()
                int r5 = r0.intValue()
                int r6 = r0.intValue()
                int r7 = r0.intValue()
                int r8 = r0.intValue()
                int r9 = r0.intValue()
                int r10 = r0.intValue()
                int r11 = r0.intValue()
                int r12 = r0.intValue()
                int r13 = r0.intValue()
                int r14 = r0.intValue()
                int r15 = r0.intValue()
                int r16 = r0.intValue()
                int r17 = r0.intValue()
                int r18 = r0.intValue()
                int r19 = r0.intValue()
                com.startapp.a1 r0 = com.startapp.a1.this
                android.util.SparseArray r0 = r0.f34087i
                r20 = r4
                if (r0 == 0) goto L_0x005f
                com.startapp.a1 r0 = com.startapp.a1.this
                android.util.SparseArray r0 = r0.f34087i
                java.lang.Object r0 = r0.get(r3)
                android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
                goto L_0x0060
            L_0x005f:
                r0 = 0
            L_0x0060:
                if (r0 != 0) goto L_0x0068
                com.startapp.a1 r0 = com.startapp.a1.this
                android.telephony.TelephonyManager r0 = r0.f34086h
            L_0x0068:
                com.startapp.networkTest.enums.NetworkTypes r21 = com.startapp.networkTest.enums.NetworkTypes.Unknown
                com.startapp.a1 r4 = com.startapp.a1.this     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                android.util.SparseArray r4 = r4.f34087i     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                if (r4 != 0) goto L_0x00a4
                com.startapp.a1 r4 = com.startapp.a1.this     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                java.lang.reflect.Method r4 = r4.Q     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                if (r4 == 0) goto L_0x00a4
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                java.lang.reflect.Method r0 = r0.Q     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                com.startapp.a1 r4 = com.startapp.a1.this     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                android.telephony.TelephonyManager r4 = r4.f34086h     // Catch:{ SecurityException -> 0x00c2, all -> 0x00b8 }
                r24 = r6
                r22 = r7
                r6 = 1
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                java.lang.Integer r25 = java.lang.Integer.valueOf(r28)     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                r23 = 0
                r7[r23] = r25     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                java.lang.Object r0 = r0.invoke(r4, r7)     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                int r0 = r0.intValue()     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                com.startapp.networkTest.enums.NetworkTypes r0 = com.startapp.a1.d((int) r0)     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                goto L_0x00b1
            L_0x00a4:
                r24 = r6
                r22 = r7
                r6 = 1
                int r0 = r0.getNetworkType()     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
                com.startapp.networkTest.enums.NetworkTypes r0 = com.startapp.a1.d((int) r0)     // Catch:{ SecurityException -> 0x00b6, all -> 0x00b4 }
            L_0x00b1:
                r21 = r0
                goto L_0x00cb
            L_0x00b4:
                r0 = move-exception
                goto L_0x00be
            L_0x00b6:
                r0 = move-exception
                goto L_0x00c8
            L_0x00b8:
                r0 = move-exception
                r24 = r6
                r22 = r7
                r6 = 1
            L_0x00be:
                com.startapp.l2.a((java.lang.Throwable) r0)
                goto L_0x00cb
            L_0x00c2:
                r0 = move-exception
                r24 = r6
                r22 = r7
                r6 = 1
            L_0x00c8:
                com.startapp.l2.b(r0)
            L_0x00cb:
                r0 = r21
                com.startapp.networkTest.enums.NetworkTypes r4 = com.startapp.networkTest.enums.NetworkTypes.Unknown
                if (r0 != r4) goto L_0x00e1
                com.startapp.a1 r0 = com.startapp.a1.this
                com.startapp.a1$i r0 = r0.f34092n
                com.startapp.networkTest.data.radio.NetworkRegistrationInfo[] r0 = r0.b(r3)
                com.startapp.a1 r4 = com.startapp.a1.this
                com.startapp.networkTest.enums.NetworkTypes r0 = r4.b((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r0)
            L_0x00e1:
                com.startapp.networkTest.enums.NetworkGenerations r4 = com.startapp.a1.b((com.startapp.networkTest.enums.NetworkTypes) r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r7 = 29
                if (r0 < r7) goto L_0x01aa
                java.util.List r0 = r27.getCellSignalStrengths()
                java.util.Iterator r0 = r0.iterator()
            L_0x00f3:
                boolean r7 = r0.hasNext()
                if (r7 == 0) goto L_0x01aa
                java.lang.Object r7 = r0.next()
                android.telephony.CellSignalStrength r7 = (android.telephony.CellSignalStrength) r7
                com.startapp.networkTest.enums.NetworkGenerations r6 = com.startapp.networkTest.enums.NetworkGenerations.Gen2
                r25 = r0
                if (r4 != r6) goto L_0x011f
                boolean r0 = r7 instanceof android.telephony.CellSignalStrengthGsm
                if (r0 == 0) goto L_0x011f
                android.telephony.CellSignalStrengthGsm r7 = (android.telephony.CellSignalStrengthGsm) r7
                int r5 = r7.getDbm()
            L_0x010f:
                r0 = r5
                r12 = r0
            L_0x0111:
                r5 = r17
                r6 = r18
                r7 = r19
                r18 = r22
                r17 = r24
                r21 = 1
                goto L_0x01b7
            L_0x011f:
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen3
                if (r4 != r0) goto L_0x0138
                boolean r0 = r7 instanceof android.telephony.CellSignalStrengthWcdma
                if (r0 == 0) goto L_0x0138
                android.telephony.CellSignalStrengthWcdma r7 = (android.telephony.CellSignalStrengthWcdma) r7
                int r12 = r7.getDbm()
                java.lang.Integer r0 = com.startapp.networkTest.data.RadioInfo.INVALID
                int r0 = r0.intValue()
                if (r5 != r0) goto L_0x0136
                r5 = r12
            L_0x0136:
                r0 = r5
                goto L_0x0111
            L_0x0138:
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen4
                if (r4 != r0) goto L_0x0169
                boolean r0 = r7 instanceof android.telephony.CellSignalStrengthLte
                if (r0 == 0) goto L_0x0169
                android.telephony.CellSignalStrengthLte r7 = (android.telephony.CellSignalStrengthLte) r7
                int r5 = r7.getDbm()
                int r6 = r7.getCqi()
                int r0 = r7.getRsrp()
                int r8 = r7.getRssnr()
                int r9 = r7.getRsrq()
                int r10 = r7.getRssi()
                r12 = r5
                r7 = r19
                r21 = 1
                r5 = r17
                r17 = r6
                r6 = r18
                r18 = r0
                r0 = r12
                goto L_0x01b7
            L_0x0169:
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen5
                if (r4 != r0) goto L_0x0191
                boolean r0 = r7 instanceof android.telephony.CellSignalStrengthNr
                if (r0 == 0) goto L_0x0191
                android.telephony.CellSignalStrengthNr r7 = (android.telephony.CellSignalStrengthNr) r7
                int r5 = r7.getDbm()
                int r14 = r7.getCsiRsrp()
                int r15 = r7.getCsiRsrq()
                int r16 = r7.getCsiSinr()
                int r17 = r7.getSsRsrp()
                int r18 = r7.getSsRsrq()
                int r19 = r7.getSsSinr()
                goto L_0x010f
            L_0x0191:
                if (r4 != r6) goto L_0x01a5
                boolean r0 = r7 instanceof android.telephony.CellSignalStrengthCdma
                if (r0 == 0) goto L_0x01a5
                android.telephony.CellSignalStrengthCdma r7 = (android.telephony.CellSignalStrengthCdma) r7
                int r0 = r7.getCdmaEcio()
                int r5 = r7.getDbm()
                r20 = r0
                goto L_0x010f
            L_0x01a5:
                r0 = r25
                r6 = 1
                goto L_0x00f3
            L_0x01aa:
                r0 = r5
                r5 = r17
                r6 = r18
                r7 = r19
                r18 = r22
                r17 = r24
                r21 = 0
            L_0x01b7:
                if (r21 != 0) goto L_0x0388
                boolean r0 = r27.isGsm()
                if (r0 == 0) goto L_0x01f6
                com.startapp.a1 r0 = com.startapp.a1.this
                java.lang.reflect.Field r0 = r0.C
                if (r0 == 0) goto L_0x01da
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen3
                if (r4 != r0) goto L_0x01da
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x01d6 }
                java.lang.reflect.Field r0 = r0.C     // Catch:{ all -> 0x01d6 }
                int r13 = r0.getInt(r2)     // Catch:{ all -> 0x01d6 }
                goto L_0x01da
            L_0x01d6:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x01da:
                int r0 = r27.getGsmSignalStrength()
                if (r0 != 0) goto L_0x01ec
                java.lang.Integer r19 = com.startapp.networkTest.data.RadioInfo.INVALID
                r21 = r8
                int r8 = r19.intValue()
                if (r13 == r8) goto L_0x01ee
                r8 = r13
                goto L_0x0204
            L_0x01ec:
                r21 = r8
            L_0x01ee:
                if (r0 >= 0) goto L_0x01f1
                goto L_0x0202
            L_0x01f1:
                int r0 = com.startapp.a1.c((int) r0)
                goto L_0x0202
            L_0x01f6:
                r21 = r8
                int r0 = r27.getCdmaDbm()
                int r8 = r27.getCdmaEcio()
                r20 = r8
            L_0x0202:
                r8 = r13
                r13 = r0
            L_0x0204:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x022c }
                java.lang.reflect.Method r0 = r0.f34097s     // Catch:{ all -> 0x022c }
                if (r0 == 0) goto L_0x0227
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x022c }
                java.lang.reflect.Method r0 = r0.f34097s     // Catch:{ all -> 0x022c }
                r19 = r8
                r22 = r9
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0225 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x0225 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0225 }
                int r0 = r0.intValue()     // Catch:{ all -> 0x0225 }
                r12 = r0
                goto L_0x0234
            L_0x0225:
                r0 = move-exception
                goto L_0x0231
            L_0x0227:
                r19 = r8
                r22 = r9
                goto L_0x0234
            L_0x022c:
                r0 = move-exception
                r19 = r8
                r22 = r9
            L_0x0231:
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0234:
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen4
                if (r4 != r0) goto L_0x0308
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0254 }
                java.lang.reflect.Method r0 = r0.f34099u     // Catch:{ all -> 0x0254 }
                if (r0 == 0) goto L_0x0258
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0254 }
                java.lang.reflect.Method r0 = r0.f34099u     // Catch:{ all -> 0x0254 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0254 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x0254 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0254 }
                int r13 = r0.intValue()     // Catch:{ all -> 0x0254 }
                goto L_0x0258
            L_0x0254:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0258:
                com.startapp.a1 r0 = com.startapp.a1.this
                java.lang.reflect.Method r0 = r0.f34098t
                if (r0 == 0) goto L_0x0278
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0274 }
                java.lang.reflect.Method r0 = r0.f34098t     // Catch:{ all -> 0x0274 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0274 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x0274 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0274 }
                int r10 = r0.intValue()     // Catch:{ all -> 0x0274 }
                goto L_0x0278
            L_0x0274:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0278:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0296 }
                java.lang.reflect.Method r0 = r0.f34101w     // Catch:{ all -> 0x0296 }
                if (r0 == 0) goto L_0x029a
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0296 }
                java.lang.reflect.Method r0 = r0.f34101w     // Catch:{ all -> 0x0296 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0296 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x0296 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0296 }
                int r0 = r0.intValue()     // Catch:{ all -> 0x0296 }
                r17 = r0
                goto L_0x029a
            L_0x0296:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x029a:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x02b8 }
                java.lang.reflect.Method r0 = r0.f34102x     // Catch:{ all -> 0x02b8 }
                if (r0 == 0) goto L_0x02bc
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x02b8 }
                java.lang.reflect.Method r0 = r0.f34102x     // Catch:{ all -> 0x02b8 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x02b8 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x02b8 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x02b8 }
                int r0 = r0.intValue()     // Catch:{ all -> 0x02b8 }
                r18 = r0
                goto L_0x02bc
            L_0x02b8:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x02bc:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x02d8 }
                java.lang.reflect.Method r0 = r0.f34103y     // Catch:{ all -> 0x02d8 }
                if (r0 == 0) goto L_0x02dc
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x02d8 }
                java.lang.reflect.Method r0 = r0.f34103y     // Catch:{ all -> 0x02d8 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x02d8 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x02d8 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x02d8 }
                int r9 = r0.intValue()     // Catch:{ all -> 0x02d8 }
                goto L_0x02de
            L_0x02d8:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x02dc:
                r9 = r22
            L_0x02de:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0302 }
                java.lang.reflect.Method r0 = r0.f34104z     // Catch:{ all -> 0x0302 }
                if (r0 == 0) goto L_0x02ff
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0302 }
                java.lang.reflect.Method r0 = r0.f34104z     // Catch:{ all -> 0x0302 }
                r22 = r9
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x02fd }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ all -> 0x02fd }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x02fd }
                int r0 = r0.intValue()     // Catch:{ all -> 0x02fd }
                r8 = r0
                goto L_0x030a
            L_0x02fd:
                r0 = move-exception
                goto L_0x0305
            L_0x02ff:
                r22 = r9
                goto L_0x0308
            L_0x0302:
                r0 = move-exception
                r22 = r9
            L_0x0305:
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0308:
                r8 = r21
            L_0x030a:
                r9 = r22
                com.startapp.networkTest.enums.NetworkGenerations r0 = com.startapp.networkTest.enums.NetworkGenerations.Gen5
                if (r4 != r0) goto L_0x0357
                com.startapp.a1 r0 = com.startapp.a1.this
                java.lang.reflect.Field r0 = r0.E
                if (r0 == 0) goto L_0x0327
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0323 }
                java.lang.reflect.Field r0 = r0.E     // Catch:{ all -> 0x0323 }
                int r14 = r0.getInt(r2)     // Catch:{ all -> 0x0323 }
                goto L_0x0327
            L_0x0323:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0327:
                com.startapp.a1 r0 = com.startapp.a1.this
                java.lang.reflect.Field r0 = r0.F
                if (r0 == 0) goto L_0x033e
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x033a }
                java.lang.reflect.Field r0 = r0.F     // Catch:{ all -> 0x033a }
                int r15 = r0.getInt(r2)     // Catch:{ all -> 0x033a }
                goto L_0x033e
            L_0x033a:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x033e:
                com.startapp.a1 r0 = com.startapp.a1.this
                java.lang.reflect.Field r0 = r0.G
                if (r0 == 0) goto L_0x0357
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0353 }
                java.lang.reflect.Field r0 = r0.G     // Catch:{ all -> 0x0353 }
                int r0 = r0.getInt(r2)     // Catch:{ all -> 0x0353 }
                r16 = r0
                goto L_0x0357
            L_0x0353:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0357:
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0373 }
                java.lang.reflect.Method r0 = r0.f34100v     // Catch:{ all -> 0x0373 }
                if (r0 == 0) goto L_0x0377
                com.startapp.a1 r0 = com.startapp.a1.this     // Catch:{ all -> 0x0373 }
                java.lang.reflect.Method r0 = r0.f34100v     // Catch:{ all -> 0x0373 }
                r4 = 0
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0373 }
                java.lang.Object r0 = r0.invoke(r2, r4)     // Catch:{ all -> 0x0373 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0373 }
                int r11 = r0.intValue()     // Catch:{ all -> 0x0373 }
                goto L_0x0377
            L_0x0373:
                r0 = move-exception
                com.startapp.l2.a((java.lang.Throwable) r0)
            L_0x0377:
                r3 = r16
                r0 = r17
                r2 = r18
                r4 = r19
                r17 = r6
                r18 = r7
                r16 = r11
                r11 = r20
                goto L_0x039c
            L_0x0388:
                r21 = r8
                r22 = r9
                r4 = r13
                r3 = r16
                r2 = r18
                r13 = r0
                r18 = r7
                r16 = r11
                r0 = r17
                r11 = r20
                r17 = r6
            L_0x039c:
                long r6 = android.os.SystemClock.elapsedRealtime()
                r19 = r6
                com.startapp.a1$n r6 = new com.startapp.a1$n
                com.startapp.a1 r7 = com.startapp.a1.this
                r1 = 0
                r6.<init>(r7, r1)
                r6.f34156c = r11
                r6.f34154a = r13
                r6.f34155b = r12
                r6.f34157d = r0
                r6.f34158e = r2
                r6.f34159f = r8
                r6.f34160g = r9
                r6.f34161h = r10
                r6.f34165l = r14
                r6.f34166m = r15
                r6.f34167n = r3
                r6.f34168o = r5
                r1 = r17
                r6.f34169p = r1
                r1 = r18
                r6.f34170q = r1
                r6.f34163j = r4
                r11 = r16
                r6.f34162i = r11
                r0 = r19
                r6.f34164k = r0
                r1 = r26
                com.startapp.a1 r0 = com.startapp.a1.this
                com.startapp.a1$i r0 = r0.f34092n
                r2 = r28
                r0.a((int) r2, (com.startapp.a1.n) r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.a1.o.a(android.telephony.SignalStrength, int):void");
        }

        private void a(CellLocation cellLocation, int i2) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            g gVar = new g(a1.this, (a) null);
            gVar.f34124a = cellLocation;
            gVar.f34125b = elapsedRealtime;
            a1.this.f34092n.a(i2, gVar);
            a1.this.f34085g.post(new o2(new b(cellLocation, i2)));
        }
    }

    private void c(boolean z2) {
        SubscriptionManager subscriptionManager;
        if (z2 && this.f34093o != null && this.f34088j.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.f34088j.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.addOnSubscriptionsChangedListener(this.f34093o);
        }
        if (this.f34086h != null) {
            int i2 = ((Build.VERSION.SDK_INT >= 29 || this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) && !(this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0)) ? 257 : 1297;
            if (this.f34090l.size() == 0) {
                if (this.f34089k == null) {
                    this.f34089k = new o();
                }
                try {
                    this.f34086h.listen(this.f34089k, i2);
                } catch (Throwable th) {
                    l2.a(th);
                    this.f34086h.listen(this.f34089k, 257);
                }
            } else {
                Iterator<o> it2 = this.f34090l.iterator();
                while (it2.hasNext()) {
                    o next = it2.next();
                    SparseArray<TelephonyManager> sparseArray = this.f34087i;
                    TelephonyManager telephonyManager = (sparseArray == null || sparseArray.size() <= 0) ? null : this.f34087i.get(next.a());
                    if (telephonyManager == null) {
                        telephonyManager = this.f34086h;
                    }
                    try {
                        telephonyManager.listen(next, i2);
                    } catch (Throwable th2) {
                        l2.a(th2);
                        telephonyManager.listen(next, 257);
                    }
                }
            }
        }
    }

    private static CellConnectionStatus f(int i2) {
        if (i2 == 0) {
            return CellConnectionStatus.None;
        }
        if (i2 == 1) {
            return CellConnectionStatus.Primary;
        }
        if (i2 != 2) {
            return CellConnectionStatus.Unknown;
        }
        return CellConnectionStatus.Secondary;
    }

    public NetworkTypes k() {
        if (b3.b(this.f34088j)) {
            TelephonyManager telephonyManager = this.f34086h;
            if (telephonyManager == null || Build.VERSION.SDK_INT < 24) {
                Method method = this.A;
                if (method != null) {
                    try {
                        return d(((Integer) method.invoke(telephonyManager, new Object[0])).intValue());
                    } catch (Throwable th) {
                        l2.a(th);
                    }
                }
            } else {
                try {
                    return d(telephonyManager.getVoiceNetworkType());
                } catch (SecurityException e2) {
                    l2.b(e2);
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        try {
            c(z2);
        } catch (Throwable th) {
            l2.a(th);
        }
    }

    public class k {

        /* renamed from: a  reason: collision with root package name */
        public long f34139a;

        /* renamed from: b  reason: collision with root package name */
        public int f34140b;

        /* renamed from: c  reason: collision with root package name */
        public int f34141c;

        /* renamed from: d  reason: collision with root package name */
        public long f34142d;

        private k() {
            this.f34139a = 0;
            this.f34140b = 0;
            this.f34141c = 0;
            this.f34142d = 0;
        }

        public /* synthetic */ k(a1 a1Var, a aVar) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:196:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x048b  */
    @android.annotation.TargetApi(22)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.networkTest.data.RadioInfo h(int r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = -1
            if (r2 == r3) goto L_0x048f
            boolean r0 = r16.k((int) r17)
            if (r0 == 0) goto L_0x048f
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 22
            if (r0 < r4) goto L_0x048f
            int[] r0 = r1.V
            int r0 = r0.length
            if (r0 != 0) goto L_0x001a
            goto L_0x048f
        L_0x001a:
            com.startapp.networkTest.data.RadioInfo r4 = new com.startapp.networkTest.data.RadioInfo
            r4.<init>()
            r4.SubscriptionId = r2
            com.startapp.q1 r0 = r1.f34094p
            int r5 = r0.DefaultVoiceSimId
            r6 = 1
            r7 = 0
            if (r2 != r5) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            r4.IsDefaultVoiceSim = r5
            int r0 = r0.DefaultDataSimId
            if (r2 != r0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r4.IsDefaultDataSim = r0
            android.content.Context r0 = r1.f34088j
            com.startapp.networkTest.enums.PreferredNetworkTypes r0 = r1.a((android.content.Context) r0, (int) r2)
            r4.PreferredNetwork = r0
            com.startapp.networkTest.enums.PreferredNetworkTypes r5 = com.startapp.networkTest.enums.PreferredNetworkTypes.Unknown
            if (r0 != r5) goto L_0x005b
            android.content.Context r0 = r1.f34088j
            android.util.SparseArray r0 = r1.a((android.content.Context) r0)
            com.startapp.q1 r5 = r1.f34094p
            com.startapp.r1 r5 = r5.getSimInfoSubId(r2)
            int r5 = r5.SimSlotIndex
            java.lang.Object r0 = r0.get(r5)
            com.startapp.networkTest.enums.PreferredNetworkTypes r0 = (com.startapp.networkTest.enums.PreferredNetworkTypes) r0
            if (r0 == 0) goto L_0x005b
            r4.PreferredNetwork = r0
        L_0x005b:
            android.telephony.TelephonyManager r0 = r1.f34086h
            if (r0 == 0) goto L_0x048e
            android.util.SparseArray<android.telephony.TelephonyManager> r0 = r1.f34087i
            r5 = 0
            if (r0 == 0) goto L_0x0074
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0074
            android.util.SparseArray<android.telephony.TelephonyManager> r0 = r1.f34087i
            java.lang.Object r0 = r0.get(r2)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r8 = r0
            goto L_0x0075
        L_0x0074:
            r8 = r5
        L_0x0075:
            r9 = 3
            android.telephony.TelephonyManager r0 = r1.f34086h     // Catch:{ all -> 0x009e }
            int r0 = r0.getDataState()     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0099
            if (r0 == r6) goto L_0x0094
            r10 = 2
            if (r0 == r10) goto L_0x008f
            if (r0 == r9) goto L_0x008a
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Unknown     // Catch:{ all -> 0x009e }
            r4.MobileDataConnectionState = r0     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x008a:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Suspended     // Catch:{ all -> 0x009e }
            r4.MobileDataConnectionState = r0     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x008f:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Connected     // Catch:{ all -> 0x009e }
            r4.MobileDataConnectionState = r0     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x0094:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Connecting     // Catch:{ all -> 0x009e }
            r4.MobileDataConnectionState = r0     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x0099:
            com.startapp.networkTest.enums.radio.DataConnectionStates r0 = com.startapp.networkTest.enums.radio.DataConnectionStates.Disconnected     // Catch:{ all -> 0x009e }
            r4.MobileDataConnectionState = r0     // Catch:{ all -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x00a2:
            boolean r0 = r16.m()
            if (r0 == 0) goto L_0x00ab
            com.startapp.networkTest.enums.FlightModeStates r0 = com.startapp.networkTest.enums.FlightModeStates.Enabled
            goto L_0x00ad
        L_0x00ab:
            com.startapp.networkTest.enums.FlightModeStates r0 = com.startapp.networkTest.enums.FlightModeStates.Disabled
        L_0x00ad:
            r4.FlightMode = r0
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Unknown
            r4.MobileDataEnabled = r0
            if (r8 == 0) goto L_0x00ce
            int r0 = android.os.Build.VERSION.SDK_INT
            r10 = 26
            if (r0 < r10) goto L_0x00ce
            boolean r0 = r8.isDataEnabled()     // Catch:{ SecurityException -> 0x00c9 }
            if (r0 == 0) goto L_0x00c4
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Enabled     // Catch:{ SecurityException -> 0x00c9 }
            goto L_0x00c6
        L_0x00c4:
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Disabled     // Catch:{ SecurityException -> 0x00c9 }
        L_0x00c6:
            r4.MobileDataEnabled = r0     // Catch:{ SecurityException -> 0x00c9 }
            goto L_0x00f4
        L_0x00c9:
            r0 = move-exception
            com.startapp.l2.b(r0)
            goto L_0x00f4
        L_0x00ce:
            java.lang.reflect.Method r0 = r1.O
            if (r0 == 0) goto L_0x00f4
            android.telephony.TelephonyManager r10 = r1.f34086h     // Catch:{ all -> 0x00f0 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x00f0 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x00f0 }
            r11[r7] = r12     // Catch:{ all -> 0x00f0 }
            java.lang.Object r0 = r0.invoke(r10, r11)     // Catch:{ all -> 0x00f0 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f0 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00eb
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Enabled     // Catch:{ all -> 0x00f0 }
            goto L_0x00ed
        L_0x00eb:
            com.startapp.networkTest.enums.ThreeState r0 = com.startapp.networkTest.enums.ThreeState.Disabled     // Catch:{ all -> 0x00f0 }
        L_0x00ed:
            r4.MobileDataEnabled = r0     // Catch:{ all -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x00f4:
            if (r8 == 0) goto L_0x00fd
            boolean r0 = r8.isNetworkRoaming()
            r4.IsRoaming = r0
            goto L_0x011c
        L_0x00fd:
            java.lang.reflect.Method r0 = r1.P
            if (r0 == 0) goto L_0x011c
            android.telephony.TelephonyManager r10 = r1.f34086h     // Catch:{ all -> 0x0118 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x0118 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0118 }
            r11[r7] = r12     // Catch:{ all -> 0x0118 }
            java.lang.Object r0 = r0.invoke(r10, r11)     // Catch:{ all -> 0x0118 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0118 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0118 }
            r4.IsRoaming = r0     // Catch:{ all -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x011c:
            com.startapp.networkTest.enums.ThreeStateShort r0 = r16.o()
            r4.IsMetered = r0
            com.startapp.networkTest.enums.ThreeStateShort r0 = r16.n()
            int r0 = com.startapp.v2.a((com.startapp.networkTest.enums.ThreeStateShort) r0)
            r4.IsVpn = r0
            com.startapp.networkTest.enums.ConnectionTypes r0 = r16.d()
            r4.ConnectionType = r0
            if (r8 == 0) goto L_0x0152
            int r0 = android.os.Build.VERSION.SDK_INT
            r10 = 30
            if (r0 < r10) goto L_0x0142
            android.content.Context r0 = r1.f34088j
            boolean r0 = com.startapp.b3.b(r0)
            if (r0 == 0) goto L_0x0152
        L_0x0142:
            int r0 = r8.getNetworkType()     // Catch:{ SecurityException -> 0x014d }
            com.startapp.networkTest.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ SecurityException -> 0x014d }
            r4.NetworkType = r0     // Catch:{ SecurityException -> 0x014d }
            goto L_0x0175
        L_0x014d:
            r0 = move-exception
            com.startapp.l2.b(r0)
            goto L_0x0175
        L_0x0152:
            java.lang.reflect.Method r0 = r1.Q
            if (r0 == 0) goto L_0x0175
            android.telephony.TelephonyManager r10 = r1.f34086h     // Catch:{ all -> 0x0171 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x0171 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0171 }
            r11[r7] = r12     // Catch:{ all -> 0x0171 }
            java.lang.Object r0 = r0.invoke(r10, r11)     // Catch:{ all -> 0x0171 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0171 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0171 }
            com.startapp.networkTest.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ all -> 0x0171 }
            r4.NetworkType = r0     // Catch:{ all -> 0x0171 }
            goto L_0x0175
        L_0x0171:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x0175:
            if (r8 == 0) goto L_0x0182
            java.lang.String r0 = r8.getNetworkOperatorName()
            java.lang.String r0 = com.startapp.f3.a((java.lang.String) r0)
            r4.OperatorName = r0
            goto L_0x01a1
        L_0x0182:
            java.lang.reflect.Method r0 = r1.R
            if (r0 == 0) goto L_0x01a1
            android.telephony.TelephonyManager r10 = r1.f34086h     // Catch:{ all -> 0x019d }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x019d }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x019d }
            r11[r7] = r12     // Catch:{ all -> 0x019d }
            java.lang.Object r0 = r0.invoke(r10, r11)     // Catch:{ all -> 0x019d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x019d }
            java.lang.String r0 = com.startapp.f3.a((java.lang.String) r0)     // Catch:{ all -> 0x019d }
            r4.OperatorName = r0     // Catch:{ all -> 0x019d }
            goto L_0x01a1
        L_0x019d:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x01a1:
            java.lang.String r10 = ""
            if (r8 == 0) goto L_0x01aa
            java.lang.String r0 = r8.getNetworkOperator()
            goto L_0x01de
        L_0x01aa:
            java.lang.reflect.Method r0 = r1.T
            if (r0 == 0) goto L_0x01c4
            android.telephony.TelephonyManager r8 = r1.f34086h     // Catch:{ all -> 0x01bf }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x01bf }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x01bf }
            r11[r7] = r12     // Catch:{ all -> 0x01bf }
            java.lang.Object r0 = r0.invoke(r8, r11)     // Catch:{ all -> 0x01bf }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x01bf }
            goto L_0x01de
        L_0x01bf:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
            goto L_0x01dd
        L_0x01c4:
            java.lang.reflect.Method r0 = r1.S
            if (r0 == 0) goto L_0x01dd
            android.telephony.TelephonyManager r8 = r1.f34086h     // Catch:{ all -> 0x01d9 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x01d9 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x01d9 }
            r11[r7] = r12     // Catch:{ all -> 0x01d9 }
            java.lang.Object r0 = r0.invoke(r8, r11)     // Catch:{ all -> 0x01d9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x01d9 }
            goto L_0x01de
        L_0x01d9:
            r0 = move-exception
            com.startapp.l2.a((java.lang.Throwable) r0)
        L_0x01dd:
            r0 = r10
        L_0x01de:
            int r8 = r0.length()
            r11 = 4
            if (r8 <= r11) goto L_0x01f1
            java.lang.String r8 = r0.substring(r7, r9)
            r4.MCC = r8
            java.lang.String r0 = r0.substring(r9)
            r4.MNC = r0
        L_0x01f1:
            com.startapp.networkTest.data.radio.NetworkRegistrationInfo[] r0 = r16.g((int) r17)
            com.startapp.a1$i r8 = r1.f34092n
            com.startapp.a1$g r8 = r8.a((int) r2)
            if (r8 != 0) goto L_0x0202
            com.startapp.a1$g r8 = new com.startapp.a1$g
            r8.<init>(r1, r5)
        L_0x0202:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r5 >= r9) goto L_0x0212
            android.content.Context r5 = r1.f34088j
            java.lang.String r9 = "android.permission.ACCESS_COARSE_LOCATION"
            int r5 = r5.checkCallingOrSelfPermission(r9)
            if (r5 == 0) goto L_0x0226
        L_0x0212:
            android.content.Context r5 = r1.f34088j
            java.lang.String r9 = "android.permission.ACCESS_FINE_LOCATION"
            int r5 = r5.checkCallingOrSelfPermission(r9)
            if (r5 != 0) goto L_0x0233
            android.content.Context r5 = r1.f34088j
            java.lang.String r9 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r5 = r5.checkCallingOrSelfPermission(r9)
            if (r5 != 0) goto L_0x0233
        L_0x0226:
            android.telephony.CellLocation r5 = r8.f34124a
            if (r5 != 0) goto L_0x0235
            android.telephony.TelephonyManager r5 = r1.f34086h
            android.telephony.CellLocation r5 = r5.getCellLocation()
            r8.f34124a = r5
            goto L_0x0235
        L_0x0233:
            r4.MissingPermission = r6
        L_0x0235:
            android.telephony.CellLocation r5 = r8.f34124a
            r11 = 0
            r13 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r5 == 0) goto L_0x0325
            java.lang.Class r5 = r5.getClass()
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r9 = android.telephony.gsm.GsmCellLocation.class
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x028e
            android.telephony.CellLocation r5 = r8.f34124a
            android.telephony.gsm.GsmCellLocation r5 = (android.telephony.gsm.GsmCellLocation) r5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getLac()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.GsmLAC = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getCid()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.GsmCellId = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r5 = r5.getPsc()
            r9.append(r5)
            r9.append(r10)
            java.lang.String r5 = r9.toString()
            r4.PrimaryScramblingCode = r5
            goto L_0x0309
        L_0x028e:
            android.telephony.CellLocation r5 = r8.f34124a
            java.lang.Class r5 = r5.getClass()
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r9 = android.telephony.cdma.CdmaCellLocation.class
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x0309
            android.telephony.CellLocation r5 = r8.f34124a
            android.telephony.cdma.CdmaCellLocation r5 = (android.telephony.cdma.CdmaCellLocation) r5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getBaseStationId()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.CdmaBaseStationId = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getBaseStationLatitude()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.CdmaBaseStationLatitude = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getBaseStationLongitude()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.CdmaBaseStationLongitude = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r15 = r5.getNetworkId()
            r9.append(r15)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r4.CdmaNetworkId = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r5 = r5.getSystemId()
            r9.append(r5)
            r9.append(r10)
            java.lang.String r5 = r9.toString()
            r4.CdmaSystemId = r5
        L_0x0309:
            long r6 = r8.f34125b
            int r15 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x0323
            long r6 = android.os.SystemClock.elapsedRealtime()
            r15 = r10
            long r9 = r8.f34125b
            long r6 = r6 - r9
            int r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x031f
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0320
        L_0x031f:
            int r7 = (int) r6
        L_0x0320:
            r4.GsmCellIdAge = r7
            goto L_0x034d
        L_0x0323:
            r15 = r10
            goto L_0x034d
        L_0x0325:
            r15 = r10
            if (r0 == 0) goto L_0x034d
            int r6 = r0.length
            r7 = 0
        L_0x032a:
            if (r7 >= r6) goto L_0x034d
            r8 = r0[r7]
            java.lang.String r9 = r8.Domain
            java.lang.String r10 = "CS"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x034a
            java.lang.String r9 = r8.CellId
            r4.GsmCellId = r9
            java.lang.String r10 = r8.Tac
            r4.GsmLAC = r10
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x034a
            int r8 = r8.Age
            r4.GsmCellIdAge = r8
        L_0x034a:
            int r7 = r7 + 1
            goto L_0x032a
        L_0x034d:
            com.startapp.a1$i r6 = r1.f34092n
            com.startapp.a1$m r6 = r6.d(r2)
            com.startapp.networkTest.enums.ServiceStates r7 = r6.f34147a
            r4.ServiceState = r7
            com.startapp.networkTest.enums.DuplexMode r7 = r6.f34149c
            r4.DuplexMode = r7
            com.startapp.networkTest.enums.ThreeStateShort r7 = r6.f34150d
            r4.ManualSelection = r7
            com.startapp.networkTest.enums.ThreeStateShort r7 = r6.f34152f
            r4.CarrierAggregation = r7
            int r7 = r6.f34151e
            r4.ARFCN = r7
            long r7 = r6.f34148b
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x037f
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r9 = r6.f34148b
            long r7 = r7 - r9
            int r6 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x037c
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x037d
        L_0x037c:
            int r6 = (int) r7
        L_0x037d:
            r4.ServiceStateAge = r6
        L_0x037f:
            java.lang.String r6 = r1.c((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r0)
            r4.NrState = r6
            com.startapp.networkTest.enums.ThreeStateShort r6 = r1.d((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r0)
            r4.NrAvailable = r6
            com.startapp.networkTest.enums.NetworkTypes r6 = r4.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r7 = com.startapp.networkTest.enums.NetworkTypes.Unknown
            if (r6 != r7) goto L_0x0397
            com.startapp.networkTest.enums.NetworkTypes r6 = r1.b((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r0)
            r4.NetworkType = r6
        L_0x0397:
            com.startapp.a1$i r6 = r1.f34092n
            com.startapp.a1$n r2 = r6.e(r2)
            int r6 = r2.f34163j
            r4.RSCP = r6
            int r6 = r2.f34156c
            r4.CdmaEcIo = r6
            int r6 = r2.f34154a
            r4.RXLevel = r6
            int r7 = r2.f34155b
            r4.NativeDbm = r7
            int r7 = r2.f34162i
            r4.EcN0 = r7
            int r7 = r2.f34157d
            r4.LteCqi = r7
            int r7 = r2.f34158e
            r4.LteRsrp = r7
            int r8 = r2.f34160g
            r4.LteRsrq = r8
            int r8 = r2.f34159f
            r4.LteRssnr = r8
            int r8 = r2.f34161h
            r4.LteRssi = r8
            int r8 = r2.f34165l
            r4.NrCsiRsrp = r8
            int r8 = r2.f34166m
            r4.NrCsiRsrq = r8
            int r8 = r2.f34167n
            r4.NrCsiSinr = r8
            int r8 = r2.f34168o
            r4.NrSsRsrp = r8
            int r8 = r2.f34169p
            r4.NrSsRsrq = r8
            int r8 = r2.f34170q
            r4.NrSsSinr = r8
            com.startapp.networkTest.enums.NetworkTypes r8 = r4.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r9 = com.startapp.networkTest.enums.NetworkTypes.LTE
            if (r8 == r9) goto L_0x03e7
            com.startapp.networkTest.enums.NetworkTypes r9 = com.startapp.networkTest.enums.NetworkTypes.LTE_CA
            if (r8 != r9) goto L_0x03eb
        L_0x03e7:
            if (r6 <= r3) goto L_0x03eb
            r4.RXLevel = r7
        L_0x03eb:
            com.startapp.networkTest.enums.NetworkTypes r3 = com.startapp.networkTest.enums.NetworkTypes.LTE_CA
            if (r8 != r3) goto L_0x03f3
            com.startapp.networkTest.enums.ThreeStateShort r3 = com.startapp.networkTest.enums.ThreeStateShort.Yes
            r4.CarrierAggregation = r3
        L_0x03f3:
            com.startapp.networkTest.enums.ThreeStateShort r3 = r4.CarrierAggregation
            com.startapp.networkTest.enums.ThreeStateShort r6 = com.startapp.networkTest.enums.ThreeStateShort.Unknown
            if (r3 != r6) goto L_0x03ff
            com.startapp.networkTest.enums.ThreeStateShort r0 = r1.a((com.startapp.networkTest.data.radio.NetworkRegistrationInfo[]) r0)
            r4.CarrierAggregation = r0
        L_0x03ff:
            com.startapp.networkTest.enums.NetworkTypes r0 = r4.NetworkType
            com.startapp.networkTest.enums.NetworkTypes r3 = com.startapp.networkTest.enums.NetworkTypes.NR
            if (r0 != r3) goto L_0x047c
            java.lang.String r0 = r4.MCC     // Catch:{ NumberFormatException -> 0x0414 }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0414 }
            java.lang.String r0 = r4.MNC     // Catch:{ NumberFormatException -> 0x0412 }
            int r7 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0412 }
            goto L_0x041a
        L_0x0412:
            r0 = move-exception
            goto L_0x0416
        L_0x0414:
            r0 = move-exception
            r3 = 0
        L_0x0416:
            com.startapp.l2.b(r0)
            r7 = 0
        L_0x041a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r15
            r0.append(r5)
            r0.append(r3)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.startapp.a1$i r3 = r1.f34092n
            com.startapp.a1$k r0 = r3.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x047c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r6 = r0.f34139a
            r3.append(r6)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.GsmCellId = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r6 = r0.f34140b
            r3.append(r6)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.GsmLAC = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r6 = r0.f34141c
            r3.append(r6)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.PrimaryScramblingCode = r3
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r7 = r0.f34142d
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            long r5 = r5 - r7
            int r0 = (int) r5
            r4.GsmCellIdAge = r0
        L_0x047c:
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2.f34164k
            long r5 = r5 - r2
            int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x048b
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x048c
        L_0x048b:
            int r6 = (int) r5
        L_0x048c:
            r4.RXLevelAge = r6
        L_0x048e:
            return r4
        L_0x048f:
            com.startapp.networkTest.data.RadioInfo r0 = r16.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.a1.h(int):com.startapp.networkTest.data.RadioInfo");
    }

    public NetworkTypes i(int i2) {
        if (k(i2) && b3.b(this.f34088j)) {
            SparseArray<TelephonyManager> sparseArray = this.f34087i;
            if (sparseArray == null || sparseArray.get(i2) == null || Build.VERSION.SDK_INT < 24) {
                Method method = this.B;
                if (method != null) {
                    try {
                        return d(((Integer) method.invoke(this.f34086h, new Object[]{Integer.valueOf(i2)})).intValue());
                    } catch (Throwable th) {
                        l2.a(th);
                    }
                }
            } else {
                try {
                    return d(this.f34087i.get(i2).getVoiceNetworkType());
                } catch (SecurityException e2) {
                    l2.b(e2);
                }
            }
        }
        return k();
    }

    public boolean j(int i2) {
        Method method = this.P;
        if (method == null) {
            return p();
        }
        try {
            return ((Boolean) method.invoke(this.f34086h, new Object[]{Integer.valueOf(i2)})).booleanValue();
        } catch (Throwable th) {
            l2.a(th);
            return p();
        }
    }

    /* access modifiers changed from: private */
    public void a(int[] iArr) {
        this.f34090l = new ArrayList<>();
        for (int oVar : iArr) {
            this.f34090l.add(new o(oVar));
        }
    }

    private void b(Context context) {
        if (this.f34095q == null) {
            this.f34095q = new j(this, (a) null);
        }
        Objects.requireNonNull(this.f34095q);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ANY_DATA_STATE");
        Objects.requireNonNull(this.f34095q);
        intentFilter.addAction("com.samsung.ims.action.IMS_REGISTRATION");
        context.registerReceiver(this.f34095q, intentFilter);
    }

    public class m {

        /* renamed from: a  reason: collision with root package name */
        public ServiceStates f34147a;

        /* renamed from: b  reason: collision with root package name */
        public long f34148b;

        /* renamed from: c  reason: collision with root package name */
        public DuplexMode f34149c;

        /* renamed from: d  reason: collision with root package name */
        public ThreeStateShort f34150d;

        /* renamed from: e  reason: collision with root package name */
        public int f34151e;

        /* renamed from: f  reason: collision with root package name */
        public ThreeStateShort f34152f;

        private m() {
            this.f34147a = ServiceStates.Unknown;
            this.f34148b = 0;
            this.f34149c = DuplexMode.Unknown;
            ThreeStateShort threeStateShort = ThreeStateShort.Unknown;
            this.f34150d = threeStateShort;
            this.f34151e = -1;
            this.f34152f = threeStateShort;
        }

        public /* synthetic */ m(a1 a1Var, a aVar) {
            this();
        }
    }

    @TargetApi(18)
    public com.startapp.networkTest.data.radio.CellInfo[] a(boolean z2) {
        List<CellInfo> list;
        if (this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0 || (this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && Build.VERSION.SDK_INT >= 29)) {
            return new com.startapp.networkTest.data.radio.CellInfo[0];
        }
        ArrayList arrayList = new ArrayList();
        TelephonyManager telephonyManager = this.f34086h;
        if (telephonyManager != null) {
            if (z2 || (list = this.f34096r) == null) {
                try {
                    list = telephonyManager.getAllCellInfo();
                } catch (Throwable th) {
                    l2.a(th);
                    list = null;
                }
                if (this.f34096r != null && (list == null || list.isEmpty())) {
                    list = this.f34096r;
                }
            }
            if (list == null) {
                return new com.startapp.networkTest.data.radio.CellInfo[0];
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (CellInfo next : list) {
                com.startapp.networkTest.data.radio.CellInfo cellInfo = new com.startapp.networkTest.data.radio.CellInfo();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28) {
                    cellInfo.CellConnectionStatus = f(next.getCellConnectionStatus());
                }
                if (next instanceof CellInfoGsm) {
                    b(next, cellInfo, uptimeMillis);
                } else if (next instanceof CellInfoLte) {
                    c(next, cellInfo, uptimeMillis);
                } else if (next instanceof CellInfoWcdma) {
                    e(next, cellInfo, uptimeMillis);
                } else if (next instanceof CellInfoCdma) {
                    a(next, cellInfo, uptimeMillis);
                } else if (i2 >= 29 && (next instanceof CellInfoNr)) {
                    try {
                        d(next, cellInfo, uptimeMillis);
                    } catch (Throwable th2) {
                        l2.a(th2);
                    }
                }
                arrayList.add(cellInfo);
            }
        }
        return (com.startapp.networkTest.data.radio.CellInfo[]) arrayList.toArray(new com.startapp.networkTest.data.radio.CellInfo[arrayList.size()]);
    }

    @TargetApi(17)
    private void b(CellInfo cellInfo, com.startapp.networkTest.data.radio.CellInfo cellInfo2, long j2) {
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        cellInfo2.IsRegistered = cellInfoGsm.isRegistered();
        cellInfo2.CellNetworkType = CellNetworkTypes.Gsm;
        cellInfo2.CellInfoAge = j2 - (cellInfoGsm.getTimeStamp() / 1000000);
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            cellInfo2.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            cellInfo2.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            int cid = cellIdentity.getCid();
            cellInfo2.Cid = cid;
            cellInfo2.CellId = (long) cid;
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            cellInfo2.Lac = cellIdentity.getLac();
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            cellInfo2.Psc = cellIdentity.getPsc();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (cellIdentity.getArfcn() != Integer.MAX_VALUE) {
                cellInfo2.Arfcn = cellIdentity.getArfcn();
            }
            if (cellIdentity.getBsic() != Integer.MAX_VALUE) {
                cellInfo2.GsmBsic = cellIdentity.getBsic();
            }
        }
        cellInfo2.Dbm = cellInfoGsm.getCellSignalStrength().getDbm();
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public int f34112a;

        /* renamed from: b  reason: collision with root package name */
        public String f34113b;

        /* renamed from: c  reason: collision with root package name */
        public String f34114c;

        /* renamed from: d  reason: collision with root package name */
        public String f34115d;

        /* renamed from: e  reason: collision with root package name */
        public String f34116e;

        /* renamed from: f  reason: collision with root package name */
        public String f34117f;

        /* renamed from: g  reason: collision with root package name */
        public int f34118g;

        /* renamed from: h  reason: collision with root package name */
        public long f34119h;

        /* renamed from: i  reason: collision with root package name */
        public long f34120i;

        /* renamed from: j  reason: collision with root package name */
        public String f34121j;

        /* renamed from: k  reason: collision with root package name */
        public WifiDetailedStates f34122k;

        private f() {
            this.f34112a = -1;
            this.f34113b = "";
            this.f34114c = "";
            this.f34115d = "";
            this.f34116e = "";
            this.f34117f = "";
            this.f34118g = -1;
            this.f34119h = -1;
            this.f34120i = -1;
            this.f34121j = "";
            this.f34122k = WifiDetailedStates.Unknown;
        }

        public /* synthetic */ f(a1 a1Var, a aVar) {
            this();
        }
    }

    @TargetApi(29)
    private void d(CellInfo cellInfo, com.startapp.networkTest.data.radio.CellInfo cellInfo2, long j2) {
        CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
        cellInfo2.IsRegistered = cellInfoNr.isRegistered();
        cellInfo2.CellNetworkType = CellNetworkTypes.Nr;
        cellInfo2.CellInfoAge = j2 - (cellInfoNr.getTimeStamp() / 1000000);
        CellIdentity a2 = cellInfoNr.getCellIdentity();
        if (a2 instanceof CellIdentityNr) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) a2;
            cellInfo2.Arfcn = cellIdentityNr.getNrarfcn();
            cellInfo2.LtePci = cellIdentityNr.getPci();
            cellInfo2.LteTac = cellIdentityNr.getTac();
            cellInfo2.CellId = cellIdentityNr.getNci();
            if (cellIdentityNr.getMccString() != null) {
                try {
                    cellInfo2.Mcc = Integer.parseInt(cellIdentityNr.getMccString());
                } catch (NumberFormatException e2) {
                    l2.b(e2);
                }
            }
            if (cellIdentityNr.getMncString() != null) {
                try {
                    cellInfo2.Mnc = Integer.parseInt(cellIdentityNr.getMncString());
                } catch (NumberFormatException e3) {
                    l2.b(e3);
                }
            }
        }
        CellSignalStrength a3 = cellInfoNr.getCellSignalStrength();
        if (a3 instanceof CellSignalStrengthNr) {
            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) a3;
            cellInfo2.Dbm = cellSignalStrengthNr.getDbm();
            cellInfo2.NrCsiRsrp = cellSignalStrengthNr.getCsiRsrp();
            cellInfo2.NrCsiRsrq = cellSignalStrengthNr.getCsiRsrq();
            cellInfo2.NrCsiSinr = cellSignalStrengthNr.getCsiSinr();
            cellInfo2.NrSsRsrp = cellSignalStrengthNr.getSsRsrp();
            cellInfo2.NrSsRsrq = cellSignalStrengthNr.getSsRsrq();
            cellInfo2.NrSsSinr = cellSignalStrengthNr.getSsSinr();
        }
    }

    public class n {

        /* renamed from: a  reason: collision with root package name */
        public int f34154a;

        /* renamed from: b  reason: collision with root package name */
        public int f34155b;

        /* renamed from: c  reason: collision with root package name */
        public int f34156c;

        /* renamed from: d  reason: collision with root package name */
        public int f34157d;

        /* renamed from: e  reason: collision with root package name */
        public int f34158e;

        /* renamed from: f  reason: collision with root package name */
        public int f34159f;

        /* renamed from: g  reason: collision with root package name */
        public int f34160g;

        /* renamed from: h  reason: collision with root package name */
        public int f34161h;

        /* renamed from: i  reason: collision with root package name */
        public int f34162i;

        /* renamed from: j  reason: collision with root package name */
        public int f34163j;

        /* renamed from: k  reason: collision with root package name */
        public long f34164k;

        /* renamed from: l  reason: collision with root package name */
        public int f34165l;

        /* renamed from: m  reason: collision with root package name */
        public int f34166m;

        /* renamed from: n  reason: collision with root package name */
        public int f34167n;

        /* renamed from: o  reason: collision with root package name */
        public int f34168o;

        /* renamed from: p  reason: collision with root package name */
        public int f34169p;

        /* renamed from: q  reason: collision with root package name */
        public int f34170q;

        private n() {
            Integer num = RadioInfo.INVALID;
            this.f34154a = num.intValue();
            this.f34155b = num.intValue();
            this.f34156c = num.intValue();
            this.f34157d = num.intValue();
            this.f34158e = num.intValue();
            this.f34159f = num.intValue();
            this.f34160g = num.intValue();
            this.f34161h = num.intValue();
            this.f34162i = num.intValue();
            this.f34163j = num.intValue();
            this.f34165l = num.intValue();
            this.f34166m = num.intValue();
            this.f34167n = num.intValue();
            this.f34168o = num.intValue();
            this.f34169p = num.intValue();
            this.f34170q = num.intValue();
        }

        public /* synthetic */ n(a1 a1Var, a aVar) {
            this();
        }
    }

    public Future<ApnInfo[]> e() {
        return ThreadManager.b().a().submit(new c());
    }

    private void c(Context context) {
        j jVar;
        if (context != null && (jVar = this.f34095q) != null) {
            try {
                context.unregisterReceiver(jVar);
            } catch (Throwable th) {
                l2.a(th);
            }
        }
    }

    private static PreferredNetworkTypes e(int i2) {
        switch (i2) {
            case 0:
                return PreferredNetworkTypes.WCDMA_PREF;
            case 1:
                return PreferredNetworkTypes.GSM_ONLY;
            case 2:
                return PreferredNetworkTypes.WCDMA_ONLY;
            case 3:
                return PreferredNetworkTypes.GSM_UMTS;
            case 4:
                return PreferredNetworkTypes.CDMA;
            case 5:
                return PreferredNetworkTypes.CDMA_NO_EVDO;
            case 6:
                return PreferredNetworkTypes.EVDO_NO_CDMA;
            case 7:
                return PreferredNetworkTypes.GLOBAL;
            case 8:
                return PreferredNetworkTypes.LTE_CDMA_EVDO;
            case 9:
                return PreferredNetworkTypes.LTE_GSM_WCDMA;
            case 10:
                return PreferredNetworkTypes.LTE_CDMA_EVDO_GSM_WCDMA;
            case 11:
                return PreferredNetworkTypes.LTE_ONLY;
            case 12:
                return PreferredNetworkTypes.LTE_WCDMA;
            case 13:
                return PreferredNetworkTypes.TDSCDMA_ONLY;
            case 14:
                return PreferredNetworkTypes.TDSCDMA_WCDMA;
            case 15:
                return PreferredNetworkTypes.LTE_TDSCDMA;
            case 16:
                return PreferredNetworkTypes.TDSCDMA_GSM;
            case 17:
                return PreferredNetworkTypes.LTE_TDSCDMA_GSM;
            case 18:
                return PreferredNetworkTypes.TDSCDMA_GSM_WCDMA;
            case 19:
                return PreferredNetworkTypes.LTE_TDSCDMA_WCDMA;
            case 20:
                return PreferredNetworkTypes.LTE_TDSCDMA_GSM_WCDMA;
            case 21:
                return PreferredNetworkTypes.TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 22:
                return PreferredNetworkTypes.LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 23:
                return PreferredNetworkTypes.NR_ONLY;
            case 24:
                return PreferredNetworkTypes.NR_LTE;
            case 25:
                return PreferredNetworkTypes.NR_LTE_CDMA_EVDO;
            case 26:
                return PreferredNetworkTypes.NR_LTE_GSM_WCDMA;
            case 27:
                return PreferredNetworkTypes.NR_LTE_CDMA_EVDO_GSM_WCDMA;
            case 28:
                return PreferredNetworkTypes.NR_LTE_WCDMA;
            case 29:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA;
            case 30:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_GSM;
            case 31:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_WCDMA;
            case 32:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_GSM_WCDMA;
            case 33:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            default:
                return PreferredNetworkTypes.Unknown;
        }
    }

    @TargetApi(18)
    public com.startapp.networkTest.data.radio.CellInfo[] c() {
        return a(true);
    }

    @TargetApi(17)
    private void c(CellInfo cellInfo, com.startapp.networkTest.data.radio.CellInfo cellInfo2, long j2) {
        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
        cellInfo2.IsRegistered = cellInfoLte.isRegistered();
        cellInfo2.CellNetworkType = CellNetworkTypes.Lte;
        cellInfo2.CellInfoAge = j2 - (cellInfoLte.getTimeStamp() / 1000000);
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            cellInfo2.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            cellInfo2.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCi() != Integer.MAX_VALUE) {
            int ci = cellIdentity.getCi();
            cellInfo2.Cid = ci;
            cellInfo2.CellId = (long) ci;
        }
        if (cellIdentity.getPci() != Integer.MAX_VALUE) {
            cellInfo2.LtePci = cellIdentity.getPci();
        }
        if (cellIdentity.getTac() != Integer.MAX_VALUE) {
            cellInfo2.LteTac = cellIdentity.getTac();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24 && cellIdentity.getEarfcn() != Integer.MAX_VALUE) {
            int a2 = cellIdentity.getEarfcn();
            cellInfo2.Arfcn = a2;
            g1 a3 = LteFrequencyUtil.a(a2);
            if (a3 != null) {
                cellInfo2.LteBand = a3.band;
                cellInfo2.LteUploadEarfcn = a3.upload_earfcn;
                cellInfo2.LteDownloadEarfcn = a3.download_earfcn;
                cellInfo2.LteUploadFrequency = a3.upload_frequency;
                cellInfo2.LteDonwloadFrequency = a3.download_frequency;
            }
        }
        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
        cellInfo2.Dbm = cellSignalStrength.getDbm();
        if (cellSignalStrength.getTimingAdvance() != Integer.MAX_VALUE) {
            cellInfo2.LteTimingAdvance = cellSignalStrength.getTimingAdvance();
        }
        if (i2 >= 29) {
            int a4 = cellSignalStrength.getCqi();
            if (a4 != Integer.MAX_VALUE) {
                cellInfo2.LteCqi = a4;
            }
            cellInfo2.LteRssnr = cellSignalStrength.getRssnr();
            cellInfo2.LteRsrq = cellSignalStrength.getRsrq();
            cellInfo2.LteRssi = cellSignalStrength.getRssi();
            return;
        }
        Field field = this.M;
        if (field != null) {
            try {
                int i3 = field.getInt(cellSignalStrength);
                if (i3 != Integer.MAX_VALUE) {
                    cellInfo2.LteCqi = i3;
                }
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        Field field2 = this.K;
        if (field2 != null) {
            try {
                cellInfo2.LteRsrq = field2.getInt(cellSignalStrength);
            } catch (Throwable th2) {
                l2.a(th2);
            }
        }
        Field field3 = this.L;
        if (field3 != null) {
            try {
                cellInfo2.LteRssnr = field3.getInt(cellSignalStrength);
            } catch (Throwable th3) {
                l2.a(th3);
            }
        }
        Field field4 = this.J;
        if (field4 != null) {
            try {
                cellInfo2.LteRssi = field4.getInt(cellSignalStrength);
            } catch (Throwable th4) {
                l2.a(th4);
            }
        }
    }

    public static NetworkGenerations b(NetworkTypes networkTypes) {
        switch (networkTypes.ordinal()) {
            case 1:
            case 2:
            case 3:
            case 8:
            case 13:
            case 18:
                return NetworkGenerations.Gen2;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 17:
            case 19:
                return NetworkGenerations.Gen3;
            case 14:
            case 15:
                return NetworkGenerations.Gen4;
            case 16:
                return NetworkGenerations.Gen5;
            default:
                return NetworkGenerations.Unknown;
        }
    }

    @TargetApi(17)
    private void a(CellInfo cellInfo, com.startapp.networkTest.data.radio.CellInfo cellInfo2, long j2) {
        CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
        cellInfo2.IsRegistered = cellInfoCdma.isRegistered();
        cellInfo2.CellNetworkType = CellNetworkTypes.Gsm;
        cellInfo2.CellInfoAge = j2 - (cellInfoCdma.getTimeStamp() / 1000000);
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        cellInfo2.CdmaBaseStationLatitude = cellIdentity.getLatitude();
        cellInfo2.CdmaBaseStationLongitude = cellIdentity.getLongitude();
        if (cellIdentity.getSystemId() != Integer.MAX_VALUE) {
            cellInfo2.CdmaSystemId = cellIdentity.getSystemId();
        }
        if (cellIdentity.getNetworkId() != Integer.MAX_VALUE) {
            cellInfo2.CdmaNetworkId = cellIdentity.getNetworkId();
        }
        if (cellIdentity.getBasestationId() != Integer.MAX_VALUE) {
            cellInfo2.CdmaBaseStationId = cellIdentity.getBasestationId();
        }
        CellSignalStrengthCdma cellSignalStrength = cellInfoCdma.getCellSignalStrength();
        cellInfo2.Dbm = cellSignalStrength.getDbm();
        cellInfo2.CdmaDbm = cellSignalStrength.getCdmaDbm();
        cellInfo2.CdmaEcio = cellSignalStrength.getCdmaEcio();
        cellInfo2.EvdoDbm = cellSignalStrength.getEvdoDbm();
        cellInfo2.EvdoEcio = cellSignalStrength.getEvdoEcio();
        cellInfo2.EvdoSnr = cellSignalStrength.getEvdoSnr();
    }

    public void b(c1 c1Var) {
        if (c1Var == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.W.remove(c1Var);
        } else {
            this.f34085g.post(new o2(new e(c1Var)));
        }
    }

    public ConnectionTypes d() {
        NetworkInfo activeNetworkInfo;
        ConnectionTypes connectionTypes = ConnectionTypes.Unknown;
        if (this.f34091m == null || this.f34088j.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (activeNetworkInfo = this.f34091m.getActiveNetworkInfo()) == null) {
            return connectionTypes;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return ConnectionTypes.Mobile;
        }
        if (type == 1) {
            return ConnectionTypes.WiFi;
        }
        if (type == 6) {
            return ConnectionTypes.WiMAX;
        }
        if (type == 7) {
            return ConnectionTypes.Bluetooth;
        }
        if (type != 9) {
            return connectionTypes;
        }
        return ConnectionTypes.Ethernet;
    }

    public q1 b() {
        return this.f34094p;
    }

    public NetworkTypes b(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS")) {
                    return a(networkRegistrationInfo.NetworkTechnology);
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    public static NetworkTypes d(int i2) {
        switch (i2) {
            case 1:
                return NetworkTypes.GPRS;
            case 2:
                return NetworkTypes.EDGE;
            case 3:
                return NetworkTypes.UMTS;
            case 4:
                return NetworkTypes.CDMA;
            case 5:
                return NetworkTypes.EVDO_0;
            case 6:
                return NetworkTypes.EVDO_A;
            case 7:
                return NetworkTypes.Cdma1xRTT;
            case 8:
                return NetworkTypes.HSDPA;
            case 9:
                return NetworkTypes.HSUPA;
            case 10:
                return NetworkTypes.HSPA;
            case 11:
                return NetworkTypes.IDEN;
            case 12:
                return NetworkTypes.EVDO_B;
            case 13:
                return NetworkTypes.LTE;
            case 14:
                return NetworkTypes.EHRPD;
            case 15:
                return NetworkTypes.HSPAP;
            case 16:
                return NetworkTypes.GSM;
            case 17:
                return NetworkTypes.TD_SCDMA;
            case 18:
                return NetworkTypes.WiFi;
            case 19:
                return NetworkTypes.LTE_CA;
            case 20:
                return NetworkTypes.NR;
            default:
                return NetworkTypes.Unknown;
        }
    }

    @TargetApi(21)
    public ApnInfo[] a() {
        l c2;
        ArrayList arrayList = new ArrayList();
        for (f next : q()) {
            ApnInfo apnInfo = new ApnInfo();
            apnInfo.Apn = next.f34113b;
            apnInfo.TxBytes = next.f34119h;
            apnInfo.RxBytes = next.f34120i;
            apnInfo.ApnTypes = next.f34115d;
            apnInfo.Capabilities = next.f34116e;
            apnInfo.SubscriptionId = next.f34118g;
            apnInfo.PcscfAddresses = next.f34117f;
            apnInfo.MobileDataConnectionState = next.f34122k;
            apnInfo.NetworkType = d(next.f34112a);
            apnInfo.Reason = this.f34092n.a(next.f34118g, next.f34115d);
            if (apnInfo.ApnTypes.contains("ims") && (c2 = this.f34092n.c(next.f34118g)) != null) {
                apnInfo.SamsungSipError = c2.f34144a;
                apnInfo.SamsungImsServices = c2.f34145b;
            }
            arrayList.add(apnInfo);
        }
        return (ApnInfo[]) arrayList.toArray(new ApnInfo[arrayList.size()]);
    }

    public ThreeStateShort d(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS") && networkRegistrationInfo.TransportType.equals("WWAN")) {
                    return networkRegistrationInfo.NrAvailable;
                }
            }
        }
        return ThreeStateShort.Unknown;
    }

    public String c(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr == null) {
            return "Unknown";
        }
        for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
            if (networkRegistrationInfo.Domain.equals("PS") && networkRegistrationInfo.TransportType.equals("WWAN")) {
                return networkRegistrationInfo.NrState;
            }
        }
        return "Unknown";
    }

    private boolean a(com.startapp.networkTest.data.radio.CellInfo cellInfo, RadioInfo radioInfo) {
        try {
            if (radioInfo.MCC.isEmpty() || radioInfo.MNC.isEmpty() || !cellInfo.IsRegistered || cellInfo.Mcc != Integer.parseInt(radioInfo.MCC) || cellInfo.Mnc != Integer.parseInt(radioInfo.MNC)) {
                return false;
            }
            NetworkTypes i2 = i(radioInfo.SubscriptionId);
            NetworkTypes networkTypes = NetworkTypes.Unknown;
            if (i2 == networkTypes) {
                i2 = radioInfo.NetworkType;
            }
            if (i2 == networkTypes || cellInfo.CellNetworkType == a(i2)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            l2.b(e2);
            return false;
        }
    }

    public static NetworkTypes a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2039427040:
                if (str.equals("LTE_CA")) {
                    c2 = 0;
                    break;
                }
                break;
            case -908593671:
                if (str.equals("TD_SCDMA")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    c2 = 2;
                    break;
                }
                break;
            case 70881:
                if (str.equals("GSM")) {
                    c2 = 3;
                    break;
                }
                break;
            case 75709:
                if (str.equals("LTE")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2063797:
                if (str.equals("CDMA")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2123197:
                if (str.equals("EDGE")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194666:
                if (str.equals("GPRS")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2227260:
                if (str.equals("HSPA")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2608919:
                if (str.equals("UMTS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 3195620:
                if (str.equals("iDEN")) {
                    c2 = 10;
                    break;
                }
                break;
            case 69034058:
                if (str.equals("HSDPA")) {
                    c2 = 11;
                    break;
                }
                break;
            case 69045140:
                if (str.equals("HSPAP")) {
                    c2 = 12;
                    break;
                }
                break;
            case 69050395:
                if (str.equals("HSUPA")) {
                    c2 = 13;
                    break;
                }
                break;
            case 70083979:
                if (str.equals("IWLAN")) {
                    c2 = 14;
                    break;
                }
                break;
            case 836263277:
                if (str.equals("CDMA - 1xRTT")) {
                    c2 = 15;
                    break;
                }
                break;
            case 882856261:
                if (str.equals("CDMA - eHRPD")) {
                    c2 = 16;
                    break;
                }
                break;
            case 893165057:
                if (str.equals("CDMA - EvDo rev. 0")) {
                    c2 = 17;
                    break;
                }
                break;
            case 893165074:
                if (str.equals("CDMA - EvDo rev. A")) {
                    c2 = 18;
                    break;
                }
                break;
            case 893165075:
                if (str.equals("CDMA - EvDo rev. B")) {
                    c2 = 19;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return NetworkTypes.LTE_CA;
            case 1:
                return NetworkTypes.TD_SCDMA;
            case 2:
                return NetworkTypes.NR;
            case 3:
                return NetworkTypes.GSM;
            case 4:
                return NetworkTypes.LTE;
            case 5:
                return NetworkTypes.CDMA;
            case 6:
                return NetworkTypes.EDGE;
            case 7:
                return NetworkTypes.GPRS;
            case 8:
                return NetworkTypes.HSPA;
            case 9:
                return NetworkTypes.UMTS;
            case 10:
                return NetworkTypes.IDEN;
            case 11:
                return NetworkTypes.HSDPA;
            case 12:
                return NetworkTypes.HSPAP;
            case 13:
                return NetworkTypes.HSUPA;
            case 14:
                return NetworkTypes.WiFi;
            case 15:
                return NetworkTypes.Cdma1xRTT;
            case 16:
                return NetworkTypes.EHRPD;
            case 17:
                return NetworkTypes.EVDO_0;
            case 18:
                return NetworkTypes.EVDO_A;
            case 19:
                return NetworkTypes.EVDO_B;
            default:
                return NetworkTypes.Unknown;
        }
    }

    private static CellNetworkTypes a(NetworkTypes networkTypes) {
        if (networkTypes == NetworkTypes.CDMA) {
            return CellNetworkTypes.Cdma;
        }
        int ordinal = b(networkTypes).ordinal();
        if (ordinal == 0) {
            return CellNetworkTypes.Gsm;
        }
        if (ordinal == 1) {
            return CellNetworkTypes.Wcdma;
        }
        if (ordinal == 2) {
            return CellNetworkTypes.Lte;
        }
        if (ordinal != 3) {
            return CellNetworkTypes.Unknown;
        }
        return CellNetworkTypes.Nr;
    }

    public static SignalStrengths a(RadioInfo radioInfo) {
        int i2;
        if (radioInfo == null) {
            return SignalStrengths.Unknown;
        }
        int i3 = radioInfo.RXLevel;
        NetworkGenerations b2 = b(radioInfo.NetworkType);
        NetworkGenerations networkGenerations = NetworkGenerations.Gen5;
        if (b2 == networkGenerations && (i2 = radioInfo.NrCsiRsrp) < -1) {
            i3 = i2;
        }
        if (i3 == 0) {
            return SignalStrengths.Unknown;
        }
        u0 b3 = w0.b();
        int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G = b3.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G();
        int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G = b3.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G();
        int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G = b3.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G();
        int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G = b3.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G();
        if (b2 == NetworkGenerations.Gen2) {
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G[0]) {
                return SignalStrengths.Excellent;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G[1]) {
                return SignalStrengths.Good;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G[2]) {
                return SignalStrengths.Fair;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G[3]) {
                return SignalStrengths.Poor;
            }
            return SignalStrengths.Bad;
        } else if (b2 == NetworkGenerations.Gen3) {
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G[0]) {
                return SignalStrengths.Excellent;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G[1]) {
                return SignalStrengths.Good;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G[2]) {
                return SignalStrengths.Fair;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G[3]) {
                return SignalStrengths.Poor;
            }
            return SignalStrengths.Bad;
        } else if (b2 == NetworkGenerations.Gen4) {
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G[0]) {
                return SignalStrengths.Excellent;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G[1]) {
                return SignalStrengths.Good;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G[2]) {
                return SignalStrengths.Fair;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G[3]) {
                return SignalStrengths.Poor;
            }
            return SignalStrengths.Bad;
        } else if (b2 != networkGenerations) {
            return SignalStrengths.Unknown;
        } else {
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G[0]) {
                return SignalStrengths.Excellent;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G[1]) {
                return SignalStrengths.Good;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G[2]) {
                return SignalStrengths.Fair;
            }
            if (i3 >= STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G[3]) {
                return SignalStrengths.Poor;
            }
            return SignalStrengths.Bad;
        }
    }

    public NetworkRegistrationInfo[] g(int i2) {
        NetworkRegistrationInfo[] b2 = this.f34092n.b(i2);
        if (b2 == null) {
            return new NetworkRegistrationInfo[0];
        }
        m d2 = this.f34092n.d(i2);
        for (NetworkRegistrationInfo networkRegistrationInfo : b2) {
            if (d2 != null && d2.f34148b > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - d2.f34148b;
                networkRegistrationInfo.Age = elapsedRealtime > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime;
            }
        }
        return b2;
    }

    private PreferredNetworkTypes a(Context context, int i2) {
        PreferredNetworkTypes preferredNetworkTypes = PreferredNetworkTypes.Unknown;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return e(Settings.Global.getInt(contentResolver, "preferred_network_mode" + i2));
        } catch (Throwable th) {
            l2.a(th);
            return preferredNetworkTypes;
        }
    }

    private SparseArray<PreferredNetworkTypes> a(Context context) {
        SparseArray<PreferredNetworkTypes> sparseArray = new SparseArray<>();
        try {
            String[] split = Settings.Global.getString(context.getContentResolver(), "preferred_network_mode").split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                sparseArray.put(i2, e(Integer.valueOf(split[i2]).intValue()));
            }
        } catch (Throwable th) {
            l2.a(th);
        }
        return sparseArray;
    }

    public void a(c1 c1Var) {
        if (c1Var == null) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f34085g.post(new o2(new d(c1Var)));
        } else if (!this.W.contains(c1Var)) {
            this.W.add(c1Var);
        }
    }

    public ThreeStateShort a(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS")) {
                    return networkRegistrationInfo.CarrierAggregation;
                }
            }
        }
        return ThreeStateShort.Unknown;
    }
}
