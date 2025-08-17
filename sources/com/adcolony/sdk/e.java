package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.e0;
import com.facebook.ads.AudienceNetworkActivity;
import java.io.IOException;
import java.util.regex.Matcher;
import kotlin.text.Regex;

public final class e extends j {
    private String H = "";
    private String I = "";

    static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f13107b;

        a(e eVar) {
            this.f13107b = eVar;
        }

        public final void run() {
            e.super.c();
        }
    }

    public e(Context context, int i2, h0 h0Var) {
        super(context, i2, h0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public final void H(Exception exc) {
        new e0.a().c(exc.getClass().toString()).c(" during metadata injection w/ metadata = ").c(c0.E(getInfo(), "metadata")).d(e0.f13114i);
        AdColonyInterstitial remove = a.f().T().z().remove(c0.E(getInfo(), "ad_session_id"));
        if (remove != null) {
            remove.G();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        kotlin.io.CloseableKt.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String Z() {
        /*
            r8 = this;
            java.lang.String r0 = r8.I
            int r0 = r0.length()
            r1 = 0
            if (r0 <= 0) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x0036
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = "script\\s*src\\s*=\\s*\"mraid.js\""
            r0.<init>((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "script src=\"file://"
            r1.append(r2)
            java.lang.String r2 = r8.getMraidFilepath()
            r1.append(r2)
            r2 = 34
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r8.I
            java.lang.String r0 = r0.j(r2, r1)
            goto L_0x0086
        L_0x0036:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.lang.String r2 = r8.H
            r0.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            int r3 = r0.available()     // Catch:{ all -> 0x0087 }
            r2.<init>(r3)     // Catch:{ all -> 0x0087 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ all -> 0x0087 }
        L_0x004a:
            int r5 = r0.read(r4, r1, r3)     // Catch:{ all -> 0x0087 }
            if (r5 < 0) goto L_0x005b
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0087 }
            java.nio.charset.Charset r7 = kotlin.text.Charsets.f40513b     // Catch:{ all -> 0x0087 }
            r6.<init>(r4, r1, r5, r7)     // Catch:{ all -> 0x0087 }
            r2.append(r6)     // Catch:{ all -> 0x0087 }
            goto L_0x004a
        L_0x005b:
            java.lang.String r3 = r8.H     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = ".html"
            r5 = 2
            r6 = 0
            boolean r1 = kotlin.text.StringsKt__StringsKt.L(r3, r4, r1, r5, r6)     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x006c
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0087 }
            goto L_0x0082
        L_0x006c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "<html><script>"
            r1.append(r3)     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "</script></html>"
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0087 }
        L_0x0082:
            kotlin.io.CloseableKt.a(r0, r6)
            r0 = r1
        L_0x0086:
            return r0
        L_0x0087:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.e.Z():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String P(f1 f1Var) {
        boolean z2;
        if (this.I.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "";
        }
        return super.P(f1Var);
    }

    public void c() {
        long j2;
        if (!getDestroyed()) {
            a aVar = new a(this);
            if (U()) {
                j2 = 1000;
            } else {
                j2 = 0;
            }
            z0.n(aVar, j2);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void u() {
        f1 f1Var;
        h0 message = getMessage();
        if (message == null) {
            f1Var = null;
        } else {
            f1Var = message.a();
        }
        if (f1Var == null) {
            f1Var = c0.q();
        }
        this.H = K(f1Var);
        this.I = c0.E(f1Var, "interstitial_html");
        super.u();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void v() {
        f1 f1Var;
        boolean z2;
        try {
            h0 message = getMessage();
            if (message == null) {
                f1Var = null;
            } else {
                f1Var = message.a();
            }
            if (f1Var == null) {
                f1Var = c0.q();
            }
            String E = c0.E(c0.C(f1Var, "info"), "metadata");
            String z3 = z(Z(), c0.E(c0.r(E), "iab_filepath"));
            Regex regex = new Regex("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;");
            String j2 = regex.j(z3, Matcher.quoteReplacement("var ADC_DEVICE_INFO = " + E + ';'));
            String mUrl = getMUrl();
            if (mUrl.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                mUrl = getBaseUrl();
            }
            loadDataWithBaseURL(mUrl, j2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, (String) null);
        } catch (IOException e2) {
            H(e2);
        } catch (IllegalArgumentException e3) {
            H(e3);
        } catch (IndexOutOfBoundsException e4) {
            H(e4);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void w() {
    }
}
