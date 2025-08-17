package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdSize;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final TreeMap<String, String> f14460a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f14461b;

    /* renamed from: c  reason: collision with root package name */
    private static JSONArray f14462c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f14463d = new Object();

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        f14460a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "BidMachine");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", "Criteo");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        f14461b = new ArrayList(treeMap.keySet());
    }

    public static o.a a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? o.a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? o.a.MEDIATION_INCENTIVIZED : maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL ? o.a.MEDIATION_REWARDED_INTERSTITIAL : o.a.MEDIATION_BANNER;
    }

    public static AppLovinSdkUtils.Size a(int i2, MaxAdFormat maxAdFormat, Context context) {
        if (i2 < 0) {
            try {
                Display defaultDisplay = (context instanceof Activity ? ((Activity) context).getWindowManager() : (WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i2 = AppLovinSdkUtils.pxToDp(context, displayMetrics.widthPixels);
            } catch (Throwable unused) {
                return maxAdFormat.getSize();
            }
        }
        Class<AdSize> cls = AdSize.class;
        int i3 = AdSize.FULL_WIDTH;
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", new Class[]{Context.class, Integer.TYPE});
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object invoke = method.invoke((Object) null, new Object[]{context, Integer.valueOf(i2)});
        return new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, new Object[0])).intValue(), ((Integer) method3.invoke(invoke, new Object[0])).intValue());
    }

    public static JSONArray a(m mVar) {
        if (f14462c != null) {
            b(mVar);
            return f14462c;
        }
        f14462c = new JSONArray();
        for (String next : f14461b) {
            MaxAdapter b2 = b(next, mVar);
            if (b2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", f14460a.get(next));
                    jSONObject.put("class", next);
                    jSONObject.put("sdk_version", b2.getSdkVersion());
                    jSONObject.put(MediationMetaData.KEY_VERSION, b2.getAdapterVersion());
                } catch (Throwable unused) {
                }
                synchronized (f14463d) {
                    f14462c.put(jSONObject);
                }
            }
        }
        return f14462c;
    }

    public static JSONObject a(String str, m mVar) {
        JSONArray a2 = a(mVar);
        for (int i2 = 0; i2 < a2.length(); i2++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(a2, i2, (JSONObject) null);
            if (jSONObject != null && str.equals(JsonUtils.getString(jSONObject, "class", (String) null))) {
                return jSONObject;
            }
        }
        return null;
    }

    public static boolean a(Object obj) {
        return (obj instanceof e) && StringUtils.isValidString(((e) obj).N());
    }

    public static MaxAdapter b(String str, m mVar) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        if (TextUtils.isEmpty(str)) {
            if (v.a()) {
                mVar.A().e("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return (MaxAdapter) cls2.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{mVar.Y()});
            }
            if (v.a()) {
                v A = mVar.A();
                A.e("AppLovinSdk", str + " error: not an instance of '" + cls.getName() + "'.");
            }
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            if (v.a()) {
                v A2 = mVar.A();
                A2.b("AppLovinSdk", "Failed to load: " + str, th);
            }
        }
    }

    private static void b(m mVar) {
        MaxAdapter b2;
        for (int i2 = 0; i2 < f14462c.length(); i2++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(f14462c, i2, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, "class", "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (b2 = b(string, mVar)) != null) {
                String sdkVersion = b2.getSdkVersion();
                if (StringUtils.isValidString(sdkVersion)) {
                    synchronized (f14463d) {
                        JsonUtils.putString(jSONObject, "sdk_version", sdkVersion);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static boolean b(Object obj) {
        return (obj instanceof a) && "APPLOVIN".equals(((a) obj).M());
    }
}
