package com.startapp;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyDataConfig;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyMetadata;
import com.startapp.x6;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class rd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35795a;

    /* renamed from: b  reason: collision with root package name */
    public final va f35796b;

    /* renamed from: c  reason: collision with root package name */
    public final x6 f35797c;

    /* renamed from: d  reason: collision with root package name */
    public final ua<TelephonyMetadata> f35798d;

    /* renamed from: e  reason: collision with root package name */
    public c f35799e;

    /* renamed from: f  reason: collision with root package name */
    public final double f35800f = Math.random();

    /* renamed from: g  reason: collision with root package name */
    public volatile String f35801g = "e106";

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            rd rdVar = rd.this;
            rdVar.getClass();
            try {
                if (rdVar.a() != null) {
                    c a2 = rdVar.a((Class<?>) SignalStrength.class);
                    if (a2 != null) {
                        a2.a();
                    }
                }
            } catch (Throwable th) {
                if (rdVar.a(8)) {
                    y8.a(rdVar.f35795a, th);
                }
            }
        }
    }

    public class b extends c {

        /* renamed from: d  reason: collision with root package name */
        public final TelephonyCallback f35803d = new a();

        public class a extends TelephonyCallback implements TelephonyCallback.ServiceStateListener, TelephonyCallback.SignalStrengthsListener {
            public a() {
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                b.this.a(ServiceState.class, serviceState);
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                rd.this.a(signalStrength);
                b.this.a(SignalStrength.class, signalStrength);
            }
        }

        public b(TelephonyManager telephonyManager, Class<?> cls) {
            super(telephonyManager, cls);
        }

        public void a() {
            this.f35806a.registerTelephonyCallback(rd.this.f35796b, this.f35803d);
        }

        public void b() {
            this.f35806a.unregisterTelephonyCallback(this.f35803d);
        }
    }

    public abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final TelephonyManager f35806a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f35807b;

        public c(TelephonyManager telephonyManager, Class<?> cls) {
            this.f35806a = telephonyManager;
            this.f35807b = cls;
        }

        public abstract void a();

        public <T> void a(Class<T> cls, T t2) {
            rd rdVar = rd.this;
            rdVar.getClass();
            try {
                TelephonyMetadata a2 = rdVar.a();
                if (a2 != null) {
                    if (t2 != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String simpleName = cls.getSimpleName();
                        if (a2.a(simpleName).c()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("timestamp", currentTimeMillis);
                            jSONObject.put("type", simpleName);
                            jSONObject.put("data", t2.toString());
                            String c2 = lb.c(jSONObject.toString());
                            x6.a a3 = rdVar.f35797c.edit();
                            a3.a(simpleName, c2);
                            a3.f36915a.putString(simpleName, c2);
                            a3.apply();
                        }
                    }
                }
            } catch (Throwable th) {
                if (rdVar.a(2)) {
                    y8.a(rdVar.f35795a, th);
                }
            }
            if (cls.equals(this.f35807b)) {
                try {
                    b();
                } catch (Throwable th2) {
                    if (rd.this.a(16)) {
                        y8.a(rd.this.f35795a, th2);
                    }
                }
            }
        }

        public abstract void b();
    }

    public class d extends c {

        /* renamed from: d  reason: collision with root package name */
        public final PhoneStateListener f35809d = new a();

        public class a extends PhoneStateListener {
            public a() {
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                d.this.a(ServiceState.class, serviceState);
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                rd.this.a(signalStrength);
                d.this.a(SignalStrength.class, signalStrength);
            }
        }

        public d(TelephonyManager telephonyManager, Class<?> cls) {
            super(telephonyManager, cls);
        }

        public void a() {
            this.f35806a.listen(this.f35809d, 257);
        }

        public void b() {
            this.f35806a.listen(this.f35809d, 0);
        }
    }

    public rd(Context context, va vaVar, x6 x6Var, ua<TelephonyMetadata> uaVar) {
        this.f35795a = context;
        this.f35796b = vaVar;
        this.f35797c = x6Var;
        this.f35798d = uaVar;
    }

    public final c a(Class<?> cls) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f35795a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return new d(telephonyManager, cls);
        }
        return new b(telephonyManager, cls);
    }

    public void b() {
        this.f35796b.execute(new a());
    }

    public final TelephonyMetadata a() {
        TelephonyMetadata call = this.f35798d.call();
        if (call == null || !call.c()) {
            return null;
        }
        return call;
    }

    public boolean a(int i2) {
        TelephonyMetadata a2 = a();
        if (a2 == null || this.f35800f >= a2.b() || (a2.a() & i2) != i2) {
            return false;
        }
        return true;
    }

    public void a(SignalStrength signalStrength) {
        if (signalStrength != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f35801g = String.valueOf(signalStrength.getLevel());
                } else {
                    this.f35801g = String.valueOf(SignalStrength.class.getMethod("getLevel", new Class[0]).invoke(signalStrength, new Object[0]));
                }
            } catch (NoSuchMethodException unused) {
                this.f35801g = "e104";
            } catch (Throwable unused2) {
                this.f35801g = "e105";
            }
        }
    }

    public Map<String, String> a(z8 z8Var) {
        List<String> a2;
        TelephonyMetadata a3 = a();
        if (a3 == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = null;
        for (Map.Entry next : this.f35797c.getAll().entrySet()) {
            Object value = next.getValue();
            if (value instanceof String) {
                String str = (String) next.getKey();
                TelephonyDataConfig a4 = a3.a(str);
                if (a4.c() && (a2 = a4.a()) != null && a2.contains(z8Var.f37008o)) {
                    String b2 = a4.b();
                    if (b2 != null) {
                        str = b2;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(str, (String) value);
                }
            }
        }
        return hashMap == null ? Collections.emptyMap() : hashMap;
    }
}
