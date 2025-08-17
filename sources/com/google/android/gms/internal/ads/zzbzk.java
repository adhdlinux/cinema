package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbzk {
    public static final Handler zza = new zzfmd(Looper.getMainLooper());
    private static final String zzb = AdView.class.getName();
    private static final String zzc = InterstitialAd.class.getName();
    private static final String zzd = AdManagerAdView.class.getName();
    private static final String zze = AdManagerInterstitialAd.class.getName();
    private static final String zzf = SearchAdView.class.getName();
    private static final String zzg = AdLoader.class.getName();
    private float zzh = -1.0f;

    private final JSONArray zzA(Collection collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zzB : collection) {
            zzB(jSONArray, zzB);
        }
        return jSONArray;
    }

    private final void zzB(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzi((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zzA((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zzg((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zzC(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Boolean[] boolArr;
        Long[] lArr;
        Double[] dArr;
        Integer[] numArr;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzt)).booleanValue()) {
            str = String.valueOf(str);
        }
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzh((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzi((Map) obj));
        } else if (obj instanceof Collection) {
            jSONObject.put(String.valueOf(str), zzA((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zzA(Arrays.asList((Object[]) obj)));
        } else {
            int i2 = 0;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr == null) {
                    numArr = new Integer[0];
                } else {
                    int length = iArr.length;
                    Integer[] numArr2 = new Integer[length];
                    while (i2 < length) {
                        numArr2[i2] = Integer.valueOf(iArr[i2]);
                        i2++;
                    }
                    numArr = numArr2;
                }
                jSONObject.put(str, zzg(numArr));
            } else if (obj instanceof double[]) {
                double[] dArr2 = (double[]) obj;
                if (dArr2 == null) {
                    dArr = new Double[0];
                } else {
                    int length2 = dArr2.length;
                    Double[] dArr3 = new Double[length2];
                    while (i2 < length2) {
                        dArr3[i2] = Double.valueOf(dArr2[i2]);
                        i2++;
                    }
                    dArr = dArr3;
                }
                jSONObject.put(str, zzg(dArr));
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                if (jArr == null) {
                    lArr = new Long[0];
                } else {
                    int length3 = jArr.length;
                    Long[] lArr2 = new Long[length3];
                    while (i2 < length3) {
                        lArr2[i2] = Long.valueOf(jArr[i2]);
                        i2++;
                    }
                    lArr = lArr2;
                }
                jSONObject.put(str, zzg(lArr));
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null) {
                    boolArr = new Boolean[0];
                } else {
                    int length4 = zArr.length;
                    Boolean[] boolArr2 = new Boolean[length4];
                    while (i2 < length4) {
                        boolArr2[i2] = Boolean.valueOf(zArr[i2]);
                        i2++;
                    }
                    boolArr = boolArr2;
                }
                jSONObject.put(str, zzg(boolArr));
            } else {
                jSONObject.put(str, obj);
            }
        }
    }

    private static final void zzD(ViewGroup viewGroup, zzq zzq, String str, int i2, int i3) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i2);
            textView.setBackgroundColor(i3);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i2);
            int zzx = zzx(context, 3);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(zzq.zzf - zzx, zzq.zzc - zzx, 17));
            viewGroup.addView(frameLayout, zzq.zzf, zzq.zzc);
        }
    }

    public static int zza(Context context, int i2) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i3 = configuration.orientation;
        if (i2 == 0) {
            i2 = i3;
        }
        if (i2 == i3) {
            return Math.round(((float) displayMetrics.heightPixels) / displayMetrics.density);
        }
        return Math.round(((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    public static AdSize zzc(Context context, int i2, int i3, int i4) {
        int i5;
        int zza2 = zza(context, i4);
        if (zza2 == -1) {
            return AdSize.INVALID;
        }
        int min = Math.min(90, Math.round(((float) zza2) * 0.15f));
        if (i2 > 655) {
            i5 = Math.round((((float) i2) / 728.0f) * 90.0f);
        } else if (i2 > 632) {
            i5 = 81;
        } else if (i2 > 526) {
            i5 = Math.round((((float) i2) / 468.0f) * 60.0f);
        } else if (i2 > 432) {
            i5 = 68;
        } else {
            i5 = Math.round((((float) i2) / 320.0f) * 50.0f);
        }
        return new AdSize(i2, Math.max(Math.min(i5, min), 50));
    }

    public static String zzd() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return bigInteger;
    }

    public static String zze(String str) {
        return zzz(str, "MD5");
    }

    public static String zzf(String str) {
        return zzz(str, "SHA-256");
    }

    public static boolean zzo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith((String) zzbdn.zzd.zze());
    }

    public static final int zzp(DisplayMetrics displayMetrics, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, displayMetrics);
    }

    public static final String zzq(StackTraceElement[] stackTraceElementArr, String str) {
        int i2;
        String str2;
        int i3 = 0;
        while (true) {
            i2 = i3 + 1;
            if (i2 >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            String className = stackTraceElement.getClassName();
            if (!"loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) || (!zzb.equalsIgnoreCase(className) && !zzc.equalsIgnoreCase(className) && !zzd.equalsIgnoreCase(className) && !zze.equalsIgnoreCase(className) && !zzf.equalsIgnoreCase(className) && !zzg.equalsIgnoreCase(className))) {
                i3 = i2;
            }
        }
        str2 = stackTraceElementArr[i2].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                for (int i4 = 2; i4 > 0 && stringTokenizer.hasMoreElements(); i4--) {
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                }
                str = sb.toString();
            }
            if (str2 == null || str2.contains(str)) {
                return null;
            }
            return str2;
        }
        return null;
    }

    public static final boolean zzr() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator")) {
            return true;
        }
        return false;
    }

    public static final boolean zzs(Context context, int i2) {
        if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i2) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean zzt(Context context) {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
            return true;
        }
        return false;
    }

    public static final boolean zzu() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final int zzv(DisplayMetrics displayMetrics, int i2) {
        return Math.round(((float) i2) / displayMetrics.density);
    }

    public static final void zzw(Context context, String str, String str2, Bundle bundle, boolean z2, zzbzj zzbzj) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            str = GoogleApiAvailabilityLight.getInstance().getApkVersion(context) + ".232400000";
        }
        bundle.putString("js", str);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(UriUtil.HTTPS_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps");
        for (String next : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(next, bundle.getString(next));
        }
        zzbzj.zza(appendQueryParameter.toString());
    }

    public static final int zzx(Context context, int i2) {
        return zzp(context.getResources().getDisplayMetrics(), i2);
    }

    public static final String zzy(Context context) {
        String str;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        if (str == null || zzr()) {
            str = "emulator";
        }
        return zzz(str, "MD5");
    }

    private static String zzz(String str, String str2) {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException unused) {
                i2++;
            } catch (ArithmeticException unused2) {
                return null;
            }
        }
        return null;
    }

    public final int zzb(Context context, int i2) {
        if (this.zzh < 0.0f) {
            synchronized (this) {
                if (this.zzh < 0.0f) {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager == null) {
                        return 0;
                    }
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.zzh = displayMetrics.density;
                }
            }
        }
        return Math.round(((float) i2) / this.zzh);
    }

    /* access modifiers changed from: package-private */
    public final JSONArray zzg(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zzB : objArr) {
            zzB(jSONArray, zzB);
        }
        return jSONArray;
    }

    public final JSONObject zzh(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            zzC(jSONObject, next, bundle.get(next));
        }
        return jSONObject;
    }

    public final JSONObject zzi(Map map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zzC(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf(e2.getMessage())));
        }
    }

    public final JSONObject zzj(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return zzh(bundle);
        } catch (JSONException e2) {
            zzbzr.zzh("Error converting Bundle to JSON", e2);
            return null;
        }
    }

    public final void zzk(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject2.get(next);
            try {
                Object obj2 = jSONObject.get(next);
                Class<JSONObject> cls = JSONObject.class;
                if (cls.isInstance(obj2) && cls.isInstance(obj)) {
                    zzk((JSONObject) obj2, (JSONObject) obj);
                }
            } catch (JSONException unused) {
                jSONObject.put(next, obj);
            }
        }
    }

    public final void zzl(ViewGroup viewGroup, zzq zzq, String str, String str2) {
        if (str2 != null) {
            zzbzr.zzj(str2);
        }
        zzD(viewGroup, zzq, str, -65536, -16777216);
    }

    public final void zzm(ViewGroup viewGroup, zzq zzq, String str) {
        zzD(viewGroup, zzq, "Ads by Google", -16777216, -1);
    }

    public final void zzn(Context context, String str, String str2, Bundle bundle, boolean z2) {
        zzw(context, str, "gmob-apps", bundle, true, new zzbzh(this));
    }
}
