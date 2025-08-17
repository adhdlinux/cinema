package com.startapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.impl.sdk.utils.Utils;
import com.google.ar.core.ImageMetadata;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class o6 {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f35552a;

    /* renamed from: b  reason: collision with root package name */
    public static ProgressDialog f35553b;

    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /*
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ all -> 0x000f }
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo()     // Catch:{ all -> 0x000f }
            int r1 = r1.labelRes     // Catch:{ all -> 0x000f }
            java.lang.String r2 = r0.getString(r1)     // Catch:{ all -> 0x000f }
            return r2
        L_0x000f:
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()     // Catch:{ all -> 0x001f }
            java.lang.String r2 = r2.packageName     // Catch:{ all -> 0x001f }
            r1 = 0
            android.content.pm.ApplicationInfo r2 = r0.getApplicationInfo(r2, r1)     // Catch:{ all -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0026
            java.lang.CharSequence r3 = r0.getApplicationLabel(r2)
        L_0x0026:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.o6.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void b(Context context, String str, TrackingParams trackingParams) {
        if (context != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder(str);
            String a2 = a(str, (String) null);
            if (a2 != null) {
                sb.append(fc.c(a2));
            }
            if (trackingParams != null && (a2 != null || lb.d(str))) {
                sb.append(trackingParams.e());
            }
            b(context, sb.toString());
        }
    }

    public static boolean c(String str) {
        if (str == null || (!str.startsWith("http://") && !str.startsWith("https://"))) {
            return false;
        }
        return true;
    }

    public static boolean a(Activity activity) {
        boolean z2 = activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
            return true;
        }
        return z2;
    }

    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ComponentLocator.a(context).o().execute(new m6(context, str));
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }
    }

    public static int a(String str) {
        String[] split = str.split("&");
        return Integer.parseInt(split[split.length - 1].split("=")[1]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r17, java.lang.String r18, java.lang.String[] r19, java.lang.String r20, com.startapp.sdk.adsbase.commontracking.TrackingParams r21, long r22, long r24, boolean r26, java.lang.Boolean r27, boolean r28, java.lang.Runnable r29) {
        /*
            r15 = r17
            r0 = r18
            r13 = r20
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            boolean r1 = r1.N()
            if (r1 == 0) goto L_0x01be
            r3 = r19
            r4 = r21
            r6 = r28
            android.util.Pair r1 = a((android.content.Context) r15, (java.lang.String[]) r3, (java.lang.String) r0, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r4, (boolean) r6)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r14 = r1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            boolean r0 = r0.M()
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x003c
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = 0
            goto L_0x003d
        L_0x003c:
            r0 = 1
        L_0x003d:
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = com.startapp.fc.c(r14)
            goto L_0x0047
        L_0x0046:
            r0 = r2
        L_0x0047:
            r1.append(r0)
            java.lang.String r12 = r1.toString()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.startapp.android.OnClickCallback"
            r0.<init>(r1)
            com.startapp.wb r1 = com.startapp.wb.a((android.content.Context) r17)
            r1.a((android.content.Intent) r0)
            boolean r0 = b((java.lang.String) r12)
            if (r0 == 0) goto L_0x00ad
            if (r13 == 0) goto L_0x00a3
            boolean r0 = r13.equals(r2)
            if (r0 != 0) goto L_0x00a3
            java.lang.String r0 = r12.toLowerCase()
            java.lang.String r1 = r20.toLowerCase()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x00a3
            com.startapp.y8 r0 = new com.startapp.y8
            com.startapp.z8 r1 = com.startapp.z8.f36996c
            r0.<init>((com.startapp.z8) r1)
            java.lang.String r1 = "Wrong package reached"
            r0.f36954d = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = ", Link: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.f36955e = r1
            r0.f36957g = r14
            r0.a(r15)
        L_0x00a3:
            b((android.content.Context) r15, (java.lang.String) r12, (java.lang.String) r14)
            if (r29 == 0) goto L_0x01ce
            r29.run()
            goto L_0x01ce
        L_0x00ad:
            boolean r0 = r15 instanceof android.app.Activity
            if (r0 == 0) goto L_0x00b7
            r0 = r15
            android.app.Activity r0 = (android.app.Activity) r0
            com.startapp.lb.a((android.app.Activity) r0, (boolean) r4)
        L_0x00b7:
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r17)     // Catch:{ all -> 0x01aa }
            com.startapp.nb r0 = r0.u()     // Catch:{ all -> 0x01aa }
            android.webkit.WebView r0 = r0.b()     // Catch:{ all -> 0x01aa }
            android.app.ProgressDialog r1 = f35553b     // Catch:{ all -> 0x01aa }
            if (r1 != 0) goto L_0x0157
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0151 }
            r2 = 22
            if (r1 < r2) goto L_0x00d8
            android.app.ProgressDialog r2 = new android.app.ProgressDialog     // Catch:{ all -> 0x0151 }
            r5 = 16974545(0x10302d1, float:2.406292E-38)
            r2.<init>(r15, r5)     // Catch:{ all -> 0x0151 }
            f35553b = r2     // Catch:{ all -> 0x0151 }
            goto L_0x00df
        L_0x00d8:
            android.app.ProgressDialog r2 = new android.app.ProgressDialog     // Catch:{ all -> 0x0151 }
            r2.<init>(r15)     // Catch:{ all -> 0x0151 }
            f35553b = r2     // Catch:{ all -> 0x0151 }
        L_0x00df:
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            r5 = 0
            r2.setTitle(r5)     // Catch:{ all -> 0x0151 }
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            java.lang.String r5 = "Loading...."
            r2.setMessage(r5)     // Catch:{ all -> 0x0151 }
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            r2.setIndeterminate(r3)     // Catch:{ all -> 0x0151 }
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            r2.setCancelable(r3)     // Catch:{ all -> 0x0151 }
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            com.startapp.n6 r3 = new com.startapp.n6     // Catch:{ all -> 0x0151 }
            r3.<init>(r0)     // Catch:{ all -> 0x0151 }
            r2.setOnCancelListener(r3)     // Catch:{ all -> 0x0151 }
            boolean r2 = r15 instanceof android.app.Activity     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0113
            r2 = r15
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x0151 }
            boolean r2 = r2.isFinishing()     // Catch:{ all -> 0x0151 }
            if (r2 != 0) goto L_0x0113
            android.app.ProgressDialog r1 = f35553b     // Catch:{ all -> 0x0151 }
            r1.show()     // Catch:{ all -> 0x0151 }
            goto L_0x0157
        L_0x0113:
            boolean r2 = r15 instanceof android.app.Activity     // Catch:{ all -> 0x0151 }
            if (r2 != 0) goto L_0x0157
            r2 = 23
            if (r1 < r2) goto L_0x0120
            boolean r2 = android.provider.Settings.canDrawOverlays(r17)     // Catch:{ all -> 0x0151 }
            goto L_0x0126
        L_0x0120:
            java.lang.String r2 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r2 = com.startapp.hc.a((android.content.Context) r15, (java.lang.String) r2)     // Catch:{ all -> 0x0151 }
        L_0x0126:
            if (r2 == 0) goto L_0x0157
            android.app.ProgressDialog r2 = f35553b     // Catch:{ all -> 0x0151 }
            android.view.Window r2 = r2.getWindow()     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0157
            r2 = 26
            if (r1 < r2) goto L_0x0140
            android.app.ProgressDialog r1 = f35553b     // Catch:{ all -> 0x0151 }
            android.view.Window r1 = r1.getWindow()     // Catch:{ all -> 0x0151 }
            r2 = 2038(0x7f6, float:2.856E-42)
            r1.setType(r2)     // Catch:{ all -> 0x0151 }
            goto L_0x014b
        L_0x0140:
            android.app.ProgressDialog r1 = f35553b     // Catch:{ all -> 0x0151 }
            android.view.Window r1 = r1.getWindow()     // Catch:{ all -> 0x0151 }
            r2 = 2003(0x7d3, float:2.807E-42)
            r1.setType(r2)     // Catch:{ all -> 0x0151 }
        L_0x014b:
            android.app.ProgressDialog r1 = f35553b     // Catch:{ all -> 0x0151 }
            r1.show()     // Catch:{ all -> 0x0151 }
            goto L_0x0157
        L_0x0151:
            r0 = move-exception
            r1 = r12
            r19 = r14
            r2 = r15
            goto L_0x01b0
        L_0x0157:
            android.webkit.WebSettings r1 = r0.getSettings()     // Catch:{ all -> 0x01aa }
            r1.setJavaScriptEnabled(r4)     // Catch:{ all -> 0x01aa }
            android.webkit.WebChromeClient r1 = new android.webkit.WebChromeClient     // Catch:{ all -> 0x01aa }
            r1.<init>()     // Catch:{ all -> 0x01aa }
            r0.setWebChromeClient(r1)     // Catch:{ all -> 0x01aa }
            com.startapp.qb r11 = new com.startapp.qb     // Catch:{ all -> 0x01aa }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r17)     // Catch:{ all -> 0x01aa }
            com.startapp.x6 r3 = r1.d()     // Catch:{ all -> 0x01aa }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r17)     // Catch:{ all -> 0x01aa }
            java.util.concurrent.Executor r4 = r1.i()     // Catch:{ all -> 0x01aa }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x01aa }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x01aa }
            r5.<init>(r1)     // Catch:{ all -> 0x01aa }
            r1 = r11
            r2 = r17
            r6 = r22
            r8 = r24
            r10 = r26
            r16 = r11
            r11 = r27
            r18 = r12
            r13 = r20
            r19 = r14
            r15 = r29
            r1.<init>(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x01a6 }
            r1 = r16
            r0.setWebViewClient(r1)     // Catch:{ all -> 0x01a6 }
            r1 = r18
            r0.loadUrl(r1)     // Catch:{ all -> 0x01a4 }
            goto L_0x01ce
        L_0x01a4:
            r0 = move-exception
            goto L_0x01ae
        L_0x01a6:
            r0 = move-exception
            r1 = r18
            goto L_0x01ae
        L_0x01aa:
            r0 = move-exception
            r1 = r12
            r19 = r14
        L_0x01ae:
            r2 = r17
        L_0x01b0:
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r0)
            r3 = r19
            b((android.content.Context) r2, (java.lang.String) r1, (java.lang.String) r3)
            if (r29 == 0) goto L_0x01ce
            r29.run()
            goto L_0x01ce
        L_0x01be:
            r3 = r19
            r4 = r21
            r6 = r28
            r2 = r15
            r1 = r17
            r2 = r18
            r5 = r26
            a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String[]) r3, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r4, (boolean) r5, (boolean) r6)
        L_0x01ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.o6.a(android.content.Context, java.lang.String, java.lang.String[], java.lang.String, com.startapp.sdk.adsbase.commontracking.TrackingParams, long, long, boolean, java.lang.Boolean, boolean, java.lang.Runnable):void");
    }

    public static boolean b(String str) {
        return str.startsWith(Utils.PLAY_STORE_SCHEME) || str.startsWith("http://play.google.com") || str.startsWith("https://play.google.com");
    }

    public static void b(Context context) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            Map<Activity, Integer> map = lb.f34876a;
            lb.a(activity, activity.getResources().getConfiguration().orientation, false);
        }
        ProgressDialog progressDialog = f35553b;
        if (progressDialog != null) {
            synchronized (progressDialog) {
                ProgressDialog progressDialog2 = f35553b;
                if (progressDialog2 != null && progressDialog2.isShowing()) {
                    try {
                        f35553b.cancel();
                    } catch (Throwable th) {
                        y8.a(context, th);
                    }
                    f35553b = null;
                }
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        boolean c2 = c(str);
        if (context != null) {
            int i2 = (AdsCommonMetaData.f36186h.J() || !(context instanceof Activity)) ? 344457216 : 76021760;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(i2);
            boolean a2 = a(context, intent);
            if (!a2) {
                try {
                    if (MetaData.f36379h.i() && ComponentLocator.a(context).d().getBoolean("chromeTabs", false)) {
                        a(context, str, c2);
                        return;
                    }
                } catch (Throwable th) {
                    y8.a(context, th);
                    try {
                        Intent parseUri = Intent.parseUri(str, i2);
                        a(context, parseUri);
                        if (!(context instanceof Activity)) {
                            parseUri.addFlags(268435456);
                        }
                        context.startActivity(parseUri);
                        return;
                    } catch (Throwable th2) {
                        y8.a(context, th2);
                        return;
                    }
                }
            }
            if (c2 && !a2) {
                String[] strArr = {"com.android.chrome", "com.android.browser", "com.opera.mini.native", "org.mozilla.firefox", "com.opera.browser"};
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, i2);
                if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        String str3 = strArr[i3];
                        if (hc.a(context, str3, 0)) {
                            intent.setPackage(str3);
                            break;
                        }
                        i3++;
                    }
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String[] strArr, String str, int i2, String str2) {
        TrackingParams a2 = new TrackingParams(str).a(i2).a(str2);
        if (strArr == null || strArr.length == 0) {
            y8 y8Var = new y8(z8.f36996c);
            y8Var.f36954d = "Non-impression without trackingUrls";
            y8Var.f36959i = str2;
            y8Var.f36955e = lb.b(a2.d());
            y8Var.a(context);
            return;
        }
        for (String str3 : strArr) {
            if (!TextUtils.isEmpty(str3)) {
                b(context, str3, a2);
            }
        }
    }

    public static List<String> a(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 5;
            List<String> subList = list.subList(i2, Math.min(i3, list.size()));
            StringBuilder sb = new StringBuilder();
            sb.append(AdsConstants.f36192f);
            sb.append("?");
            sb.append(TextUtils.join("&", subList));
            sb.append("&isShown=");
            sb.append(str);
            sb.append("&appPresence=" + str2);
            arrayList.add(sb.toString());
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[Catch:{ all -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2, java.lang.String r3, java.lang.String[] r4, com.startapp.sdk.adsbase.commontracking.TrackingParams r5, boolean r6, boolean r7) {
        /*
            android.util.Pair r4 = a((android.content.Context) r2, (java.lang.String[]) r4, (java.lang.String) r3, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r5, (boolean) r7)
            java.lang.Object r5 = r4.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.second
            java.lang.String r4 = (java.lang.String) r4
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x0088 }
            boolean r7 = r7.M()     // Catch:{ all -> 0x0088 }
            if (r7 != 0) goto L_0x001d
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0088 }
            if (r7 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r7 = 0
            goto L_0x001e
        L_0x001d:
            r7 = 1
        L_0x001e:
            if (r7 == 0) goto L_0x0033
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r7.<init>()     // Catch:{ all -> 0x0088 }
            r7.append(r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = com.startapp.fc.c(r4)     // Catch:{ all -> 0x0088 }
            r7.append(r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0088 }
        L_0x0033:
            com.startapp.sdk.adsbase.remoteconfig.MetaData r7 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h     // Catch:{ all -> 0x0088 }
            boolean r7 = r7.O()     // Catch:{ all -> 0x0088 }
            if (r7 == 0) goto L_0x0041
            if (r6 == 0) goto L_0x0041
            a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0041:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0088 }
            r5 = 0
            if (r4 == 0) goto L_0x0084
            boolean r4 = a((android.content.Context) r2)     // Catch:{ all -> 0x0088 }
            if (r4 == 0) goto L_0x0084
            com.startapp.sdk.components.ComponentLocator r4 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)     // Catch:{ all -> 0x0088 }
            com.startapp.x6 r4 = r4.d()     // Catch:{ all -> 0x0088 }
            com.startapp.x6$a r4 = r4.edit()     // Catch:{ all -> 0x0088 }
            java.lang.String r6 = "shared_prefs_CookieFeatureTS"
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0088 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0088 }
            r4.a((java.lang.String) r6, r7)     // Catch:{ all -> 0x0088 }
            android.content.SharedPreferences$Editor r7 = r4.f36915a     // Catch:{ all -> 0x0088 }
            r7.putLong(r6, r0)     // Catch:{ all -> 0x0088 }
            r4.apply()     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r4.<init>()     // Catch:{ all -> 0x0088 }
            r4.append(r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = "&cki=1"
            r4.append(r3)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0088 }
            b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0084:
            b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r3 = move-exception
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r3)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.o6.a(android.content.Context, java.lang.String, java.lang.String[], com.startapp.sdk.adsbase.commontracking.TrackingParams, boolean, boolean):void");
    }

    public static Pair<String, String> a(Context context, String[] strArr, String str, TrackingParams trackingParams, boolean z2) {
        String str2;
        String str3;
        int i2 = 0;
        if (strArr != null) {
            for (String str4 : strArr) {
                if (!TextUtils.isEmpty(str4)) {
                    a(context, str4, trackingParams);
                }
            }
        }
        String str5 = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.f36232o = true;
        startAppSDKInternal.f36225h = true;
        String str6 = null;
        if (!z2) {
            try {
                int length = strArr.length;
                str2 = null;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    try {
                        str3 = strArr[i2];
                        str2 = a(str, str3);
                        if (str2 != null || lb.d(str3)) {
                            str6 = str3;
                        } else {
                            i2++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        y8.a(context, th);
                        return new Pair<>(str6, str2);
                    }
                }
                str6 = str3;
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                y8.a(context, th);
                return new Pair<>(str6, str2);
            }
        } else {
            str2 = null;
        }
        return new Pair<>(str6, str2);
    }

    public static void a(Context context, String str, TrackingParams trackingParams) {
        b(context, str, trackingParams);
        lb.a(context, false, TextUtils.isEmpty(str) ? "Closed Ad" : "Clicked Ad", true);
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            y8 y8Var = new y8(z8.f36996c);
            y8Var.f36954d = "Can not open in app browser, clickUrl is empty";
            if (str2 != null) {
                y8Var.f36957g = str2;
            }
            y8Var.a(context);
        } else if (!b(str)) {
            Map<Activity, Integer> map = lb.f34876a;
            try {
                if (MetaData.f36379h.j() && ComponentLocator.a(context).d().getBoolean("chromeTabs", false)) {
                    a(context, str, true);
                    return;
                }
            } catch (Throwable th) {
                y8.a(context, th);
            }
            Intent intent = new Intent(context, OverlayActivity.class);
            intent.addFlags(ImageMetadata.LENS_APERTURE);
            intent.addFlags(32768);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            intent.putExtra("placement", AdPreferences.Placement.INAPP_BROWSER.a());
            intent.putExtra("activityShouldLockOrientation", false);
            try {
                context.startActivity(intent);
            } catch (Throwable th2) {
                y8.a(context, th2);
            }
        } else {
            b(context, str, str2);
        }
    }

    public static void a(Context context, String str, boolean z2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Bundle bundle = new Bundle();
        bundle.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
        intent.putExtras(bundle);
        if (z2) {
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                    intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
                }
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Throwable th2) {
            y8.a(context, th2);
        }
    }

    public static void a(Context context, String[] strArr, String str, int i2, String str2, JSONObject jSONObject) {
        try {
            AnalyticsConfig analyticsConfig = MetaData.f36379h.analytics;
            if (!(analyticsConfig == null || !analyticsConfig.j() || jSONObject == null)) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "viewability_info";
                y8Var.f36959i = str2;
                y8Var.f36955e = lb.c(jSONObject.toString());
                y8Var.a(context);
            }
        } catch (Throwable th) {
            y8.a(context, th);
        }
        try {
            String str3 = "Dropped impression because " + str2;
            if (jSONObject != null) {
                str3 = str3 + ", view hierarchy: " + jSONObject.toString(2);
            }
            lb.a(context, true, str3, false);
        } catch (Throwable th2) {
            y8.a(context, th2);
        }
        a(context, strArr, str, i2, str2);
    }

    public static void a(String str, String str2, String str3, Context context, TrackingParams trackingParams) {
        b(context, str3, trackingParams);
        Intent a2 = lb.a(context, str);
        if (!(a2 == null || str2 == null)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    a2.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
            }
        }
        if (a2 != null) {
            try {
                context.startActivity(a2);
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }
    }

    public static String a(String str, String str2) {
        if (str2 != null) {
            try {
                if (!str2.equals("")) {
                    str = str2;
                }
            } catch (Exception unused) {
            }
        }
        String[] split = str.split("[?&]d=");
        if (split.length >= 2) {
            return split[1].split("[?&]")[0];
        }
        return null;
    }

    public static boolean a(Context context, Intent intent) {
        for (ResolveInfo next : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (next.activityInfo.packageName.equalsIgnoreCase(Constants.f36416a)) {
                ActivityInfo activityInfo = next.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                return true;
            }
        }
        return false;
    }

    public static String a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i2 = 0; i2 < 8; i2++) {
            if (stackTrace[i2].getMethodName().compareTo("doHome") == 0) {
                return "home";
            }
            if (stackTrace[i2].getMethodName().compareTo("onBackPressed") == 0) {
                String str = StartAppSDKInternal.f36218a;
                StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
                Activity activity = startAppSDKInternal.f36231n;
                if (!(activity != null ? activity.isTaskRoot() : true)) {
                    return com.vungle.ads.internal.Constants.PLACEMENT_TYPE_INTERSTITIAL;
                }
                startAppSDKInternal.f36224g = false;
                startAppSDKInternal.f36226i = true;
                return "back";
            }
        }
        return com.vungle.ads.internal.Constants.PLACEMENT_TYPE_INTERSTITIAL;
    }

    public static String[] a(v6 v6Var) {
        if (v6Var instanceof HtmlAd) {
            return ((HtmlAd) v6Var).trackingUrls;
        }
        return v6Var instanceof JsonAd ? a(((JsonAd) v6Var).g()) : new String[0];
    }

    public static String[] a(List<AdDetails> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (AdDetails w2 : list) {
                arrayList.addAll(Arrays.asList(w2.w()));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean a(Context context, AdPreferences.Placement placement) {
        if (placement.equals(AdPreferences.Placement.INAPP_SPLASH) || !AdsCommonMetaData.f36186h.a()) {
            return false;
        }
        return a(context);
    }

    public static boolean a(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        if (a2.a().a().f36969d) {
            return false;
        }
        long j2 = a2.d().getLong("shared_prefs_CookieFeatureTS", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 == 0 || j2 + (((long) AdsCommonMetaData.f36186h.e()) * SignalManager.TWENTY_FOUR_HOURS_MILLIS) <= currentTimeMillis) {
            return true;
        }
        return false;
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null || mainLooper.getThread() == Thread.currentThread()) {
                runnable.run();
                return;
            }
            Handler handler = f35552a;
            if (handler == null) {
                handler = new Handler(mainLooper);
                f35552a = handler;
            }
            handler.post(runnable);
        }
    }
}
