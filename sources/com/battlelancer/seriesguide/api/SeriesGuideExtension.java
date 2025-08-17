package com.battlelancer.seriesguide.api;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.JobIntentService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class SeriesGuideExtension extends JobIntentService {

    /* renamed from: k  reason: collision with root package name */
    private final String f16090k;

    /* renamed from: l  reason: collision with root package name */
    private SharedPreferences f16091l;

    /* renamed from: m  reason: collision with root package name */
    private Map<ComponentName, String> f16092m;

    /* renamed from: n  reason: collision with root package name */
    private Action f16093n;

    /* renamed from: o  reason: collision with root package name */
    private int f16094o;

    /* renamed from: p  reason: collision with root package name */
    private int f16095p;

    /* renamed from: q  reason: collision with root package name */
    private Handler f16096q = new Handler();

    public SeriesGuideExtension(String str) {
        this.f16090k = str;
    }

    private synchronized void C() {
        for (ComponentName D : this.f16092m.keySet()) {
            D(D);
        }
    }

    @SuppressLint({"LogNotTimber"})
    private synchronized void D(ComponentName componentName) {
        Bundle bundle;
        String str = this.f16092m.get(componentName);
        if (TextUtils.isEmpty(str)) {
            Log.w("SeriesGuideExtension", "Not active, canceling update, id=" + this.f16090k);
            return;
        }
        Intent putExtra = new Intent("com.battlelancer.seriesguide.api.action.PUBLISH_ACTION").setComponent(componentName).putExtra("com.battlelancer.seriesguide.api.extra.TOKEN", str);
        Action action = this.f16093n;
        if (action != null) {
            bundle = action.b();
        } else {
            bundle = null;
        }
        Intent putExtra2 = putExtra.putExtra("com.battlelancer.seriesguide.api.extra.ACTION", bundle).putExtra("com.battlelancer.seriesguide.api.extra.ACTION_TYPE", this.f16094o);
        int i2 = this.f16095p;
        if (i2 == 2) {
            try {
                getPackageManager().getReceiverInfo(componentName, 0);
                sendBroadcast(putExtra2);
            } catch (PackageManager.NameNotFoundException unused) {
                G(componentName);
                return;
            }
        } else if (i2 == 1) {
            if (Build.VERSION.SDK_INT < 26) {
                try {
                    if (startService(putExtra2) == null) {
                        G(componentName);
                    }
                } catch (SecurityException e2) {
                    Log.e("SeriesGuideExtension", "Couldn't publish update, id=" + this.f16090k, e2);
                }
            }
        }
        return;
    }

    @SuppressLint({"LogNotTimber"})
    private void E() {
        try {
            this.f16091l.edit().putString("action", this.f16093n.c().toString()).apply();
        } catch (JSONException e2) {
            Log.e("SeriesGuideExtension", "Couldn't serialize current state, id=" + this.f16090k, e2);
        }
    }

    private synchronized void F() {
        HashSet hashSet = new HashSet();
        for (ComponentName next : this.f16092m.keySet()) {
            hashSet.add(next.flattenToShortString() + "|" + this.f16092m.get(next));
        }
        this.f16091l.edit().putStringSet("subscriptions", hashSet).apply();
    }

    @SuppressLint({"LogNotTimber"})
    private void G(final ComponentName componentName) {
        Log.e("SeriesGuideExtension", "Update not published because subscriber no longer exists, id=" + this.f16090k);
        this.f16096q.post(new Runnable() {
            public void run() {
                SeriesGuideExtension.this.p(componentName, (String) null);
            }
        });
    }

    static void k(Context context, Class cls, int i2, Intent intent) {
        JobIntentService.d(context, cls, i2, intent);
    }

    protected static SharedPreferences m(Context context, String str) {
        return context.getSharedPreferences("seriesguideextension_" + str, 0);
    }

    private void n(int i2, Bundle bundle, int i3) {
        if (i2 > 0 && bundle != null) {
            this.f16094o = 0;
            this.f16095p = i3;
            x(i2, Episode.k(bundle));
        }
    }

    private void o(int i2, Bundle bundle, int i3) {
        if (i2 > 0 && bundle != null) {
            this.f16094o = 1;
            this.f16095p = i3;
            y(i2, Movie.e(bundle));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"LogNotTimber"})
    public synchronized void p(ComponentName componentName, String str) {
        if (componentName == null) {
            Log.w("SeriesGuideExtension", "No subscriber given.");
            return;
        }
        String str2 = this.f16092m.get(componentName);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f16092m.remove(componentName);
                r(componentName);
            }
            if (u(componentName)) {
                this.f16092m.put(componentName, str);
                q(componentName);
            } else {
                return;
            }
        } else if (str2 != null) {
            this.f16092m.remove(componentName);
            r(componentName);
        } else {
            return;
        }
        F();
    }

    private synchronized void q(ComponentName componentName) {
        if (this.f16092m.size() == 1) {
            w();
        }
        z(componentName);
    }

    private synchronized void r(ComponentName componentName) {
        A(componentName);
        if (this.f16092m.size() == 0) {
            v();
        }
    }

    @SuppressLint({"LogNotTimber"})
    private void s() {
        String string = this.f16091l.getString("action", (String) null);
        if (string != null) {
            try {
                this.f16093n = Action.a((JSONObject) new JSONTokener(string).nextValue());
            } catch (JSONException e2) {
                Log.e("SeriesGuideExtension", "Couldn't deserialize current state, id=" + this.f16090k, e2);
            }
        } else {
            this.f16093n = null;
        }
    }

    private synchronized void t() {
        this.f16092m = new HashMap();
        Set<String> stringSet = this.f16091l.getStringSet("subscriptions", (Set) null);
        if (stringSet != null) {
            for (String split : stringSet) {
                String[] split2 = split.split("\\|", 2);
                this.f16092m.put(ComponentName.unflattenFromString(split2[0]), split2[1]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void A(ComponentName componentName) {
    }

    /* access modifiers changed from: protected */
    public final void B(Action action) {
        this.f16093n = action;
        C();
        E();
    }

    /* access modifiers changed from: protected */
    public void g(Intent intent) {
        String action = intent.getAction();
        if ("com.battlelancer.seriesguide.api.action.SUBSCRIBE".equals(action)) {
            p((ComponentName) intent.getParcelableExtra("com.battlelancer.seriesguide.api.extra.SUBSCRIBER_COMPONENT"), intent.getStringExtra("com.battlelancer.seriesguide.api.extra.TOKEN"));
        } else if ("com.battlelancer.seriesguide.api.action.UPDATE".equals(action) && intent.hasExtra("com.battlelancer.seriesguide.api.extra.ENTITY_IDENTIFIER")) {
            int intExtra = intent.getIntExtra("com.battlelancer.seriesguide.api.extra.VERSION", 1);
            if (intent.hasExtra("com.battlelancer.seriesguide.api.extra.EPISODE")) {
                n(intent.getIntExtra("com.battlelancer.seriesguide.api.extra.ENTITY_IDENTIFIER", 0), intent.getBundleExtra("com.battlelancer.seriesguide.api.extra.EPISODE"), intExtra);
            } else if (intent.hasExtra("com.battlelancer.seriesguide.api.extra.MOVIE")) {
                o(intent.getIntExtra("com.battlelancer.seriesguide.api.extra.ENTITY_IDENTIFIER", 0), intent.getBundleExtra("com.battlelancer.seriesguide.api.extra.MOVIE"), intExtra);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences l() {
        return m(this, this.f16090k);
    }

    public void onCreate() {
        super.onCreate();
        this.f16091l = l();
        t();
        s();
    }

    /* access modifiers changed from: protected */
    public boolean u(ComponentName componentName) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    /* access modifiers changed from: protected */
    public void w() {
    }

    /* access modifiers changed from: protected */
    public void x(int i2, Episode episode) {
    }

    /* access modifiers changed from: protected */
    public void y(int i2, Movie movie) {
    }

    /* access modifiers changed from: protected */
    public void z(ComponentName componentName) {
    }
}
