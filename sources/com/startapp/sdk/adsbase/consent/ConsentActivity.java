package com.startapp.sdk.adsbase.consent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.hc;
import com.startapp.lb;
import com.startapp.s8;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.y8;
import com.startapp.z8;
import java.net.URI;

public class ConsentActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public WebView f36309a;

    /* renamed from: b  reason: collision with root package name */
    public String f36310b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36311c;

    public void onBackPressed() {
        WebView webView = this.f36309a;
        if (webView == null) {
            this.f36311c = true;
            super.onBackPressed();
            return;
        }
        String url = webView.getUrl();
        String str = this.f36310b;
        if (str != null && url != null && url.contains(str)) {
            this.f36309a.loadUrl("javascript:startappBackPressed();");
        } else if (this.f36309a.canGoBack()) {
            this.f36309a.goBack();
        } else {
            this.f36311c = true;
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        String dataString = getIntent().getDataString();
        if (!TextUtils.isEmpty(dataString)) {
            try {
                URI uri = new URI(dataString);
                this.f36310b = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), (String) null, (String) null).toString();
                WebView b2 = ComponentLocator.a((Context) this).u().b();
                this.f36309a = b2;
                b2.setWebViewClient(new a());
                this.f36309a.getSettings().setJavaScriptEnabled(true);
                this.f36309a.setHorizontalScrollBarEnabled(false);
                this.f36309a.setVerticalScrollBarEnabled(false);
                this.f36309a.getSettings().setTextZoom(100);
                this.f36309a.loadUrl(dataString);
                this.f36309a.setBackgroundColor(0);
                hc.a(this.f36309a, (Paint) null);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                relativeLayout.addView(this.f36309a, layoutParams2);
            } catch (Throwable th) {
                y8.a((Context) this, th);
            }
        }
        setContentView(relativeLayout, layoutParams);
    }

    public void onStop() {
        super.onStop();
        ConsentConfig k2 = MetaData.f36379h.k();
        if (!this.f36311c && k2 != null && k2.j() && lb.g(this) && lb.e((Context) this)) {
            y8 y8Var = new y8(z8.f36995b);
            y8Var.f36954d = "ConsentActivityHasBeenCovered";
            y8Var.a(this);
            finish();
            try {
                startActivity(getIntent());
            } catch (Throwable th) {
                y8.a((Context) this, th);
            }
        }
        s8 f2 = ComponentLocator.a((Context) this).f();
        f2.f35854d = false;
        Intent intent = f2.f35853c;
        if (intent != null) {
            try {
                f2.f35851a.startActivity(intent);
            } catch (Throwable th2) {
                y8.a(f2.f35851a, th2);
            }
        }
    }

    public class a extends WebViewClient {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0055 A[Catch:{ all -> 0x005e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.net.Uri r12) {
            /*
                r11 = this;
                java.lang.String r0 = r12.getScheme()
                java.lang.String r1 = r12.getHost()
                com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
                com.startapp.sdk.adsbase.consent.ConsentConfig r2 = r2.k()
                r3 = 0
                if (r0 == 0) goto L_0x0090
                java.lang.String r4 = "startappad"
                boolean r0 = r0.equalsIgnoreCase(r4)
                if (r0 == 0) goto L_0x0090
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 != 0) goto L_0x0090
                if (r2 != 0) goto L_0x0022
                goto L_0x0090
            L_0x0022:
                java.lang.String r0 = "setconsent"
                boolean r0 = r1.equalsIgnoreCase(r0)
                r4 = 1
                if (r0 == 0) goto L_0x007d
                java.lang.String r0 = "status"
                java.lang.String r0 = r12.getQueryParameter(r0)
                java.lang.String r1 = "apc"
                java.lang.String r12 = r12.getQueryParameter(r1)
                r1 = 0
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NumberFormatException -> 0x004e, all -> 0x0048 }
                if (r3 != 0) goto L_0x004e
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x004e, all -> 0x0048 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x004e, all -> 0x0048 }
                r6 = r0
                goto L_0x004f
            L_0x0048:
                r0 = move-exception
                com.startapp.sdk.adsbase.consent.ConsentActivity r3 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r0)
            L_0x004e:
                r6 = r1
            L_0x004f:
                boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x005e }
                if (r0 != 0) goto L_0x0064
                boolean r12 = java.lang.Boolean.parseBoolean(r12)     // Catch:{ all -> 0x005e }
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x005e }
                goto L_0x0064
            L_0x005e:
                r12 = move-exception
                com.startapp.sdk.adsbase.consent.ConsentActivity r0 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r12)
            L_0x0064:
                r8 = r1
                com.startapp.sdk.adsbase.consent.ConsentActivity r12 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                com.startapp.sdk.components.ComponentLocator r12 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r12)
                com.startapp.s8 r5 = r12.f()
                long r0 = r2.i()
                java.lang.Long r7 = java.lang.Long.valueOf(r0)
                r9 = 1
                r10 = 1
                r5.a(r6, r7, r8, r9, r10)
                return r4
            L_0x007d:
                java.lang.String r12 = "close"
                boolean r12 = r1.equalsIgnoreCase(r12)
                if (r12 == 0) goto L_0x0090
                com.startapp.sdk.adsbase.consent.ConsentActivity r12 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                boolean unused = r12.f36311c = r4
                com.startapp.sdk.adsbase.consent.ConsentActivity r12 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                r12.finish()
                return r4
            L_0x0090:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.consent.ConsentActivity.a.a(android.net.Uri):boolean");
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0103  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0116  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x012d  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0144  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0165  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x017d  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0195  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01b2  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01c9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPageFinished(android.webkit.WebView r9, java.lang.String r10) {
            /*
                r8 = this;
                com.startapp.sdk.adsbase.consent.ConsentActivity r0 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                android.content.Intent r0 = r0.getIntent()
                android.os.Bundle r0 = r0.getExtras()
                if (r0 != 0) goto L_0x000d
                return
            L_0x000d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "javascript:var obj = {};"
                r1.<init>(r2)
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                java.lang.String r3 = "';"
                if (r2 != 0) goto L_0x0027
                java.lang.String r2 = "obj.template = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x0027:
                java.lang.String r10 = "allowCT"
                boolean r2 = r0.containsKey(r10)
                java.lang.String r4 = ";"
                if (r2 == 0) goto L_0x0040
                boolean r10 = r0.getBoolean(r10)
                java.lang.String r2 = "obj.allowCT = "
                r1.append(r2)
                r1.append(r10)
                r1.append(r4)
            L_0x0040:
                com.startapp.sdk.adsbase.consent.ConsentActivity r10 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.lb.f34876a
                android.content.pm.PackageManager r2 = r10.getPackageManager()     // Catch:{ all -> 0x007e }
                if (r2 != 0) goto L_0x004b
                goto L_0x0082
            L_0x004b:
                java.lang.String r5 = r10.getPackageName()     // Catch:{ all -> 0x007e }
                r6 = 128(0x80, float:1.794E-43)
                android.content.pm.ApplicationInfo r5 = r2.getApplicationInfo(r5, r6)     // Catch:{ all -> 0x007e }
                android.graphics.drawable.Drawable r2 = r5.loadIcon(r2)     // Catch:{ all -> 0x007e }
                if (r2 != 0) goto L_0x005c
                goto L_0x0082
            L_0x005c:
                android.content.res.Resources r5 = r10.getResources()     // Catch:{ all -> 0x007e }
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()     // Catch:{ all -> 0x007e }
                float r5 = r5.density     // Catch:{ all -> 0x007e }
                r6 = 1111490560(0x42400000, float:48.0)
                float r6 = r6 * r5
                int r6 = (int) r6
                android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x0072 }
                java.lang.String r10 = com.startapp.lb.a((android.graphics.drawable.Drawable) r2, (int) r6, (int) r6, (android.graphics.Bitmap.Config) r7)     // Catch:{ OutOfMemoryError -> 0x0072 }
                goto L_0x0083
            L_0x0072:
                r6 = 1103101952(0x41c00000, float:24.0)
                float r5 = r5 * r6
                int r5 = (int) r5
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ OutOfMemoryError -> 0x0082 }
                java.lang.String r10 = com.startapp.lb.a((android.graphics.drawable.Drawable) r2, (int) r5, (int) r5, (android.graphics.Bitmap.Config) r6)     // Catch:{ OutOfMemoryError -> 0x0082 }
                goto L_0x0083
            L_0x007e:
                r2 = move-exception
                com.startapp.y8.a((android.content.Context) r10, (java.lang.Throwable) r2)
            L_0x0082:
                r10 = 0
            L_0x0083:
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                if (r2 != 0) goto L_0x0094
                java.lang.String r2 = "obj.imageBase64 = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x0094:
                java.lang.String r10 = "dParam"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x00b1
                java.lang.String r10 = r0.getString(r10)
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                if (r2 != 0) goto L_0x00b1
                java.lang.String r2 = "obj.dParam = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x00b1:
                java.lang.String r10 = "clickUrl"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x00ce
                java.lang.String r10 = r0.getString(r10)
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                if (r2 != 0) goto L_0x00ce
                java.lang.String r2 = "obj.clickUrl = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x00ce:
                java.lang.String r10 = "impressionUrl"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x00eb
                java.lang.String r10 = r0.getString(r10)
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                if (r2 != 0) goto L_0x00eb
                java.lang.String r2 = "obj.impressionUrl = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x00eb:
                com.startapp.sdk.adsbase.consent.ConsentActivity r10 = com.startapp.sdk.adsbase.consent.ConsentActivity.this
                com.startapp.sdk.components.ComponentLocator r10 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r10)
                com.startapp.id r10 = r10.m()
                java.lang.Object r10 = r10.b()
                com.startapp.hd r10 = (com.startapp.hd) r10
                java.lang.String r10 = r10.f34647d
                boolean r2 = android.text.TextUtils.isEmpty(r10)
                if (r2 != 0) goto L_0x010e
                java.lang.String r2 = "obj.locales = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x010e:
                java.lang.String r10 = "timestamp"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x0125
                long r5 = r0.getLong(r10)
                java.lang.String r10 = "obj.timeStamp = "
                r1.append(r10)
                r1.append(r5)
                r1.append(r4)
            L_0x0125:
                java.lang.String r10 = "templateName"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x013c
                int r10 = r0.getInt(r10)
                java.lang.String r2 = "obj.templateName = "
                r1.append(r2)
                r1.append(r10)
                r1.append(r4)
            L_0x013c:
                java.lang.String r10 = "templateId"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x0153
                int r10 = r0.getInt(r10)
                java.lang.String r2 = "obj.templateId = "
                r1.append(r2)
                r1.append(r10)
                r1.append(r4)
            L_0x0153:
                java.lang.String r10 = "obj.os = 'android';"
                r1.append(r10)
                java.lang.String r10 = "obj.consentTypeInfo = {};"
                r1.append(r10)
                java.lang.String r10 = "impression"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x0175
                int r10 = r0.getInt(r10)
                long r5 = (long) r10
                java.lang.String r10 = "obj.consentTypeInfo.impression = "
                r1.append(r10)
                r1.append(r5)
                r1.append(r4)
            L_0x0175:
                java.lang.String r10 = "trueClick"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x018d
                int r10 = r0.getInt(r10)
                long r5 = (long) r10
                java.lang.String r10 = "obj.consentTypeInfo.trueClick = "
                r1.append(r10)
                r1.append(r5)
                r1.append(r4)
            L_0x018d:
                java.lang.String r10 = "falseClick"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x01a5
                int r10 = r0.getInt(r10)
                long r5 = (long) r10
                java.lang.String r10 = "obj.consentTypeInfo.falseClick = "
                r1.append(r10)
                r1.append(r5)
                r1.append(r4)
            L_0x01a5:
                java.lang.String r10 = "obj.infoForExternalLinks = {};"
                r1.append(r10)
                java.lang.String r10 = "advertisingId"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x01c1
                java.lang.String r10 = r0.getString(r10)
                java.lang.String r2 = "obj.infoForExternalLinks.advertisingId = '"
                r1.append(r2)
                r1.append(r10)
                r1.append(r3)
            L_0x01c1:
                java.lang.String r10 = "consentType"
                boolean r2 = r0.containsKey(r10)
                if (r2 == 0) goto L_0x01d8
                int r10 = r0.getInt(r10)
                java.lang.String r0 = "obj.infoForExternalLinks.consentType = "
                r1.append(r0)
                r1.append(r10)
                r1.append(r4)
            L_0x01d8:
                java.lang.String r10 = "startappInit(obj);"
                r1.append(r10)
                java.lang.String r10 = r1.toString()
                r9.loadUrl(r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.consent.ConsentActivity.a.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl());
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(Uri.parse(str));
        }
    }
}
