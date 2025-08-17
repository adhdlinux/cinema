package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import com.iab.omid.library.startio.adsession.CreativeType;
import com.iab.omid.library.startio.adsession.ImpressionType;
import com.iab.omid.library.startio.adsession.Owner;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.banner.banner3d.Banner3D;
import com.startapp.sdk.ads.banner.banner3d.Banner3DSize$Size;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCachedAd;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.omsdk.AdVerification;
import com.startapp.sdk.omsdk.VerificationDetails;
import com.startapp.simple.bloomfilter.algo.OpenBitSet;
import com.startapp.simple.bloomfilter.version.BloomVersion;
import com.startapp.x6;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.CookieManager;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static cc f35597a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f35598b;

    public static String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility == 8) {
            return "viewGone";
        }
        if (visibility == 4) {
            return "viewInvisible";
        }
        if (visibility != 0) {
            return "viewNotVisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }

    public static void a(x xVar) {
        if (!xVar.f36851g) {
            throw new IllegalStateException("AdSession is not started");
        } else if (xVar.f36852h) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, Exception exc) {
        Log.e("OMIDLIB", str, exc);
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void b(x xVar) {
        if (xVar.f36852h) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void c(x xVar) {
        if (!xVar.d()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static boolean c(Context context) {
        try {
            if (o.f35531a.f35624a) {
                return true;
            }
            o.a(context);
            return true;
        } catch (Throwable th) {
            y8.a(context, th);
            return false;
        }
    }

    public static void d(Context context) {
        x6 d2 = ComponentLocator.a(context).d();
        int i2 = d2.getInt("videoErrorsCount", 0);
        x6.a a2 = d2.edit();
        int i3 = i2 + 1;
        a2.a("videoErrorsCount", Integer.valueOf(i3));
        a2.f36915a.putInt("videoErrorsCount", i3);
        a2.apply();
    }

    public static String b(String str, String str2) {
        Pattern pattern = a0.f34072a;
        String str3 = "<script type=\"text/javascript\">" + str + "</script>";
        a(str2, "HTML is null or empty");
        ArrayList arrayList = new ArrayList();
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str2.indexOf("<!--", i2);
            if (indexOf >= 0) {
                int indexOf2 = str2.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i2 = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i2 = length;
        }
        int[][] iArr2 = (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2}));
        StringBuilder sb = new StringBuilder(str2.length() + str3.length() + 16);
        if (a0.b(str2, sb, a0.f34073b, str3, iArr2) || a0.a(str2, sb, a0.f34072a, str3, iArr2) || a0.b(str2, sb, a0.f34075d, str3, iArr2) || a0.a(str2, sb, a0.f34074c, str3, iArr2) || a0.b(str2, sb, a0.f34077f, str3, iArr2) || a0.a(str2, sb, a0.f34076e, str3, iArr2) || a0.a(str2, sb, a0.f34078g, str3, iArr2)) {
            return sb.toString();
        }
        return str3 + str2;
    }

    public static r a(Context context, s sVar) {
        if (sVar == null) {
            return null;
        }
        try {
            x xVar = (x) sVar;
            a((Object) sVar, "AdSession is null");
            AdSessionStatePublisher adSessionStatePublisher = xVar.f36850f;
            if (adSessionStatePublisher.f31610b != null) {
                throw new IllegalStateException("AdEvents already exists for AdSession");
            } else if (!xVar.f36852h) {
                r rVar = new r(xVar);
                adSessionStatePublisher.f31610b = rVar;
                return rVar;
            } else {
                throw new IllegalStateException("AdSession is finished");
            }
        } catch (Throwable th) {
            y8.a(context, th);
            return null;
        }
    }

    public static void c(Context context, Point point, View view) {
        point.x = Math.round(((float) ((view.getMeasuredWidth() - view.getPaddingLeft()) - view.getPaddingRight())) / context.getResources().getDisplayMetrics().density);
    }

    public static void b(Context context, AdEventListener adEventListener, Ad ad) {
        o6.a((Runnable) adEventListener == null ? null : new n7(adEventListener, ad, context));
    }

    public static String d() {
        return "startapp_ads".concat(File.separator).concat("keys");
    }

    public static Object b(JsonReader jsonReader) throws IOException {
        switch (bb.f34260a[jsonReader.peek().ordinal()]) {
            case 1:
                return a(jsonReader);
            case 2:
                HashMap hashMap = new HashMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    hashMap.put(jsonReader.nextName(), b(jsonReader));
                }
                jsonReader.endObject();
                return hashMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return new BigDecimal(jsonReader.nextString());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IOException(String.valueOf(jsonReader.peek()));
        }
    }

    public static String c() {
        return "startapp_ads".concat(File.separator).concat("interstitials");
    }

    public static double a(double d2, double d3, double d4) {
        return 1.0d / (Math.exp((d3 - d2) * d4) + 1.0d);
    }

    public static double a(double d2, double d3, double d4, double d5) {
        return (a(d2, d3, d4) - d5) / (1.0d - d5);
    }

    public static Class<?> a(String str) throws ClassNotFoundException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1808118735:
                if (str.equals("String")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1325958191:
                if (str.equals("double")) {
                    c2 = 1;
                    break;
                }
                break;
            case -891985903:
                if (str.equals("string")) {
                    c2 = 2;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3052374:
                if (str.equals("char")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c2 = 6;
                    break;
                }
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c2 = 7;
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c2 = 8;
                    break;
                }
                break;
            case 109413500:
                if (str.equals("short")) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                return String.class;
            case 1:
                return Double.TYPE;
            case 3:
                return Integer.TYPE;
            case 4:
                return Byte.TYPE;
            case 5:
                return Character.TYPE;
            case 6:
                return Long.TYPE;
            case 7:
                return Boolean.TYPE;
            case 8:
                return Float.TYPE;
            case 9:
                return Short.TYPE;
            default:
                return Class.forName(str);
        }
    }

    public static void b(Context context, int i2, int i3, WebView webView) {
        lb.a(webView, true, "mraid.setScreenSize", Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)));
    }

    public static int b(Context context, int i2) {
        return Math.round(((float) i2) / context.getResources().getDisplayMetrics().density);
    }

    public static boolean b(Field field) {
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        if (declaredAnnotations == null || declaredAnnotations.length == 0) {
            return false;
        }
        Annotation annotation = field.getDeclaredAnnotations()[0];
        if (!annotation.annotationType().equals(j0.class)) {
            return false;
        }
        return ((j0) annotation).complex();
    }

    public static String a(List<String> list) {
        ff ffVar = new ff();
        long currentTimeMillis = System.currentTimeMillis();
        BloomVersion bloomVersion = BloomVersion.FOUR;
        ef efVar = ffVar.f34541b.f36844a.get(bloomVersion).f36753b;
        efVar.getClass();
        OpenBitSet openBitSet = new OpenBitSet((long) (efVar.f34491a * efVar.f34492b));
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            ByteBuffer wrap = ByteBuffer.wrap(it2.next().getBytes());
            long c2 = openBitSet.c();
            int i2 = efVar.f34491a;
            long[] jArr = new long[i2];
            long j2 = c2 / ((long) i2);
            long j3 = currentTimeMillis;
            long a2 = a(wrap, wrap.position(), wrap.remaining(), 0);
            long a3 = a(wrap, wrap.position(), wrap.remaining(), a2);
            Iterator<String> it3 = it2;
            int i3 = 0;
            while (i3 < efVar.f34491a) {
                BloomVersion bloomVersion2 = bloomVersion;
                long j4 = (long) i3;
                jArr[i3] = (j4 * j2) + Math.abs(((j4 * a3) + a2) % j2);
                i3++;
                bloomVersion = bloomVersion2;
                efVar = efVar;
            }
            BloomVersion bloomVersion3 = bloomVersion;
            ef efVar2 = efVar;
            for (int i4 = 0; i4 < i2; i4++) {
                openBitSet.b(jArr[i4]);
            }
            bloomVersion = bloomVersion3;
            currentTimeMillis = j3;
            it2 = it3;
            efVar = efVar2;
        }
        long j5 = currentTimeMillis;
        BloomVersion bloomVersion4 = bloomVersion;
        tf tfVar = ffVar.f34540a;
        tfVar.getClass();
        try {
            String a4 = tfVar.f36590a.a(openBitSet);
            nf nfVar = tfVar.f36591b.f36844a.get(bloomVersion4).f36752a;
            return j5 + "-" + bloomVersion4.c() + "-" + nfVar.a(a4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(Context context, int i2, int i3, int i4, int i5, WebView webView) {
        lb.a(webView, true, "mraid.setDefaultPosition", Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i4) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i5) / context.getResources().getDisplayMetrics().density)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "/system/xbin/which"
            java.lang.String r3 = "su"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x002c }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x002c }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002a }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ all -> 0x002a }
            r3.<init>(r4)     // Catch:{ all -> 0x002a }
            r2.<init>(r3)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = r2.readLine()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0026
            r0 = 1
        L_0x0026:
            r1.destroy()
            return r0
        L_0x002a:
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.destroy()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.b():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0100, code lost:
        throw new java.lang.IllegalArgumentException(r14, r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fa A[ExcHandler: IOException (r0v1 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.ub b(java.lang.String r14) {
        /*
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r1)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.List r0 = a((android.util.JsonReader) r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1 = 0
            java.lang.Object r2 = r0.get(r1)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r4 == 0) goto L_0x00f4
            r2 = 1
            java.lang.Object r3 = r0.get(r2)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r5 == 0) goto L_0x00ee
            r3 = 2
            java.lang.Object r3 = r0.get(r3)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.List r3 = (java.util.List) r3     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r3 == 0) goto L_0x00e8
            int r6 = r3.size()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r10 = 0
        L_0x0038:
            if (r10 >= r6) goto L_0x00af
            java.lang.Object r11 = r3.get(r10)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r11 == 0) goto L_0x00a9
            int r12 = r11.size()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r12 != r2) goto L_0x00a3
            java.util.Set r11 = r11.entrySet()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.Object r11 = r11.next()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.Object r12 = r11.getKey()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r12 == 0) goto L_0x009d
            java.lang.Class r13 = a((java.lang.String) r12)     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            java.lang.Object r11 = r11.getValue()     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            java.lang.Object r11 = a((java.lang.Class) r13, (java.lang.Object) r11)     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            r7[r10] = r12     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            r8[r10] = r13     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            r9[r10] = r11     // Catch:{ ClassCastException -> 0x0096, ClassNotFoundException -> 0x008f, InstantiationException -> 0x0088, InvocationTargetException -> 0x0081, NoSuchMethodException -> 0x007a, IllegalAccessException -> 0x0073, IOException -> 0x00fa }
            int r10 = r10 + 1
            goto L_0x0038
        L_0x0073:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x007a:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x0081:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x0088:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x008f:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x0096:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r1.<init>(r14, r0)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r1     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x009d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00a3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00a9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00af:
            r2 = 3
            java.lang.Object r0 = r0.get(r2)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.util.List r0 = (java.util.List) r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r0 == 0) goto L_0x00e2
            int r2 = r0.size()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            int r3 = r0.size()     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00c2:
            if (r1 >= r3) goto L_0x00d7
            java.lang.Object r6 = r0.get(r1)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            if (r6 == 0) goto L_0x00d1
            r2[r1] = r6     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            int r1 = r1 + 1
            goto L_0x00c2
        L_0x00d1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00d7:
            com.startapp.ub r0 = new com.startapp.ub     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r3 = r0
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            return r0
        L_0x00e2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00e8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00ee:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00f4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            r0.<init>(r14)     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
            throw r0     // Catch:{ ClassCastException -> 0x0101, IOException -> 0x00fa }
        L_0x00fa:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r14, r0)
            throw r1
        L_0x0101:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r14, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.b(java.lang.String):com.startapp.ub");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r11) {
        /*
            android.content.Context r0 = com.startapp.ia.a(r11)
            if (r0 == 0) goto L_0x0007
            r11 = r0
        L_0x0007:
            com.startapp.cc r0 = f35597a
            if (r0 != 0) goto L_0x0012
            com.startapp.cc r0 = new com.startapp.cc
            r0.<init>(r11)
            f35597a = r0
        L_0x0012:
            com.startapp.cc r0 = f35597a
            r0.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String[] r2 = com.startapp.dc.f34369a
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.addAll(r2)
            boolean r1 = r0.a((java.util.List<java.lang.String>) r1)
            java.lang.String r2 = "test-keys"
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x007f
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String[] r5 = com.startapp.dc.f34370b
            java.util.List r5 = java.util.Arrays.asList(r5)
            r1.addAll(r5)
            boolean r1 = r0.a((java.util.List<java.lang.String>) r1)
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = "su"
            boolean r1 = r0.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = "busybox"
            boolean r1 = r0.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x007f
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x007f
            boolean r1 = r0.b()
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = android.os.Build.TAGS
            if (r1 == 0) goto L_0x006b
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 1
            goto L_0x006c
        L_0x006b:
            r1 = 0
        L_0x006c:
            if (r1 != 0) goto L_0x007f
            boolean r1 = r0.c()
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = "magisk"
            boolean r0 = r0.a((java.lang.String) r1)
            if (r0 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r0 = 0
            goto L_0x0080
        L_0x007f:
            r0 = 1
        L_0x0080:
            if (r0 != 0) goto L_0x00de
            java.lang.String r0 = android.os.Build.TAGS
            if (r0 == 0) goto L_0x008e
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x008e
            r0 = 1
            goto L_0x008f
        L_0x008e:
            r0 = 0
        L_0x008f:
            if (r0 != 0) goto L_0x00de
            boolean r0 = a()
            if (r0 != 0) goto L_0x00de
            boolean r0 = a()
            if (r0 != 0) goto L_0x00de
            boolean r0 = b()
            if (r0 != 0) goto L_0x00de
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00af }
            java.lang.String r1 = "/system/app/Superuser.apk"
            r0.<init>(r1)     // Catch:{ all -> 0x00af }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x00af }
            goto L_0x00b1
        L_0x00af:
            r0 = 0
        L_0x00b1:
            if (r0 != 0) goto L_0x00de
            java.lang.String r5 = "com.noshufou.android.su"
            java.lang.String r6 = "com.thirdparty.superuser"
            java.lang.String r7 = "eu.chainfire.supersu"
            java.lang.String r8 = "com.koushikdutta.superuser"
            java.lang.String r9 = "com.zachspong.temprootremovejb"
            java.lang.String r10 = "com.ramdroid.appquarantine"
            java.lang.String[] r0 = new java.lang.String[]{r5, r6, r7, r8, r9, r10}
            r1 = 0
        L_0x00c4:
            r2 = 6
            if (r1 >= r2) goto L_0x00db
            r2 = r0[r1]
            android.content.pm.PackageManager r5 = r11.getPackageManager()
            r5.getPackageInfo(r2, r4)     // Catch:{ all -> 0x00d2 }
            r2 = 1
            goto L_0x00d4
        L_0x00d2:
            r2 = 0
        L_0x00d4:
            if (r2 == 0) goto L_0x00d8
            r11 = 1
            goto L_0x00dc
        L_0x00d8:
            int r1 = r1 + 1
            goto L_0x00c4
        L_0x00db:
            r11 = 0
        L_0x00dc:
            if (r11 == 0) goto L_0x00df
        L_0x00de:
            r3 = 1
        L_0x00df:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.a(android.content.Context):boolean");
    }

    public static String a(Field field) {
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        if (declaredAnnotations != null && declaredAnnotations.length > 0) {
            Annotation annotation = field.getDeclaredAnnotations()[0];
            if (annotation.annotationType().equals(j0.class)) {
                j0 j0Var = (j0) annotation;
                if (!"".equals(j0Var.name())) {
                    return j0Var.name();
                }
            }
        }
        return field.getName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.sdk.ads.video.VideoUtil$VideoEligibility b(android.content.Context r10) {
        /*
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil$VideoEligibility.ELIGIBLE
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r1 = r1.G()
            int r1 = r1.o()
            r2 = 1
            r3 = 0
            if (r1 >= 0) goto L_0x0011
            goto L_0x002d
        L_0x0011:
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r10)
            com.startapp.x6 r1 = r1.d()
            java.lang.String r4 = "videoErrorsCount"
            int r1 = r1.getInt(r4, r3)
            com.startapp.sdk.adsbase.AdsCommonMetaData r4 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r4 = r4.G()
            int r4 = r4.o()
            if (r1 < r4) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == 0) goto L_0x0032
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil$VideoEligibility.INELIGIBLE_ERRORS_THRESHOLD_REACHED
        L_0x0032:
            java.lang.Class<com.startapp.sdk.ads.interstitials.OverlayActivity> r1 = com.startapp.sdk.ads.interstitials.OverlayActivity.class
            java.util.Map<android.app.Activity, java.lang.Integer> r4 = com.startapp.lb.f34876a
            android.content.pm.PackageManager r4 = r10.getPackageManager()     // Catch:{ Exception -> 0x005b }
            java.lang.String r5 = r10.getPackageName()     // Catch:{ Exception -> 0x005b }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r2)     // Catch:{ Exception -> 0x005b }
            android.content.pm.ActivityInfo[] r4 = r4.activities     // Catch:{ Exception -> 0x005b }
            int r5 = r4.length     // Catch:{ Exception -> 0x005b }
            r6 = 0
        L_0x0046:
            if (r6 >= r5) goto L_0x005c
            r7 = r4[r6]     // Catch:{ Exception -> 0x005b }
            java.lang.String r7 = r7.name     // Catch:{ Exception -> 0x005b }
            java.lang.String r8 = r1.getName()     // Catch:{ Exception -> 0x005b }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x005b }
            if (r7 == 0) goto L_0x0058
            r1 = 1
            goto L_0x005d
        L_0x0058:
            int r6 = r6 + 1
            goto L_0x0046
        L_0x005b:
        L_0x005c:
            r1 = 0
        L_0x005d:
            if (r1 != 0) goto L_0x0061
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil$VideoEligibility.INELIGIBLE_MISSING_ACTIVITY
        L_0x0061:
            java.io.File r10 = r10.getFilesDir()
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.lb.f34876a
            int r1 = com.startapp.hc.f34643a
            if (r10 == 0) goto L_0x0077
            boolean r1 = r10.isDirectory()     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            long r4 = r10.getFreeSpace()     // Catch:{ all -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r4 = -1
        L_0x0079:
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0080
            goto L_0x0094
        L_0x0080:
            com.startapp.sdk.adsbase.AdsCommonMetaData r10 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r10 = r10.G()
            long r6 = r10.f()
            r8 = 1024(0x400, double:5.06E-321)
            long r4 = r4 / r8
            long r6 = r6 * r8
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r2 = 0
        L_0x0095:
            if (r2 != 0) goto L_0x0099
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil$VideoEligibility.INELIGIBLE_NO_STORAGE
        L_0x0099:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.b(android.content.Context):com.startapp.sdk.ads.video.VideoUtil$VideoEligibility");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00d0, code lost:
        r2 = r2 ^ (((long) r0.get(((r19 + r1) - r4) + 3)) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00dc, code lost:
        r2 = r2 ^ (((long) r0.get(((r19 + r1) - r4) + 2)) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00e8, code lost:
        r2 = r2 ^ (((long) r0.get(((r19 + r1) - r4) + 1)) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00f4, code lost:
        r4 = -4132994306676758123L;
        r2 = (((long) r0.get((r19 + r1) - r4)) ^ r2) * -4132994306676758123L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0104, code lost:
        r1 = (r2 ^ (r2 >>> 47)) * r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0110, code lost:
        return r1 ^ (r1 >>> 47);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00b6, code lost:
        r2 = r2 ^ (((long) r0.get(((r19 + r1) - r4) + 5)) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00c4, code lost:
        r2 = r2 ^ (((long) r0.get(((r19 + r1) - r4) + 4)) << 32);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.nio.ByteBuffer r18, int r19, int r20, long r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r21 & r2
            long r4 = (long) r1
            r6 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r4 = r4 * r6
            long r2 = r2 ^ r4
            int r4 = r1 >> 3
            r5 = 0
        L_0x0017:
            r10 = 32
            r11 = 24
            r12 = 16
            r13 = 8
            if (r5 >= r4) goto L_0x009d
            int r15 = r5 << 3
            int r15 = r19 + r15
            int r14 = r15 + 0
            byte r14 = r0.get(r14)
            long r6 = (long) r14
            r16 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r16
            int r14 = r15 + 1
            byte r14 = r0.get(r14)
            long r8 = (long) r14
            long r8 = r8 & r16
            long r8 = r8 << r13
            long r6 = r6 + r8
            int r8 = r15 + 2
            byte r8 = r0.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r16
            long r8 = r8 << r12
            long r6 = r6 + r8
            int r8 = r15 + 3
            byte r8 = r0.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r16
            long r8 = r8 << r11
            long r6 = r6 + r8
            int r8 = r15 + 4
            byte r8 = r0.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r16
            long r8 = r8 << r10
            long r6 = r6 + r8
            int r8 = r15 + 5
            byte r8 = r0.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r16
            r10 = 40
            long r8 = r8 << r10
            long r6 = r6 + r8
            int r8 = r15 + 6
            byte r8 = r0.get(r8)
            long r8 = (long) r8
            long r8 = r8 & r16
            r10 = 48
            long r8 = r8 << r10
            long r6 = r6 + r8
            int r15 = r15 + 7
            byte r8 = r0.get(r15)
            long r8 = (long) r8
            long r8 = r8 & r16
            r10 = 56
            long r8 = r8 << r10
            long r6 = r6 + r8
            r8 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r6 = r6 * r8
            r10 = 47
            long r10 = r6 >>> r10
            long r6 = r6 ^ r10
            long r6 = r6 * r8
            long r2 = r2 ^ r6
            long r2 = r2 * r8
            int r5 = r5 + 1
            r6 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            goto L_0x0017
        L_0x009d:
            r4 = r1 & 7
            switch(r4) {
                case 1: goto L_0x00f4;
                case 2: goto L_0x00e8;
                case 3: goto L_0x00dc;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00c4;
                case 6: goto L_0x00b6;
                case 7: goto L_0x00a8;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            r4 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            goto L_0x0104
        L_0x00a8:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 6
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            r7 = 48
            long r5 = r5 << r7
            long r2 = r2 ^ r5
        L_0x00b6:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 5
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            r7 = 40
            long r5 = r5 << r7
            long r2 = r2 ^ r5
        L_0x00c4:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 4
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            long r5 = r5 << r10
            long r2 = r2 ^ r5
        L_0x00d0:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 3
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            long r5 = r5 << r11
            long r2 = r2 ^ r5
        L_0x00dc:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 2
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            long r5 = r5 << r12
            long r2 = r2 ^ r5
        L_0x00e8:
            int r5 = r19 + r1
            int r5 = r5 - r4
            int r5 = r5 + 1
            byte r5 = r0.get(r5)
            long r5 = (long) r5
            long r5 = r5 << r13
            long r2 = r2 ^ r5
        L_0x00f4:
            int r1 = r19 + r1
            int r1 = r1 - r4
            byte r0 = r0.get(r1)
            long r0 = (long) r0
            long r0 = r0 ^ r2
            r4 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r2 = r0 * r4
        L_0x0104:
            r0 = 47
            long r6 = r2 >>> r0
            long r1 = r2 ^ r6
            long r1 = r1 * r4
            long r3 = r1 >>> r0
            long r0 = r1 ^ r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.a(java.nio.ByteBuffer, int, int, long):long");
    }

    public static void a(Context context, c6 c6Var) {
        if (c6Var != null) {
            for (String b2 : c6Var.f34285a) {
                o6.b(context, b2);
            }
        }
    }

    public static void a(MraidState mraidState, WebView webView) {
        lb.a(webView, true, "mraid.fireStateChangeEvent", mraidState.name().toLowerCase());
    }

    public static void a(Context context, WebView webView, m9 m9Var) {
        if (m9Var == null) {
            m9Var = new m9(context);
        }
        boolean z2 = true;
        a(webView, "mraid.SUPPORTED_FEATURES.CALENDAR", m9Var.f34913b.contains("calendar") && hc.a(m9Var.f34912a, "android.permission.WRITE_CALENDAR"));
        a(webView, "mraid.SUPPORTED_FEATURES.INLINEVIDEO", m9Var.f34913b.contains("inlineVideo"));
        a(webView, "mraid.SUPPORTED_FEATURES.SMS", m9Var.f34913b.contains("sms") && hc.a(m9Var.f34912a, "android.permission.SEND_SMS"));
        a(webView, "mraid.SUPPORTED_FEATURES.STOREPICTURE", m9Var.f34913b.contains("storePicture"));
        if (!m9Var.f34913b.contains("tel") || !hc.a(m9Var.f34912a, "android.permission.CALL_PHONE")) {
            z2 = false;
        }
        a(webView, "mraid.SUPPORTED_FEATURES.TEL", z2);
    }

    public static void b(Context context, Point point, View view) {
        point.y = Math.round(((float) ((view.getMeasuredHeight() - view.getPaddingBottom()) - view.getPaddingTop())) / context.getResources().getDisplayMetrics().density);
    }

    public static s b(Context context, AdVerification adVerification, boolean z2) {
        try {
            return a(context, adVerification, z2);
        } catch (Throwable th) {
            y8.a(context, th);
            return null;
        }
    }

    public static y b(Context context, s sVar) {
        if (sVar == null) {
            return null;
        }
        try {
            return y.a(sVar);
        } catch (Throwable th) {
            y8.a(context, th);
            return null;
        }
    }

    public static String b(View view) {
        String name = view.getClass().getName();
        if (name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("com.android.")) {
            return view.getClass().getSimpleName();
        }
        String packageName = view.getContext().getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(".");
        return name.startsWith(sb.toString()) ? name.substring(packageName.length()) : name;
    }

    public static int a(Context context, int i2) {
        return Math.round(TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics()));
    }

    public static void a(Context context, int i2, int i3, WebView webView) {
        lb.a(webView, true, "mraid.setMaxSize", Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)));
    }

    public static void a(Context context, BannerListener bannerListener, View view) {
        o6.a((Runnable) bannerListener == null ? null : new o3(bannerListener, view, context));
    }

    public static boolean a() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static void a(Context context, AdEventListener adEventListener, Ad ad) {
        o6.a((Runnable) adEventListener == null ? null : new o7(adEventListener, ad, context));
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, WebView webView) {
        lb.a(webView, true, "mraid.setCurrentPosition", Integer.valueOf(Math.round(((float) i2) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i3) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i4) / context.getResources().getDisplayMetrics().density)), Integer.valueOf(Math.round(((float) i5) / context.getResources().getDisplayMetrics().density)));
    }

    public static s a(WebView webView) {
        try {
            if (!c(webView.getContext())) {
                return null;
            }
            a("Startio", "Name is null or empty");
            a("4.10.0", "Version is null or empty");
            v vVar = new v("Startio", "4.10.0");
            a((Object) vVar, "Partner is null");
            a((Object) webView, "WebView is null");
            return a(new u(vVar, webView, (String) null, (List<w>) null, (String) null, "", AdSessionContextType.HTML), false, false);
        } catch (Throwable th) {
            y8.a(webView.getContext(), th);
            return null;
        }
    }

    public static void a(TextView textView, Set<String> set) {
        int i2;
        if (set.contains("UNDERLINE")) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
        if (set.contains("BOLD") && set.contains("ITALIC")) {
            i2 = 3;
        } else if (set.contains("BOLD")) {
            i2 = 1;
        } else {
            i2 = set.contains("ITALIC") ? 2 : 0;
        }
        textView.setTypeface((Typeface) null, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r5 = (r5 = r4.getAttributes()).getNamedItem(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.w3c.dom.Node> a(org.w3c.dom.Node r6, java.lang.String r7, java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.w3c.dom.NodeList r6 = r6.getChildNodes()
            int r1 = r6.getLength()
            r2 = 0
            r3 = 0
        L_0x000f:
            if (r3 >= r1) goto L_0x004a
            org.w3c.dom.Node r4 = r6.item(r3)
            java.lang.String r5 = r4.getNodeName()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0047
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 != 0) goto L_0x0041
            if (r9 != 0) goto L_0x0028
            goto L_0x0041
        L_0x0028:
            org.w3c.dom.NamedNodeMap r5 = r4.getAttributes()
            if (r5 == 0) goto L_0x003f
            org.w3c.dom.Node r5 = r5.getNamedItem(r8)
            if (r5 == 0) goto L_0x003f
            java.lang.String r5 = r5.getNodeValue()
            boolean r5 = r9.contains(r5)
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r5 = 0
            goto L_0x0042
        L_0x0041:
            r5 = 1
        L_0x0042:
            if (r5 == 0) goto L_0x0047
            r0.add(r4)
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.a(org.w3c.dom.Node, java.lang.String, java.lang.String, java.util.List):java.util.List");
    }

    public static NotDisplayedReason a(View view, BannerOptions bannerOptions, AtomicReference<JSONObject> atomicReference) {
        int compare;
        ViewGroup viewGroup = view;
        AtomicReference<JSONObject> atomicReference2 = atomicReference;
        if (viewGroup == null) {
            return NotDisplayedReason.INTERNAL_ERROR;
        }
        if (view.getParent() == null) {
            return NotDisplayedReason.VIEW_NOT_ATTACHED;
        }
        if (view.getRootView() == null) {
            return NotDisplayedReason.VIEW_NOT_ATTACHED;
        }
        if (view.getRootView().getParent() == null) {
            return NotDisplayedReason.VIEW_NOT_ATTACHED;
        }
        if (bannerOptions.r() && !view.hasWindowFocus()) {
            return NotDisplayedReason.WINDOW_NOT_FOCUSED;
        }
        if (!view.isShown()) {
            return NotDisplayedReason.VIEW_NOT_VISIBLE;
        }
        if (view.getWidth() < 1 || view.getHeight() < 1) {
            return NotDisplayedReason.VIEW_INVALID_SIZE;
        }
        int width = ((view.getWidth() * view.getHeight()) * Math.min(Math.max(1, bannerOptions.h()), 100)) / 100;
        Rect rect = new Rect();
        if (!viewGroup.getGlobalVisibleRect(rect)) {
            return NotDisplayedReason.AD_CLIPPED;
        }
        if (rect.isEmpty()) {
            return NotDisplayedReason.AD_CLIPPED;
        }
        Rect rect2 = null;
        if (!bannerOptions.q()) {
            return null;
        }
        Region region = new Region(rect);
        Rect rect3 = new Rect();
        atomicReference2.set(a(viewGroup, rect, true));
        NotDisplayedReason notDisplayedReason = NotDisplayedReason.AD_CLIPPED;
        while (true) {
            int i2 = 0;
            if (!(viewGroup.getParent() instanceof ViewGroup)) {
                RegionIterator regionIterator = new RegionIterator(region);
                while (regionIterator.next(rect3)) {
                    i2 += rect3.width() * rect3.height();
                    if (i2 >= width) {
                        return null;
                    }
                }
                return notDisplayedReason;
            } else if (viewGroup.getAlpha() < 1.0f) {
                return NotDisplayedReason.VIEW_TRANSPARENT;
            } else {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                JSONObject a2 = a((View) viewGroup2, rect2, false);
                a(a2, atomicReference.get());
                atomicReference2.set(a2);
                int indexOfChild = viewGroup2.indexOfChild(viewGroup);
                int childCount = viewGroup2.getChildCount();
                int i3 = 0;
                while (i3 < childCount) {
                    View childAt = viewGroup2.getChildAt(i3);
                    if (childAt != viewGroup && (compare = Float.compare(childAt.getZ(), viewGroup.getZ())) >= 0 && ((compare != 0 || i3 > indexOfChild) && childAt != null && childAt.getVisibility() == 0 && childAt.getGlobalVisibleRect(rect3) && Rect.intersects(rect, rect3))) {
                        region.op(rect3, Region.Op.DIFFERENCE);
                        a(a2, a(childAt, rect3, false));
                        notDisplayedReason = NotDisplayedReason.AD_WAS_COVERED;
                    }
                    i3++;
                    rect2 = null;
                }
                viewGroup = viewGroup2;
            }
        }
    }

    public static s a(Context context, AdVerification adVerification, boolean z2) {
        URL url;
        if (!c(context)) {
            return null;
        }
        if (adVerification == null || adVerification.a() == null) {
            y8 y8Var = new y8(z8.f36996c);
            y8Var.f36954d = "OMSDK: Verification details can't be null!";
            y8Var.a(context);
            return null;
        }
        String a2 = ne.a();
        List<VerificationDetails> a3 = adVerification.a();
        ArrayList arrayList = new ArrayList(a3.size());
        for (VerificationDetails next : a3) {
            try {
                url = new URL(next.c());
            } catch (Throwable th) {
                y8.a(context, th);
                url = null;
            }
            if (url != null) {
                String a4 = next.a();
                String b2 = next.b();
                a(a4, "VendorKey is null or empty");
                a((Object) url, "ResourceURL is null");
                a(b2, "VerificationParameters is null or empty");
                arrayList.add(new w(a4, url, b2));
            }
        }
        a("Startio", "Name is null or empty");
        a("4.10.0", "Version is null or empty");
        v vVar = new v("Startio", "4.10.0");
        a((Object) vVar, "Partner is null");
        a((Object) a2, "OM SDK JS script content is null");
        a((Object) arrayList, "VerificationScriptResources is null");
        return a(new u(vVar, (WebView) null, a2, arrayList, (String) null, "", AdSessionContextType.NATIVE), z2, true);
    }

    public static List<Object> a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(b(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static Object a(Class cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (cls == Byte.TYPE) {
            if (obj instanceof Number) {
                return Byte.valueOf(((Number) obj).byteValue());
            }
        } else if (cls == Short.TYPE) {
            if (obj instanceof Number) {
                return Short.valueOf(((Number) obj).shortValue());
            }
        } else if (cls == Integer.TYPE) {
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
        } else if (cls == Long.TYPE) {
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
        } else if (cls == Float.TYPE) {
            if (obj instanceof Number) {
                return Float.valueOf(((Number) obj).floatValue());
            }
        } else if (cls == Double.TYPE) {
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
        } else if (cls == String.class) {
            if (obj != null) {
                return obj.toString();
            }
        } else if (cls == Boolean.TYPE && (obj instanceof Boolean)) {
            return obj;
        }
        if (obj == null) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return cls.cast(obj);
        }
        return cls.getConstructor(new Class[]{obj.getClass()}).newInstance(new Object[]{obj});
    }

    public static void a(Context context, AdDisplayListener adDisplayListener, Ad ad) {
        o6.a((Runnable) adDisplayListener == null ? null : new m7(adDisplayListener, ad, context));
    }

    public static TextView a(Context context, TextView textView, Typeface typeface, int i2, float f2, int i3, int i4) {
        TextView textView2 = new TextView(context);
        textView2.setTypeface(typeface, i2);
        textView2.setTextSize(1, f2);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(i3);
        textView2.setId(i4);
        return textView2;
    }

    public static void a(WebView webView, String str, String str2) {
        lb.a(webView, true, "mraid.fireErrorEvent", str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r10, java.net.URL r11, java.lang.String r12) {
        /*
            java.lang.String r0 = ".temp"
            r1 = 0
            java.lang.String r2 = a((android.content.Context) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x0073, all -> 0x006f }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0073, all -> 0x006f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0073, all -> 0x006f }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0073, all -> 0x006f }
            if (r4 != 0) goto L_0x006d
            java.io.InputStream r4 = r11.openStream()     // Catch:{ Exception -> 0x0073, all -> 0x006f }
            java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r7.<init>()     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r7.append(r12)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r7.append(r0)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r8 = 0
            java.io.FileOutputStream r7 = r10.openFileOutput(r7, r8)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
        L_0x0033:
            int r9 = r5.read(r6)     // Catch:{ Exception -> 0x0062 }
            if (r9 <= 0) goto L_0x003d
            r7.write(r6, r8, r9)     // Catch:{ Exception -> 0x0062 }
            goto L_0x0033
        L_0x003d:
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0062 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0062 }
            r8.<init>()     // Catch:{ Exception -> 0x0062 }
            r8.append(r12)     // Catch:{ Exception -> 0x0062 }
            r8.append(r0)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r8 = a((android.content.Context) r10, (java.lang.String) r8)     // Catch:{ Exception -> 0x0062 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0062 }
            r6.renameTo(r3)     // Catch:{ Exception -> 0x0062 }
            r4.close()     // Catch:{ Exception -> 0x0060 }
            r5.close()     // Catch:{ Exception -> 0x0060 }
            r1 = r2
            goto L_0x00ae
        L_0x0060:
            r1 = r2
            goto L_0x00b1
        L_0x0062:
            r2 = move-exception
            goto L_0x0077
        L_0x0064:
            r10 = move-exception
            goto L_0x00b4
        L_0x0066:
            r2 = move-exception
            r7 = r1
            goto L_0x0077
        L_0x0069:
            r10 = move-exception
            goto L_0x0071
        L_0x006b:
            r2 = move-exception
            goto L_0x0075
        L_0x006d:
            throw r1     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            return r2
        L_0x006f:
            r10 = move-exception
            r4 = r1
        L_0x0071:
            r5 = r1
            goto L_0x00b4
        L_0x0073:
            r2 = move-exception
            r4 = r1
        L_0x0075:
            r5 = r1
            r7 = r5
        L_0x0077:
            java.lang.String r3 = "StartAppWall.VideoUtil"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r6.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = "Error downloading video from "
            r6.append(r8)     // Catch:{ all -> 0x00b2 }
            r6.append(r11)     // Catch:{ all -> 0x00b2 }
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x00b2 }
            android.util.Log.e(r3, r11, r2)     // Catch:{ all -> 0x00b2 }
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x00b2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r2.<init>()     // Catch:{ all -> 0x00b2 }
            r2.append(r12)     // Catch:{ all -> 0x00b2 }
            r2.append(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x00b2 }
            java.lang.String r10 = a((android.content.Context) r10, (java.lang.String) r12)     // Catch:{ all -> 0x00b2 }
            r11.<init>(r10)     // Catch:{ all -> 0x00b2 }
            r11.delete()     // Catch:{ all -> 0x00b2 }
            r4.close()     // Catch:{ Exception -> 0x00b1 }
            r5.close()     // Catch:{ Exception -> 0x00b1 }
        L_0x00ae:
            r7.close()     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            return r1
        L_0x00b2:
            r10 = move-exception
            r1 = r7
        L_0x00b4:
            r4.close()     // Catch:{ Exception -> 0x00bd }
            r5.close()     // Catch:{ Exception -> 0x00bd }
            r1.close()     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.a(android.content.Context, java.net.URL, java.lang.String):java.lang.String");
    }

    public static void a(WebView webView, String str, boolean z2) {
        lb.a(webView, false, "mraid.setSupports", str, Boolean.valueOf(z2));
    }

    public static List<AdDetails> a(Context context, List<AdDetails> list, int i2, Set<String> set, boolean z2) {
        Context context2 = context;
        int i3 = i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z3 = false;
        for (AdDetails next : list) {
            ArrayList arrayList5 = (ArrayList) lb.a((List<String>) Arrays.asList(next.w()));
            AppPresenceDetails appPresenceDetails = new AppPresenceDetails(arrayList5.isEmpty() ? null : (String) arrayList5.get(0), next.c(), i3, next.o());
            boolean z4 = next.c() != null && next.c().startsWith("!");
            boolean a2 = hc.a(context, z4 ? next.c().substring(1) : next.c(), next.o());
            boolean z5 = AdsCommonMetaData.f36186h.H() && ((a2 && !z4) || (!a2 && z4));
            arrayList3.add(appPresenceDetails);
            if (z5) {
                appPresenceDetails.a(a2);
                appPresenceDetails.b(false);
                if (!z4) {
                    arrayList2.add(next);
                    arrayList4.add(appPresenceDetails);
                }
                set.add(next.p());
                z3 = true;
            } else {
                Set<String> set2 = set;
                arrayList.add(next);
            }
        }
        if (arrayList.size() < 5 && (list.size() != 1 || i3 > 0)) {
            int min = Math.min(5 - arrayList.size(), arrayList2.size());
            arrayList.addAll(arrayList2.subList(0, min));
            for (AppPresenceDetails b2 : arrayList4.subList(0, min)) {
                b2.b(true);
            }
        }
        if (z3) {
            SimpleTokenUtils.f(context);
            if (z2) {
                new s7(context, arrayList3).a();
            }
        }
        return arrayList;
    }

    public static boolean a(Context context, ViewParent viewParent, BannerOptions bannerOptions, Banner3D banner3D, r3 r3Var) {
        Point point = new Point();
        point.x = bannerOptions.o();
        point.y = bannerOptions.d();
        if (banner3D.getLayoutParams() != null && banner3D.getLayoutParams().width > 0) {
            point.x = Math.round(((float) (banner3D.getLayoutParams().width + 1)) / context.getResources().getDisplayMetrics().density);
        }
        if (banner3D.getLayoutParams() != null && banner3D.getLayoutParams().height > 0) {
            point.y = Math.round(((float) (banner3D.getLayoutParams().height + 1)) / context.getResources().getDisplayMetrics().density);
        }
        if (banner3D.getLayoutParams() == null || banner3D.getLayoutParams().width <= 0 || banner3D.getLayoutParams().height <= 0) {
            if (context instanceof Activity) {
                View decorView = ((Activity) context).getWindow().getDecorView();
                try {
                    View view = (View) viewParent;
                    if (view instanceof Banner) {
                        view = (View) view.getParent();
                    }
                    boolean z2 = false;
                    boolean z3 = false;
                    while (view != null && (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0)) {
                        if (view.getMeasuredWidth() > 0 && !z2) {
                            c(context, point, view);
                            z2 = true;
                        }
                        if (view.getMeasuredHeight() > 0 && !z3) {
                            b(context, point, view);
                            z3 = true;
                        }
                        view = (View) view.getParent();
                    }
                    if (view == null) {
                        a(context, point, decorView);
                    } else {
                        if (!z2) {
                            c(context, point, view);
                        }
                        if (!z3) {
                            b(context, point, view);
                        }
                    }
                } catch (Throwable th) {
                    a(context, point, decorView);
                    y8.a(context, th);
                }
            } else {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager != null) {
                        a(context, windowManager, point);
                    }
                } catch (Throwable th2) {
                    y8.a(context, th2);
                }
            }
        }
        r3 r3Var2 = new r3(point.x, point.y);
        Point point2 = r3Var2.f35750a;
        r3Var.a(point2.x, point2.y);
        Banner3DSize$Size[] values = Banner3DSize$Size.values();
        boolean z4 = false;
        for (int i2 = 0; i2 < 6; i2++) {
            Banner3DSize$Size banner3DSize$Size = values[i2];
            if (banner3DSize$Size.getSize().f35750a.x <= r3Var2.f35750a.x && banner3DSize$Size.getSize().f35750a.y <= r3Var2.f35750a.y) {
                bannerOptions.a(banner3DSize$Size.getSize().f35750a.x, banner3DSize$Size.getSize().f35750a.y);
                z4 = true;
            }
        }
        if (!z4) {
            bannerOptions.a(0, 0);
        }
        return z4;
    }

    public static RelativeLayout.LayoutParams a(Context context, int[] iArr, int[] iArr2) {
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        for (int addRule : iArr2) {
            layoutParams.addRule(addRule);
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                i2 = 0;
            } else {
                i2 = Math.round(TypedValue.applyDimension(1, (float) i4, context.getResources().getDisplayMetrics()));
            }
            iArr[i3] = i2;
        }
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        return layoutParams;
    }

    public static s a(u uVar, boolean z2, boolean z3) {
        CreativeType creativeType = z2 ? CreativeType.VIDEO : z3 ? CreativeType.NATIVE_DISPLAY : CreativeType.HTML_DISPLAY;
        ImpressionType impressionType = ImpressionType.VIEWABLE;
        Owner owner = Owner.NATIVE;
        Owner owner2 = z2 ? owner : Owner.NONE;
        a((Object) creativeType, "CreativeType is null");
        a((Object) impressionType, "ImpressionType is null");
        a((Object) owner, "Impression owner is null");
        if (creativeType != CreativeType.DEFINED_BY_JAVASCRIPT) {
            t tVar = new t(creativeType, impressionType, owner, owner2, false);
            if (o.f35531a.f35624a) {
                a((Object) tVar, "AdSessionConfiguration is null");
                a((Object) uVar, "AdSessionContext is null");
                return new x(tVar, uVar);
            }
            throw new IllegalStateException("Method called before OM SDK activation");
        }
        throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
    }

    public static ImageView a(Context context, ImageView imageView, Bitmap bitmap, int i2) {
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageBitmap(bitmap);
        imageView2.setId(i2);
        return imageView2;
    }

    public static void a(Context context, WindowManager windowManager, Point point) {
        windowManager.getDefaultDisplay().getSize(point);
        point.x = Math.round(((float) point.x) / context.getResources().getDisplayMetrics().density);
        point.y = Math.round(((float) point.y) / context.getResources().getDisplayMetrics().density);
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Cif.f34709a);
    }

    public static List<AppPresenceDetails> a(String str, int i2) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[0];
        String a2 = lb.a(str, "@tracking@", "@tracking@");
        if (a2 != null) {
            strArr = a2.split(",");
        }
        String[] strArr2 = new String[0];
        String a3 = lb.a(str, "@appPresencePackage@", "@appPresencePackage@");
        if (a3 != null) {
            strArr2 = a3.split(",");
        }
        String[] strArr3 = new String[0];
        String a4 = lb.a(str, "@minAppVersion@", "@minAppVersion@");
        if (a4 != null) {
            strArr3 = a4.split(",");
        }
        int i3 = 0;
        while (i3 < strArr2.length) {
            arrayList.add(new AppPresenceDetails(strArr.length > i3 ? strArr[i3] : null, strArr2[i3], i2, strArr3.length > i3 ? Integer.valueOf(strArr3[i3]).intValue() : 0));
            i3++;
        }
        while (i3 < strArr.length) {
            arrayList.add(new AppPresenceDetails(strArr[i3], "", i2, strArr3.length > i3 ? Integer.valueOf(strArr3[i3]).intValue() : 0));
            i3++;
        }
        return arrayList;
    }

    public static void a(Context context, Point point, View view) {
        point.x = Math.round(((float) view.getMeasuredWidth()) / context.getResources().getDisplayMetrics().density);
        point.y = Math.round(((float) view.getMeasuredHeight()) / context.getResources().getDisplayMetrics().density);
    }

    public static Boolean a(Context context, List<AppPresenceDetails> list, int i2, Set<String> set, List<AppPresenceDetails> list2) {
        boolean z2 = false;
        for (AppPresenceDetails next : list) {
            boolean startsWith = next.b().startsWith("!");
            boolean a2 = hc.a(context, startsWith ? next.b().substring(1) : next.b(), next.a());
            if ((!startsWith && a2) || (startsWith && !a2)) {
                next.a(a2);
                z2 = i2 == 0;
                if (z2 && !startsWith) {
                    set.add(next.b());
                } else if (!z2 && next.c() != null) {
                    next.a(next.c() + "&isShown=" + next.e() + "&appPresence=" + next.d());
                }
            }
            list2.add(next);
        }
        if (z2) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                list2.get(i3).b(false);
            }
        }
        return Boolean.valueOf(z2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = "0x" + java.lang.Integer.toHexString(r3.getId());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.view.View r3, android.graphics.Rect r4, boolean r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "class"
            java.lang.String r2 = b((android.view.View) r3)     // Catch:{ JSONException -> 0x0083 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0083 }
            int r1 = r3.getId()     // Catch:{ JSONException -> 0x0083 }
            r2 = -1
            if (r1 != r2) goto L_0x0017
            r1 = 0
            goto L_0x0041
        L_0x0017:
            android.content.Context r1 = r3.getContext()     // Catch:{ NotFoundException -> 0x0028 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ NotFoundException -> 0x0028 }
            int r2 = r3.getId()     // Catch:{ NotFoundException -> 0x0028 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0028 }
            goto L_0x0041
        L_0x0028:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0083 }
            r1.<init>()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = "0x"
            r1.append(r2)     // Catch:{ JSONException -> 0x0083 }
            int r2 = r3.getId()     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = java.lang.Integer.toHexString(r2)     // Catch:{ JSONException -> 0x0083 }
            r1.append(r2)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0083 }
        L_0x0041:
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = "id"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0083 }
        L_0x0048:
            if (r5 == 0) goto L_0x0050
            java.lang.String r5 = "target"
            r1 = 1
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x0083 }
        L_0x0050:
            float r5 = r3.getAlpha()     // Catch:{ JSONException -> 0x0083 }
            r1 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x0064
            java.lang.String r5 = "alpha"
            float r3 = r3.getAlpha()     // Catch:{ JSONException -> 0x0083 }
            double r1 = (double) r3     // Catch:{ JSONException -> 0x0083 }
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x0083 }
        L_0x0064:
            if (r4 == 0) goto L_0x0082
            java.lang.String r3 = "left"
            int r5 = r4.left     // Catch:{ JSONException -> 0x0083 }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r3 = "top"
            int r5 = r4.top     // Catch:{ JSONException -> 0x0083 }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r3 = "right"
            int r5 = r4.right     // Catch:{ JSONException -> 0x0083 }
            r0.put(r3, r5)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r3 = "bottom"
            int r4 = r4.bottom     // Catch:{ JSONException -> 0x0083 }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x0083 }
        L_0x0082:
            return r0
        L_0x0083:
            r3 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.p.a(android.view.View, android.graphics.Rect, boolean):org.json.JSONObject");
    }

    public static String a(Context context, String str) {
        return context.getFilesDir() + "/" + str;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
            try {
                jSONObject.put("children", optJSONArray);
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        optJSONArray.put(jSONObject2);
    }

    public static void a(Context context, DiskAdCacheManager$DiskCachedAd diskAdCacheManager$DiskCachedAd, o8 o8Var, AdEventListener adEventListener) {
        v6 a2 = diskAdCacheManager$DiskCachedAd.a();
        a2.setContext(context);
        Map<Activity, Integer> map = lb.f34876a;
        boolean z2 = true;
        if (a2 instanceof InterstitialAd) {
            InterstitialAd interstitialAd = (InterstitialAd) a2;
            String b2 = diskAdCacheManager$DiskCachedAd.b();
            if (b2 == null || b2.equals("")) {
                a(context, adEventListener, (Ad) null);
                return;
            }
            if (AdsCommonMetaData.f36186h.H()) {
                List<AppPresenceDetails> a3 = a(b2, 0);
                ArrayList arrayList = new ArrayList();
                if (a(context, a3, 0, (Set<String>) new HashSet(), (List<AppPresenceDetails>) arrayList).booleanValue()) {
                    new s7(context, arrayList).a();
                    z2 = false;
                }
            }
            if (!z2) {
                a(context, adEventListener, (Ad) null);
                return;
            }
            d8 d8Var = d8.f34354a;
            d8Var.f34356c.put(interstitialAd.k(), b2);
            ((i8) o8Var).f34688a.f34747e = interstitialAd;
            ComponentLocator.a(context).f36430d.b().a(b2, new n8(context, adEventListener, interstitialAd));
        } else if (a2 instanceof OfferWall3DAd) {
            OfferWall3DAd offerWall3DAd = (OfferWall3DAd) a2;
            List<AdDetails> g2 = offerWall3DAd.g();
            if (g2 == null) {
                a(context, adEventListener, (Ad) null);
                return;
            }
            if (AdsCommonMetaData.f36186h.H()) {
                g2 = a(context, g2, 0, (Set<String>) new HashSet(), true);
            }
            if (g2.size() > 0) {
                ((i8) o8Var).f34688a.f34747e = offerWall3DAd;
                l4 a4 = m4.f34897a.a(offerWall3DAd.h());
                a4.getClass();
                a4.f34855b = new ArrayList();
                a4.f34856c = "";
                for (AdDetails a5 : g2) {
                    a4.a(a5);
                }
                b(context, adEventListener, (Ad) offerWall3DAd);
                return;
            }
            a(context, adEventListener, (Ad) null);
        } else {
            a(context, adEventListener, (Ad) null);
        }
    }
}
