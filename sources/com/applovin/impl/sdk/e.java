package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class e implements AppLovinCommunicatorSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private final m f15323a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f15324b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashMap<String, Bundle> f15325c = new LinkedHashMap<String, Bundle>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final Set<a> f15326d = Collections.synchronizedSet(new HashSet());

    public interface a {
        void onCreativeIdGenerated(String str, String str2);
    }

    public e(m mVar) {
        this.f15323a = mVar;
        AppLovinCommunicator.getInstance(mVar.L()).subscribe((AppLovinCommunicatorSubscriber) this, "safedk_ad_info");
    }

    public static String a() {
        return d(MobileAdsBridge.versionMethodName);
    }

    public static String b() {
        return d("getSdkKey");
    }

    private static String d(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("com.applovin.quality.AppLovinQualityService");
        } catch (Throwable unused) {
            return "";
        }
        return (String) cls.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return BundleUtils.getString("ad_review_creative_id", b(str));
    }

    public void a(a aVar) {
        this.f15326d.add(aVar);
    }

    public Bundle b(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f15324b) {
            bundle = this.f15325c.get(str);
        }
        return bundle;
    }

    public void b(a aVar) {
        this.f15326d.remove(aVar);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f15324b) {
                this.f15325c.remove(str);
            }
        }
    }

    public String getCommunicatorId() {
        return e.class.getSimpleName();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle != null) {
                Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
                if (bundle2 == null) {
                    if (v.a()) {
                        this.f15323a.A().d("AppLovinSdk", "Received SafeDK ad info without private data");
                    }
                } else if (MaxAdFormat.formatFromString(bundle2.getString("ad_format")) != null) {
                    final String string = bundle2.getString("id");
                    if (!TextUtils.isEmpty(string)) {
                        synchronized (this.f15324b) {
                            v A = this.f15323a.A();
                            A.b("AppLovinSdk", "Storing current SafeDK ad info for serve id: " + string);
                            this.f15325c.put(string, bundle);
                        }
                        final String string2 = bundle.getString("ad_review_creative_id");
                        if (StringUtils.isValidString(string2) && !this.f15326d.isEmpty()) {
                            Iterator it2 = new HashSet(this.f15326d).iterator();
                            while (it2.hasNext()) {
                                final a aVar = (a) it2.next();
                                this.f15323a.S().a((a) new z(this.f15323a, new Runnable() {
                                    public void run() {
                                        aVar.onCreativeIdGenerated(string, string2);
                                    }
                                }), o.a.BACKGROUND);
                            }
                        }
                    } else if (v.a()) {
                        this.f15323a.A().d("AppLovinSdk", "Received SafeDK ad info without serve id");
                    }
                } else if (v.a()) {
                    this.f15323a.A().d("AppLovinSdk", "Received SafeDK ad info without ad format");
                }
            } else if (v.a()) {
                this.f15323a.A().d("AppLovinSdk", "Received SafeDK ad info without public data");
            }
        }
    }
}
