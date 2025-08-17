package com.facebook.ads.internal.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.c.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final String f19647e = "f";

    /* renamed from: f  reason: collision with root package name */
    private final Uri f19648f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f19649g;

    public f(Context context, c cVar, String str, Uri uri, Map<String, String> map, l lVar) {
        super(context, cVar, str, lVar);
        this.f19648f = uri;
        this.f19649g = map;
    }

    private Intent a(g gVar) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(gVar.a()) && !TextUtils.isEmpty(gVar.b())) {
            intent.setComponent(new ComponentName(gVar.a(), gVar.b()));
        }
        if (!TextUtils.isEmpty(gVar.c())) {
            intent.setData(Uri.parse(gVar.c()));
        }
        return intent;
    }

    private Intent b(g gVar) {
        if (TextUtils.isEmpty(gVar.a()) || !e.a(this.f19639a, gVar.a())) {
            return null;
        }
        String c2 = gVar.c();
        if (!TextUtils.isEmpty(c2) && (c2.startsWith("tel:") || c2.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c2));
        }
        PackageManager packageManager = this.f19639a.getPackageManager();
        if (TextUtils.isEmpty(gVar.b()) && TextUtils.isEmpty(c2)) {
            return packageManager.getLaunchIntentForPackage(gVar.a());
        }
        Intent a2 = a(gVar);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a2, 65536);
        if (a2.getComponent() == null) {
            Iterator<ResolveInfo> it2 = queryIntentActivities.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ResolveInfo next = it2.next();
                if (next.activityInfo.packageName.equals(gVar.a())) {
                    ActivityInfo activityInfo = next.activityInfo;
                    a2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                    break;
                }
            }
        }
        if (queryIntentActivities.isEmpty() || a2.getComponent() == null) {
            return null;
        }
        return a2;
    }

    private List<g> f() {
        String queryParameter = this.f19648f.getQueryParameter("appsite_data");
        if (TextUtils.isEmpty(queryParameter) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    g a2 = g.a(optJSONArray.optJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
        } catch (JSONException e2) {
            Log.w(f19647e, "Error parsing appsite_data", e2);
        }
        return arrayList;
    }

    private boolean g() {
        List<Intent> d2 = d();
        if (d2 == null) {
            return false;
        }
        for (Intent startActivity : d2) {
            try {
                this.f19639a.startActivity(startActivity);
                return true;
            } catch (Exception e2) {
                Log.d(f19647e, "Failed to open app intent, falling back", e2);
            }
        }
        return false;
    }

    private boolean h() {
        g gVar = new g();
        try {
            g.a(gVar, this.f19639a, c(), this.f19641c);
            return true;
        } catch (Exception e2) {
            String str = f19647e;
            Log.d(str, "Failed to open market url: " + this.f19648f.toString(), e2);
            String queryParameter = this.f19648f.getQueryParameter("store_url_web_fallback");
            if (queryParameter == null || queryParameter.length() <= 0) {
                return false;
            }
            g.a(gVar, this.f19639a, Uri.parse(queryParameter), this.f19641c);
            return false;
        }
    }

    public a.C0033a a() {
        return a.C0033a.OPEN_STORE;
    }

    /* access modifiers changed from: protected */
    public Uri c() {
        String queryParameter = this.f19648f.getQueryParameter("store_url");
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        return Uri.parse(String.format("market://details?id=%s", new Object[]{this.f19648f.getQueryParameter(AppLovinEventParameters.IN_APP_PURCHASE_TRANSACTION_IDENTIFIER)}));
    }

    /* access modifiers changed from: protected */
    public List<Intent> d() {
        List<g> f2 = f();
        ArrayList arrayList = new ArrayList();
        if (f2 != null) {
            for (g b2 : f2) {
                Intent b3 = b(b2);
                if (b3 != null) {
                    arrayList.add(b3);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a aVar = null;
        String str = "opened_deeplink";
        if (!g()) {
            try {
                str = h() ? "opened_store_url" : "opened_store_fallback_url";
            } catch (Exception unused) {
                Log.d(f19647e, "Failed to open all options including fallback url, can't open anything");
                aVar = a.CANNOT_OPEN;
            }
        }
        this.f19649g.put(str, String.valueOf(true));
        a(this.f19649g, aVar);
    }
}
